package io.github.eiot.charge.ykc;

import io.github.eiot.*;
import io.github.eiot.charge.ykc.data.YkcHeartbeatRequest;
import io.github.eiot.charge.ykc.data.YkcHeartbeatResponse;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.net.SocketAddress;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by wang007 on 2025/6/28
 */
public class YkcServerTest extends VertxTestBase {

    protected String terminalNo = "123456789012";

    protected SocketAddress socketAddress;
    protected IotClient iotClient;
    protected IotServer iotServer;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        socketAddress = SocketAddress.inetSocketAddress(1234, "localhost");
        iotClient = YkcClient.create(vertx);
        iotServer = YkcServer.create(vertx);
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

    public void writeHeartbeatFrame() {
        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    YkcFrame<YkcHeartbeatRequest> ykcFrame = YkcFrame.create(connection, YkcCommand.HeartbeatRequest);
                    YkcHeartbeatRequest request = ykcFrame.newData();
                    request.setGunNo(1);
                    request.setGunStatus(0);
                    ykcFrame.data(request).write();
                });
    }

    public Future<? extends Frame<YkcHeartbeatResponse>> requestHeartbeatFrame(SocketAddress socketAddress) {
        return iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .flatMap(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    YkcFrame<YkcHeartbeatRequest> ykcFrame = YkcFrame.create(connection, YkcCommand.HeartbeatRequest);
                    YkcHeartbeatRequest request = ykcFrame.newData();
                    request.setGunNo(1);
                    request.setGunStatus(0);
                    return ykcFrame.data(request).asRequest(YkcCommand.HeartbeatRequest).request();
                });
    }

    private void checkCheckCodeResult(Frame<?> frame) {
        YkcFrame<?> ykcFrame = (YkcFrame<?>) frame;
        assertTrue(ykcFrame.checkCodeResult());
    }

    @Test
    public void testWrite() throws Exception {
        AtomicReference<ByteBuf> ref = new AtomicReference<>();

        iotServer.frameHandler(frame -> {
            checkCheckCodeResult(frame);
            ByteBuf byteBuf = frame.toByteBuf();
            assertTrue(byteBuf.equals(ref.get()));
            complete();
        });
        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    connection.outboundHook(new OutboundHook() {
                        @Override
                        public Future<Frame<?>> beforeWrite(Frame<?> frame) {
                            ref.set(frame.toByteBuf());
                            return Future.succeededFuture(frame);
                        }
                    });

                    YkcFrame<YkcHeartbeatRequest> ykcFrame = YkcFrame.create(connection, YkcCommand.HeartbeatRequest);
                    YkcHeartbeatRequest request = ykcFrame.newData();
                    request.setGunNo(1);
                    request.setGunStatus(0);
                    ykcFrame.data(request).write();
                });
        await();
    }


    private void testRequest(boolean matchSeqNoFirst) throws Exception {
        waitFor(20);
        IotServer iotServer = matchSeqNoFirst ? this.iotServer : YkcServer.create(vertx, YkcServer.newOptions().setSeqNoMatchFirst(false));
        iotServer.frameHandler(frame -> {
            checkCheckCodeResult(frame);
            Frame<YkcHeartbeatRequest> requestFrame = (Frame<YkcHeartbeatRequest>) frame;
            Frame<YkcHeartbeatResponse> responseFrame = requestFrame.asRequest(YkcCommand.HeartbeatRequest).responseFrame();
            YkcHeartbeatResponse response = responseFrame.newData();
            response.setResult(0);
            response.setGunNo(1);
            response.setTerminalNo(frame.terminalNo());

            responseFrame.data(response).write();
        });
        startServer(socketAddress, iotServer);

        for (int i = 0; i < 10; i++) {
            requestHeartbeatFrame(socketAddress)
                    .onSuccess(responseFrame -> {
                        YkcHeartbeatResponse data = responseFrame.data();
                        assertTrue(data != null && data.getGunNo() == 1 && data.getResult() == 0);
                        complete();
                    });
        }

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    for (int i = 0; i < 10; i++) {
                        YkcFrame<YkcHeartbeatRequest> ykcFrame = YkcFrame.create(connection, YkcCommand.HeartbeatRequest);
                        YkcHeartbeatRequest request = ykcFrame.newData();
                        request.setGunNo(1);
                        request.setGunStatus(0);
                        ykcFrame.data(request)
                                .asRequest(YkcCommand.HeartbeatRequest)
                                .request()
                                .onSuccess(responseFrame -> {
                                    YkcHeartbeatResponse data = responseFrame.data();
                                    assertTrue(data != null && data.getGunNo() == 1 && data.getResult() == 0);
                                    complete();
                                });
                    }
                });
        await();
    }

    @Test
    public void testRequest() throws Exception {
        testRequest(true);
    }

    @Test
    public void testMatchCommandRequest() throws Exception {
        testRequest(false);
    }


}
