package io.github.eiot.ocpp.impl;

import io.vertx.codegen.annotations.CacheReturn;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocketBase;
import io.vertx.core.http.WebSocketFrame;
import io.vertx.core.net.SocketAddress;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.cert.X509Certificate;
import java.security.cert.Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * created by wang007 on 2025/5/13
 */
public class OcppWebSocketWrapper implements WebSocketBase {

    private final WebSocketBase webSocketBase;

    public OcppWebSocketWrapper(WebSocketBase webSocketBase) {
        this.webSocketBase = webSocketBase;
    }

    @Override
    @Fluent
    public WebSocketBase textMessageHandler(@Nullable Handler<String> handler) {
        throw new UnsupportedOperationException("unsupported to set textMessageHandler");
    }

    @Override
    @Fluent
    public WebSocketBase closeHandler(@Nullable Handler<Void> handler) {
        throw new UnsupportedOperationException("unsupported to set closeHandler");
    }

    @Override
    public WebSocketBase shutdownHandler(@Nullable Handler<Void> handler) {
        return webSocketBase.shutdownHandler(handler);
    }

    @Override
    public WebSocketBase exceptionHandler(Handler<Throwable> handler) {
        return webSocketBase.exceptionHandler(handler);
    }

    @Override
    public WebSocketBase handler(Handler<Buffer> handler) {
        return webSocketBase.handler(handler);
    }

    @Override
    public WebSocketBase pause() {
        return webSocketBase.pause();
    }

    @Override
    public WebSocketBase resume() {
        return webSocketBase.resume();
    }

    @Override
    public WebSocketBase fetch(long amount) {
        return webSocketBase.fetch(amount);
    }

    @Override
    public WebSocketBase endHandler(Handler<Void> endHandler) {
        return webSocketBase.endHandler(endHandler);
    }

    @Override
    public WebSocketBase setWriteQueueMaxSize(int maxSize) {
        return webSocketBase.setWriteQueueMaxSize(maxSize);
    }

    @Override
    public WebSocketBase drainHandler(Handler<Void> handler) {
        return webSocketBase.drainHandler(handler);
    }

    @Override
    public String binaryHandlerID() {
        return webSocketBase.binaryHandlerID();
    }

    @Override
    public String textHandlerID() {
        return webSocketBase.textHandlerID();
    }

    @Override
    public String subProtocol() {
        return webSocketBase.subProtocol();
    }

    @Override
    public Short closeStatusCode() {
        return webSocketBase.closeStatusCode();
    }

    @Override
    public String closeReason() {
        return webSocketBase.closeReason();
    }

    @Override
    public MultiMap headers() {
        return webSocketBase.headers();
    }

    @Override
    public Future<Void> writeFrame(WebSocketFrame frame) {
        return webSocketBase.writeFrame(frame);
    }

    @Override
    public Future<Void> writeFinalTextFrame(String text) {
        return webSocketBase.writeFinalTextFrame(text);
    }

    @Override
    public Future<Void> writeFinalBinaryFrame(Buffer data) {
        return webSocketBase.writeFinalBinaryFrame(data);
    }

    @Override
    public Future<Void> writeBinaryMessage(Buffer data) {
        return webSocketBase.writeBinaryMessage(data);
    }

    @Override
    public Future<Void> writeTextMessage(String text) {
        return webSocketBase.writeTextMessage(text);
    }

    @Override
    public Future<Void> writePing(Buffer data) {
        return webSocketBase.writePing(data);
    }

    @Override
    public Future<Void> writePong(Buffer data) {
        return webSocketBase.writePong(data);
    }

    @Override
    @Fluent
    public WebSocketBase frameHandler(@Nullable Handler<WebSocketFrame> handler) {
        return webSocketBase.frameHandler(handler);
    }

    @Override
    @Fluent
    public WebSocketBase binaryMessageHandler(@Nullable Handler<Buffer> handler) {
        return webSocketBase.binaryMessageHandler(handler);
    }

    @Override
    @Fluent
    public WebSocketBase pongHandler(@Nullable Handler<Buffer> handler) {
        return webSocketBase.pongHandler(handler);
    }

    @Override
    public Future<Void> end() {
        return webSocketBase.end();
    }

    @Override
    public Future<Void> close() {
        return webSocketBase.close();
    }

    @Override
    public Future<Void> close(short statusCode) {
        return webSocketBase.close(statusCode);
    }


    @Override
    public Future<Void> close(short statusCode, @Nullable String reason) {
        return webSocketBase.close(statusCode, reason);
    }

    @Override
    public Future<Void> shutdown(long timeout, TimeUnit unit, short statusCode, @Nullable String reason) {
        return null;
    }

    @Override
    @CacheReturn
    public SocketAddress remoteAddress() {
        return webSocketBase.remoteAddress();
    }

    @Override
    @CacheReturn
    public SocketAddress localAddress() {
        return webSocketBase.localAddress();
    }

    @Override
    public boolean isSsl() {
        return webSocketBase.isSsl();
    }

    @Override
    public boolean isClosed() {
        return webSocketBase.isClosed();
    }

    @Override
    @GenIgnore({"permitted-type"})
    public SSLSession sslSession() {
        return webSocketBase.sslSession();
    }

    @Override
    @GenIgnore
    public List<Certificate> peerCertificates() throws SSLPeerUnverifiedException {
        return webSocketBase.peerCertificates();
    }

    @Override
    public Future<Void> write(Buffer data) {
        return webSocketBase.write(data);
    }

    @Override
    public boolean writeQueueFull() {
        return webSocketBase.writeQueueFull();
    }

}
