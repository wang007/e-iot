package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/2/26
 */
public class BCDTimeCodec extends AbstractCodec<BCDTime> {

    public BCDTimeCodec(ByteOrder byteOrder) {
        super(6, byteOrder);
    }

    @Override
    public BCDTime decode(ByteBuf byteBuf, CodecContext context) {
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            CodecUtil.reverseBytes(bs);
        }
        return new BCDTime(bs);
    }

    @Override
    public void encode(ByteBuf byteBuf, BCDTime data, CodecContext context) {
        byte[] bs = data.getBytes();
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            bs = CodecUtil.reverseBytesNewOne(bs);
        }
        byteBuf.writeBytes(bs);
    }
}
