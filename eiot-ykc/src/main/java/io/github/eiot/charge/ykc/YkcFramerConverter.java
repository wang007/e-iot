package io.github.eiot.charge.ykc;


import io.github.eiot.Frame;
import io.github.eiot.FrameConverter;
import io.github.eiot.MessageType;
import io.github.eiot.SeqNoIotConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 云快充 frame 转换，从 RawYkcFrame 转换为具体的 Frame
 * <p>
 * created by wang007 on 2025/3/21
 */
public class YkcFramerConverter extends FrameConverter {

    public static final YkcFramerConverter INSTANCE = new YkcFramerConverter();

    private YkcFramerConverter() {
    }

    @Override
    public Frame<?> convert(Frame<?> frame, MessageType<?> messageType) {
        return new DefaultYkcFrame<>((RawYkcFrame) frame, messageType);
    }
}
