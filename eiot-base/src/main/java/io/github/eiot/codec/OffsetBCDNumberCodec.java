package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/5/22
 */
public class OffsetBCDNumberCodec extends AbstractCodec<OffsetBCDNumber> {

    private final int unit;
    private final int offset;
    private final boolean offsetReverse;
    private final BCDCodec bcdCodec;

    public OffsetBCDNumberCodec(int length, int unit, int offset) {
        this(length, unit, offset, false);
    }

    public OffsetBCDNumberCodec(int length, int unit, int offset, boolean offsetReverse) {
        super(length);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    public OffsetBCDNumberCodec(int length, ByteOrder byteOrder, int unit, int offset) {
        this(length, byteOrder, unit, offset, false);
    }

    public OffsetBCDNumberCodec(int length, ByteOrder byteOrder, int unit, int offset, boolean offsetReverse) {
        super(length, byteOrder);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    @Override
    public OffsetBCDNumber decode(ByteBuf byteBuf, CodecContext context) {
        BCD bcd = bcdCodec.decode(byteBuf, context);
        return new OffsetBCDNumber(bcd, unit, offset, offsetReverse);
    }

    @Override
    public void encode(ByteBuf byteBuf, OffsetBCDNumber data, CodecContext context) {
        bcdCodec.encode(byteBuf, data.getBcd());
    }
}
