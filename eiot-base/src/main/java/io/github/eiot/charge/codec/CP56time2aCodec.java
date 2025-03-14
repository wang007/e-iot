package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * CP56time2a codec
 *
 * created by wang007 on 2025/2/28
 */
public class CP56time2aCodec extends AbstractCodec<CP56time2a> {

    public CP56time2aCodec(ByteOrder byteOrder) {
        super(7, byteOrder);
    }

    @Override
    public CP56time2a decode(ByteBuf byteBuf, CodecContext context) {
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, CP56time2a data, CodecContext context) {

    }
}
