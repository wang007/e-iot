package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * created by wang007 on 2025/6/19
 */
public class ListCodec<T> extends AbstractCodec<List<T>> {

    private final Codec<T> codec;

    public ListCodec(int length, Codec<T> codec) {
        this(length, ByteOrder.LITTLE_ENDIAN, codec);
    }

    public ListCodec(int length, ByteOrder byteOrder, Codec<T> codec) {
        this(length, ByteOrder.LITTLE_ENDIAN, null, codec);
    }

    public ListCodec(int length, ByteOrder byteOrder, String lengthKey, Codec<T> codec) {
        super(length, byteOrder, lengthKey);
        this.codec = codec;
    }

    @Override
    public List<T> decode(ByteBuf byteBuf, CodecContext context) {
        int len = getLengthWithContext(context);
        List<T> values = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            values.add(codec.decode(byteBuf, context));
        }
        return values;
    }

    @Override
    public void encode(ByteBuf byteBuf, List<T> data, CodecContext context) {
        checkLength(data.size());
        for (T v : data) {
            codec.encode(byteBuf, v, context);
        }
    }
}
