package io.github.eiot.ocpp.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.ocpp.*;
import io.github.eiot.IotServer;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.impl.HttpServerImpl;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.net.SocketAddress;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * created by wang007 on 2025/4/17
 */
public class OcppServerImpl implements OcppServer {

    private final VertxInternal vertx;
    private final OcppServerOptions options;
    private final HttpServerImpl httpServer;

    private Handler<Frame<?>> frameHandler;
    private Handler<IotConnection> connectionHandler;
    private Handler<Throwable> exceptionHandler;
    private Handler<OcppWebSocketHandshake> handshakeHandler;

    private boolean compatibleOcpp2_0_1;

    // for wrap
    public OcppServerImpl(Vertx vertx, HttpServer httpServer, OcppServerOptions options) {
        this.vertx = (VertxInternal) vertx;
        this.options = convertOptions(options);
        List<String> subProtocols = options.getWebSocketSubProtocols();
        if (subProtocols == null || subProtocols.isEmpty()) {
            throw new IllegalStateException("wrapped http server must be set subProtocols");
        }
        configHttpServer(httpServer);
        this.httpServer = (HttpServerImpl) httpServer;
    }

    public OcppServerImpl(Vertx vertx, OcppServerOptions options) {
        this.vertx = (VertxInternal) vertx;
        options = convertOptions(options);
        this.options = options;
        HttpServer httpServer = vertx.createHttpServer(options);
        configHttpServer(httpServer);
        this.httpServer = (HttpServerImpl) httpServer;
    }

    private OcppServerOptions convertOptions(OcppServerOptions options) {
        OcppServerOptions newOptions = new OcppServerOptions(options);
        List<OcppVersion> ocppVersions = newOptions.getOcppVersions();
        if (ocppVersions == null) {
            ocppVersions = OcppServerOptions.DEFAULT_OCPP_VERSIONS;
        }
        List<String> protocols = ocppVersions.stream().map(c -> c.versionName).collect(Collectors.toList());
        newOptions.setWebSocketSubProtocols(protocols);
        if (options.isSetResponseResult() && !options.isFrameConverter()) {
            throw new IllegalArgumentException("if SetResponseResult = true, must be frameConverter = true");
        }
        this.compatibleOcpp2_0_1 = ocppVersions.containsAll(OcppServerOptions.DEFAULT_OCPP_VERSIONS);
        return newOptions;
    }

    public boolean isCompatibleOcpp2_0_1() {
        return compatibleOcpp2_0_1;
    }

    private void configHttpServer(HttpServer server) {
        server.webSocketHandler(ws -> {
            // NOOP, do nothing. just for mark!
        });
        server.webSocketHandshakeHandler(wsHandshake -> {
            Handler<OcppWebSocketHandshake> handshakeHandler = this.handshakeHandler;
            OcppWebSocketHandshakeImpl ocppWebSocketHandshake = new OcppWebSocketHandshakeImpl(vertx, wsHandshake, this.options,
                    this.frameHandler, this.exceptionHandler, this.connectionHandler,
                    compatibleOcpp2_0_1);
            handshakeHandler.handle(ocppWebSocketHandshake);
        });
    }

    @Override
    public Future<IotServer> listen() {
        return listen(options.getPort(), options.getHost());
    }

    @Override
    public synchronized Future<IotServer> listen(SocketAddress address) {
        if (handshakeHandler == null) {
            throw new IllegalStateException("Set webSocketHandshakeHandler first");
        }
        if (frameHandler == null && connectionHandler == null) {
            throw new IllegalStateException("Set frame or connect handler first");
        }
        return this.httpServer.listen(address).map(this);
    }

    @Override
    public Future<Void> close() {
        return this.httpServer.close();
    }

    @Override
    public int actualPort() {
        return this.httpServer.actualPort();
    }

    @Override
    public synchronized Handler<Frame<?>> frameHandler() {
        return this.frameHandler;
    }

    @Override
    public synchronized Handler<IotConnection> connectionHandler() {
        return this.connectionHandler;
    }

    @Override
    public String protocol() {
        return "ocpp";
    }

    @Override
    public synchronized OcppServer webSocketHandshakeHandler(Handler<OcppWebSocketHandshake> handler) {
        this.handshakeHandler = handler;
        return this;
    }

    @Override
    public synchronized OcppServer frameHandler(Handler<Frame<?>> handler) {
        if (httpServer.isListening()) {
            throw new IllegalStateException("Cannot set frameHandler when server is listening");
        }
        this.frameHandler = handler;
        return this;
    }

    @Override
    public synchronized OcppServer connectionHandler(Handler<IotConnection> handler) {
        if (httpServer.isListening()) {
            throw new IllegalStateException("Cannot set connectionHandler when server is listening");
        }
        this.connectionHandler = handler;
        return this;
    }

    @Override
    public synchronized OcppServer exceptionHandler(Handler<Throwable> handler) {
        if (httpServer.isListening()) {
            throw new IllegalStateException("Cannot set exceptionHandler when server is listening");
        }
        this.exceptionHandler = handler;
        return this;
    }
}
