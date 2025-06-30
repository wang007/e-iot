package io.github.eiot.ocpp.schema.v2_0_1;

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
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocketBase;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * created by wang007 on 2025/6/29
 */
public class FakeOcppConnection implements OcppConnection {

    private final AtomicLong messageIdGenerator = new AtomicLong(1);
    private final Map<String, Object> attrs = new ConcurrentHashMap<>();
    private final OcppVersion ocppVersion;

    public FakeOcppConnection() {
        this.ocppVersion = OcppVersion.OCPP2_0_1;
    }

    public FakeOcppConnection(OcppVersion ocppVersion) {
        this.ocppVersion = ocppVersion;
    }

    @Override
    public Map<String, Object> attributes() {
        return attrs;
    }

    @Override
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override
    public SocketAddress remoteAddress(boolean real) {
        return null;
    }

    @Override
    public SocketAddress localAddress() {
        return null;
    }

    @Override
    public SocketAddress localAddress(boolean real) {
        return null;
    }

    @Override
    public Future<Frame<?>> request(RequestFrame<?, Frame<?>> frame, int timeoutMs) {
        return null;
    }

    @Override
    public Future<Void> write(Frame<?> frame) {
        return null;
    }

    @Override
    public Future<Void> close() {
        return null;
    }

    @Override
    public Future<Void> closeFuture() {
        return null;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public IotConnection exceptionHandler(Handler<Throwable> handler) {
        return null;
    }

    @Override
    public ReadStream<Buffer> handler(@Nullable Handler<Buffer> handler) {
        return null;
    }

    @Override
    public ReadStream<Buffer> pause() {
        return null;
    }

    @Override
    public ReadStream<Buffer> resume() {
        return null;
    }

    @Override
    public ReadStream<Buffer> fetch(long l) {
        return null;
    }

    @Override
    public ReadStream<Buffer> endHandler(@Nullable Handler<Void> handler) {
        return null;
    }

    @Override
    public IotConnection frameHandler(Handler<Frame<?>> handler) {
        return null;
    }

    @Override
    public IotConnection outboundHook(OutboundHook hook) {
        return null;
    }

    @Override
    public OutboundHook outboundHook() {
        return null;
    }

    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        return false;
    }

    @Override
    public String protocol() {
        return ocppVersion.versionName;
    }

    @Override
    public String terminalNo() {
        return null;
    }

    @Override
    public OcppVersion ocppVersion() {
        return ocppVersion;
    }

    @Override
    public WebSocketBase websocket() {
        return null;
    }

    @Override
    public void write(Buffer utf8TextData, Handler<AsyncResult<Void>> handler) {

    }

    @Override
    public void end(Handler<AsyncResult<Void>> handler) {

    }

    @Override
    public WriteStream<Buffer> setWriteQueueMaxSize(int i) {
        return null;
    }

    @Override
    public boolean writeQueueFull() {
        return false;
    }

    @Override
    public WriteStream<Buffer> drainHandler(@Nullable Handler<Void> handler) {
        return null;
    }

    @Override
    public Future<Void> write(Buffer utf8TextData) {
        return null;
    }

    @Override
    public String nextMessageId() {
        long v = messageIdGenerator.getAndIncrement();
        return Long.toString(v);
    }
}
