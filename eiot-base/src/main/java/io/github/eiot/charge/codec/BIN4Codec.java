package io.github.eiot.charge.codec;


import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * codec bin length 1 ~ 4
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BIN4Codec extends AbstractCodec<Integer> {

    public BIN4Codec(int length) {
        super(length);
        if (length > 4 || length < 1) {
            throw new IllegalArgumentException("BIN4 codec length must be >= 1 and <= 4");
        }
    }

    public BIN4Codec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
        if (length > 4 || length < 1) {
            throw new IllegalArgumentException("BIN4 codec length must be >=1 and <= 4");
        }
    }

    @Override
    public Integer decode(ByteBuf byteBuf, CodecContext context) {
        long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        return (int) number;
    }

    @Override
    public void encode(ByteBuf byteBuf, Integer data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data, byteOrder, length);
    }
}
