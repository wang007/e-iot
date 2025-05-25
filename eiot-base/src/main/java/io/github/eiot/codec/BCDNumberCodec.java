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
    private final BCDCodec bcdCodec;

    public BCDNumberCodec(int length, int unit) {
        super(length);
        this.unit = unit;
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    public BCDNumberCodec(int length, ByteOrder byteOrder, int unit) {
        this(length, byteOrder, null, unit);
    }

    public BCDNumberCodec(int length, ByteOrder byteOrder, String lengthKey, int unit) {
        super(length, byteOrder, null);
        this.unit = unit;
        this.bcdCodec = new BCDCodec(length, byteOrder, lengthKey);
    }


    @Override
    public BCDNumber decode(ByteBuf byteBuf, CodecContext context) {
        BCD bcd = bcdCodec.decode(byteBuf, context);
        return new BCDNumber(bcd, unit);
    }

    @Override
    public void encode(ByteBuf byteBuf, BCDNumber data, CodecContext context) {
        bcdCodec.encode(byteBuf, data.getBcd());
    }
}
