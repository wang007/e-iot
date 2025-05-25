package io.github.eiot.codec;

import io.github.eiot.utils.StringUtil;

/**
 * ascii data type
 * created by wang007 on 2025/2/28
 */
public class Ascii {

    private static final char NULL_PADDING = 0;

    private final String value;

    Ascii(String value) {
        this.value = value;
    }

    /**
     * new a fixed len ascii, fill ascii(0) at last to complete length
     *
     * @param value          string value
     * @param completeLength ascii completeLength
     */
    public Ascii(String value, int completeLength) {
        int len = value.length();
        if (len > completeLength) {
            throw new IllegalArgumentException("value.length > completeLength");
        }

        if (len == completeLength) {
            this.value = value;
        } else {
            int remaining = completeLength - len;
            StringBuilder sb = new StringBuilder(completeLength);
            for (int i = 0; i < remaining; i++) {
                sb.append(NULL_PADDING);
            }
            sb.append(value);
            this.value = sb.toString();
        }
    }

    /**
     * filter invalid char
     *
     * @return a valid string
     */
    public String toValidString() {
        int start = 0;
        while (start != value.length() && value.charAt(start) == NULL_PADDING) {
            start++;
        }
        int end = value.length();
        while (end != 0 && value.charAt(end - 1) == NULL_PADDING) {
            end--;
        }
        return value.substring(start, end);
    }

    /**
     * @return complete string
     */
    public String toCompleteString() {
        return value;
    }

    @Override
    public String toString() {
        return toCompleteString();
    }

    public static Ascii from(String value) {
        return from(value, value.length());
    }

    public static Ascii from(String value, int len) {
        StringUtil.validateAscii(value);
        return new Ascii(value, len);
    }
}
