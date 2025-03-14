package io.github.eiot.charge.codec;


import java.util.HashMap;
import java.util.Map;

/**
 * default codec context
 *
 * created by wang007 on 2025/2/26
 */
public class DefaultCodecContext implements CodecContext {

    private final Map<String, Object> map;

    public DefaultCodecContext() {
        map = new HashMap<>(2, 1.0f);
    }

    @Override
    public Object put(String key, Object obj) {
        return map.put(key, obj);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) map.get(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key, T defaultValue) {
        return (T) map.getOrDefault(key, defaultValue);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T remove(String key) {
        return (T) map.remove(key);
    }

    @Override
    public Map<String, Object> attributes() {
        return map;
    }
}
