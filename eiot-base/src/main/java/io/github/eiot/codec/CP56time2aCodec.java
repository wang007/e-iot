package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * CP56time2a codec
 *
 * created by wang007 on 2025/2/28
 */
public class CP56time2aCodec extends AbstractCodec<CP56time2a> {

    public CP56time2aCodec() {
        super(7);
    }

    public CP56time2aCodec(ByteOrder byteOrder) {
        super(7, byteOrder, null);
    }

    @Override
    public CP56time2a decode(ByteBuf byteBuf, CodecContext context) {
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            CodecUtil.reverseBytes(bs);
        }
        return new CP56time2a(bs);
    }

    @Override
    public void encode(ByteBuf byteBuf, CP56time2a data, CodecContext context) {
        byte[] bs = data.getBytes();
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            bs = CodecUtil.reverseBytesNewOne(bs);
        }
        byteBuf.writeBytes(bs);
    }
}
