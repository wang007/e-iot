package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * Number unit codec
 * created by wang007 on 2025/2/28
 */
public class NumberUnitCodec extends AbstractCodec<NumberUnit> {

    private final int unit;

    public NumberUnitCodec(int length, int unit) {
        this(length, ByteOrder.LITTLE_ENDIAN, unit);
    }


    public NumberUnitCodec(int length, ByteOrder byteOrder, int unit) {
        super(length, byteOrder, null);
        this.unit = unit;
    }

    @Override
    public NumberUnit decode(ByteBuf byteBuf, CodecContext context) {
        long number = CodecUtil.readNumber(byteBuf, byteOrder, length);
        return new NumberUnit(number, unit);
    }

    @Override
    public void encode(ByteBuf byteBuf, NumberUnit data, CodecContext context) {
        CodecUtil.writeNumber(byteBuf, data.originNumber(), byteOrder, length);
    }
}
