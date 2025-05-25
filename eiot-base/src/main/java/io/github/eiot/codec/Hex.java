package io.github.eiot.codec;

import io.github.eiot.utils.StringUtil;
import io.netty.buffer.ByteBufUtil;

/**
 * hex data type
 * <p>
 * created by wang007 on 2025/2/26
 */
public class Hex {
    protected final byte[] bytes;
    protected final String hexString;

    public Hex(byte[] bytes) {
        this.bytes = bytes;
        this.hexString = ByteBufUtil.hexDump(bytes);
    }

    public Hex(byte[] bytes, String hexString) {
        this.bytes = bytes;
        this.hexString = hexString;
    }

    public String toHexString() {
        return this.hexString;
    }

    /**
     * @return never update byte[]!!!
     */
    public byte[] getBytes() {
        return this.bytes;
    }

    public static Hex from(String hexString) {
        if ((hexString.length() % 2) != 0) {
            throw new IllegalArgumentException("hexString.length() /2 != 0");
        }
        byte[] bytes = ByteBufUtil.decodeHexDump(hexString);
        return new Hex(bytes, hexString);
    }

    /**
     * like {@link #from(String)}, but add 0 to the prefix depending on the length
     *
     * @param hexString hexString
     * @param len       The length of hex
     * @return new BCD
     */
    public static Hex from(String hexString, int len) {
        if ((hexString.length() % 2) != 0) {
            throw new IllegalArgumentException("hexString.length() /2 != 0");
        }
        if (hexString.length() == len) {
            return from(hexString);
        }
        return from(StringUtil.leftPad(hexString, len, '0'));
    }

    @Override
    public String toString() {
        return toHexString();
    }

}
