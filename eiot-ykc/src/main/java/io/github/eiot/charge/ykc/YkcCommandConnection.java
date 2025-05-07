package io.github.eiot.charge.ykc;

import io.github.eiot.CommandIotConnection;
import io.github.eiot.Frame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.vertx.core.Future;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.spi.metrics.TCPMetrics;

/**
 * 基于 command 匹配 response frame
 *
 * created by wang007 on 2025/3/17
 */
public class YkcCommandConnection extends CommandIotConnection implements YkcConnectionBase {

    protected YkcCommandConnection(ContextInternal context, ChannelHandlerContext chctx, TCPMetrics<?> metrics, boolean frameConverter, boolean setResponseResult, int waitResponseTimeout, String protocol) {
        super(context, chctx, metrics, frameConverter, setResponseResult, waitResponseTimeout, protocol);
    }

    @Override
    public Frame<?> convertRawFrame(ByteBuf byteBuf) {
        return YkcConnectionBase.super.convertRawFrame(byteBuf);
    }

    @Override
    public Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        return YkcConnectionBase.super.convertConcreteFrame(rawFrame);
    }

    @Override
    public Future<Frame<?>> beforeWrite(Frame<?> frame) {
        return YkcConnectionBase.super.beforeWrite(frame);
    }
}
