package io.github.eiot.ocpp;

import io.github.eiot.IotConnection;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
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
     * Return the underlying websocket.
     * <p>
     * NOTE: websocket not supported to set {@link WebSocketBase#textMessageHandler(Handler)}
     * and {@link WebSocketBase#closeHandler(Handler)}
     *
     * @return Return the underlying websocket.
     */
    WebSocketBase websocket();

    /**
     * @param utf8TextData must be utf-8 bytes
     * @param handler      the handler
     */
    @Override
    void write(Buffer utf8TextData, Handler<AsyncResult<Void>> handler);

    /**
     * @param utf8TextData must be utf-8 bytes
     * @return the handler
     */
    @Override
    Future<Void> write(Buffer utf8TextData);
}
