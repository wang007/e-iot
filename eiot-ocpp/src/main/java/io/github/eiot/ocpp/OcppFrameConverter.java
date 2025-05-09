package io.github.eiot.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;

/**
 * created by wang007 on 2025/5/10
 */
public class OcppFrameConverter extends FrameConverter {

    public static final OcppFrameConverter INSTANCE = new OcppFrameConverter();

    @Override
    protected Frame<?> convert(Frame<?> frame, CommandDef<?> commandDef) {
        return new DefaultOcppFrame<>((RawOcppFrame) frame, commandDef);
    }
}
