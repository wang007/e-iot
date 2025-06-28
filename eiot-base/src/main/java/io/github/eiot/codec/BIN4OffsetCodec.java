package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/6/28
 */
public class BIN4OffsetCodec extends AbstractCodec<Integer> {

    private final int offset;

    public BIN4OffsetCodec(int length, int offset) {
        this(length, ByteOrder.LITTLE_ENDIAN, offset);
    }

    public BIN4OffsetCodec(int length, ByteOrder byteOrder, int offset) {
        this(length, byteOrder, null, offset);
    }

    public BIN4OffsetCodec(int length, ByteOrder byteOrder, String lengthKey, int offset) {
        super(length, byteOrder, lengthKey);
        this.offset = offset;
    }

    @Override
    public void encode(ByteBuf byteBuf, Integer data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data, byteOrder, length);
        putLengthIntoContext(context, data - offset);
    }

    @Override
    public Integer decode(ByteBuf byteBuf, CodecContext context) {
        long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        Integer v = (int) number;
        putLengthIntoContext(context, number + offset);
        return v;
    }
}
