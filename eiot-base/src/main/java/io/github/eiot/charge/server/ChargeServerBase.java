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
import io.vertx.core.impl.VertxInternal;
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
public abstract class ChargeServerBase extends TCPServerBase implements ChargeServer, Closeable, Shareable {

    protected static final Logger log = LoggerFactory.getLogger(ChargeServerBase.class);

    private static final Handler<Throwable> DEFAULT_EXCEPTION_HANDLER = t -> log.warn("Connection failure", t);

    protected final ChargeServerOptions options;

    //private SendWriteHook sendWriteHook;
    private Handler<Frame<?>> frameHandler;
    private Handler<ChargeConnection> connectionHandler;
    private Handler<Throwable> exceptionHandler;


    /**
     * @param vertx   the vertx
     * @param options the options
     */
    protected ChargeServerBase(Vertx vertx, ChargeServerOptions options) {
        super(new ChargeVertxInternal((VertxInternal) vertx), options);
        this.options = new ChargeServerOptions(options);
        if (options.isSetResponseResult() && !options.isFrameConverter()) {
            throw new IllegalArgumentException("SetResponseResult must be frameConverter = true");
        }
    }


    protected abstract <T extends ChargeConnectionBase> T newChargeConnection(ContextInternal context, ChannelHandlerContext chctx,
                                                                              SslChannelProvider sslChannelProvider, TCPMetrics<?> metrics,
                                                                              ChargeServerOptions options);

    @Override
    public Future<ChargeServer> listen() {
        return listen(options.getPort(), options.getHost());
    }

    @Override
    public Future<ChargeServer> listen(SocketAddress address) {
        if (address == null) {
            throw new NullPointerException("No null bind local address");
        }
        if (frameHandler == null && connectionHandler == null) {
            throw new IllegalStateException("Set connect handler first");
        }
        return bind(address).map(this);

    }

    @Override
    public Future<Void> close() {
        ContextInternal context = vertx.getOrCreateContext();
        Promise<Void> promise = context.promise();
        close(promise);
        return promise.future();
    }

    @Override
    public int actualPort() {
        return super.actualPort();
    }

    @Override
    protected BiConsumer<Channel, SslChannelProvider> childHandler(ContextInternal context, SocketAddress socketAddress, GlobalTrafficShapingHandler trafficShapingHandler) {
        return new ChargeServerWorker(context, trafficShapingHandler, frameHandler, connectionHandler,
                exceptionHandler != null ? exceptionHandler : DEFAULT_EXCEPTION_HANDLER);
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

    /*@Override
    public synchronized ChargeServer sendWriteHook(SendWriteHook hook) {
        if (isListening()) {
            throw new IllegalStateException("Cannot set SendWriteHook when server is listening");
        }
        this.sendWriteHook = hook;
        return this;
    }*/

    @Override
    public String protocol() {
        return options.getProtocol();
    }


    class ChargeServerWorker implements BiConsumer<Channel, SslChannelProvider> {

        private final ContextInternal context;
        private final GlobalTrafficShapingHandler trafficShapingHandler;

        private final Handler<Frame<?>> frameHandler;
        private final Handler<ChargeConnection> connectionHandler;
        private final Handler<Throwable> exceptionHandler;

        public ChargeServerWorker(ContextInternal context, GlobalTrafficShapingHandler trafficShapingHandler,
                                  Handler<Frame<?>> frameHandler, Handler<ChargeConnection> connectionHandler,
                                  Handler<Throwable> exceptionHandler) {
            this.context = context;
            this.trafficShapingHandler = trafficShapingHandler;

            this.frameHandler = frameHandler;
            this.connectionHandler = connectionHandler;
            this.exceptionHandler = exceptionHandler;
        }

        // copy from Vertx NetServerImpl
        @Override
        public void accept(Channel ch, SslChannelProvider sslChannelProvider) {
            // TODO accept()
            if (HAProxyMessageCompletionHandler.canUseProxyProtocol(options.isUseProxyProtocol())) {
                IdleStateHandler idle;
                io.netty.util.concurrent.Promise<Channel> p = ch.eventLoop().newPromise();
                ch.pipeline().addLast(new HAProxyMessageDecoder());
                if (options.getProxyProtocolTimeout() > 0) {
                    ch.pipeline().addLast("idle", idle = new IdleStateHandler(0, 0, options.getProxyProtocolTimeout(), options.getProxyProtocolTimeoutUnit()));
                } else {
                    idle = null;
                }
                ch.pipeline().addLast(new HAProxyMessageCompletionHandler(p));
                p.addListener((GenericFutureListener<io.netty.util.concurrent.Future<Channel>>) future -> {
                    if (future.isSuccess()) {
                        if (idle != null) {
                            ch.pipeline().remove(idle);
                        }
                        configurePipeline(future.getNow(), sslChannelProvider);
                    } else {
                        //No need to close the channel.HAProxyMessageDecoder already did
                        handleException(future.cause());
                    }
                });
            } else {
                configurePipeline(ch, sslChannelProvider);
            }
        }

        private void configurePipeline(Channel ch, SslChannelProvider sslChannelProvider) {
            if (options.isSsl()) {
                ch.pipeline().addLast("ssl", sslChannelProvider.createServerHandler(HttpUtils.socketAddressToHostAndPort(ch.remoteAddress())));
                ChannelPromise p = ch.newPromise();
                ch.pipeline().addLast("handshaker", new SslHandshakeCompletionHandler(p));
                p.addListener(future -> {
                    if (future.isSuccess()) {
                        connected(ch, sslChannelProvider);
                    } else {
                        handleException(future.cause());
                    }
                });
            } else {
                connected(ch, sslChannelProvider);
            }
            if (trafficShapingHandler != null) {
                ch.pipeline().addFirst("globalTrafficShaping", trafficShapingHandler);
            }
        }

        private void handleException(Throwable cause) {
            if (exceptionHandler != null) {
                context.emit(v -> exceptionHandler.handle(cause));
            }
        }

        private void connected(Channel ch, SslChannelProvider sslChannelProvider) {
            initChannel(ch.pipeline(), options.isSsl());
            // TODO ChargeServerMetrics()
            TCPMetrics<?> metrics = getMetrics();
            VertxHandler<ChargeConnectionBase> handler = VertxHandler.create(ctx ->
                    newChargeConnection(context, ctx, sslChannelProvider, metrics, options));

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

            ch.pipeline().addLast("handler", handler);
        }

        protected void initChannel(ChannelPipeline pipeline, boolean ssl) {
            if (ssl || !vertx.transport().supportFileRegion() || (options.getTrafficShapingOptions() != null && options.getTrafficShapingOptions().getOutboundGlobalBandwidth() > 0)) {
                // only add ChunkedWriteHandler when SSL is enabled or FileRegion isn't supported or when outbound traffic shaping is enabled
                pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());       // For large file / sendfile support
            }
            int idleTimeout = options.getIdleTimeout();
            int readIdleTimeout = options.getReadIdleTimeout();
            int writeIdleTimeout = options.getWriteIdleTimeout();
            if (idleTimeout > 0 || readIdleTimeout > 0 || writeIdleTimeout > 0) {
                pipeline.addLast("idle", new IdleStateHandler(readIdleTimeout, writeIdleTimeout, idleTimeout, options.getIdleTimeoutUnit()));
            }
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
            pipeline.addLast("frameBytesDecoder", lengthFieldBasedFrameDecoder);

            if (options.getLogActivity()) {
                pipeline.addLast("logging", new LoggingHandler(options.getActivityLogDataFormat()));
            }
        }

    }

}
