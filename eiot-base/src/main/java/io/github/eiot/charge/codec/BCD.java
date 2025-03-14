package io.github.eiot.charge.codec;

import io.netty.util.internal.StringUtil;

/**
 * bcd data type
 * like Hex but without ABCDEF
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BCD {

    private final byte[] bcd;

    public BCD(byte[] bytes) {
        this.bcd = bytes;
    }

    byte[] getBytes() {
        return bcd;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(bcd.length);
        for (int j : bcd) {
            s.append(j);
        }
        return s.toString();
    }

    /**
     * In general, the prefix 0 is required during the interaction
     *
     * @return Remove all the prefix 0
     */
    public String to0StripString() {
        StringBuilder s = new StringBuilder(bcd.length);
        boolean append = false;
        for (int j : bcd) {
            if (append) {
                s.append(j);
                break;
            }
            if (j == 48) { // '0'
                break;
            }
            append = true;
            s.append(j);
        }
        return s.toString();
    }

    /**
     * new BCD instances by bcdString.
     *
     * NOTE: The length of the bcd string must correspond to the length of the underlying encoding.
     *
     * @param bcdString bcdString Contains 0 to 9 digits and must be an even number
     * @return the bcd
     */
    public static BCD from(String bcdString) {
        int len = bcdString.length();
        if ((len & 1) != 0) {
            throw new IllegalArgumentException("bcd length % 2 != 0");
        }
        byte[] bcd = new byte[len];
        for (int i = 0; i < len; i++) {
            int num = StringUtil.decodeHexNibble(bcdString.charAt(i));
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("bcd string must be 0 ~ 9");
            }
            bcd[i] = (byte) num;
        }
        return new BCD(bcd);
    }

    /**
     * like {@link #from(String)}, but add 0 to the prefix depending on the length
     *
     * @param bcdString bcdString Contains 0 to 9 digits and must be an even number
     * @param len The length of BCD
     * @return new BCD
     */
    public static BCD from(String bcdString, int len) {
        if (bcdString.length() > len) {
            throw new IllegalArgumentException("bcdString length > len");
        }
        if (bcdString.length() == len) {
            return from(bcdString);
        }
        StringBuilder s = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            s.append('0');
        }
        s.append(bcdString);
        return from(s.toString());
    }







}
