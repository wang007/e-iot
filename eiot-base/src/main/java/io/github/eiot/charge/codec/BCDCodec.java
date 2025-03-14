package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * BCD codec
 *
 * created by wang007 on 2025/2/26
 */
public class BCDCodec extends AbstractCodec<BCD> {

    public BCDCodec(int length) {
        super(length);
    }

    public BCDCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public BCD decode(ByteBuf byteBuf, CodecContext context) {
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, BCD data, CodecContext context) {

    }
}
