package com.github.eiot.test.example;

import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import io.github.eiot.CommandDef;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleFrameConverter extends FrameConverter {

    public static final ExampleFrameConverter INSTANCE = new ExampleFrameConverter();

    @Override
    protected Frame<?> convert(Frame<?> frame, CommandDef<?> commandDef) {
        return new DefaultExampleFrame<>((RawExampleFrame) frame, commandDef);
    }
}
