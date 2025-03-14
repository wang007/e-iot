package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/2/26
 */
public class BytesCodec extends AbstractCodec<byte[]> {

    public BytesCodec(int length) {
        super(length);
    }

    public BytesCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public byte[] decode(ByteBuf byteBuf, CodecContext context) {
        return new byte[0];
    }

    @Override
    public void encode(ByteBuf byteBuf, byte[] data, CodecContext context) {

    }

}
