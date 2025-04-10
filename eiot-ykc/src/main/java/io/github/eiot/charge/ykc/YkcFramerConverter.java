package io.github.eiot.charge.ykc;


import io.github.eiot.charge.Frame;
import io.github.eiot.charge.FrameConverter;
import io.github.eiot.charge.MessageType;
import io.github.eiot.charge.SeqNoChargeConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 云快充 frame 转换，从 RawYkcFrame 转换为具体的 Frame
 * <p>
 * created by wang007 on 2025/3/21
 */
public class YkcFramerConverter implements FrameConverter {

    private static final Logger logger = LoggerFactory.getLogger(SeqNoChargeConnection.class);

    public static final YkcFramerConverter INSTANCE = new YkcFramerConverter();

    private YkcFramerConverter() {
    }

    @Override
    public Frame<?> apply(Frame<?> frame) {
        RawYkcFrame rawFrame = (RawYkcFrame) frame;
        String messageType = rawFrame.messageType();
        MessageType<?> messageTypeEnum = YkcMessageType.match(messageType);
        if (messageTypeEnum == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("terminalNo: {} messageType: {} not found messageTypeEnum.", frame.terminalNo(), frame.messageType());
            }
            return frame;
        }
        return new DefaultYkcFrame<>(rawFrame, messageTypeEnum);
    }
}
