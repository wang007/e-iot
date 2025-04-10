package io.github.eiot.codec;

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

    public String toHexString() {
        return this.hexString;
    }

    /**
     *
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
        return new Hex(bytes);
    }

    @Override
    public String toString() {
        return toHexString();
    }

}
