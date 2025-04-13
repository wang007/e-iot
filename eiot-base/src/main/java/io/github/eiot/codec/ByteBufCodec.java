package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * byteBuf codec
 * <p>
 * created by wang007 on 2025/2/26
 */
public class ByteBufCodec extends AbstractCodec<ByteBufRef> {

    public ByteBufCodec(int length) {
        super(length);
    }

    public ByteBufCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public ByteBufRef decode(ByteBuf byteBuf, CodecContext context) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        int len = length;
        if (len == -1) {
            len = context.get(CodecContext.DATA_LEN_KEY, -1);
        }
        if (len < 0) {
            throw new IllegalArgumentException("codec length < 0");
        }
        return new ByteBufRef(byteBuf.readSlice(len));
    }

    @Override
    public void encode(ByteBuf byteBuf, ByteBufRef data, CodecContext context) {
        if (length != -1) {
            int readableBytes = data.byteBuf().readableBytes();
            if (readableBytes != length) {
                throw new IllegalArgumentException("byteBuf length != codec length");
            }
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        byteBuf.writeBytes(data.byteBuf());
    }
}
