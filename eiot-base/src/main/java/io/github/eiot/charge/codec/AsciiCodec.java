package io.github.eiot.charge.codec;

import io.github.eiot.charge.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * ascii codec
 *
 * @author yan
 * @since 2025-03-15
 */
public class AsciiCodec extends AbstractCodec<Ascii> {
    public AsciiCodec(int length) {
        super(length);
    }

    public AsciiCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder);
    }

    @Override
    public Ascii decode(ByteBuf byteBuf, CodecContext context) {
        byte[] bs = CodecUtil.readBytes(byteBuf, length);
        if (byteOrder == ByteOrder.BIG_ENDIAN){
            CodecUtil.reverseBytes(bs);
        }
        return new Ascii(new String(bs));
    }

    @Override
    public void encode(ByteBuf byteBuf, Ascii data, CodecContext context) {
        String ascii = data.toCompleteString();
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            ascii = new StringBuilder(ascii).reverse().toString();
        }
        byteBuf.writeBytes(ascii.getBytes());
    }
}
