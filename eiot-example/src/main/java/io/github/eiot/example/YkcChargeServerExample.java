package io.github.eiot.example;

import io.github.eiot.Frame;
import io.github.eiot.charge.ykc.YkcChargeServer;
import io.github.eiot.charge.ykc.YkcMessageType;
import io.github.eiot.charge.ykc.data.YkcHeartbeatRequest;
import io.github.eiot.charge.ykc.data.YkcHeartbeatResponse;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.github.eiot.charge.ykc.data.YkcLoginResponse;
import io.github.eiot.route.IotRouter;
import io.github.eiot.route.IotRoutingContext;
import io.github.eiot.route.MessageTypeHandler;
import io.github.eiot.server.IotServer;
import io.vertx.core.Vertx;

/**
 * created by wang007 on 2025/4/11
 */
public class YkcChargeServerExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        IotServer chargeServer = YkcChargeServer.create(vertx);
        IotRouter router = IotRouter.router(vertx);

        // heartbeat handler
        router.route(YkcMessageType.YkcHeartbeatRequest)
                .handler(ctx -> {
                    Frame<YkcHeartbeatRequest> frame = ctx.frame();
                    System.out.println("heartbeat. gunNo: " + frame.data().getGunNo());

                    Frame<YkcHeartbeatResponse> responseFrame = frame.<YkcHeartbeatResponse>asRequest().responseFrame();

                    YkcHeartbeatResponse response = responseFrame.newDate();
                    response.setGunNo(frame.data().getGunNo());
                    response.setResult(1);
                    responseFrame.data(response).write();
                });


        router.route(new YkcLoginHandler());

        chargeServer.frameHandler(router).listen()
                .onComplete(ar -> {
                    if (ar.succeeded()) {
                        System.out.println(ar.result().protocol() + " server listening on: " + ar.result().actualPort());
                    } else {
                        System.out.println(ar.result().protocol() + " server start failed");
                        ar.cause().printStackTrace();
                        ;
                    }
                });
    }

    /**
     * login handler
     */
    static class YkcLoginHandler implements MessageTypeHandler<YkcLoginRequest> {

        @Override
        public String messageType() {
            return YkcMessageType.YkcLoginRequest.messageType();
        }

        @Override
        public void handle(IotRoutingContext<YkcLoginRequest> ctx) {
            Frame<YkcLoginRequest> frame = ctx.frame();
            YkcLoginRequest data = frame.data();
            String terminalNo = frame.terminalNo();
            System.out.println("terminalNo: " + terminalNo + "login.");

            // Login authentication processing

            // response login result
            Frame<YkcLoginResponse> responseFrame = frame.<YkcLoginResponse>asRequest().responseFrame();
            YkcLoginResponse loginResponse = responseFrame.newDate();
            loginResponse.setResult(1);
            loginResponse.setTerminalNo(data.getTerminalNo());
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
