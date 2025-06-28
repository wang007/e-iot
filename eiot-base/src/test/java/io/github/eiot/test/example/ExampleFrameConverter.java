package io.github.eiot.test.example;

import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import io.github.eiot.CommandDef;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleFrameConverter implements FrameConverter {

    public static final ExampleFrameConverter INSTANCE = new ExampleFrameConverter();

    @Override
    public Frame<?> apply(Frame<?> frame) {
        if (!frame.isRaw()) {
            return frame;
        }
        CommandDef<?> command = ExampleCommand.COMMAND_PROTOCOL.match(frame.command());
        if (command == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("terminalNo: {} command: {} not found commandDef.", frame.terminalNo(), frame.command());
            }
            return frame;
        }
        return new DefaultExampleFrame<>((RawExampleFrame) frame, command);
    }
}
