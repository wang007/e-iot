package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * {@link BIN4Codec} but put value to context use {@link CodecContext#DATA_LEN_KEY}
 *
 * created by wang007 on 2025/2/26
 */
public class BIN4ContextCodec extends AbstractCodec<Integer> {

    public BIN4ContextCodec(int length) {
        super(length);
    }

    public BIN4ContextCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public Integer decode(ByteBuf byteBuf, CodecContext context) {
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, Integer data, CodecContext context) {

    }
}
