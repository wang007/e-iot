package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * bcd number codec
 *
 * @author yan
 * @since 2025-03-17
 */
public class BCDNumberCodec extends AbstractCodec<BCDNumber> {

    private final int unit;
    private final int offset;
    private final boolean offsetReverse;
    private final BCDCodec bcdCodec;

    public BCDNumberCodec(int length, int unit) {
        this(length, unit, 0, false);
    }

    public BCDNumberCodec(int length, int unit, int offset) {
        this(length, unit, offset, false);
    }

    public BCDNumberCodec(int length, int unit, int offset, boolean offsetReverse) {
        super(length);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    public BCDNumberCodec(int length, ByteOrder byteOrder, int unit) {
        this(length, byteOrder, unit, 0, false);
    }

    public BCDNumberCodec(int length, ByteOrder byteOrder, int unit, int offset) {
        this(length, byteOrder, unit, offset, false);
    }

    public BCDNumberCodec(int length, ByteOrder byteOrder, int unit, int offset, boolean offsetReverse) {
        super(length, byteOrder);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    @Override
    public BCDNumber decode(ByteBuf byteBuf, CodecContext context) {
        BCD bcd = bcdCodec.decode(byteBuf, context);
        return new BCDNumber(bcd, unit, offset, offsetReverse);
    }

    @Override
    public void encode(ByteBuf byteBuf, BCDNumber data, CodecContext context) {
        bcdCodec.encode(byteBuf, data.getBcd());
    }
}
