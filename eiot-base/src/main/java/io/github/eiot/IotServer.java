package io.github.eiot;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.SocketAddressImpl;

/**
 * A charge server.
 * <p>
 * You receive {@link Frame} by providing a {@link #frameHandler()}. As Frame arrive on the server the handler
 * will be called with the Frame.
 * <p>
 * You receive {@link IotConnection} by providing a {@link #connectionHandler()}. As charge connection arrive on the server, the
 * connection is passed to the handler.
 * <p>
 * <p>
 * created by wang007 on 2025/2/22
 */
public interface IotServer {

    /**
     * Tell the server to start listening. The server will listen on the port and host specified in the
     * {@link IotConnection} that was used when creating the server.
     * <p>
     * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
     *
     * @return a future completed with the listen operation result
     */
    Future<IotServer> listen();

    /**
     * Like {@link #listen(int, String)} but the server will listen on host "0.0.0.0" and port specified here ignoring
     * any value in the {@link IotServerOptions} that was used when creating the server.
     *
     * @param port the port to listen on
     * @return a future completed with the listen operation result
     */
    default Future<IotServer> listen(int port) {
        return listen(port, "0.0.0.0");
    }

    /**
     * Tell the server to start listening. The server will listen on the port and host specified here,
     * ignoring any value set in the {@link IotServerOptions} that was used when creating the server.
     * <p>
     * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
     *
     * @param port the port to listen on
     * @param host the host to listen on
     * @return a future completed with the listen operation result
     */
    default Future<IotServer> listen(int port, String host) {
        return listen(new SocketAddressImpl(port, host));
    }

    /**
     * Tell the server to start listening on the given address supplying
     * a handler that will be called when the server is actually
     * listening (or has failed).
     *
     * @param address the address to listen on
     */
    Future<IotServer> listen(SocketAddress address);

    /**
     * Close the server. Any open charge connections will be closed.
     * <p>
     * The close happens asynchronously and the server may not be closed until some time after the call has returned.
     *
     * @return a future completed with the result
     */
    Future<Void> close();


    /**
     * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
     * signifying an ephemeral port
     *
     * @return the actual port the server is listening on.
     */
    int actualPort();

    /**
     * Set the frame handler for the server to {@code frameHandler}. As frame are received by the server,
     * instances of {@link Frame} will be created and passed to this handler.
     *
     * @return a reference to this, so the API can be used fluently
     */
    IotServer frameHandler(Handler<Frame<?>> handler);

    /**
     * @return the frame handler
     */
    Handler<Frame<?>> frameHandler();

    /**
     * Set a connection handler for the server.
     * The handler will always be called on the event-loop thread.
     *
     * @return a reference to this, so the API can be used fluently
     */
    IotServer connectionHandler(Handler<IotConnection> handler);

    /**
     * @return the connection handler
     */
    Handler<IotConnection> connectionHandler();

    /**
     * Set an exception handler called for socket errors happening before the charge connection
     * is established, e.g during the TLS handshake.
     *
     * @param handler the handler to set
     * @return a reference to this, so the API can be used fluently
     */
    IotServer exceptionHandler(Handler<Throwable> handler);

    /**
     * Set an hook called for connection before request or write
     *
     * @param hook hook
     * @return a reference to this, so the API can be used fluently
     */
    //ChargeServer outboundHook(SendWriteHook hook);

    /**
     * @return Implementation of the charging protocol
     */
    String protocol();

}
