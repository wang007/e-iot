package io.github.eiot.charge.client;

import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.ChargeConnectionBase;
import io.github.eiot.charge.FrameCodecOptions;
import io.github.eiot.charge.server.ChargeServerOptions;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.vertx.core.Future;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.impl.future.PromiseInternal;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.net.impl.NetClientImpl;
import io.vertx.core.net.impl.NetSocketImpl;
import io.vertx.core.net.impl.VertxHandler;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/17
 */
public abstract class ChargeClientBase implements ChargeClient {

    protected final ChargeClientOptions options;
    protected final VertxInternal vertxInternal;
    protected final NetClientImpl netClient;

    protected ChargeClientBase(VertxInternal vertxInternal, ChargeClientOptions options) {
        this.vertxInternal = vertxInternal;
        this.options = new ChargeClientOptions(options);
        this.netClient = (NetClientImpl) vertxInternal.createNetClient(options);
    }

    @Override
    public Future<ChargeConnection> connect(int port, String host) {
        return connect(SocketAddress.inetSocketAddress(port, host));
    }

    @Override
    public Future<ChargeConnection> connect(SocketAddress remoteAddress) {
        return netClient.connect(remoteAddress).map(so -> wrap((NetSocketImpl) so));
    }

    private ChargeConnectionBase wrap(NetSocketImpl so) {
        TCPMetrics<?> metrics = so.metrics();
        ContextInternal context = so.getContext();
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
        ch.pipeline().addLast("frameBytesDecoder", lengthFieldBasedFrameDecoder);

        VertxHandler<ChargeConnectionBase> handler = VertxHandler.create(ctx ->
                newChargeConnection(context, ctx, metrics, options));
        ch.pipeline().replace(VertxHandler.class, "handler", handler);

        return handler.getConnection();
    }

    protected abstract <T extends ChargeConnectionBase> T newChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                                                                              ChargeClientOptions options);


    @Override
    public Future<Void> close() {
        PromiseInternal<Void> promise = vertxInternal.promise();
        netClient.close(promise);
        return null;
    }

    @Override
    public String protocol() {
        return options.getProtocol();
    }
}
