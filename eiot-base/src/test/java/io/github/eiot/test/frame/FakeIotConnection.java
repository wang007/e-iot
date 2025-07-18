package io.github.eiot.test.frame;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.OutboundHook;
import io.github.eiot.RequestFrame;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by wang007 on 2025/5/25
 */
public class FakeIotConnection implements IotConnection {

    private final Map<String, Object> attrs = new ConcurrentHashMap<>();

    private final String protocol;

    public FakeIotConnection(String protocol) {
        this.protocol = protocol;
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
    public WriteStream<Buffer> setWriteQueueMaxSize(int maxSize) {
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
    public ReadStream<Buffer> fetch(long amount) {
        return null;
    }

    @Override
    public ReadStream<Buffer> endHandler(@Nullable Handler<Void> endHandler) {
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
        return protocol;
    }
}
