package io.github.eiot.charge.ykc;


import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import io.github.eiot.CommandDef;


/**
 * 云快充 frame 转换，从 RawYkcFrame 转换为具体的 Frame
 * <p>
 * created by wang007 on 2025/3/21
 */
public class YkcFramerConverter implements FrameConverter {

    public static final YkcFramerConverter INSTANCE = new YkcFramerConverter();

    private YkcFramerConverter() {
    }

    @Override
    public Frame<?> apply(Frame<?> frame) {
        if (!frame.isRaw()) {
            return frame;
        }
        CommandDef<?> command = YkcCommand.match(frame.command());
        if (command == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("terminalNo: {} command: {} not found commandDef.", frame.terminalNo(), frame.command());
            }
            return frame;
        }
        return new DefaultYkcFrame<>((RawYkcFrame) frame, command);
    }
}
