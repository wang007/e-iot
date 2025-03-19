package io.github.eiot.charge.ykc;

import io.github.eiot.charge.Frame;
import io.github.eiot.charge.MessageTypeChargeConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.net.impl.SslChannelProvider;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * 基于 message type 匹配 response frame
 *
 * created by wang007 on 2025/3/17
 */
public class YkcMTChargeConnection extends MessageTypeChargeConnection {

    protected YkcMTChargeConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    protected Frame<?> convertRawFrame(ByteBuf byteBuf) {
        return RawYkcFrame.new4Receiver(this, byteBuf);
    }

    @Override
    protected Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        // TODO
        return null;
    }

    @Override
    protected Future<Frame<?>> beforeWrite(Frame<?> frame) {
        // TODO update checkCode
        return super.beforeWrite(frame);
    }
}
