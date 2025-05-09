package io.github.eiot.impl;

import io.github.eiot.*;
import io.github.eiot.exception.ConvertIotException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.net.impl.ConnectionBase;
import io.vertx.core.net.impl.VertxHandler;
import io.vertx.core.spi.metrics.TCPMetrics;
import io.vertx.core.streams.impl.InboundBuffer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * use for client connection and server connection
 * <p>
 * created by wang007 on 2025/3/2
 */
public abstract class IotConnectionBase extends ConnectionBase implements OutboundIotConnectionInternal {

    private final Map<String, Object> map;

    protected final TCPMetrics<?> metrics;
    protected final boolean frameConverter;
    protected final boolean setResponseResult;
    protected final int waitResponseTimeout;
    protected final String protocol;

    private final InboundBuffer<Object> pending;

    private boolean closed;

    protected Handler<Frame<?>> frameHandler;
    protected OutboundHook outboundHook;

    private Handler<Void> endHandler;
    private Handler<Void> drainHandler;
    private Handler<Buffer> handler;

    protected IotConnectionBase(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                boolean frameConverter, boolean setResponseResult,
                                int waitResponseTimeout, String protocol) {
        super(context, chctx);
        this.map = new ConcurrentHashMap<>();
        this.metrics = metrics;
        this.frameConverter = frameConverter;
        this.setResponseResult = setResponseResult;
        this.waitResponseTimeout = waitResponseTimeout;
        this.protocol = protocol;
        closeFuture().onComplete(ar -> {
            synchronized (IotConnectionBase.this) {
                this.closed = true;
            }
        });

        pending = new InboundBuffer<>(context);
        pending.drainHandler(v -> doResume());
        pending.handler(this::handleMsg);
        pending.exceptionHandler(context::reportException);
    }

    @Override
    public Vertx vertx() {
        return vertx;
    }

    @Override
    public ContextInternal context() {
        return context;
    }

    private void handleMsg(Object msg) {
        if (msg == InboundBuffer.END_SENTINEL) {
            Handler<Void> endHandler;
            synchronized (this) {
                endHandler = this.endHandler;
            }
            if (endHandler != null) {
                endHandler.handle(null);
            }
            return;
        }
        ByteBuf byteBuf = (ByteBuf) msg;

        Handler<Frame<?>> frameHandler;
        Handler<Buffer> handler;
        Handler<Throwable> exceptionHandler;
        boolean frameConvert;
        boolean setResponseResult;

        synchronized (this) {
            frameHandler = this.frameHandler;
            handler = this.handler;
            exceptionHandler = exceptionHandler();
            frameConvert = this.frameConverter;
            setResponseResult = this.setResponseResult;
        }
        if (frameHandler != null) {
            context.dispatch(byteBuf, v -> {
                Frame<?> frame;
                try {
                    frame = convertRawFrame(byteBuf);
                } catch (Throwable e) {
                    String terminalNo = get(TERMINAL_NO_KEY, "");
                    Throwable ex;
                    if (e instanceof ConvertIotException) {
                        ex = e;
                    } else {
                        ex = new ConvertIotException(terminalNo, null, "convert raw frame failed", e);
                    }
                    if (exceptionHandler != null) {
                        exceptionHandler.handle(ex);
                    }
                    return;
                }

                if (frameConvert) {
                    try {
                        frame = convertConcreteFrame(frame);
                    } catch (Throwable e) {
                        Throwable ex;
                        if (e instanceof ConvertIotException) {
                            ex = e;
                        } else {
                            String terminalNo = frame.terminalNo();
                            ex = new ConvertIotException(terminalNo, frame, "convert concrete frame failed", e);
                        }
                        if (trySetResponseResult(frame, ex)) {
                            return;
                        }
                        if (exceptionHandler != null) {
                            exceptionHandler.handle(ex);
                        }
                        return;
                    }
                }

                if (setResponseResult && trySetResponseResult(frame, null)) {
                    return;
                }
                frameHandler.handle(frame);
            });
        }

        if (handler != null) {
            context.dispatch(byteBuf, v -> handler.handle(Buffer.buffer(v)));
        }
    }

    @Override
    public Map<String, Object> attributes() {
        return map;
    }

    /**
     * convert byteBuf to raw frame
     *
     * @param byteBuf the byteBuf
     * @return the raw frame
     */
    protected abstract Frame<?> convertRawFrame(ByteBuf byteBuf);

    /**
     * Converts a raw frame into a frame of a specific type.
     *
     * @param rawFrame the raw frame, from {@link #convertRawFrame(ByteBuf)}
     * @see FrameConverter
     */
    protected abstract Frame<?> convertConcreteFrame(Frame<?> rawFrame);

    @Override
    public synchronized boolean isClosed() {
        return closed;
    }

    @Override
    public synchronized IotConnectionBase exceptionHandler(Handler<Throwable> handler) {
        super.exceptionHandler(handler);
        return this;
    }

    @Override
    public synchronized IotConnection frameHandler(Handler<Frame<?>> handler) {
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
        return outboundHook;
    }

    @Override
    public TCPMetrics<?> metrics() {
        return metrics;
    }

    @Override
    public String protocol() {
        return protocol;
    }

    @Override
    public final Future<Frame<?>> request(RequestFrame<?, Frame<?>> frame, int timeoutMs) {
        if (timeoutMs <= 0) {
            timeoutMs = this.waitResponseTimeout;
        }
        int time0 = timeoutMs;
        // use caller context.
        PromiseInternal<Frame<?>> promise = this.vertx.promise();
        request(frame, time0, promise);
        return promise.future();
    }


    @Override
    public final Future<Void> write(Frame<?> frame) {
        // use caller context.
        PromiseInternal<Void> promise = this.vertx.promise();
        write(frame, promise);
        return promise.future();
    }

    @Override
    public void writeOutInternal(Frame<?> frame, PromiseInternal<Void> promise) {
        ByteBuf byteBuf = frame.toByteBuf();
        writeToChannel(byteBuf, promise);
    }

    @Override
    protected void handleClosed() {
        context.emit(InboundBuffer.END_SENTINEL, pending::write);
        super.handleClosed();
    }

    @Override
    protected void handleMessage(Object msg) {
        if (msg instanceof ByteBuf) {
            msg = VertxHandler.safeBuffer((ByteBuf) msg);
            ByteBuf byteBuf = (ByteBuf) msg;
            if (!pending.write(byteBuf)) {
                doPause();
            }
        } else {
            if (msg instanceof ReferenceCounted) {
                ((ReferenceCounted) msg).release();
            }
        }
    }

    @Override
    protected void handleInterestedOpsChanged() {
        context.emit(null, v -> callDrainHandler());
    }

    @Override
    public synchronized IotConnection handler(@Nullable Handler<Buffer> handler) {
        this.handler = handler;
        return this;
    }

    @Override
    public IotConnection pause() {
        pending.pause();
        return this;
    }

    @Override
    public IotConnection resume() {
        pending.resume();
        return this;
    }

    @Override
    public IotConnection fetch(long amount) {
        pending.fetch(amount);
        return this;
    }

    @Override
    public synchronized IotConnection endHandler(@Nullable Handler<Void> endHandler) {
        this.endHandler = endHandler;
        return this;
    }


    @SuppressWarnings("deprecation")
    @Override
    public Future<Void> write(Buffer data) {
        return write(data.getByteBuf());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void write(Buffer data, Handler<AsyncResult<Void>> handler) {
        write(data.getByteBuf()).onComplete(handler);
    }

    private Future<Void> write(ByteBuf byteBuf) {
        reportBytesWritten(byteBuf.readableBytes());
        PromiseInternal<Void> promise = context.promise();
        writeToChannel(byteBuf, promise);
        return promise.future();
    }


    @Override
    public void end(Handler<AsyncResult<Void>> handler) {
        close(handler);
    }


    @Override
    public IotConnection setWriteQueueMaxSize(int maxSize) {
        doSetWriteQueueMaxSize(maxSize);
        return this;
    }

    @Override
    public boolean writeQueueFull() {
        return isNotWritable();
    }

    @Override
    public synchronized IotConnection drainHandler(@Nullable Handler<Void> handler) {
        this.drainHandler = handler;
        return this;
    }

    private synchronized void callDrainHandler() {
        if (drainHandler != null) {
            if (!writeQueueFull()) {
                drainHandler.handle(null);
            }
        }
    }
}
