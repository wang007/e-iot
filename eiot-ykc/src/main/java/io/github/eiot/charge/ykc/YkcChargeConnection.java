package io.github.eiot.charge.ykc;

import io.github.eiot.charge.Frame;
import io.github.eiot.charge.RequestFrame;
import io.github.eiot.charge.SeqNoChargeConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.net.impl.SslChannelProvider;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * 基于 message type 匹配 response frame
 *
 * created by wang007 on 2025/3/16
 */
public class YkcChargeConnection extends SeqNoChargeConnection {

    protected YkcChargeConnection(ContextInternal context, ChannelHandlerContext chctx,
                                  SslChannelProvider sslChannelProvider, TCPMetrics<?> metrics,
                                  boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, sslChannelProvider, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    protected Frame<?> convertRawFrame(ByteBuf byteBuf) {
        return RawYkcFrame.new4Receiver(this, byteBuf);
    }

    @Override
    protected Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        // TODO convertConcreteFrame
        return null;
    }

    @Override
    protected void updateSeqNo(RequestFrame<?, Frame<?>> requestFrame, int seqNo) {
        YkcFrame<?> ykcFrame = (YkcFrame<?>) requestFrame;
        ykcFrame.sequenceNo(seqNo);
    }

    @Override
    protected int getSeqNo(Frame<?> frame) {
        YkcFrame<?> ykcFrame = (YkcFrame<?>) frame;
        return ykcFrame.sequenceNo();
    }

    @Override
    protected Future<Frame<?>> beforeWrite(Frame<?> frame) {
        // TODO update checkCode()

        return super.beforeWrite(frame);
    }
}
