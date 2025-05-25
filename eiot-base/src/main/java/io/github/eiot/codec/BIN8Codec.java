package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * codec bin length 5 ~ 8
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BIN8Codec extends AbstractCodec<Long> {

    public BIN8Codec(int length) {
        this(length, ByteOrder.LITTLE_ENDIAN);
    }

    public BIN8Codec(int length, ByteOrder byteOrder) {
        this(length, byteOrder, null);
    }

    public BIN8Codec(int length, ByteOrder byteOrder, String lengthKey) {
        super(length, byteOrder, lengthKey);
        if (length <= 4 || length > 8) {
            throw new IllegalArgumentException("BIN8 codec length must be > 4 and < 8");
        }
    }


    @Override
    public Long decode(ByteBuf byteBuf, CodecContext context) {
        Long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        putLengthIntoContext(context, number);
        return number;
    }

    @Override
    public void encode(ByteBuf byteBuf, Long data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data, byteOrder, length);
        putLengthIntoContext(context, data);
    }
}
