package io.github.eiot.charge.ykc;

import io.github.eiot.charge.AbstractFrame;
import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Frame;
import io.github.eiot.charge.SeqNoChargeConnection;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by wang007 on 2025/3/21
 */
interface YkcChargeConnectionBase extends ChargeConnection {

    Logger logger = LoggerFactory.getLogger(SeqNoChargeConnection.class);

    default Future<Frame<?>> beforeWrite(Frame<?> frame) {
        if (!frame.isRaw()) {
            frame = ((AbstractFrame<?,?>)frame).rawFrame();
        }
        RawYkcFrame rawFrame = (RawYkcFrame) frame;
        rawFrame.checkCode(rawFrame.calcCheckCode());
        return Future.succeededFuture(frame);
    }

    default Frame<?> convertRawFrame(ByteBuf byteBuf) {
        RawYkcFrame rawYkcFrame = RawYkcFrame.new4Receiver(this, byteBuf);
        if (YkcMessageTypeEnum.YkcLoginRequest.messageType().equals(rawYkcFrame.messageType())) {
            try {
                String terminalNo = new Ykc.YkcLoginRequestFrame(rawYkcFrame)
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
