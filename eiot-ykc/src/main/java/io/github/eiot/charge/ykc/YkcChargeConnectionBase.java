package io.github.eiot.charge.ykc;

import io.github.eiot.AbstractFrame;
import io.github.eiot.IotConnection;
import io.github.eiot.Frame;
import io.github.eiot.SeqNoIotConnection;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by wang007 on 2025/3/21
 */
interface YkcChargeConnectionBase extends IotConnection {

    Logger logger = LoggerFactory.getLogger(SeqNoIotConnection.class);

    default Future<Frame<?>> beforeWrite(Frame<?> frame) {
        if (!frame.isRaw()) {
            frame = ((AbstractFrame<?, ?>) frame).rawFrame();
        }
        RawYkcFrame rawFrame = (RawYkcFrame) frame;
        rawFrame.checkCode(rawFrame.calcCheckCode());
        return Future.succeededFuture(frame);
    }

    default Frame<?> convertRawFrame(ByteBuf byteBuf) {
        RawYkcFrame rawYkcFrame = RawYkcFrame.new4Receiver(this, byteBuf);
        if (YkcMessageType.YkcLoginRequest.messageType().equals(rawYkcFrame.messageType())) {
            try {
                DefaultYkcFrame<YkcLoginRequest> ykcFrame = new DefaultYkcFrame<>(rawYkcFrame, YkcMessageType.YkcLoginRequest);
                String terminalNo = ykcFrame
                        .data()
                        .getTerminalNo()
                        .toString();
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
