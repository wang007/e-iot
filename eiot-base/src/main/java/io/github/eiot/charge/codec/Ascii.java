package io.github.eiot.charge.codec;

import org.apache.commons.lang3.StringUtils;

/**
 * ascii data type
 * created by wang007 on 2025/2/28
 */
public class Ascii {

    private static final String DEFAULT_PADDING = new String(new char[]{0});

    private final String value;
    private final short len;

    public Ascii(String value) {
        this.value = value;
        this.len = (short) value.length();
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
                sb.append(DEFAULT_PADDING);
            }
            sb.append(value);
            this.value = sb.toString();
        }
        this.len = (short) len;
    }

    /**
     * @return the real string
     */
    public String toRealString() {
        return value.substring(value.length() - len);
    }

    /**
     * filter invalid char
     * @return a valid string
     */
    public String toValidString() {
        return StringUtils.strip(value, DEFAULT_PADDING);
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
}
