package io.github.eiot.utils;

/**
 * created by wang007 on 2025/5/22
 */
public class ValidationUtil {

    /**
     * value.len must be <= len
     *
     * @param value
     * @param len
     */
    public static void lteLen(String value, int len, String name) {
        if (value == null) {
            return;
        }
        if (value.length() > len) {
            throw new IllegalArgumentException(name + " length must be lte " + len);
        }
    }

}
