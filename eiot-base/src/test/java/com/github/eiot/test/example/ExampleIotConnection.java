package com.github.eiot.test.example;

import io.github.eiot.Frame;
import io.github.eiot.RequestFrame;
import io.github.eiot.SeqNoIotConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleIotConnection extends SeqNoIotConnection {

    protected ExampleIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    protected Frame<?> convertRawFrame(ByteBuf byteBuf) {
        return RawExampleFrame.new4Receiver(this, byteBuf);
    }

    @Override
    protected Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        return ExampleFrameConverter.INSTANCE.apply(rawFrame);
    }

    @Override
    protected void updateSeqNo(RequestFrame<?, Frame<?>> requestFrame, int seqNo) {
        ExampleFrame<?> frame = (ExampleFrame<?>) requestFrame;
        frame.sequenceNo(seqNo);
    }

    @Override
    protected int getSeqNo(Frame<?> frame) {
        ExampleFrame<?> f = (ExampleFrame<?>) frame;
        return f.sequenceNo();
    }
}
