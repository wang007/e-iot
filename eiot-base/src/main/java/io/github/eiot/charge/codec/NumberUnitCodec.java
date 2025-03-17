package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * Number unit codec
 * created by wang007 on 2025/2/28
 */
public class NumberUnitCodec extends AbstractCodec<NumberUnit> {

    private final int unit;
    private final int offset;
    private final boolean offsetReverse;

    public NumberUnitCodec(int length, int unit, int offset, boolean offsetReverse) {
        super(length);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    public NumberUnitCodec(int length, int unit, int offset) {
        this(length, unit, offset, false);
    }

    public NumberUnitCodec(int length, ByteOrder byteOrder, int unit, int offset, boolean offsetReverse) {
        super(length, byteOrder);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    public NumberUnitCodec(int length, ByteOrder byteOrder, int unit, int offset) {
        this(length, byteOrder, unit, offset, false);
    }

    @Override
    public NumberUnit decode(ByteBuf byteBuf, CodecContext context) {
        long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        return new NumberUnit(number, unit, offset, offsetReverse);
    }

    @Override
    public void encode(ByteBuf byteBuf, NumberUnit data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data.originNumber(), byteOrder, length);
    }
}
