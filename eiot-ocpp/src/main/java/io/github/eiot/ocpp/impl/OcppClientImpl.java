package io.github.eiot.ocpp.impl;

import io.github.eiot.ocpp.OcppClient;
import io.github.eiot.ocpp.OcppClientOptions;
import io.github.eiot.ocpp.OcppConnectOptions;
import io.github.eiot.ocpp.OcppConnection;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.WebSocketClient;

/**
 * created by wang007 on 2025/5/12
 */
public class OcppClientImpl implements OcppClient {

    private final Vertx vertx;
    private final WebSocketClient webSocketClient;
    private final OcppClientOptions options;

    public OcppClientImpl(Vertx vertx, OcppClientOptions options) {
        this(vertx, vertx.createWebSocketClient(options), options);
    }

    // for wrap
    public OcppClientImpl(Vertx vertx, WebSocketClient webSocketClient, OcppClientOptions options) {
        this.vertx  = vertx;
        this.webSocketClient = webSocketClient;
        this.options = options;
    }


    @Override
    public Future<OcppConnection> connect(OcppConnectOptions options) {
        return null;
    }

    @Override
    public Future<Void> close() {
        return null;
    }
}
