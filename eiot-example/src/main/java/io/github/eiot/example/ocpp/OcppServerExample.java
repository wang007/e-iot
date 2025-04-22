package io.github.eiot.example.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.Frame;
import io.github.eiot.ocpp.OcppFrame;
import io.github.eiot.ocpp.OcppServer;
import io.github.eiot.ocpp.schema.v2_1.*;
import io.github.eiot.route.CommandDefHandler;
import io.github.eiot.route.IotRouter;
import io.github.eiot.route.IotRoutingContext;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;

import java.time.ZonedDateTime;

/**
 * created by wang007 on 2025/5/19
 */
public class OcppServerExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(OcppServerVerticle.class, new DeploymentOptions());
    }

    public static class OcppServerVerticle extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) throws Exception {

            // default only support ocpp2.0.1 and ocpp2.1
            OcppServer ocppServer = OcppServer.create(vertx);

            IotRouter router = IotRouter.router(vertx);


            router.route(Ocpp2_1Command.BootNotificationRequest)
                    .handler(ctx -> {
                        Frame<BootNotificationRequest> requestFrame = ctx.frame();
                        BootNotificationRequest data = requestFrame.data();
                        ChargingStation chargingStation = data.getChargingStation();
                        System.out.println("login in charging Station: " + chargingStation);

                        Frame<BootNotificationResponse> responseFrame = requestFrame.asRequest(BootNotificationResponse.class)
                                .responseFrame();
                        BootNotificationResponse response = responseFrame.data();

                        response.setCurrentTime(ZonedDateTime.now());
                        response.setInterval(45); // heart beat interval 45s
                        response.setStatus(RegistrationStatusEnum.ACCEPTED); // success

                        responseFrame.data(response).write();

                        // request frame to charging station
                        OcppFrame<TriggerMessageRequest> frame = OcppFrame.create(ctx.connection(), Ocpp2_1Command.TriggerMessageRequest);
                        TriggerMessageRequest requestData = frame.newData()
                                .withEvse(new EVSE().withId(1))
                                .withRequestedMessage(MessageTriggerEnum.HEARTBEAT);

                        frame.data(requestData)
                                .asRequest(TriggerMessageResponse.class)
                                .request()
                                .onSuccess(respFrame -> {
                                    TriggerMessageResponse tmResponse = respFrame.data();
                                    System.out.println("TriggerMessageResponse status: " + tmResponse.getStatus());
                                })
                                .onFailure(ex -> {
                                    System.out.println("request TriggerMessage failed. ");
                                    ex.printStackTrace();
                                });
                    });

            router.route(new HeartbeatHandler());

            ocppServer.webSocketHandshakeHandler(wsHandshake -> {
                String terminalNo = wsHandshake.extractLastPathAsTerminalNo();
                System.out.println("accept ws ocpp connection: " + terminalNo + ", path: " + wsHandshake.path());

                String auth = wsHandshake.headers().get(HttpHeaders.AUTHORIZATION);
                System.out.println("http auth: " + auth);

                // accept
                wsHandshake.accept(terminalNo);
            });

            ocppServer.frameHandler(router)
                    .listen(8888)
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            System.out.println(ar.result().protocol() + " server listening on: " + ar.result().actualPort());
                        } else {
                            System.out.println(ar.result().protocol() + " server start failed");
                            ar.cause().printStackTrace();
                            ;
                        }
                    })
                    .<Void>mapEmpty()
                    .onComplete(startPromise);
        }
    }

    static class HeartbeatHandler implements CommandDefHandler<HeartbeatRequest> {

        @Override
        public CommandDef<HeartbeatRequest> commandDef() {
            return Ocpp2_1Command.HeartbeatRequest;
        }

        @Override
        public void handle(IotRoutingContext<HeartbeatRequest> ctx) {
            Frame<HeartbeatRequest> requestFrame = ctx.frame();
            requestFrame.asRequest(HeartbeatResponse.class)
                    .responseFrame()
                    .data(new HeartbeatResponse().withCurrentTime(ZonedDateTime.now()))
                    .write();
        }
    }


}
