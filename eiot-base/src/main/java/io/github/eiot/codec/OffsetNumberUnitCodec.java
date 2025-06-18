package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/5/22
 */
public class OffsetNumberUnitCodec extends AbstractCodec<OffsetNumberUnit> {

    private final int unit;
    private final int offset;
    private final boolean offsetReverse;

    public OffsetNumberUnitCodec(int length, int unit, int offset) {
        this(length, unit, offset, false);
    }

    public OffsetNumberUnitCodec(int length, int unit, int offset, boolean offsetReverse) {
        super(length);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    public OffsetNumberUnitCodec(int length, ByteOrder byteOrder, int unit, int offset) {
        this(length, byteOrder, unit, offset, false);
    }

    public OffsetNumberUnitCodec(int length, ByteOrder byteOrder, int unit, int offset, boolean offsetReverse) {
        super(length, byteOrder, null);
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    @Override
    public OffsetNumberUnit decode(ByteBuf byteBuf, CodecContext context) {
        long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        return new OffsetNumberUnit(number, unit, offset, offsetReverse);
    }

    @Override
    public void encode(ByteBuf byteBuf, OffsetNumberUnit data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data.originNumber(), byteOrder, length);
    }
}
