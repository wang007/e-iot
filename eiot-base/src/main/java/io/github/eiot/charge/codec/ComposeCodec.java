package io.github.eiot.charge.codec;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

/**
 * Combine multiple codecs
 *
 * created by wang007 on 2025/3/1
 */
public class ComposeCodec implements Codec<List<Object>> {

    private final List<Codec<?>> codecList;
    private final int length;

    public ComposeCodec(List<Codec<?>> codecList) {
        this.codecList = codecList;
        this.length = codecList.size();
    }

    @Override
    public List<Object> decode(ByteBuf byteBuf, CodecContext context) {
        List<Object> values = new ArrayList<>(length);
        for (Codec<?> codec : codecList) {
            Object v = codec.decode(byteBuf, context);
            values.add(v);
        }
        return values;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void encode(ByteBuf byteBuf, List<Object> data, CodecContext context) {
        int len = length;
        if (data.size() != len) {
            throw new IllegalArgumentException("encode failed, data length != codecs length");
        }
        for (int i = 0; i < len; i++) {
            Object v = data.get(i);
            Codec<Object> codec = (Codec<Object>) codecList.get(i);
            codec.encode(byteBuf, v);
        }
    }

    @Override
    public int getLength() {
        return -1;
    }
}
