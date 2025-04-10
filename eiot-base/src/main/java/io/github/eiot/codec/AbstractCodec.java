package io.github.eiot.codec;


import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/2/26
 */
public abstract class AbstractCodec<T> implements Codec<T> {

    protected final int length;

    protected final ByteOrder byteOrder;

    public AbstractCodec(int length) {
        this(length, ByteOrder.LITTLE_ENDIAN);
    }

    public AbstractCodec(int length, ByteOrder byteOrder) {
        this.length = length;
        this.byteOrder = byteOrder;
    }

    @Override
    public int getLength() {
        return length;
    }
}
