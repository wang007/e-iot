package io.github.eiot.charge;

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
    Object put(String key, Object obj);

    /**
     * get attribute from holder
     *
     * @param key the key for the data
     * @param <T> the type of the data
     * @return the data
     * @throws ClassCastException if the data is not of the expected type
     */
    <T> T get(String key);

    /**
     * get attribute from the holder
     *
     * @param key the key for the data
     * @param <T> the type of the data
     * @return the data
     * @throws ClassCastException if the data is not of the expected type
     */
    <T> T get(String key, T defaultValue);

    /**
     * Remove some attribute from the holder.
     *
     * @param key the key for the data
     * @param <T> the type of the data
     * @return the previous data associated with the key
     * @throws ClassCastException if the data is not of the expected type
     */
    <T> T remove(String key);

    /**
     * @return all the attribute as a map
     */
    Map<String, Object> attributes();
}
