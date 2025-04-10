package io.github.eiot.codec;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/2/26
 */
public class BCDTimeCodec extends AbstractCodec<BCDTime> {

    private final BCDCodec bcdCodec;

    public BCDTimeCodec() {
        super(6);
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    public BCDTimeCodec(ByteOrder byteOrder) {
        super(6, byteOrder);
        this.bcdCodec = new BCDCodec(length, byteOrder);
    }

    @Override
    public BCDTime decode(ByteBuf byteBuf, CodecContext context) {
        BCD bcd = bcdCodec.decode(byteBuf, context);
        return new BCDTime(bcd.getBytes());
    }

    @Override
    public void encode(ByteBuf byteBuf, BCDTime data, CodecContext context) {
        bcdCodec.encode(byteBuf, data.getBcd());
    }
}
