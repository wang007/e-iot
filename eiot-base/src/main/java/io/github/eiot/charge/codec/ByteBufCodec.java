package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

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
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        return ByteBufRef.from(Unpooled.wrappedBuffer(bs));
    }

    @Override
    public void encode(ByteBuf byteBuf, ByteBufRef data, CodecContext context) {
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            throw new UnsupportedOperationException("byteBuf not support BIG_ENDIAN");
        }
        byteBuf.writeBytes(data.byteBuf());
    }
}
