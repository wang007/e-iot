package io.github.eiot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * frame translation.
 * raw frame: The data field is still byte[], and the other fields are already parsed.
 * Converts a raw frame into a frame of a specific type.
 * <p>
 * created by wang007 on 2025/2/25
 */
public abstract class FrameConverter implements Function<Frame<?>, Frame<?>> {

    static Logger logger = LoggerFactory.getLogger(FrameConverter.class);

    /**
     * Converts a raw frame into a frame of a specific type
     *
     * @param frame raw frame
     * @return The concrete type of frame
     */
    @Override
    public Frame<?> apply(Frame<?> frame) {
        if (!frame.isRaw()) {
            return frame;
        }
        String messageType = frame.messageType();
        MessageType<?> match = MessageType.match(frame.iotConnection().protocol(), messageType);
        if (match == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("terminalNo: {} messageType: {} not found messageTypeEnum.", frame.terminalNo(), frame.messageType());
            }
            return frame;
        }
        return convert(frame, match);
    }

    /**
     * @param frame       the raw frame
     * @param messageType match message type
     * @return the concrete frame
     */
    protected abstract Frame<?> convert(Frame<?> frame, MessageType<?> messageType);
}
