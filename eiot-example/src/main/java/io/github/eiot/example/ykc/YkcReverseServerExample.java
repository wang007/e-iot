package io.github.eiot.example.ykc;

import io.github.eiot.charge.ykc.YkcClient;
import io.github.eiot.charge.ykc.YkcServer;
import io.github.eiot.charge.ykc.YkcCommand;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

/**
 * created by wang007 on 2025/4/11
 */
public class YkcReverseServerExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(YkcReverseServerVerticle.class, new DeploymentOptions());
    }

    public static class YkcReverseServerVerticle extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {

            YkcClient chargeClient = YkcClient.create(vertx);

            YkcServer chargeServer = YkcServer.create(vertx);
            chargeServer.connectionHandler(conn -> {
                conn.frameHandler(frame -> {
                    // pause first
                    conn.pause();

                    // first frame must be login frame
                    if (!frame.command().equals(YkcCommand.YkcLoginRequest.command())) {
                        // drop it!
                        return;
                    }
                    // rout to upstream by terminalNo
                    String terminalNo = frame.terminalNo();
                    int choose = terminalNo.hashCode() % 2;
                    String server = "localhost";
                    int port = choose == 0 ? 8888 : 8899;

                    // connect to upstream
                    chargeClient.connect(port, server)
                            .onFailure(ex -> {
                                System.out.println("route to upstream failed. terminalNo: " + terminalNo);
                                ex.printStackTrace();
                                conn.close();
                            })
                            .onSuccess(clientConn -> {
                                // reset handler
                                conn.frameHandler(null);
                                // write first frame to upstream
                                clientConn.write(frame);

                                conn.pipeTo(clientConn);
                                clientConn.pipeTo(conn);
                            });
                });
            });
            chargeServer.listen(8081)
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            System.out.println(ar.result().protocol() + " proxy server listening on: " + ar.result().actualPort());
                        } else {
                            System.out.println(ar.result().protocol() + " proxy server start failed");
                            ar.cause().printStackTrace();
                        }
                    })
                    .<Void>mapEmpty()
                    .onComplete(startPromise);
        }
    }
}
