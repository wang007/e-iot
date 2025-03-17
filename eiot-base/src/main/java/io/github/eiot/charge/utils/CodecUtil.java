package io.github.eiot.charge.utils;

import io.netty.buffer.ByteBuf;

/**
 * @author yan
 * @since 2025-03-15
 */
public class CodecUtil {

    public static byte[] reverseBytes(byte[] bs) {
        int end = bs.length - 1;
        for (int i = 0; i < bs.length / 2; i++) {
            byte t = bs[i];
            bs[i] = bs[end - i];
            bs[end - i] = t;
        }
        return bs;
    }

    public static byte[] readBytes(ByteBuf byteBuf, int length) {
        byte[] bs = new byte[length];
        byteBuf.readBytes(bs);
        return bs;
    }
}
