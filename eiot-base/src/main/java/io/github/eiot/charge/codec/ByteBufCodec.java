package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * byteBuf codec
 *
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
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, ByteBufRef data, CodecContext context) {

    }

}
