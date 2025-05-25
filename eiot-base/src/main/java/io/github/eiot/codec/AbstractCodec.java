package io.github.eiot.codec;


import java.nio.ByteOrder;
import java.util.Objects;

/**
 * created by wang007 on 2025/2/26
 */
public abstract class AbstractCodec<T> implements Codec<T> {

    protected final int length;

    protected final ByteOrder byteOrder;

    protected final String lengthKey;

    public AbstractCodec(int length) {
        this(length, ByteOrder.LITTLE_ENDIAN, null);
    }

    public AbstractCodec(int length, ByteOrder byteOrder, String lengthKey) {
        this.length = length;
        this.byteOrder = byteOrder;
        this.lengthKey = lengthKey;
    }

    @Override
    public int getLength() {
        return length;
    }

    public void putLengthIntoContext(CodecContext context, Number value) {
        if (lengthKey == null || lengthKey.isEmpty()) {
            return;
        }
        context.put(lengthKey, value);
    }


    public int getLengthWithContext(CodecContext context) {
        int len = length;
        if (len != -1) {
            return len;
        }
        String key = lengthKey;
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("codec length == -1 and lengthKey == null");
        }
        Number v = context.get(key);
        if (v == null) {
            throw new IllegalArgumentException("not found value by: " + key + " in context");
        }
        len = v.intValue();
        if (len < 0) {
            throw new IllegalArgumentException("codec length < 0");
        }
        return len;
    }

    public void checkLength(int length) {
        int l = this.length;
        // Indefinite length, not check
        if (l == -1) {
            return;
        }
        if (l != length) {
            throw new IllegalArgumentException("codec length != value length");
        }
    }

}
