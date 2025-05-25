package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

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
        int len = getLengthWithContext(context);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bs = CodecUtil.readBytes(byteBuf, len);
            CodecUtil.reverseBytes(bs);
            return new Ascii(new String(bs));
        } else {
            int currentIdx = byteBuf.readerIndex();
            String value = byteBuf.toString(currentIdx, len, StandardCharsets.US_ASCII);
            byteBuf.readerIndex(currentIdx + len);
            return new Ascii(value);
        }
    }

    @Override
    public void encode(ByteBuf byteBuf, Ascii data, CodecContext context) {
        String ascii = data.toCompleteString();
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            ascii = new StringBuilder(ascii).reverse().toString();
        }
        byte[] bytes = ascii.getBytes(StandardCharsets.US_ASCII);
        if (length != -1) {
            if (bytes.length != length) {
                throw new IllegalArgumentException("ascii length != codec length");
            }
        }
        byteBuf.writeBytes(bytes);
    }
}
