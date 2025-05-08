package io.github.eiot.ocpp.impl;

import io.github.eiot.ocpp.OcppConnection;
import io.github.eiot.ocpp.OcppWebSocketHandshake;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.http.ServerWebSocketHandshake;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.net.HostAndPort;
import io.vertx.core.net.SocketAddress;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.security.cert.Certificate;
import java.util.List;
import java.util.function.Consumer;

/**
 * created by wang007 on 2025/4/19
 */
public class OcppWebSocketHandshakeImpl implements OcppWebSocketHandshake {

    private final VertxInternal vertx;

    private final ServerWebSocketHandshake webSocketHandshake;

    private final Consumer<OcppConnectionImpl> afterAcceptConsumer;

    public OcppWebSocketHandshakeImpl(VertxInternal vertx, ServerWebSocketHandshake webSocketHandshake, Consumer<OcppConnectionImpl> afterAcceptConsumer) {
        this.vertx = vertx;
        this.webSocketHandshake = webSocketHandshake;
        this.afterAcceptConsumer = afterAcceptConsumer;
    }

    @Override
    public MultiMap headers() {
        return webSocketHandshake.headers();
    }

    @Override
    public String scheme() {
        return webSocketHandshake.scheme();
    }

    @Override
    public HostAndPort authority() {
        return webSocketHandshake.authority();
    }

    @Override
    public String uri() {
        return webSocketHandshake.uri();
    }

    @Override
    public String path() {
        return webSocketHandshake.path();
    }

    @Override
    public String query() {
        return webSocketHandshake.query();
    }

    @Override
    public Future<OcppConnection> accept(String terminalNo) {
        return webSocketHandshake.accept()
                .map(ws -> {
                    OcppConnectionImpl ocppConnection = new OcppConnectionImpl(vertx, ws, terminalNo);
                    afterAcceptConsumer.accept(ocppConnection);
                    return ocppConnection;
                });
    }

    @Override
    public Future<Void> reject(int status) {
        return webSocketHandshake.reject(status);
    }

    @Override
    public SocketAddress remoteAddress() {
        return webSocketHandshake.remoteAddress();
    }

    @Override
    public SocketAddress localAddress() {
        return webSocketHandshake.localAddress();
    }

    @Override
    public boolean isSsl() {
        return webSocketHandshake.isSsl();
    }

    @Override
    public SSLSession sslSession() {
        return webSocketHandshake.sslSession();
    }

    @Override
    public List<Certificate> peerCertificates() throws SSLPeerUnverifiedException {
        return webSocketHandshake.peerCertificates();
    }
}
