package io.github.eiot.ocpp.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.OutboundHook;
import io.github.eiot.RequestFrame;
import io.github.eiot.ocpp.OcppConnection;
import io.github.eiot.ocpp.OcppVersion;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocketBase;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.net.SocketAddress;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * created by wang007 on 2025/4/19
 */
public class OcppConnectionImpl implements OcppConnection {

    private final Promise<Void> closedPromise = Promise.promise();
    private final Map<String, Object> attributes = new ConcurrentHashMap<>();
    private final AtomicLong messageIdGenerator;

    final VertxInternal vertx;
    final WebSocketBase webSocket;
    final String terminalNo;
    final ContextInternal context;

    private int waitResponseTimeout;
    private boolean frameConverter;
    private boolean setResponseResult;
    private OcppVersion ocppVersion;

    private Handler<Frame<?>> frameHandler;
    private Handler<Throwable> exceptionHandler;
    private OutboundHook outboundHook;


    public OcppConnectionImpl(VertxInternal vertx, WebSocketBase webSocket, String terminalNo) {
        this.vertx = vertx;
        this.webSocket = webSocket;
        this.terminalNo = terminalNo;
        this.context = vertx.getOrCreateContext().unwrap();
        webSocket.closeHandler(v -> {
            // close hook.
            closedPromise.complete(null);
        });
        messageIdGenerator = new AtomicLong(ThreadLocalRandom.current().nextLong(50));
    }

    void configCompleted() {

    }

    public String nextMessageId() {
        long messageId = messageIdGenerator.getAndIncrement();
        return Long.toString(messageId);
    }

    public void setWaitResponseTimeout(int waitResponseTimeout) {
        this.waitResponseTimeout = waitResponseTimeout;
    }

    public void setFrameConverter(boolean frameConverter) {
        this.frameConverter = frameConverter;
    }

    public void setSetResponseResult(boolean setResponseResult) {
        this.setResponseResult = setResponseResult;
    }

    public void setOcppVersion(OcppVersion ocppVersion) {
        this.ocppVersion = ocppVersion;
    }

    public WebSocketBase getWebSocket() {
        return webSocket;
    }

    @Override
    public Map<String, Object> attributes() {
        return attributes;
    }

    @Override
    public SocketAddress remoteAddress() {
        return webSocket.remoteAddress();
    }

    @Override
    public SocketAddress remoteAddress(boolean real) {
        return webSocket.remoteAddress();
    }

    @Override
    public SocketAddress localAddress() {
        return websocket().localAddress();
    }

    @Override
    public SocketAddress localAddress(boolean real) {
        return websocket().localAddress();
    }

    /**
     * @param requestFrame the requestFrame
     * @param timeout      the timeout
     * @return the ops result of Future
     */
    protected Future<RequestFrame<?, Frame<?>>> beforeRequest(RequestFrame<?, Frame<?>> requestFrame, int timeout) {
        if (outboundHook != null) {
            return outboundHook.beforeRequest(requestFrame);
        }
        return Future.succeededFuture(requestFrame);
    }

    @Override
    public Future<Frame<?>> request(RequestFrame<?, Frame<?>> frame, int timeoutMs) {
        if (timeoutMs <= 0) {
            timeoutMs = this.waitResponseTimeout;
        }
        int time0 = timeoutMs;
        // use caller context.
        PromiseInternal<Frame<?>> promise = this.vertx.promise();



        return null;
    }

    @Override
    public Future<Void> write(Frame<?> frame) {
        return null;
    }

    @Override
    public Future<Void> close() {
        return webSocket.close();
    }

    @Override
    public Future<Void> closeFuture() {
        return closedPromise.future();
    }

    // WriteStream start

    @Override
    public Future<Void> write(Buffer data) {

        return null;
    }

    @Override
    public void write(Buffer data, Handler<AsyncResult<Void>> handler) {

    }

    @Override
    public void end(Handler<AsyncResult<Void>> handler) {

    }

    @Override
    public OcppConnection setWriteQueueMaxSize(int maxSize) {
        webSocket.setWriteQueueMaxSize(maxSize);
        return this;
    }

    @Override
    public boolean writeQueueFull() {
        return webSocket.writeQueueFull();
    }

    @Override
    public OcppConnection drainHandler(@Nullable Handler<Void> handler) {
         webSocket.drainHandler(handler);
         return this;
    }

    // WriteStream end


    // ReadStream start

    @Override
    public OcppConnection handler(@Nullable Handler<Buffer> handler) {
        // TODO handler text message frame as buffer
        return null;
    }

    @Override
    public OcppConnection pause() {
        webSocket.pause();
        return this;
    }

    @Override
    public OcppConnection resume() {
        webSocket.resume();
        return this;
    }

    @Override
    public OcppConnection fetch(long amount) {
        webSocket.fetch(amount);
        return this;
    }

    @Override
    public OcppConnection endHandler(@Nullable Handler<Void> endHandler) {
        webSocket.endHandler(endHandler);
        return this;
    }

    // ReadStream end

    @Override
    public synchronized IotConnection exceptionHandler(Handler<Throwable> handler) {
        this.exceptionHandler = handler;
        return this;
    }

    @Override
    public synchronized OcppConnection frameHandler(Handler<Frame<?>> handler) {
        this.frameHandler = handler;
        return this;
    }

    @Override
    public synchronized IotConnection outboundHook(OutboundHook hook) {
        this.outboundHook = hook;
        return this;
    }

    @Override
    public synchronized OutboundHook outboundHook() {
        return this.outboundHook;
    }

    @Override
    public boolean isClosed() {
        webSocket.isClosed();
        return false;
    }


    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        return false;
    }

    @Override
    public String protocol() {
        return webSocket.subProtocol();
    }

    @Override
    public String terminalNo() {
        return terminalNo;
    }

    @Override
    public OcppVersion ocppVersion() {
        return ocppVersion;
    }

    @Override
    public WebSocketBase websocket() {
        return webSocket;
    }

}
