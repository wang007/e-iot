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
    @Fluent
    public WebSocketBase writeFrame(WebSocketFrame frame, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writeFrame(frame, handler);
    }

    @Override
    public Future<Void> writeFinalTextFrame(String text) {
        return webSocketBase.writeFinalTextFrame(text);
    }

    @Override
    @Fluent
    public WebSocketBase writeFinalTextFrame(String text, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writeFinalTextFrame(text, handler);
    }

    @Override
    public Future<Void> writeFinalBinaryFrame(Buffer data) {
        return webSocketBase.writeFinalBinaryFrame(data);
    }

    @Override
    @Fluent
    public WebSocketBase writeFinalBinaryFrame(Buffer data, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writeFinalBinaryFrame(data, handler);
    }

    @Override
    public Future<Void> writeBinaryMessage(Buffer data) {
        return webSocketBase.writeBinaryMessage(data);
    }

    @Override
    @Fluent
    public WebSocketBase writeBinaryMessage(Buffer data, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writeBinaryMessage(data, handler);
    }

    @Override
    public Future<Void> writeTextMessage(String text) {
        return webSocketBase.writeTextMessage(text);
    }

    @Override
    @Fluent
    public WebSocketBase writeTextMessage(String text, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writeTextMessage(text, handler);
    }

    @Override
    @Fluent
    public WebSocketBase writePing(Buffer data, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writePing(data, handler);
    }

    @Override
    public Future<Void> writePing(Buffer data) {
        return webSocketBase.writePing(data);
    }

    @Override
    @Fluent
    public WebSocketBase writePong(Buffer data, Handler<AsyncResult<Void>> handler) {
        return webSocketBase.writePong(data, handler);
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
    public void end(Handler<AsyncResult<Void>> handler) {
        webSocketBase.end(handler);
    }

    @Override
    public Future<Void> close() {
        return webSocketBase.close();
    }

    @Override
    public void close(Handler<AsyncResult<Void>> handler) {
        webSocketBase.close(handler);
    }

    @Override
    public Future<Void> close(short statusCode) {
        return webSocketBase.close(statusCode);
    }

    @Override
    public void close(short statusCode, Handler<AsyncResult<Void>> handler) {
        webSocketBase.close(statusCode, handler);
    }

    @Override
    public Future<Void> close(short statusCode, @Nullable String reason) {
        return webSocketBase.close(statusCode, reason);
    }

    @Override
    public void close(short statusCode, @Nullable String reason, Handler<AsyncResult<Void>> handler) {
        webSocketBase.close(statusCode, reason, handler);
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
    @Deprecated
    public X509Certificate[] peerCertificateChain() throws SSLPeerUnverifiedException {
        return webSocketBase.peerCertificateChain();
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
    public void write(Buffer data, Handler<AsyncResult<Void>> handler) {
        webSocketBase.write(data, handler);
    }

    @Override
    public boolean writeQueueFull() {
        return webSocketBase.writeQueueFull();
    }

}
