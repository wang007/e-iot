package io.github.eiot.charge;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;


/**
 * Represents an server charge connection.
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface ChargeConnection extends AttributeHolder, ReadStream<Buffer>, WriteStream<Buffer> {

    String TERMINAL_NO_KEY = "_terminal";

    /**
     * @return the remote address for this connection, possibly {@code null} (e.g a server bound on a domain socket).
     * If {@code useProxyProtocol} is set to {@code true}, the address returned will be of the actual connecting client.
     */
    SocketAddress remoteAddress();

    /**
     * Like {@link #remoteAddress()} but returns the proxy remote address when {@code real} is {@code true}
     */
    SocketAddress remoteAddress(boolean real);

    /**
     * @return the local address for this connection, possibly {@code null} (e.g a server bound on a domain socket)
     * If {@code useProxyProtocol} is set to {@code true}, the address returned will be of the proxy.
     */
    SocketAddress localAddress();

    /**
     * Like {@link #localAddress()} ()} but returns the server local address when {@code real} is {@code true}
     */
    SocketAddress localAddress(boolean real);

    /**
     * Send the current frame and wait for the response frame.
     *
     * @param frame     request frame
     * @param timeoutMs timeout
     * @return
     */
    Future<Frame<?>> send(RequestFrame<?, Frame<?>> frame, int timeoutMs);

    /**
     * Use default timeout send the current frame and wait for the response frame.
     *
     * @param frame request frame
     * @return
     */
    default Future<Frame<?>> send(RequestFrame<?, Frame<?>> frame) {
        return send(frame, 0);
    }

    /**
     * @param frame frame
     * @return a future completed with the write operation result
     */
    Future<Void> write(Frame<?> frame);

    /**
     * Close the connection
     *
     * @return a future completed with the closed operation result
     */
    Future<Void> close();

    /**
     * When the connection is closed, future is set as a result
     *
     * @return a future completed with the closed operation result
     */
    Future<Void> closeFuture();

    /**
     * @return Connection closed or not
     */
    boolean isClosed();


    /**
     * Set an exception handler
     *
     * @param handler the handler to set
     * @return a reference to this, so the API can be used fluently
     */
    @Override
    ChargeConnection exceptionHandler(Handler<Throwable> handler);

    /**
     * Set an frame handler
     *
     * @param handler the handler to set
     * @return a reference to this, so the API can be used fluently
     */
    ChargeConnection frameHandler(Handler<Frame<?>> handler);

    /**
     * Set an SendWriteHook
     *
     * @param hook the hook to set
     * @return a reference to this, so the API can be used fluently
     */
    ChargeConnection sendWriteHook(SendWriteHook hook);

    /**
     * set the response frame result by {@link #send(RequestFrame)} when the response frame come back.
     * <p>
     * NOTE: don't called it, is internal method.
     *
     * @param frame the response frame
     * @param ex    the failed result
     * @return set result
     */
    boolean trySetResponseResult(Frame<?> frame, Throwable ex);

    String protocol();
}
