package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * byteBuf codec
 * <p>
 * created by wang007 on 2025/2/26
 */
public class ByteBufRefCodec extends AbstractCodec<ByteBufRef> {

    public ByteBufRefCodec(int length) {
        super(length);
    }

    public ByteBufRefCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public ByteBufRef decode(ByteBuf byteBuf, CodecContext context) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        int len = getLengthWithContext(context);
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
