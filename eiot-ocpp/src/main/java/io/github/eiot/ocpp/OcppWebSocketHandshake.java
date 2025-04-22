package io.github.eiot.ocpp;

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.net.HostAndPort;
import io.vertx.core.net.SocketAddress;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.security.cert.Certificate;
import java.util.List;

/**
 * An ocpp server WebSocket handshake, allows controlling acceptance or rejection of an ocpp WebSocket.
 *
 * created by wang007 on 2025/4/16
 */
public interface OcppWebSocketHandshake {

    /**
     *  Returns the HTTP headers.
     *
     * @return the headers
     */
    MultiMap headers();

    /**
     * @return the WebSocket handshake scheme
     */
    String scheme();

    /**
     * @return the WebSocket handshake authority
     */
    HostAndPort authority();

    /*
     * @return the WebSocket handshake URI. This is a relative URI.
     */
    String uri();

    /**
     * @return the WebSocket handshake path.
     */
    String path();

    /**
     * extract path suffix as terminalNo.
     *
     * @return the terminalNo
     */
    default String extractLastPathAsTerminalNo() {
        String path = path();
        int indexOf = path.lastIndexOf('/');
        return path.substring(indexOf);
    }

    /**
     * @return the WebSocket handshake query string.
     */
    String query();

    /**
     * Accept the ocpp WebSocket and terminate the ocpp WebSocket handshake.
     * <p/>
     * This method should be called from the WebSocket handler to explicitly accept the ocpp WebSocket and
     * terminate the ocpp WebSocket handshake.
     *
     * @param terminalNo the terminalNo
     * @throws IllegalStateException when the ocpp WebSocket handshake is already set
     */
    Future<OcppConnection> accept(String terminalNo);

    /**
     * Reject the ocpp WebSocket.
     * <p>
     * Calling this method from the WebSocket handler when it is first passed to you gives you the opportunity to reject
     * the WebSocket, which will cause the WebSocket handshake to fail by returning
     * a {@literal 502} response code.
     * <p>
     * You might use this method, if for example you only want to accept WebSockets with a particular path.
     *
     * @throws IllegalStateException when the WebSocket handshake is already set
     */
    default Future<Void> reject() {
        // SC_BAD_GATEWAY
        return reject(502);
    }

    /**
     * Like {@link #reject()} but with a {@code status}.
     */
    Future<Void> reject(int status);

    /**
     * @return the remote address for this connection, possibly {@code null} (e.g a server bound on a domain socket).
     * If {@code useProxyProtocol} is set to {@code true}, the address returned will be of the actual connecting client.
     */
    SocketAddress remoteAddress();

    /**
     * @return the local address for this connection, possibly {@code null} (e.g a server bound on a domain socket)
     * If {@code useProxyProtocol} is set to {@code true}, the address returned will be of the proxy.
     */
    SocketAddress localAddress();

    /**
     * @return true if this {@link io.vertx.core.http.HttpConnection} is encrypted via SSL/TLS.
     */
    boolean isSsl();

    /**
     * @return SSLSession associated with the underlying socket. Returns null if connection is
     *         not SSL.
     * @see javax.net.ssl.SSLSession
     */
    SSLSession sslSession();

    /**
     * @return an ordered list of the peer certificates. Returns null if connection is
     *         not SSL.
     * @throws javax.net.ssl.SSLPeerUnverifiedException SSL peer's identity has not been verified.
     * @see SSLSession#getPeerCertificates() ()
     * @see #sslSession()
     */
    List<Certificate> peerCertificates() throws SSLPeerUnverifiedException;
}
