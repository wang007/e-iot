package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/2/26
 */
public class BCDTimeCodec extends AbstractCodec<BCDTime> {

    public BCDTimeCodec(ByteOrder byteOrder) {
        super(6, byteOrder);
    }

    @Override
    public BCDTime decode(ByteBuf byteBuf, CodecContext context) {
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, BCDTime data, CodecContext context) {

    }
}
