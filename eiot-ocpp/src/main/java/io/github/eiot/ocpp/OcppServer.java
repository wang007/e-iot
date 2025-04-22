package io.github.eiot.ocpp;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.server.IotServer;
import io.vertx.core.Handler;

/**
 * created by wang007 on 2025/4/17
 */
public interface OcppServer extends IotServer {

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
