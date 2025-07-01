package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.github.eiot.ocpp.schema.*;
import io.github.eiot.route.IotRouter;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by wang007 on 2025/6/30
 */
public class OcppServerTest extends VertxTestBase {

    protected String terminalNo = "123456789012";

    protected SocketAddress socketAddress;
    protected OcppClient ocppClient;
    protected OcppServer ocppServer;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        socketAddress = SocketAddress.inetSocketAddress(1234, "localhost");
        ocppClient = OcppClient.create(vertx);
        ocppServer = OcppServer.create(vertx);
        ocppServer.webSocketHandshakeHandler(wsHandShake -> {
            String terminalNo = wsHandShake.extractLastPathAsTerminalNo();
            wsHandShake.accept(terminalNo);
        });
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        socketAddress = null;
        ocppClient = null;
        ocppServer = null;
    }

    public OcppConnectOptions getOcppConnectOptions() {
        OcppConnectOptions connectOptions = new OcppConnectOptions();
        connectOptions.setTerminalNo(terminalNo);
        connectOptions.setServer(socketAddress);
        connectOptions.setURI("/ocpp/" + terminalNo);
        return connectOptions;
    }


    protected void startServer(SocketAddress remoteAddress) throws Exception {
        startServer(remoteAddress, vertx.getOrCreateContext());
    }

    protected void startServer(SocketAddress remoteAddress, OcppServer server) throws Exception {
        startServer(remoteAddress, vertx.getOrCreateContext(), server);
    }

    protected void startServer(SocketAddress remoteAddress, Context context) throws Exception {
        startServer(remoteAddress, context, ocppServer);
    }

    protected void startServer(SocketAddress remoteAddress, Context context, OcppServer server) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        context.runOnContext(v -> {
            server.listen(remoteAddress).onComplete(onSuccess(s -> latch.countDown()));
        });
        awaitLatch(latch);
    }

    @Test
    public void testConnectionHandler() throws Exception {
        waitFor(2);

        ocppServer.connectionHandler(connection -> {
            complete();
        });

        startServer(socketAddress);

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    complete();
                });
        await();
    }

    private void writeBootNotification() {
        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                    BootNotificationRequest request = ocppFrame.newData();
                    request.setReason(BootReasonEnum.POWER_UP);
                    request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                    ocppFrame.data(request).write();
                });
    }

    public Future<OcppFrame<BootNotificationResponse>> requestBootNotification() {
        return ocppClient.connect(getOcppConnectOptions())
                .flatMap(connection -> {
                    OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                    BootNotificationRequest request = ocppFrame.newData();
                    request.setReason(BootReasonEnum.POWER_UP);
                    request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                    return ocppFrame.data(request).asRequest(BootNotificationResponse.class).request();
                })
                .onFailure(this::fail);
    }

    @Test
    public void testOutBoundHook() throws Exception {
        waitFor(3);
        ocppServer.connectionHandler(connection -> {
            connection.outboundHook(new OutboundHook() {
                @Override
                public Future<Frame<?>> beforeWrite(Frame<?> frame) {
                    assertTrue(frame instanceof OcppFrame<?>);
                    complete();
                    return Future.succeededFuture(frame);
                }
            });

            connection.frameHandler(frame -> {
                BootNotificationRequest data = (BootNotificationRequest) frame.data();
                assertTrue(data.getReason() == BootReasonEnum.POWER_UP);
                assertTrue(data.getChargingStation().getModel().equals("SingleSocketCharger"));

                Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                BootNotificationResponse response = responseFrame.newData();
                response.setStatus(RegistrationStatusEnum.ACCEPTED);
                responseFrame.data(response).write();
            });

        });
        startServer(socketAddress);

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.outboundHook(new OutboundHook() {
                        @Override
                        public Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> frame) {
                            complete();
                            return Future.succeededFuture(frame);
                        }
                    });

                    OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                    BootNotificationRequest request = ocppFrame.newData();
                    request.setReason(BootReasonEnum.POWER_UP);
                    request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                    ocppFrame.data(request).asRequest(BootNotificationResponse.class)
                            .request(100000000)
                            .onFailure(this::fail)
                            .onSuccess(responseFrame -> {
                                BootNotificationResponse data = responseFrame.data();
                                assertTrue(data != null && data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                complete();
                            });
                });
        await();
    }


    @Test
    public void testWrite() throws Exception {
        waitFor(20);

        ocppServer.connectionHandler(connection -> {
            connection.frameHandler(frame -> {
                Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                BootNotificationResponse response = responseFrame.newData();
                response.setStatus(RegistrationStatusEnum.ACCEPTED);
                response.setInterval(300);
                responseFrame.data(response).write();
            });
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);

                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    }
                });
        await();
    }

    @Test
    public void testRequest() throws Exception {
        waitFor(40);

        ocppServer.connectionHandler(connection -> {
            connection.frameHandler(frame -> {
                Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                BootNotificationResponse response = responseFrame.newData();
                response.setStatus(RegistrationStatusEnum.ACCEPTED);
                response.setInterval(300);
                responseFrame.data(response).write();

                OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(frame.iotConnection(), Ocpp2_1Command.BootNotificationRequest);
                BootNotificationRequest request = ocppFrame.newData();
                request.setChargingStation(new ChargingStation());
                request.setReason(BootReasonEnum.APPLICATION_RESET);
                ocppFrame.data(request)
                        .asRequest(BootNotificationResponse.class)
                        .request()
                        .onFailure(this::fail)
                        .onSuccess(respFrame -> {
                            BootNotificationResponse data = respFrame.data();
                            assertTrue(data != null);
                            complete();
                        });
            });
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        connection.frameHandler(frame -> {
                            BootNotificationRequest data = (BootNotificationRequest) frame.data();
                            assertTrue(data.getReason() == BootReasonEnum.APPLICATION_RESET);

                            Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                            BootNotificationResponse response = responseFrame.newData();
                            response.setStatus(RegistrationStatusEnum.ACCEPTED);
                            responseFrame.data(response).write();
                        });

                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.frameHandler(frame -> {
                        BootNotificationRequest data = (BootNotificationRequest) frame.data();
                        assertTrue(data.getReason() == BootReasonEnum.APPLICATION_RESET);

                        Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                        BootNotificationResponse response = responseFrame.newData();
                        response.setStatus(RegistrationStatusEnum.ACCEPTED);
                        responseFrame.data(response).write();
                    });

                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);

                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    }
                });
        await();
    }


    @Test
    public void testErrorFrame() throws Exception {
        waitFor(20);
        ocppServer.frameHandler(frame -> {
            OcppFrame<Object> ocppFrame = (OcppFrame<Object>) frame;
            Object data = ocppFrame.data();
            assertTrue(data instanceof BootNotificationRequest);

            OcppFrame<Void> errorFrame = ocppFrame.newErrorFrame(OcppError.GenericError, "test", new JsonObject().put("name", "wang007"));
            errorFrame.write();
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request(1000000000)
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    assertTrue(responseFrame.failed());
                                    assertTrue(responseFrame.data() == null);
                                    assertTrue(responseFrame.errorCode() == OcppError.GenericError);
                                    assertEquals(responseFrame.errorDescription(), "test");
                                    assertEquals(responseFrame.errorDetails().getString("name"), "wang007");
                                    complete();
                                });
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request(1000000000)
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    assertTrue(responseFrame.failed());
                                    assertTrue(responseFrame.data() == null);
                                    assertTrue(responseFrame.errorCode() == OcppError.GenericError);
                                    assertEquals(responseFrame.errorDescription(), "test");
                                    assertEquals(responseFrame.errorDetails().getString("name"), "wang007");
                                    complete();
                                });
                    }
                });
        await();
    }


    @Test
    public void testSend() throws Exception {
        waitFor(20);
        ocppServer.frameHandler(frame -> {
            OcppFrame<Object> ocppFrame = (OcppFrame<Object>) frame;
            Object data = ocppFrame.data();
            assertTrue(data instanceof BootNotificationRequest);
            complete();
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request).send();
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request).send();
                    }
                });
        await();
    }

    @Test
    public void testWriteResultAwaitError() throws Exception {
        waitFor(20);
        AtomicInteger count = new AtomicInteger();

        AtomicInteger succeedCount = new AtomicInteger();
        AtomicInteger failedCount = new AtomicInteger();

        ocppServer.frameHandler(frame -> {
            OcppFrame<Object> ocppFrame = (OcppFrame<Object>) frame;
            OcppFrame<BootNotificationResponse> responseFrame = ocppFrame.asRequest(BootNotificationResponse.class).responseFrame();
            BootNotificationResponse response = responseFrame.newData();
            response.setInterval(count.getAndIncrement());
            response.setStatus(RegistrationStatusEnum.ACCEPTED);

            responseFrame.data(response)
                    .writeResultAwaitError(500)
                    .onFailure(this::fail)
                    .onSuccess(errorFrame -> {
                        if (errorFrame != null && errorFrame.failed()) {
                            failedCount.getAndIncrement();
                        }
                        if (errorFrame == null) {
                            succeedCount.getAndIncrement();
                        }
                        complete();
                    });
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    int interval = responseFrame.data().getInterval();
                                    if (interval % 2 == 0) {
                                        responseFrame.newResulErrorFrame(OcppError.GenericError, "testAwaitError1")
                                                .write();
                                    }
                                });
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    int interval = responseFrame.data().getInterval();
                                    if (interval % 2 == 0) {
                                        responseFrame.newResulErrorFrame(OcppError.GenericError, "testAwaitError2-" + interval)
                                                .write();
                                    }
                                });
                    }
                });
        await();

        assertTrue(failedCount.get() == 10);
        assertTrue(succeedCount.get() == 10);
    }


    @Test
    public void testRequestTimeout() throws Exception {
        ocppServer.frameHandler(frame -> {
        });
        startServer(socketAddress);

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                    ocppFrame.asRequest()
                            .request(500)
                            .onSuccess(result -> this.fail("not except success"))
                            .onFailure(ex -> {
                                assertTrue(ex instanceof TimeoutException);
                                complete();
                            });
                });
        await();
    }

    @Test
    public void testBufferHandler() throws Exception {
        waitFor(20);
        ocppServer.connectionHandler(connection -> {
            connection.handler(buffer -> {
                String json = buffer.toString();
                RawOcppFrame ocppFrame = RawOcppFrame.new4Receiver((OcppConnection) connection, json);
                OcppFrame<BootNotificationRequest> frame = (OcppFrame<BootNotificationRequest>) OcppFrameConverter.INSTANCE.apply(ocppFrame);

                OcppFrame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                BootNotificationResponse response = responseFrame.newData();
                response.setStatus(RegistrationStatusEnum.ACCEPTED);
                response.setCurrentTime(ZonedDateTime.now());
                responseFrame.data(response).write();
            });
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    complete();
                                });
                    });
        }

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    complete();
                                });
                    }
                });
        await();
    }

    @Test
    public void testProxyServer() throws Exception {
        waitFor(20);
        OcppServer proxyServer = OcppServer.create(vertx, OcppServer.newOptions().setSetResponseResult(false));
        proxyServer.frameHandler(frame -> {
            IotConnection proxyConnection = frame.iotConnection();

            proxyConnection.pause();
            proxyConnection.frameHandler(null); //reset handler

            ocppClient.connect(getOcppConnectOptions())
                    .onFailure(ex -> {
                        proxyConnection.close();
                        this.fail(ex);
                    })
                    .onSuccess(connection -> {
                        connection.pipeTo(proxyConnection).onFailure(this::fail);
                        proxyConnection.pipeTo(connection).onFailure(this::fail);
                        connection.write(frame); // write first accepted frame
                    });
        });
        proxyServer.webSocketHandshakeHandler(wsHandshake -> {
            String terminalNo = wsHandshake.extractLastPathAsTerminalNo();
            wsHandshake.accept(terminalNo);
        });

        SocketAddress proxyAddress = SocketAddress.inetSocketAddress(5678, "localhost");
        startServer(proxyAddress, proxyServer);

        ocppServer.connectionHandler(connection -> {
            connection.frameHandler(frame -> {
                Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                BootNotificationResponse response = responseFrame.newData();
                response.setStatus(RegistrationStatusEnum.ACCEPTED);
                response.setInterval(300);
                responseFrame.data(response).write();
            });
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            OcppConnectOptions proxyOptions = getOcppConnectOptions();
            proxyOptions.setServer(proxyAddress);

            ocppClient.connect(proxyOptions)
                    .onFailure(this::fail)
                    .onSuccess(connection -> {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    });
        }


        OcppConnectOptions proxyOptions = getOcppConnectOptions();
        proxyOptions.setServer(proxyAddress);
        ocppClient.connect(proxyOptions)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    for (int i = 0; i < 10; i++) {
                        OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                        BootNotificationRequest request = ocppFrame.newData();
                        request.setReason(BootReasonEnum.POWER_UP);
                        request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                        ocppFrame.data(request)
                                .asRequest(BootNotificationResponse.class)
                                .request(100000000)
                                .onSuccess(responseFrame -> {
                                    BootNotificationResponse data = responseFrame.data();
                                    assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                    assertTrue(data.getInterval() == 300);
                                    complete();
                                });
                    }
                });
        await();
    }


    @Test
    public void testRouter() throws Exception {
        waitFor(3);
        IotRouter router = IotRouter.router(vertx);
        router.route(Ocpp2_1Command.BootNotificationRequest)
                .handler(ctx -> {
                    Frame<BootNotificationRequest> frame = ctx.frame();
                    BootNotificationRequest data = frame.data();
                    assertTrue(data.getReason() == BootReasonEnum.POWER_UP);
                    ctx.next();
                    complete();
                });

        router.route(Ocpp2_1Command.BootNotificationRequest)
                .handler(ctx -> {
                    Frame<BootNotificationRequest> frame = ctx.frame();
                    Frame<BootNotificationResponse> responseFrame = frame.asRequest(BootNotificationResponse.class).responseFrame();
                    BootNotificationResponse response = responseFrame.newData();
                    response.setStatus(RegistrationStatusEnum.ACCEPTED);
                    response.setInterval(300);
                    responseFrame.data(response).write();
                    complete();
                });
        ocppServer.frameHandler(router);
        startServer(socketAddress);

        ocppClient.connect(getOcppConnectOptions())
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    OcppFrame<BootNotificationRequest> ocppFrame = OcppFrame.create(connection, Ocpp2_1Command.BootNotificationRequest);
                    BootNotificationRequest request = ocppFrame.newData();
                    request.setReason(BootReasonEnum.POWER_UP);
                    request.setChargingStation(new ChargingStation().withModel("SingleSocketCharger").withVendorName("VendorX"));
                    ocppFrame.data(request)
                            .asRequest(BootNotificationResponse.class)
                            .request()
                            .onSuccess(responseFrame -> {
                                BootNotificationResponse data = responseFrame.data();
                                assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                                complete();
                            });
                });
        await();
    }

}
