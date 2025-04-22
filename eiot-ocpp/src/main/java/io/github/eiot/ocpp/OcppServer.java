package io.github.eiot.ocpp;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.IotServer;
import io.github.eiot.ocpp.impl.OcppServerImpl;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;

/**
 * An ocpp server.
 * <p>
 * created by wang007 on 2025/4/17
 */
public interface OcppServer extends IotServer {

    static OcppServerOptions newOptions() {
        return new OcppServerOptions();
    }

    static OcppServerOptions newOptions(JsonObject options) {
        return new OcppServerOptions(options);
    }

    static OcppServer create(Vertx vertx) {
        return new OcppServerImpl(vertx, newOptions());
    }

    static OcppServer create(Vertx vertx, OcppServerOptions options) {
        return new OcppServerImpl(vertx, options);
    }

    static OcppServer wrap(Vertx vertx, HttpServer httpServer) {
        return new OcppServerImpl(vertx, httpServer, newOptions());
    }

    static OcppServer wrap(Vertx vertx, HttpServer httpServer, OcppServerOptions options) {
        return new OcppServerImpl(vertx, httpServer, options);
    }

    /**
     * Set a handler for ocpp webSocket handshake.
     *
     * @param handler the handler
     * @return ocpp server
     */
    OcppServer webSocketHandshakeHandler(Handler<OcppWebSocketHandshake> handler);

    @Override
    OcppServer frameHandler(Handler<Frame<?>> handler);

    @Override
    OcppServer connectionHandler(Handler<IotConnection> handler);

    OcppServer exceptionHandler(Handler<Throwable> handler);

}
