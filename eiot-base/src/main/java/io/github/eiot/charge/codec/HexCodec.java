package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * hex codec
 *
 * created by wang007 on 2025/2/26
 */
public class HexCodec extends AbstractCodec<Hex> {

    public HexCodec(int length) {
        super(length);
    }

    public HexCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public Hex decode(ByteBuf byteBuf, CodecContext context) {
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            return new Hex(CodecUtil.reverseBytes(bs));
        }
        return new Hex(bs);
    }

    @Override
    public void encode(ByteBuf byteBuf, Hex data, CodecContext context) {
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            byteBuf.writeBytes(CodecUtil.reverseBytes(data.getBytes()));
        }else {
            byteBuf.writeBytes(data.getBytes());
        }
    }
}
