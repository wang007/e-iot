package io.github.eiot.charge.server;

import io.github.eiot.charge.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.haproxy.HAProxyMessageDecoder;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.util.concurrent.GenericFutureListener;
import io.vertx.core.*;
import io.vertx.core.http.impl.HttpUtils;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxImpl;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.*;
import io.vertx.core.shareddata.Shareable;
import io.vertx.core.spi.metrics.TCPMetrics;

import java.util.function.BiConsumer;

/**
 * created by wang007 on 2025/3/1
 */
public abstract class ChargeServerBase implements ChargeServer, Closeable, Shareable {

    protected static final Logger log = LoggerFactory.getLogger(ChargeServerBase.class);

    private static final Handler<Throwable> DEFAULT_EXCEPTION_HANDLER = t -> log.warn("Connection failure", t);

    protected final ChargeServerOptions options;

    //private SendWriteHook sendWriteHook;
    private Handler<Frame<?>> frameHandler;
    private Handler<ChargeConnection> connectionHandler;
    private Handler<Throwable> exceptionHandler;
    private NetServerImpl netServer;
    private final VertxInternal vertx;

    /**
     * @param vertx   the vertx
     * @param options the options
     */
    protected ChargeServerBase(Vertx vertx, ChargeServerOptions options) {
        this.vertx = (VertxInternal) vertx;
        this.options = new ChargeServerOptions(options);
        if (options.isSetResponseResult() && !options.isFrameConverter()) {
            throw new IllegalArgumentException("SetResponseResult must be frameConverter = true");
        }
    }


    @Override
    public Future<ChargeServer> listen() {
        return listen(options.getPort(), options.getHost());
    }

    @Override
    public synchronized Future<ChargeServer> listen(SocketAddress address) {
        if (address == null) {
            throw new NullPointerException("No null bind local address");
        }
        if (frameHandler == null && connectionHandler == null) {
            throw new IllegalStateException("Set connect handler first");
        }

        NetServerImpl server = (NetServerImpl) vertx.createNetServer(options);

        Handler<Throwable> exceptionHandler = this.exceptionHandler == null ? DEFAULT_EXCEPTION_HANDLER : this.exceptionHandler;
        server.exceptionHandler(exceptionHandler);
        server.connectHandler(so -> configurePipeline((NetSocketImpl) so));

        this.netServer = server;

        return server.listen(address).map(this);
    }

    private void configurePipeline(NetSocketImpl so) {
        Channel ch = so.channel();
        TCPMetrics<?> metrics = so.metrics();
        ContextInternal context = so.getContext();

        FrameCodecOptions frameCodecOptions = options.getFrameCodecOptions();
        LengthFieldBasedFrameDecoder lengthFieldBasedFrameDecoder = new LengthFieldBasedFrameDecoder(
                frameCodecOptions.getByteOrder(),
                frameCodecOptions.getMaxFrameLength(),
                frameCodecOptions.getLengthFieldOffset(),
                frameCodecOptions.getLengthFieldLength(),
                frameCodecOptions.getLengthAdjustment(),
                0,
                true
        );
        ch.pipeline().addLast("frameBytesDecoder", lengthFieldBasedFrameDecoder);

        VertxHandler<ChargeConnectionBase> handler = VertxHandler.create(ctx ->
                newChargeConnection(context, ctx, metrics, options));

        handler.addHandler(conn -> {
            if (metrics != null) {
                conn.metric(metrics.connected(conn.remoteAddress(), conn.remoteName()));
            }
            if (frameHandler != null) {
                conn.frameHandler(frameHandler);
            }
            if (exceptionHandler != null) {
                conn.exceptionHandler(exceptionHandler);
            }
            if (connectionHandler != null) {
                context.emit(conn, connectionHandler::handle);
            }
        });
        ch.pipeline().replace(VertxHandler.class, "handler", handler);
    }

    protected abstract <T extends ChargeConnectionBase> T newChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                                                              ChargeServerOptions options);


    @Override
    public synchronized Future<Void> close() {
        ContextInternal context = vertx.getOrCreateContext();
        if (this.netServer == null) {
            return context.succeededFuture();
        }
        PromiseInternal<Void> promise = context.promise();
        this.netServer.close(promise);
        return promise.future();
    }

    @Override
    public void close(Promise<Void> completion) {
        close().onComplete(completion);
    }

    @Override
    public synchronized int actualPort() {
        return this.netServer != null ? netServer.actualPort() : 0;
    }

    public synchronized boolean isListening() {
        return this.netServer != null;
    }

    @Override
    public synchronized ChargeServer frameHandler(Handler<Frame<?>> handler) {
        if (isListening()) {
            throw new IllegalStateException("Cannot set frameHandler when server is listening");
        }
        this.frameHandler = handler;
        return this;
    }

    @Override
    public synchronized Handler<Frame<?>> frameHandler() {
        return frameHandler;
    }

    @Override
    public synchronized ChargeServer connectionHandler(Handler<ChargeConnection> handler) {
        if (isListening()) {
            throw new IllegalStateException("Cannot set connectionHandler when server is listening");
        }
        this.connectionHandler = handler;
        return this;
    }

    @Override
    public synchronized Handler<ChargeConnection> connectionHandler() {
        return this.connectionHandler;
    }

    @Override
    public synchronized ChargeServer exceptionHandler(Handler<Throwable> handler) {
        if (isListening()) {
            throw new IllegalStateException("Cannot set exceptionHandler when server is listening");
        }
        this.exceptionHandler = handler;
        return this;
    }

    @Override
    public String protocol() {
        return options.getProtocol();
    }


}
