package io.github.eiot.codec;


import java.util.HashMap;
import java.util.Map;

/**
 * default codec context
 * <p>
 * created by wang007 on 2025/2/26
 */
public class DefaultCodecContext implements CodecContext {

    private final Map<String, Object> map;

    public DefaultCodecContext() {
        map = new HashMap<>(2, 1.0f);
    }

    @Override
    public Map<String, Object> attributes() {
        return map;
    }
}
