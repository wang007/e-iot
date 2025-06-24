package com.github.eiot.test;

import com.github.eiot.test.example.*;
import com.github.eiot.test.example.data.ExampleHeartbeatRequest;
import com.github.eiot.test.example.data.ExampleHeartbeatResponse;
import io.github.eiot.*;
import io.github.eiot.codec.BCDTime;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.AsyncTestBase;
import io.vertx.test.core.VertxTestBase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

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

        /*iotServer.connectionHandler(connection -> {

        })*/

    }




}
