package io.github.eiot.impl;

import io.github.eiot.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.vertx.core.Future;
import io.vertx.core.internal.ContextInternal;
import io.vertx.core.internal.PromiseInternal;
import io.vertx.core.internal.VertxInternal;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.NetSocketImpl;
import io.vertx.core.net.impl.VertxHandler;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/17
 */
public abstract class IotClientBase implements IotClient {

    protected final IotClientOptions options;
    protected final VertxInternal vertxInternal;
    protected final NetClient netClient;

    protected IotClientBase(VertxInternal vertxInternal, IotClientOptions options) {
        this.vertxInternal = vertxInternal;
        this.options = new IotClientOptions(options);
        this.netClient = vertxInternal.createNetClient(options);
    }

    @Override
    public Future<IotConnection> connect(int port, String host) {
        return connect(SocketAddress.inetSocketAddress(port, host));
    }

    @Override
    public Future<IotConnection> connect(SocketAddress remoteAddress) {
        return netClient.connect(remoteAddress).map(so -> wrap((NetSocketImpl) so));
    }

    private IotConnectionBase wrap(NetSocketImpl so) {
        TCPMetrics<?> metrics = so.metrics();
        ContextInternal context = so.context();
        Channel ch = so.channel();

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
        ch.pipeline().addBefore("handler","frameBytesDecoder", lengthFieldBasedFrameDecoder);

        VertxHandler<IotConnectionBase> handler = VertxHandler.create(ctx ->
                newIotConnection(context, ctx, metrics, options));
        ch.pipeline().replace(VertxHandler.class, "handler", handler);

        return handler.getConnection();
    }

    protected abstract IotConnectionBase newIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                                          IotClientOptions options);

    @Override
    public Future<Void> close() {
        return netClient.close();
    }

    @Override
    public String protocol() {
        return options.getProtocol();
    }
}
