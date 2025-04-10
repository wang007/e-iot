package io.github.eiot;

import java.util.Map;

/**
 * Attribute holder object
 * <p>
 * created by wang007 on 2025/2/20
 */
public interface AttributeHolder {

    /**
     * Put some arbitrary attribute in the holder.
     *
     * @param key the key for the data
     * @param obj the data
     * @return the old value
     */
    default Object put(String key, Object obj) {
        return attributes().put(key, obj);
    }

    /**
     * get attribute from holder
     *
     * @param key the key for the data
     * @param <V> the type of the data
     * @return the data
     * @throws ClassCastException if the data is not of the expected type
     */
    @SuppressWarnings("unchecked")
    default <V> V get(String key) {
        return (V) attributes().get(key);
    }

    /**
     * get attribute from the holder
     *
     * @param key the key for the data
     * @param <V> the type of the data
     * @return the data
     * @throws ClassCastException if the data is not of the expected type
     */
    @SuppressWarnings("unchecked")
    default <V> V get(String key, V defaultValue) {
        return (V) attributes().getOrDefault(key, defaultValue);
    }

    /**
     * Remove some attribute from the holder.
     *
     * @param key the key for the data
     * @param <V> the type of the data
     * @return the previous data associated with the key
     * @throws ClassCastException if the data is not of the expected type
     */
    @SuppressWarnings("unchecked")
    default <V> V remove(String key) {
        return (V) attributes().remove(key);
    }

    /**
     * @return all the attribute as a map
     */
    Map<String, Object> attributes();
}
