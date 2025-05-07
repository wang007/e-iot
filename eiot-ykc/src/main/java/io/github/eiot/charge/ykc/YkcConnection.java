package io.github.eiot.charge.ykc;

import io.github.eiot.Frame;
import io.github.eiot.RequestFrame;
import io.github.eiot.SeqNoIotConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/3/16
 */
public class YkcConnection extends SeqNoIotConnection implements YkcConnectionBase {


    protected YkcConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics,
                            boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
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
    public Future<Frame<?>> beforeWrite(Frame<?> frame) {
        return YkcConnectionBase.super.beforeWrite(frame);
    }

    @Override
    public Frame<?> convertRawFrame(ByteBuf byteBuf) {
        return YkcConnectionBase.super.convertRawFrame(byteBuf);
    }

    @Override
    public Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        return YkcConnectionBase.super.convertConcreteFrame(rawFrame);
    }
}
