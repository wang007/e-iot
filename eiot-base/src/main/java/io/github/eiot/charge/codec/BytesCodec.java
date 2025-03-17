package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * byte codec
 * created by wang007 on 2025/2/26
 */
public class BytesCodec extends AbstractCodec<byte[]> {

    public BytesCodec(int length) {
        super(length);
    }

    public BytesCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public byte[] decode(ByteBuf byteBuf, CodecContext context) {
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            CodecUtil.reverseBytes(bs);
        }
        return bs;
    }

    @Override
    public void encode(ByteBuf byteBuf, byte[] data, CodecContext context) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteBuf.writeBytes(CodecUtil.reverseBytesNewOne(data));
        } else {
            byteBuf.writeBytes(data);
        }
    }

}
