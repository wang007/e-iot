package io.github.eiot.server;

import io.github.eiot.IotConnection;
import io.github.eiot.IotConnectionBase;
import io.github.eiot.Frame;
import io.github.eiot.FrameCodecOptions;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.vertx.core.*;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.*;
import io.vertx.core.shareddata.Shareable;
import io.vertx.core.spi.metrics.TCPMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * created by wang007 on 2025/3/1
 */
public abstract class IotServerBase implements IotServer, Closeable, Shareable {

    protected static final Logger log = LoggerFactory.getLogger(IotServerBase.class);

    private static final Handler<Throwable> DEFAULT_EXCEPTION_HANDLER = t -> log.warn("Connection failure", t);

    protected final IotServerOptions options;

    //private SendWriteHook outboundHook;
    private Handler<Frame<?>> frameHandler;
    private Handler<IotConnection> connectionHandler;
    private Handler<Throwable> exceptionHandler;
    private NetServerImpl netServer;
    private final VertxInternal vertx;

    /**
     * @param vertx   the vertx
     * @param options the options
     */
    protected IotServerBase(Vertx vertx, IotServerOptions options) {
        this.vertx = (VertxInternal) vertx;
        this.options = new IotServerOptions(options);
        if (options.isSetResponseResult() && !options.isFrameConverter()) {
            throw new IllegalArgumentException("if SetResponseResult = true, must be frameConverter = true");
        }
    }


    @Override
    public Future<IotServer> listen() {
        return listen(options.getPort(), options.getHost());
    }

    @Override
    public synchronized Future<IotServer> listen(SocketAddress address) {
        if (address == null) {
            throw new NullPointerException("No null bind local address");
        }
        if (frameHandler == null && connectionHandler == null) {
            throw new IllegalStateException("Set frame or connect handler first");
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

        VertxHandler<IotConnectionBase> handler = VertxHandler.create(ctx ->
                newIotConnection(context, ctx, metrics, options));

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

    protected abstract IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                                          IotServerOptions options);


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
    public synchronized IotServer frameHandler(Handler<Frame<?>> handler) {
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
    public synchronized IotServer connectionHandler(Handler<IotConnection> handler) {
        if (isListening()) {
            throw new IllegalStateException("Cannot set connectionHandler when server is listening");
        }
        this.connectionHandler = handler;
        return this;
    }

    @Override
    public synchronized Handler<IotConnection> connectionHandler() {
        return this.connectionHandler;
    }

    @Override
    public synchronized IotServer exceptionHandler(Handler<Throwable> handler) {
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
