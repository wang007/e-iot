package com.github.eiot.test;

import com.github.eiot.test.example.*;
import com.github.eiot.test.example.data.ExampleHeartbeatRequest;
import com.github.eiot.test.example.data.ExampleHeartbeatResponse;
import io.github.eiot.*;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.BCDTime;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.AsyncTestBase;
import io.vertx.test.core.VertxTestBase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by wang007 on 2025/5/26
 */
public class IotServerTest extends VertxTestBase {


    private SocketAddress socketAddress;
    private IotClient iotClient;
    private IotServer iotServer;

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

        String terminalNo = "123456789012";
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

        String terminalNo = "123456789012";
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

        String terminalNo = "123456789012";
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
        String terminalNo = "123456789012";
        iotServer.frameHandler(frame -> {
            frame.iotConnection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
            ExampleHeartbeatResponse response = responseFrame.newData();
            response.setResult(1);
            responseFrame.data(response).write();
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
    public void testRequestTimeout() throws Exception {
        String terminalNo = "123456789012";
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
        String terminalNo = "123456789012";
        iotServer.connectionHandler(connection -> {
            connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            connection.handler(buffer -> {
                ByteBuf byteBuf = buffer.getByteBuf();

                RawExampleFrame rawExampleFrame = RawExampleFrame.new4Receiver(connection, byteBuf);
                ExampleFrame<ExampleHeartbeatRequest> frame = (ExampleFrame<ExampleHeartbeatRequest>) ExampleFrameConverter.INSTANCE.apply(rawExampleFrame);

                Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
                ExampleHeartbeatResponse response = responseFrame.newData();
                response.setResult(1);
                responseFrame.data(response);
                connection.write(Buffer.buffer(responseFrame.toByteBuf()));
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
        int count = 10;
        waitFor(count);

        String terminalNo = "123456789012";
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

        AtomicInteger receiveCount = new AtomicInteger();
        iotServer.frameHandler(frame -> {
            System.out.println("frame receive count: " + receiveCount.getAndIncrement());
            frame.iotConnection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
            ExampleHeartbeatResponse response = responseFrame.newData();
            response.setResult(1);
            responseFrame.data(response).write();
        });
        startServer(socketAddress);

        iotClient.connect(proxyAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    for (int i = 0; i < count; i++) {
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
                    }

                });
        await();
    }


}
