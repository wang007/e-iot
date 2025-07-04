package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
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
        super(length, byteOrder, null);
    }

    public BytesCodec(int length, ByteOrder byteOrder, String lengthKey) {
        super(length, byteOrder, lengthKey);
    }

    @Override
    public byte[] decode(ByteBuf byteBuf, CodecContext context) {
        int len = getLengthWithContext(context);
        byte[] bs = CodecUtil.readBytes(byteBuf, len);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            CodecUtil.reverseBytes(bs);
        }
        return bs;
    }

    @Override
    public void encode(ByteBuf byteBuf, byte[] data, CodecContext context) {
        checkLength(data.length);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteBuf.writeBytes(CodecUtil.reverseBytesNewOne(data));
        } else {
            byteBuf.writeBytes(data);
        }
    }

}
