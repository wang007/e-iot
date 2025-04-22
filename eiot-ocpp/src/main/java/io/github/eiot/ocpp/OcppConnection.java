package io.github.eiot.ocpp;

import io.github.eiot.IotConnection;
import io.vertx.core.http.WebSocketBase;

/**
 * Represents an ocpp connection. include ocpp 1.6, ocpp 2.0.1, ocpp 2.1, ...
 * <p>
 * created by wang007 on 2025/4/14
 */
public interface OcppConnection extends IotConnection {

    /**
     * @return terminalNo
     */
    String terminalNo();

    /**
     * @return the ocpp version
     */
    OcppVersion ocppVersion();

    /**
     *
     * @return Return the underlying websocket.
     */
    WebSocketBase websocket();



}
