package io.github.eiot.test;

import io.github.eiot.route.handler.CheckCodeHandler;
import io.github.eiot.route.handler.FrameConverterHandler;
import io.github.eiot.route.handler.SetResponseResultHandler;
import io.github.eiot.test.example.*;
import io.github.eiot.test.example.data.ExampleHeartbeatRequest;
import io.github.eiot.test.example.data.ExampleHeartbeatResponse;
import io.github.eiot.test.example.data.ExampleLoginRequest;
import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.IotServerOptions;
import io.github.eiot.codec.BCDTime;
import io.github.eiot.route.*;
import io.netty.buffer.ByteBuf;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * created by wang007 on 2025/6/26
 */
public class IotRouterTest extends IotServerTest {

    @Test
    public void testRouteHandler() throws Exception {
        waitFor(2);

        IotRouter router = IotRouter.router(vertx);
        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> {
                    Frame<ExampleHeartbeatRequest> frame = ctx.frame();
                    ExampleHeartbeatRequest data = frame.data();
                    assertTrue(data != null);
                    complete();
                });

        router.route(ExampleCommand.LoginRequest.command())
                .handler(ctx -> {
                    Frame<Object> frame = ctx.frame();
                    ExampleLoginRequest data = (ExampleLoginRequest) frame.data();
                    assertTrue(data != null);
                    complete();
                });

        iotServer.frameHandler(router);
        startServer(socketAddress);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest heartbeatRequest = frame.newData();
                    heartbeatRequest.setTime(BCDTime.now());
                    heartbeatRequest.setStatus(1);
                    frame.data(heartbeatRequest).write();

                    ExampleFrame<ExampleLoginRequest> frame1 = new DefaultExampleFrame<>(connection, ExampleCommand.LoginRequest);
                    ExampleLoginRequest loginRequest = frame1.newData();
                    loginRequest.setCard("1234");
                    loginRequest.setUsername("wang007");
                    loginRequest.setSafeMode(1);
                    frame1.data(loginRequest).write();
                });
        await();
    }

    @Test
    public void testMatchAll() throws Exception {
        IotRouter router = IotRouter.router(vertx);
        router.route(ExampleCommand.LoginRequest)
                .handler(ctx -> {
                    this.fail("not except match loginRequest frame");
                });
        router.route()
                .handler(ctx -> {
                    Frame<Object> frame = ctx.frame();
                    assertTrue(frame.data() != null);
                    complete();
                });
        iotServer.frameHandler(router);
        startServer(socketAddress);

        writeHeartbeatFrame();
        await();
    }

    @Test
    public void testNext() throws Exception {
        waitFor(3);
        IotRouter router = IotRouter.router(vertx);

        router.route(ExampleCommand.HeartbeatRequest.command())
                .handler(ctx -> {
                    ctx.next();
                    complete();
                });
        router.route()
                .handler(ctx -> {
                    ctx.next();
                    complete();
                });

        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> {
                    Frame<ExampleHeartbeatRequest> frame = ctx.frame();
                    ExampleHeartbeatRequest data = frame.data();
                    assertTrue(data != null && data.getStatus() == 1);
                    complete();
                });
        iotServer.frameHandler(router);
        startServer(socketAddress);

        writeHeartbeatFrame();
        await();
    }

    @Test
    public void testMatchRaw() throws Exception {
        waitFor(2);
        IotServerOptions serverOptions = ExampleIotServer.newOptions()
                .setSetResponseResult(false)
                .setFrameConverter(false);
        ExampleIotServer iotServer = ExampleIotServer.create(vertx, serverOptions);
        IotRouter router = IotRouter.router(vertx);
        router.route()
                .matchRaw()
                .handler(ctx -> {
                    Frame<Object> frame = ctx.frame();
                    ByteBuf data = (ByteBuf) frame.data();
                    assertTrue(data != null && data.readableBytes() > 0);
                    ctx.next();
                    complete();
                });

        router.route().matchRaw().handler(new FrameConverterHandler(ExampleFrameConverter.INSTANCE));

        router.route()
                .onlyMatchRaw()
                .handler(ctx -> {
                    this.fail("not except match");
                });

        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> {
                    Frame<ExampleHeartbeatRequest> frame = ctx.frame();
                    ExampleHeartbeatRequest data = frame.data();
                    assertTrue(data != null && data.getStatus() == 1);
                    complete();
                });

        iotServer.frameHandler(router);
        startServer(socketAddress, iotServer);

        writeHeartbeatFrame();
        await();
    }

    @Test
    public void testFailureHandler() throws Exception {
        waitFor(4);
        IotRouter router = IotRouter.router(vertx);
        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> {
                    ctx.fail(new RuntimeException());
                    complete();
                });

        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> this.fail("not except match"));

        router.route()
                .handler(ctx -> this.fail("not except match"));

        router.route(ExampleCommand.HeartbeatRequest)
                .failureHandler(ctx -> {
                    assertTrue(ctx.failed());
                    assertTrue(ctx.failure() instanceof RuntimeException);
                    ctx.next();
                    complete();
                });

        router.route()
                .failureHandler(ctx -> {
                    assertTrue(ctx.failed());
                    assertTrue(ctx.failure() instanceof RuntimeException);
                    complete();
                    ctx.next();
                });

        router.exceptionHandler(ex -> {
            assertTrue(ex instanceof RuntimeException);
            complete();
        });
        iotServer.frameHandler(router);
        startServer(socketAddress);

        writeHeartbeatFrame();
        await();
    }

    @Test
    public void testOrder() throws Exception {
        waitFor(4);
        IotRouter router = IotRouter.router(vertx);
        List<Integer> orders = new ArrayList<>();

        router.route()
                .last()
                .handler(ctx -> {
                    orders.add(4);
                    ctx.next();
                    complete();
                });

        router.route()
                .first()
                .handler(ctx -> {
                    orders.add(1);
                    ctx.next();
                    complete();
                });

        router.route(ExampleCommand.HeartbeatRequest)
                .order(1)
                .handler(ctx -> {
                    orders.add(2);
                    ctx.next();
                    complete();
                });

        router.route()
                .order(2)
                .handler(ctx -> {
                    orders.add(3);
                    ctx.next();
                    complete();
                });

        iotServer.frameHandler(router);
        startServer(socketAddress);

        writeHeartbeatFrame();
        await();

        for (int i = 1; i <= 4; i++) {
            assertTrue(orders.get(i - 1) == i);
        }
    }


    @Test
    public void testHandlerMapping() throws Exception {
        waitFor(2);

        IotRouter router = IotRouter.router(vertx);
        IotHandlerMapping handlers = new IotHandlerMapping();
        router.route().handler(handlers);

        handlers.handler(ExampleCommand.HeartbeatRequest, ctx -> {
            Frame<ExampleHeartbeatRequest> frame = ctx.frame();
            ExampleHeartbeatRequest data = frame.data();
            assertTrue(data != null);
            complete();
        });

        handlers.handler(ExampleCommand.LoginRequest, ctx -> {
            Frame<ExampleLoginRequest> frame = ctx.frame();
            ExampleLoginRequest data = frame.data();
            assertTrue(data != null);
            complete();
        });

        iotServer.frameHandler(router);
        startServer(socketAddress);

        writeHeartbeatFrame();

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);

                    ExampleFrame<ExampleLoginRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.LoginRequest);
                    ExampleLoginRequest request = frame.newData();
                    request.setUsername("wang007");
                    request.setCard("1234");
                    request.setSafeMode(1);
                    frame.data(request).write();
                });

        await();
    }


    @Test
    public void testUseFrameConvertAndSetResultHandler() throws Exception {
        IotServerOptions options = ExampleIotServer.newOptions().setSetResponseResult(false).setFrameConverter(false);
        ExampleIotServer iotServer = ExampleIotServer.create(vertx, options);

        IotRouter router = IotRouter.router(vertx);

        router.route().matchRaw().handler(ctx -> {
            ctx.connection().put(IotConnection.TERMINAL_NO_KEY, terminalNo);
            Frame<Object> frame = ctx.frame();
            assertTrue(frame.isRaw());
            ctx.next();
        });
        router.route().matchRaw().handler(new CheckCodeHandler());
        router.route().matchRaw().handler(new FrameConverterHandler(ExampleFrameConverter.INSTANCE));
        router.route().matchRaw().handler(new SetResponseResultHandler());

        router.route(ExampleCommand.HeartbeatRequest)
                .handler(ctx -> {
                    Frame<ExampleHeartbeatRequest> frame = ctx.frame();
                    assertTrue(frame.data() != null);

                    Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
                    ExampleHeartbeatResponse response = responseFrame.newData();
                    response.setResult(1);
                    responseFrame.data(response).write();

                    ExampleFrame<ExampleHeartbeatRequest> requestFrame = new DefaultExampleFrame<>(ctx.connection(), ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest request = requestFrame.newData();
                    request.setTime(BCDTime.now());
                    request.setStatus(1);
                    requestFrame.data(request)
                            .asRequest(ExampleHeartbeatResponse.class)
                            .request()
                            .onFailure(this::fail)
                            .onSuccess(respFrame -> {
                                ExampleHeartbeatResponse data = respFrame.data();
                                assertTrue(data != null);
                                complete();
                            });
                });

        iotServer.frameHandler(router);
        startServer(socketAddress, iotServer);

        iotClient.connect(socketAddress)
                .onFailure(this::fail)
                .onSuccess(connection -> {
                    connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
                    connection.frameHandler(frame -> {
                        Frame<ExampleHeartbeatResponse> responseFrame = frame.asRequest(ExampleHeartbeatResponse.class).responseFrame();
                        ExampleHeartbeatResponse response = responseFrame.newData();
                        response.setResult(1);
                        responseFrame.data(response).write();
                    });

                    ExampleFrame<ExampleHeartbeatRequest> frame = new DefaultExampleFrame<>(connection, ExampleCommand.HeartbeatRequest);
                    ExampleHeartbeatRequest heartbeatRequest = frame.newData();
                    heartbeatRequest.setTime(BCDTime.now());
                    heartbeatRequest.setStatus(1);
                    frame.data(heartbeatRequest).asRequest().request();
                });

        await();
    }


}
