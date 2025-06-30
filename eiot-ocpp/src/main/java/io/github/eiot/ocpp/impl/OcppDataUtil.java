package io.github.eiot.ocpp.impl;

import io.github.eiot.exception.IotException;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by wang007 on 2025/6/30
 */
public class OcppDataUtil {

    private static final Map<Class<?>, Constructor<?>> constructors = new ConcurrentHashMap<>(128);

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clz) {
        Constructor<?> c = constructors.computeIfAbsent(clz, k -> {
            Constructor<?> constructor;
            try {
                constructor = k.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                throw new IotException(e);
            }
            return constructor;
        });
        try {
            return (T) c.newInstance();
        } catch (Exception e) {
            throw new IotException("class: " + clz.getName() + " newInstance failed", e);
        }
    }

}
