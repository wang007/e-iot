package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.github.eiot.ocpp.impl.OcppConnectionImpl;
import io.github.eiot.ocpp.schema.*;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.VertxTestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

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
                        connection.frameHandler(frame -> {
                            BootNotificationResponse data = (BootNotificationResponse) frame.data();
                            assertTrue(data.getStatus() == RegistrationStatusEnum.ACCEPTED);
                            assertTrue(data.getInterval() == 300);
                            complete();
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


}
