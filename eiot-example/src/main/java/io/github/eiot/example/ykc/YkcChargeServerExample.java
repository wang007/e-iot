package io.github.eiot.example.ykc;

import io.github.eiot.CommandDef;
import io.github.eiot.Frame;
import io.github.eiot.charge.ykc.*;
import io.github.eiot.charge.ykc.data.*;
import io.github.eiot.codec.CP56time2a;
import io.github.eiot.route.CommandDefHandler;
import io.github.eiot.route.IotRouter;
import io.github.eiot.route.IotRoutingContext;
import io.vertx.core.*;

/**
 * created by wang007 on 2025/4/11
 */
public class YkcChargeServerExample {


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(YkcServerVerticle.class, new DeploymentOptions());
    }

    public static class YkcServerVerticle extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) throws Exception {
            YkcServer chargeServer = YkcServer.create(vertx);
            IotRouter router = IotRouter.router(vertx);

            // heartbeat handler
            router.route(YkcCommand.HeartbeatRequest)
                    .handler(ctx -> {
                        Frame<YkcHeartbeatRequest> frame = ctx.frame();
                        System.out.println("heartbeat. gunNo: " + frame.data().getGunNo());

                        Frame<YkcHeartbeatResponse> responseFrame = frame.asRequest(YkcCommand.HeartbeatRequest).responseFrame();
                        YkcHeartbeatResponse response = responseFrame.newData();
                        response.setGunNo(frame.data().getGunNo());
                        response.setResult(1);
                        responseFrame.data(response).write();

                        // sync time for charge point
                        YkcFrame.create(frame.iotConnection(), YkcCommand.SyncTimeRequest)
                                .dataBuilder(data -> data.setTime(CP56time2a.now()))
                                .request()
                                .onFailure(ex -> {
                                    System.out.println("sync time for charge point failed.");
                                    ex.printStackTrace();
                                })
                                .onSuccess(respFrame -> {
                                    YkcSyncTimeResponse data = respFrame.data();
                                    System.out.println("charge point time: " + data.getTime());
                                });
                    });

            router.route(new YkcLoginHandler());

            chargeServer.frameHandler(router)
                    .listen()
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            System.out.println(ar.result().protocol() + " server listening on: " + ar.result().actualPort());
                        } else {
                            System.out.println(ar.result().protocol() + " server start failed");
                            ar.cause().printStackTrace();
                        }
                    })
                    .<Void>mapEmpty()
                    .onComplete(startPromise);
        }

        /**
         * login handler
         */
        static class YkcLoginHandler implements CommandDefHandler<YkcLoginRequest> {

            @Override
            public CommandDef<YkcLoginRequest> commandDef() {
                return YkcCommand.LoginRequest;
            }

            @Override
            public void handle(IotRoutingContext<YkcLoginRequest> ctx) {
                Frame<YkcLoginRequest> frame = ctx.frame();
                YkcLoginRequest data = frame.data();
                String terminalNo = frame.terminalNo();
                System.out.println("terminalNo: " + terminalNo + "login.");

                // Login authentication processing

                // response login result
                Frame<YkcLoginResponse> responseFrame = frame.asRequest(YkcCommand.LoginRequest).responseFrame();
                YkcLoginResponse loginResponse = responseFrame.newData();
                loginResponse.setResult(1);
                responseFrame
                        .data(loginResponse)
                        .write()
                        .onFailure(ex -> {
                            System.out.println("write login response failed");
                            ex.printStackTrace();
                        });

            }
        }
    }

}
