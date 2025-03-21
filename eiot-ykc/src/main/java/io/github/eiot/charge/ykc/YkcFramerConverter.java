package io.github.eiot.charge.ykc;

import io.github.eiot.charge.Frame;
import io.github.eiot.charge.FrameConverter;
import io.github.eiot.charge.MessageTypeEnum;
import io.github.eiot.charge.SeqNoChargeConnection;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 云快充 frame 转换，从 RawYkcFrame 转换为具体的 Frame
 * <p>
 * created by wang007 on 2025/3/21
 */
public class YkcFramerConverter implements FrameConverter {

    Logger logger = LoggerFactory.getLogger(SeqNoChargeConnection.class);

    public static final YkcFramerConverter INSTANCE = new YkcFramerConverter();

    private static final Map<String, Constructor<?>> constructors;

    static {
        Class<?>[] innerClzList = Ykc.class.getDeclaredClasses();
        Map<String, Constructor<?>> map = new HashMap<>();
        for (Class<?> clz : innerClzList) {
            String simpleName = clz.getSimpleName();
            // ...Frame
            String messageTypeName = simpleName.substring(0, simpleName.length() - 5);
            try {
                Constructor<?> constructor = clz.getConstructor(RawYkcFrame.class);
                map.put(messageTypeName, constructor);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        constructors = map;
    }

    private YkcFramerConverter() {
    }

    public static void main(String[] args) {
        new YkcFramerConverter();
    }

    @Override
    public Frame<?> apply(Frame<?> frame) {
        RawYkcFrame rawFrame = (RawYkcFrame) frame;
        String messageType = rawFrame.messageType();
        YkcMessageTypeEnum messageTypeEnum = YkcMessageTypeEnum.match(messageType);
        if (messageTypeEnum == null) {
            // TODO log
            return frame;
        }
        Constructor<?> constructor = constructors.get(messageTypeEnum.name());
        if (constructor == null) {
            // TODO log
            return frame;
        }
        try {
            return (Frame<?>) constructor.newInstance(rawFrame);
        } catch (Throwable e) {
            // TODO log
            throw new RuntimeException(e);
        }
    }
}
