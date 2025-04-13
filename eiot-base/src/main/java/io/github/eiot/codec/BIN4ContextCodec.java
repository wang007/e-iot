package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * {@link BIN4Codec} but put value to context use {@link CodecContext#DATA_LEN_KEY}
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BIN4ContextCodec implements Codec<Integer> {

    private final BIN4Codec bin4Codec;

    public BIN4ContextCodec(int length) {
        bin4Codec = new BIN4Codec(length);
    }

    public BIN4ContextCodec(int length, ByteOrder byteOrder) {
        bin4Codec = new BIN4Codec(length, byteOrder);
    }

    @Override
    public Integer decode(ByteBuf byteBuf, CodecContext context) {
        Integer v = bin4Codec.decode(byteBuf, context);
        context.put(CodecContext.DATA_LEN_KEY, v);
        return v;
    }

    @Override
    public void encode(ByteBuf byteBuf, Integer data, CodecContext context) {
        bin4Codec.encode(byteBuf, data, context);
    }

    @Override
    public int getLength() {
        return bin4Codec.getLength();
    }
}
