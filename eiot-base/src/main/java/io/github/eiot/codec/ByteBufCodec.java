package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;

/**
 * byteBuf codec
 * <p>
 * created by wang007 on 2025/2/26
 */
public class ByteBufCodec extends AbstractCodec<ByteBuf> {

    public ByteBufCodec(int length) {
        super(length);
    }

    public ByteBufCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder, null);
    }

    public ByteBufCodec(int length, ByteOrder byteOrder, String lengthKey) {
        super(length, byteOrder, lengthKey);
    }

    @Override
    public ByteBuf decode(ByteBuf byteBuf, CodecContext context) {
        int len = getLengthWithContext(context);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        byte[] bs = new byte[len];
        ByteBuf buffer = Unpooled.buffer();
        byteBuf.readBytes(bs);
        buffer.writeBytes(bs);
        return buffer;
    }

    @Override
    public void encode(ByteBuf byteBuf, ByteBuf data, CodecContext context) {
        checkLength(data.readableBytes());
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        byteBuf.writeBytes(data);
    }
}
