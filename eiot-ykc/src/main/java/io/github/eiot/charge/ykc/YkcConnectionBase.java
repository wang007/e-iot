package io.github.eiot.charge.ykc;

import io.github.eiot.*;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.github.eiot.impl.AbstractFrame;
import io.github.eiot.impl.RequestFrameBase;
import io.github.eiot.impl.SeqNoIotConnection;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by wang007 on 2025/3/21
 */
interface YkcConnectionBase extends IotConnection {

    Logger logger = LoggerFactory.getLogger(SeqNoIotConnection.class);

    default Future<Frame<?>> beforeWrite(Frame<?> frame0) {
        Frame<?> frame = frame0;
        if (!frame.isRaw()) {
            if (frame instanceof RequestFrameBase) {
                frame = ((RequestFrameBase<?, ?>) frame).delegateFrame();
            }
            frame = ((AbstractFrame<?, ?>) frame).rawFrame();
        }
        RawYkcFrame rawFrame = (RawYkcFrame) frame;
        rawFrame.checkCode(rawFrame.calcCheckCode());
        return Future.succeededFuture(frame0);
    }

    default Frame<?> convertRawFrame(ByteBuf byteBuf) {
        RawYkcFrame rawYkcFrame = RawYkcFrame.new4Receiver(this, byteBuf);
        if (YkcCommand.LoginRequest.command().equals(rawYkcFrame.command())) {
            try {
                DefaultYkcFrame<YkcLoginRequest> ykcFrame = new DefaultYkcFrame<>(rawYkcFrame, YkcCommand.LoginRequest);
                String terminalNo = ykcFrame
                        .data()
                        .getTerminalNo()
                        .to0StripString();
                this.put(TERMINAL_NO_KEY, terminalNo);
            } catch (Throwable e) {
                logger.warn("try to parse terminalNo in loginRequestFrame failed", e);
            }
        }
        return rawYkcFrame;
    }

    default Frame<?> convertConcreteFrame(Frame<?> rawFrame) {
        return YkcFramerConverter.INSTANCE.apply(rawFrame);
    }
}
