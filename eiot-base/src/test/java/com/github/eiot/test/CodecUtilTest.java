package com.github.eiot.test;

import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteOrder;

/**
 * created by wang007 on 2025/5/26
 */
public class CodecUtilTest {

    @Test
    public void readAndWriteNumberTest() {
        ByteBuf buffer = Unpooled.buffer();

        CodecUtil.writeNumber(buffer, 1234, ByteOrder.LITTLE_ENDIAN, 4);
        Assert.assertEquals(1234, CodecUtil.readNumber(buffer, ByteOrder.LITTLE_ENDIAN, 4));
        Assert.assertEquals(0, buffer.readableBytes());

        CodecUtil.writeNumber(buffer, 1234567, ByteOrder.BIG_ENDIAN, 4);
        Assert.assertEquals(1234567, CodecUtil.readNumber(buffer, ByteOrder.BIG_ENDIAN, 4));
        Assert.assertEquals(0, buffer.readableBytes());


        CodecUtil.writeNumber(buffer, 12345, ByteOrder.LITTLE_ENDIAN, 5);
        Assert.assertEquals(12345, CodecUtil.readNumber(buffer, ByteOrder.LITTLE_ENDIAN, 5));

        CodecUtil.writeNumber(buffer, 123456, ByteOrder.LITTLE_ENDIAN, 6);
        Assert.assertEquals(123456, CodecUtil.readNumber(buffer, ByteOrder.LITTLE_ENDIAN, 6));

        CodecUtil.writeNumber(buffer, 1234567, ByteOrder.LITTLE_ENDIAN, 7);
        Assert.assertEquals(1234567, CodecUtil.readNumber(buffer, ByteOrder.LITTLE_ENDIAN, 7));
    }

    @Test
    public void reverseBytesNewOneTest() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        byte[] newOne = CodecUtil.reverseBytesNewOne(bytes);
        Assert.assertArrayEquals(newOne, new byte[]{5, 4, 3, 2, 1});
    }

    @Test
    public void reverseBytesTest() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        CodecUtil.reverseBytes(bytes);
        Assert.assertArrayEquals(bytes, new byte[]{5, 4, 3, 2, 1});
    }

    @Test
    public void numberToBytesTest() {
        long num = 1234;
        byte[] bytes = CodecUtil.numberToBytes(num, 4, ByteOrder.LITTLE_ENDIAN);

        ByteBuf byteBuf = Unpooled.buffer().writeIntLE((int) num);
        Assert.assertEquals(byteBuf, Unpooled.wrappedBuffer(bytes));

        byte[] bytes0 = CodecUtil.numberToBytes(num, 4, ByteOrder.BIG_ENDIAN);
        ByteBuf byteBuf0 = Unpooled.buffer().writeInt((int) num);
        Assert.assertEquals(byteBuf0, Unpooled.wrappedBuffer(bytes0));
    }
}