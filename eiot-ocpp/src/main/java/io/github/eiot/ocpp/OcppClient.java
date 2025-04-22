package io.github.eiot.ocpp;


import io.github.eiot.ocpp.impl.OcppClientImpl;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.WebSocketClient;
import io.vertx.core.json.JsonObject;

/**
 * An ocpp client
 * <p>
 * created by wang007 on 2025/5/11
 */
public interface OcppClient {

    static OcppClientOptions newOptions() {
        return new OcppClientOptions();
    }

    static OcppClientOptions newOptions(JsonObject options) {
        return new OcppClientOptions(options);
    }

    static OcppClient create(Vertx vertx) {
        return new OcppClientImpl(vertx, newOptions());
    }

    static OcppClient create(Vertx vertx, OcppClientOptions options) {
        return new OcppClientImpl(vertx, options);
    }

    static OcppClient wrap(Vertx vertx, WebSocketClient client) {
        return new OcppClientImpl(vertx, client, newOptions());
    }

    static OcppClient wrap(Vertx vertx, WebSocketClient client, OcppClientOptions options) {
        return new OcppClientImpl(vertx, client, options);
    }


    /**
     * Connect an Ocpp Websocket  to the specified port, host and relative request URI
     *
     * @param port       the port
     * @param host       the host
     * @param requestURI the relative URI
     * @param terminalNo the terminalNo
     * @return a {@code Future} of the asynchronous result
     */
    default Future<OcppConnection> connect(int port, String host, String requestURI, String terminalNo) {
        OcppConnectOptions options = new OcppConnectOptions();
        options.setTerminalNo(terminalNo)
                .setPort(port)
                .setHost(host)
                .setURI(requestURI);
        return connect(options);
    }

    /**
     * Connect an Ocpp WebSocket to the default client port and specified host and relative request URI.
     *
     * @param host       the host
     * @param requestURI the relative URI
     * @param terminalNo the terminalNo
     * @return a {@code Future} of the asynchronous result
     */
    default Future<OcppConnection> connect(String host, String requestURI, String terminalNo) {
        OcppConnectOptions options = new OcppConnectOptions();
        options.setTerminalNo(terminalNo)
                .setHost(host)
                .setURI(requestURI);
        return connect(options);
    }

    /**
     * Connect an Ocpp WebSocket to the default client port, default client host and specified, relative request URI.
     *
     * @param requestURI the relative URI
     * @param terminalNo the terminalNo
     * @return a {@code Future} of the asynchronous result
     */
    default Future<OcppConnection> connect(String requestURI, String terminalNo) {
        OcppConnectOptions options = new OcppConnectOptions();
        options.setTerminalNo(terminalNo)
                .setURI(requestURI);
        return connect(options);
    }

    /**
     * Connect an Ocpp WebSocket with the specified options.
     * @param options the request options
     */
    Future<OcppConnection> connect(OcppConnectOptions options);

    /**
     * Close the client. Closing will close down any pooled connections.
     * Clients should always be closed after use.
     *
     * @return returns a {@code Future} of the asynchronous result
     */
    Future<Void> close();
}
