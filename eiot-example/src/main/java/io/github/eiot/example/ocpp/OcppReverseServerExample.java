package io.github.eiot.example.ocpp;

import io.github.eiot.ocpp.OcppClient;
import io.github.eiot.ocpp.OcppServer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;

/**
 * created by wang007 on 2025/7/2
 */
public class OcppReverseServerExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(OcppReverseServerVerticle.class, new DeploymentOptions());
    }

    public static class OcppReverseServerVerticle extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) throws Exception {

            OcppClient ocppClient = OcppClient.create(vertx, OcppClient.newOptions().setSetResponseResult(false)); // disabled set result

            OcppServer proxyServer = OcppServer.create(vertx, OcppServer.newOptions().setSetResponseResult(false));// disabled set result

            proxyServer.webSocketHandshakeHandler(wsHandshake -> {
                String terminalNo = wsHandshake.extractLastPathAsTerminalNo();
                System.out.println("proxy server accept ws ocpp connection: " + terminalNo + ", path: " + wsHandshake.path());

                String auth = wsHandshake.headers().get(HttpHeaders.AUTHORIZATION);
                System.out.println("http auth: " + auth);

                String uri = wsHandshake.uri();
                ocppClient.connect(8899, "localhost", uri, terminalNo)
                        .onFailure(ex -> {
                            System.out.println("connect upstream ocpp server failed, terminalNo: " + terminalNo);
                            ex.printStackTrace();
                            wsHandshake.reject();
                        })
                        .onSuccess(connection -> {
                            // accept
                            wsHandshake.accept(terminalNo)
                                    .onFailure(ex -> {
                                        System.out.println("accept failed, terminalNo: " + terminalNo);
                                        ex.printStackTrace();
                                        connection.close();
                                    })
                                    .onSuccess(proxyConnection -> {
                                        proxyConnection.pipeTo(connection);
                                        connection.pipeTo(proxyConnection);
                                    });
                        });
            });

            // must be set frameHandler or connectionHandler
            proxyServer.connectionHandler(connection -> {
            });

            proxyServer.listen(8899)
                    .onComplete(ar -> {
                        if (ar.succeeded()) {
                            System.out.println("proxy ocpp server listening on: " + ar.result().actualPort());
                        } else {
                            System.out.println("proxy ocpp server start failed");
                            ar.cause().printStackTrace();
                        }
                    })
                    .<Void>mapEmpty()
                    .onComplete(startPromise);
        }
    }

}
