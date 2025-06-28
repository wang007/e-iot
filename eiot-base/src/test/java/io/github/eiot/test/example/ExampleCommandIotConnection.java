package io.github.eiot.test.example;

import io.github.eiot.Frame;
import io.github.eiot.impl.MatchCommandIotConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleCommandIotConnection extends MatchCommandIotConnection {

    protected ExampleCommandIotConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
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
}
