package io.github.eiot.impl;

import io.github.eiot.*;
import io.github.eiot.exception.ConvertIotException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.BufferImpl;
import io.vertx.core.internal.ContextInternal;
import io.vertx.core.internal.PromiseInternal;
import io.vertx.core.internal.concurrent.InboundMessageQueue;
import io.vertx.core.net.impl.ConnectionBase;
import io.vertx.core.net.impl.NetSocketImpl;
import io.vertx.core.net.impl.VertxConnection;
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
public abstract class IotConnectionBase extends VertxConnection implements OutboundIotConnectionInternal {

    private final Map<String, Object> map;

    protected final TCPMetrics<?> metrics;
    protected final boolean frameConverter;
    protected final boolean setResponseResult;
    protected final int waitResponseTimeout;
    protected final String protocol;

    private final InboundMessageQueue<Object> pending;

    private boolean closed;

    private Handler<Throwable> exceptionHandler;
    protected Handler<Frame<?>> frameHandler;
    protected OutboundHook outboundHook;

    private Handler<Void> endHandler;
    private volatile Handler<Void> drainHandler;
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

        this.pending = new InboundMessageQueue<>(context.eventLoop(), context.executor()) {
            @Override
            protected void handleResume() {
                IotConnectionBase.this.doResume();
            }

            @Override
            protected void handlePause() {
                IotConnectionBase.this.doPause();
            }

            @Override
            protected void handleMessage(Object msg) {
                IotConnectionBase.this.handleMsg(msg);
            }
        };
    }

    @Override
    public Vertx vertx() {
        return vertx;
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
        Handler<Throwable> exceptionHandler0;
        boolean frameConvert;
        boolean setResponseResult;

        synchronized (this) {
            frameHandler = this.frameHandler;
            handler = this.handler;
            exceptionHandler0 = exceptionHandler();
            frameConvert = this.frameConverter;
            setResponseResult = this.setResponseResult;
        }

        if (frameHandler != null || setResponseResult) {
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
                    if (exceptionHandler0 != null) {
                        exceptionHandler0.handle(ex);
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
                        if (exceptionHandler0 != null) {
                            exceptionHandler0.handle(ex);
                        }
                        return;
                    }
                }

                if (setResponseResult && trySetResponseResult(frame, null)) {
                    return;
                }
                if (frameHandler != null) {
                    frameHandler.handle(frame);
                }
            });
        }

        if (handler != null) {
            context.dispatch(byteBuf, v -> {
                BufferImpl buffer = new BufferImpl(v);
                handler.handle(buffer);
            });
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
        this.exceptionHandler = handler;
        return this;
    }

    public synchronized Handler<Throwable> exceptionHandler() {
        return this.exceptionHandler;
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
    public final Future<Frame<?>> request(RequestFrame<?,?> frame, int timeoutMs) {
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
            pending.write(msg);
        } else {
            if (msg instanceof ReferenceCounted) {
                ((ReferenceCounted) msg).release();
            }
        }
    }

    @Override
    protected void handleWriteQueueDrained() {
        Handler<Void> handler = drainHandler;
        if (handler != null) {
            context.emit(null, handler);
        }
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
        pending.fetch(Long.MAX_VALUE);
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


    @Override
    public Future<Void> write(Buffer data) {
        BufferImpl buffer = (BufferImpl) data;
        return write(buffer.getByteBuf());
    }


    private Future<Void> write(ByteBuf byteBuf) {
        reportBytesWritten(byteBuf.readableBytes());
        PromiseInternal<Void> promise = context.promise();
        writeToChannel(byteBuf, promise);
        return promise.future();
    }


    @Override
    public Future<Void> end() {
        return close();
    }

    @Override
    public IotConnection setWriteQueueMaxSize(int maxSize) {
        doSetWriteQueueMaxSize(maxSize);
        return this;
    }

    @Override
    public boolean writeQueueFull() {
        return super.writeQueueFull();
    }

    @Override
    public synchronized IotConnection drainHandler(@Nullable Handler<Void> handler) {
        this.drainHandler = handler;
        return this;
    }
}
