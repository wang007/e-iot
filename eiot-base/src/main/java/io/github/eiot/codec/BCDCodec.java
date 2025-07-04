package io.github.eiot.codec;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * BCD codec
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BCDCodec extends AbstractCodec<BCD> {

    public BCDCodec(int length) {
        super(length);
    }

    public BCDCodec(int length, ByteOrder byteOrder) {
        super(length, byteOrder, null);
    }

    public BCDCodec(int length, ByteOrder byteOrder, String lengthKey) {
        super(length, byteOrder, lengthKey);
    }

    @Override
    public BCD decode(ByteBuf byteBuf, CodecContext context) {
        int len = getLengthWithContext(context);
        byte[] bcd = new byte[len * 2];
        byte[] bytes = CodecUtil.readBytes(byteBuf, len);
        for (int i = 0; i < len; i++) {
            byte b;
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                b = bytes[len - 1 - i];
            } else {
                b = bytes[i];
            }
            int high = (b >>> 4) & 0x0F;
            int low = b & 0x0F;
            bcd[i * 2] = (byte) high;
            bcd[(i * 2) + 1] = (byte) low;
        }
        return new BCD(bcd);
    }

    @Override
    public void encode(ByteBuf byteBuf, BCD data, CodecContext context) {
        byte[] value = data.getBytes();
        if ((value.length & 1) != 0) {
            throw new IllegalArgumentException("BCD encoding, value length must be a multiple of 2");
        }
        checkLength(value.length / 2);

        byte[] bcd = new byte[length];
        for (int i = 0; i < length; i++) {
            byte b;
            byte high = value[i * 2];
            byte low = value[(i * 2) + 1];
            b = (byte) ((high & 0x0F) << 4);
            b = (byte) (b | (low & 0x0F));
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                bcd[length - 1 - i] = b;
            } else {
                bcd[i] = b;
            }
        }
        byteBuf.writeBytes(bcd);
    }
}
