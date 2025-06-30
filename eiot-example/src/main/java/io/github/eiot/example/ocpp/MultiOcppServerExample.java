package io.github.eiot.example.ocpp;

import io.github.eiot.Frame;
import io.github.eiot.ocpp.*;
import io.github.eiot.ocpp.json.Json;
import io.github.eiot.ocpp.schema.v1_6.BootNotificationRequest;
import io.github.eiot.ocpp.schema.v1_6.Ocpp1_6Command;
import io.github.eiot.ocpp.schema.v2_0_1.Ocpp2_0_1Command;
import io.github.eiot.ocpp.schema.v2_1.Ocpp2_1Command;
import io.github.eiot.route.IotRouter;
import io.github.eiot.route.handler.FrameConverterHandler;
import io.github.eiot.route.handler.SetResponseResultHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;

import java.util.Arrays;

/**
 * example for multi ocpp protocol server use same port and address
 * <p>
 * created by wang007 on 2025/7/2
 */
public class MultiOcppServerExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(OcppServerVerticle.class, new DeploymentOptions());
    }


    public static class OcppServerVerticle extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) throws Exception {

            OcppServerOptions options = OcppServer.newOptions();
            // support all ocpp version
            options.setOcppVersions(Arrays.asList(OcppVersion.OCPP2_1, OcppVersion.OCPP2_0_1, OcppVersion.OCPP1_6J));
            // disabled set result and converter
            options.setSetResponseResult(false);
            options.setFrameConverter(false);
            OcppServer ocppServer = OcppServer.create(vertx);

            IotRouter mainRouter = IotRouter.router(vertx);
            // use convertHandler without compatible ocpp2_0_1
            mainRouter.route().matchRaw().handler(new FrameConverterHandler(OcppFrameConverter.INSTANCE));
            mainRouter.route().matchRaw().handler(new SetResponseResultHandler());


            IotRouter ocpp1_6Router = IotRouter.router(vertx);
            IotRouter ocpp2_0Router = IotRouter.router(vertx);
            IotRouter ocpp2_1Router = IotRouter.router(vertx);

            ocpp1_6Handler(ocpp1_6Router);
            ocpp2_0Handler(ocpp2_0Router);
            ocpp2_1Handler(ocpp2_1Router);

            mainRouter.route().matchRaw()
                    .handler(ctx -> {
                        Frame<Object> frame = ctx.frame();
                        OcppConnection connection = (OcppConnection) frame.iotConnection();

                        if (connection.ocppVersion() == OcppVersion.OCPP2_1) {
                            ocpp2_1Router.handle(frame);
                        } else if (connection.ocppVersion() == OcppVersion.OCPP2_0_1) {
                            ocpp2_0Router.handle(frame);
                        } else if (connection.ocppVersion() == OcppVersion.OCPP1_6J) {
                            ocpp1_6Router.handle(frame);
                        } else {
                            //
                            ctx.next();
                        }
                    });

            ocppServer.webSocketHandshakeHandler(wsHandshake -> {
                String terminalNo = wsHandshake.extractLastPathAsTerminalNo();
                System.out.println("accept ws ocpp connection: " + terminalNo + ", path: " + wsHandshake.path());

                String auth = wsHandshake.headers().get(HttpHeaders.AUTHORIZATION);
                System.out.println("http auth: " + auth);

                // accept
                wsHandshake.accept(terminalNo);
            });

            ocppServer.frameHandler(mainRouter)
                    .listen(8899)
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            System.out.println("multi ocpp protocol server listening on: " + ar.result().actualPort());
                        } else {
                            System.out.println("multi ocpp protocol server server start failed");
                            ar.cause().printStackTrace();
                        }
                    })
                    .<Void>mapEmpty()
                    .onComplete(startPromise);
        }

        private void ocpp1_6Handler(IotRouter router) {
            router.route(Ocpp1_6Command.BootNotificationRequest)
                    .handler(ctx -> {
                        Frame<BootNotificationRequest> frame = ctx.frame();
                        BootNotificationRequest data = frame.data();
                        System.out.println("ocpp1.6 receive BootNotification data: " + Json.toJson(data));
                    });
        }

        private void ocpp2_0Handler(IotRouter router) {
            router.route(Ocpp2_0_1Command.BootNotificationRequest)
                    .handler(ctx -> {
                        Frame<io.github.eiot.ocpp.schema.v2_0_1.BootNotificationRequest> frame = ctx.frame();
                        io.github.eiot.ocpp.schema.v2_0_1.BootNotificationRequest data = frame.data();
                        System.out.println("ocpp2.0.1 receive BootNotification data: " + Json.toJson(data));
                    });
        }

        private void ocpp2_1Handler(IotRouter router) {
            router.route(Ocpp2_1Command.BootNotificationRequest)
                    .handler(ctx -> {
                        Frame<io.github.eiot.ocpp.schema.v2_1.BootNotificationRequest> frame = ctx.frame();
                        io.github.eiot.ocpp.schema.v2_1.BootNotificationRequest data = frame.data();
                        System.out.println("ocpp2.1 receive BootNotification data: " + Json.toJson(data));
                    });
        }

    }
}
