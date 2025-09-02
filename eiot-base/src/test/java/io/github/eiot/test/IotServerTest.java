package io.github.eiot.test;

import io.github.eiot.test.example.*;
import io.github.eiot.test.example.data.ExampleHeartbeatRequest;
import io.github.eiot.test.example.data.ExampleHeartbeatResponse;
import io.github.eiot.*;
import io.github.eiot.codec.BCDTime;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.BufferImpl;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by wang007 on 2025/5/26
 */
public class IotServerTest extends VertxTestBase {

    protected String terminalNo = "123456789012";

    protected SocketAddress socketAddress;
    protected IotClient iotClient;
    protected IotServer iotServer;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        socketAddress = SocketAddress.inetSocketAddress(1234, "localhost");
        iotClient = ExampleIotClient.create(vertx);
        iotServer = ExampleIotServer.create(vertx);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        socketAddress = null;
        iotClient = null;
        iotServer = null;
    }

    protected void startServer(SocketAddress remoteAddress) throws Exception {
        startServer(remoteAddress, vertx.getOrCreateContext());
    }

    protected void startServer(SocketAddress remoteAddress, IotServer server) throws Exception {
        startServer(remoteAddress, vertx.getOrCreateContext(), server);
    }

    protected void startServer(SocketAddress remoteAddress, Context context) throws Exception {
        startServer(remoteAddress, context, iotServer);
    }

    protected void startServer(SocketAddress remoteAddress, Context context, IotServer server) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        context.runOnContext(v -> {
            server.listen(remoteAddress).onComplete(onSuccess(s -> latch.countDown()));
        });
        awaitLatch(latch);
    }

    protected void writeHeartbeatFrame() throws Exception {
        writeHeartbeatFrame(socketAddress);
    }

    protected void writeHeartbeatFrame(SocketAddress socketAddress) throws Exception {
        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest request = frame.newData();
                    request.setTime(BCDTime.now());
                    request.setStatus(1);
                    frame.data(request).write();
                });
    }

    protected Future<? extends Frame<ExampleHeartbeatResponse>> requestHeartbeatFrame() {
        return requestHeartbeatFrame(socketAddress);
    }

    protected Future<? extends Frame<ExampleHeartbeatResponse>> requestHeartbeatFrame(SocketAddress socketAddress) {
        return iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .flatMap(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = frame.newData();
                    data.setTime(BCDTime.now());
                    frame.data(data);
                    return frame.asRequest(ExampleHeartbeatResponse.class).request();
                });
    }


    @Test
    public void testNotConvert() throws Exception {
        IotServerOptions options = ExampleIotServer.newOptions();
        options.setFrameConverter(false);
        options.setSetResponseResult(false);

        ExampleIotServer iotServer = ExampleIotServer.create(vertx, options);
        iotServer.frameHandler(frame -> {
            assertTrue(frame.isRaw());
            complete();
        });
        startServer(socketAddress, iotServer);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    ExampleFrame<ExampleHeartbeatRequest> exampleFrame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = exampleFrame.newData();
                    data.setTime(BCDTime.now());
                    exampleFrame.data(data).write();
                });
        await();
    }

    @Test
    public void testConnectionHandler() throws Exception {
        waitFor(2);
        iotServer.connectionHandler(connection -> {
            complete();
        });
        startServer(socketAddress);

        ExampleIotClient iotClient = ExampleIotClient.create(vertx);
        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    complete();
                });
        await();
    }

    @Test
    public void testOutBoundHook() throws Exception {
        waitFor(3);

        iotServer.connectionHandler(connection -> {
            OutboundHook o1 = new OutboundHook() {
                @Override
                public Future<Frame<?>> beforeWrite(Frame<?> frame) {
                    complete();
                    return Future.succeededFuture(frame);
                }
            };

            OutboundHook o2 = new OutboundHook() {
                @Override
                public Future<Frame<?>> beforeWrite(Frame<?> frame) {
                    complete();
                    return Future.succeededFuture(frame);
                }
            };
            OutboundHook outboundHook = OutboundHook.compose(o1, o2);
            connection.outboundHook(outboundHook);
            connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

            connection.frameHandler(frame -> {
                Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
                ExampleHeartbeatResponse data = responseFrame.newData();
                responseFrame.data(data).write();
            });
        });

        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    OutboundHook outboundHook = new OutboundHook() {
                        @Override
                        public Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> frame) {
                            complete();
                            return Future.succeededFuture(frame);
                        }
                    };
                    connection.outboundHook(outboundHook);
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    DefaultExampleFrame<ExampleHeartbeatRequest> exampleFrame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = exampleFrame.newData();
                    data.setTime(BCDTime.now());
                    exampleFrame.data(data).asRequest().request();
                });
        await();
    }

    @Test
    public void testWrite() throws Exception {
        AtomicReference<ByteBuf> ref = new AtomicReference<>();
        iotServer.connectionHandler(connection -> {
            connection.frameHandler(frame -> {
                ExampleHeartbeatRequest data = (ExampleHeartbeatRequest) frame.data();
                assertTrue(data != null);
                ByteBuf byteBuf = frame.toByteBuf();
                assertTrue(byteBuf.equals(ref.get()));
                complete();
            });
        });
        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    connection.outboundHook(new OutboundHook() {
                        @Override
                        public Future<Frame<?>> beforeWrite(Frame<?> frame) {
                            ByteBuf byteBuf = frame.toByteBuf();
                            ref.set(byteBuf);
                            return Future.succeededFuture(frame);
                        }
                    });

                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = frame.newData();
                    data.setTime(BCDTime.now());
                    frame.data(data).write();
                });
        await();
    }


    @Test
    public void testRequest() throws Exception {
        int count = 20;
        waitFor(count);
        iotServer.frameHandler(frame -> {
            Object data = frame.data();
            assertTrue(data != null);
            frame.iotConnection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
            ExampleHeartbeatResponse response = responseFrame.newData();
            response.setResult(1);
            responseFrame.data(response).write();
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            requestHeartbeatFrame()
                    .onSuccess(responseFrame -> {
                        ExampleHeartbeatResponse response = responseFrame.data();
                        assertTrue(response != null && response.getResult() == 1);
                        complete();
                    });
        }

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    for (int i = 0; i < 10; i++) {
                        ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                        ExampleHeartbeatRequest data = frame.newData();
                        data.setTime(BCDTime.now());
                        data.setStatus(i);
                        frame.data(data)
                                .asRequest(ExampleHeartbeatResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    ExampleHeartbeatResponse response = responseFrame.data();
                                    assertTrue(response != null && response.getResult() == 1);
                                    complete();
                                });
                    }
                });

        await();
    }


    @Test
    public void testMatchCommandConnection() throws Exception {
        waitFor(20);
        ExampleIotServer iotServer = ExampleIotServer.create(vertx);
        iotServer.frameHandler(frame -> {
            frame.iotConnection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
            ExampleHeartbeatResponse response = responseFrame.newData();
            response.setResult(1);
            responseFrame.data(response).write();
        });
        startServer(socketAddress, iotServer);

        for (int i = 0; i < 10; i++) {
            requestHeartbeatFrame()
                    .onSuccess(responseFrame -> {
                        ExampleHeartbeatResponse response = responseFrame.data();
                        assertTrue(response != null && response.getResult() == 1);
                        complete();
                    });
        }

        ExampleIotClient iotClient = ExampleIotClient.create(vertx, ExampleIotClient.newOptions().setSeqNoMatchFirst(false));
        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    for (int i = 0; i < 10; i++) {
                        ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                        ExampleHeartbeatRequest data = frame.newData();
                        data.setTime(BCDTime.now());
                        data.setStatus(i);
                        frame.data(data)
                                .asRequest(ExampleHeartbeatResponse.class)
                                .request()
                                .onSuccess(responseFrame -> {
                                    ExampleHeartbeatResponse response = responseFrame.data();
                                    assertTrue(response != null && response.getResult() == 1);
                                    complete();
                                });
                    }
                });
        await();
    }


    @Test
    public void testRequestTimeout() throws Exception {
        iotServer.frameHandler(frame -> {
        });
        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = frame.newData();
                    data.setTime(BCDTime.now());

                    frame.data(data)
                            .asRequest()
                            .request(100) // timeout 100ms timeout
                            .onFailure(ex -> {
                                assertTrue(ex instanceof TimeoutException);
                                complete();
                            })
                            .onSuccess(result -> {
                                this.fail("not expect success");
                            });
                });
        await();
    }


    @Test
    public void testBufferHandler() throws Exception {

        iotServer.connectionHandler(connection -> {
            connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            connection.handler(buffer -> {
                ByteBuf byteBuf = ((BufferImpl)buffer).getByteBuf();

                RawExampleFrame rawExampleFrame = RawExampleFrame.new4Receiver(connection, byteBuf);
                ExampleFrame<ExampleHeartbeatRequest> frame = (ExampleFrame<ExampleHeartbeatRequest>) ExampleFrameConverter.INSTANCE.apply(rawExampleFrame);

                Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
                ExampleHeartbeatResponse response = responseFrame.newData();
                response.setResult(1);
                responseFrame.data(response);
                connection.write(new BufferImpl(responseFrame.toByteBuf()));
            });
        });
        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest data = frame.newData();
                    data.setTime(BCDTime.now());
                    frame.data(data)
                            .asRequest(ExampleHeartbeatResponse.class)
                            .request()
                            .onFailure(this::fail)
                            .onSuccess(responseFrame -> {
                                ExampleHeartbeatResponse response = responseFrame.data();
                                assertTrue(response != null && response.getResult() == 1);
                                complete();
                            });
                });
        await();
    }

    @Test
    public void testProxyServer() throws Exception {
        int count = 20;
        waitFor(count);

        ExampleIotServer proxyServer = ExampleIotServer.create(vertx, ExampleIotServer.newOptions().setSetResponseResult(false));
        proxyServer.frameHandler(frame -> {
            IotConnection proxyConnection = frame.iotConnection();

            proxyConnection.pause();
            proxyConnection.frameHandler(null); //reset handler
            iotClient.connect(socketAddress)
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
        SocketAddress proxyAddress = SocketAddress.inetSocketAddress(8888, "localhost");
        startServer(proxyAddress, proxyServer);

        iotServer.frameHandler(frame -> {
            ExampleHeartbeatRequest request = (ExampleHeartbeatRequest) frame.data();
            frame.iotConnection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
            ExampleHeartbeatResponse response = responseFrame.newData();
            response.setResult(request.getStatus());
            responseFrame.data(response).write();
        });
        startServer(socketAddress);

        for (int i = 0; i < 10; i++) {
            requestHeartbeatFrame()
                    .onSuccess(responseFrame -> {
                        ExampleHeartbeatResponse response = responseFrame.data();
                        assertTrue(response != null);
                        complete();
                    });
        }

        iotClient.connect(proxyAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    for (int i = 0; i < 10; i++) {
                        int i0 = i;
                        ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                        ExampleHeartbeatRequest data = frame.newData();
                        data.setStatus(i);
                        data.setTime(BCDTime.now());
                        frame.data(data)
                                .asRequest(ExampleHeartbeatResponse.class)
                                .request()
                                .onFailure(this::fail)
                                .onSuccess(responseFrame -> {
                                    ExampleHeartbeatResponse response = responseFrame.data();
                                    assertTrue(response != null && response.getResult() == i0);
                                    complete();
                                });
                    }
                });
        await();
    }


}
