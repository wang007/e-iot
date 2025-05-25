package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * hex codec
 * <p>
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
        int len = getLengthWithContext(context);
        byte[] bs = CodecUtil.readBytes(byteBuf, len);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            CodecUtil.reverseBytes(bs);
        }
        return new Hex(bs);
    }

    @Override
    public void encode(ByteBuf byteBuf, Hex data, CodecContext context) {
        if (length != -1 && data.getBytes().length != length) {
            throw new IllegalArgumentException("hex length != codec length");
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteBuf.writeBytes(CodecUtil.reverseBytesNewOne(data.getBytes()));
        } else {
            byteBuf.writeBytes(data.getBytes());
        }
    }
}
