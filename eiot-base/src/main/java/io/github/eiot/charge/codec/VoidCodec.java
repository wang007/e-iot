package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

/**
 * Just to mark
 *
 * created by wang007 on 2025/3/1
 */
public class VoidCodec implements Codec<Void> {

    VoidCodec INSTANCE = new VoidCodec();

    private VoidCodec() {}

    @Override
    public Void decode(ByteBuf byteBuf, CodecContext context) {
        return null;
    }

    @Override
    public void encode(ByteBuf byteBuf, Void data, CodecContext context) {

    }

    @Override
    public int getLength() {
        return 0;
    }
}
