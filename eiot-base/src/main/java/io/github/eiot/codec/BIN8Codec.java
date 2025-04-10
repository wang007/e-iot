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
        super(length);
        if (length <= 4 || length > 8) {
            throw new IllegalArgumentException("BIN8 codec length must be > 4 and < 8");
        }
    }

    public BIN8Codec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
        if (length <= 4 || length > 8) {
            throw new IllegalArgumentException("BIN8 codec length must be > 4 and < 8");
        }
    }

    @Override
    public Long decode(ByteBuf byteBuf, CodecContext context) {
        return CodecUtil.readNumber(byteBuf, byteOrder, length);
    }

    @Override
    public void encode(ByteBuf byteBuf, Long data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data, byteOrder, length);
    }
}
