package com.github.eiot.test;

import io.github.eiot.codec.*;
import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.math.BigDecimal;
import java.nio.ByteOrder;
import java.time.LocalDateTime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author yan
 * @since 2025-03-15
 */
public class CodecTest {

    private static boolean hasFailed = false;

    @Rule
    public TestRule watchman = new TestWatcher() {
        @Override
        public void failed(Throwable e, Description description) {
            hasFailed = true;
        }
    };

    @AfterClass
    public static void afterAll() {
        if (!hasFailed) {
            System.out.println("All Tests Passed!");
        }
    }

    @Test
    public void AsciiTest() {
        // prepare
        String str = "ABCabc1234";
        ByteBuf buf = Unpooled.wrappedBuffer(str.getBytes());
        // decode
        AsciiCodec asciiCodec = new AsciiCodec(str.length());
        Ascii ascii = asciiCodec.decode(buf);
        assertEquals(ascii.toValidString(), str);
        // encode
        ByteBuf buf1 = Unpooled.buffer();
        asciiCodec.encode(buf1, Ascii.from(str));
        assertArrayEquals(CodecUtil.readBytes(buf1, str.length()), str.getBytes());

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(str.getBytes());
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        AsciiCodec asciiCodecBig = new AsciiCodec(str.length(), ByteOrder.BIG_ENDIAN);
        Ascii asciiBig = asciiCodecBig.decode(bufBig);
        assertEquals(asciiBig.toValidString(), str);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        asciiCodecBig.encode(bufBig1, Ascii.from(str));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, str.length()), reverseBytes);
    }

    @Test
    public void HexTest() {
        // prepare
        String hexStr = "680c0aff2ccc";
        byte[] bs = {0x68, 0x0C, 0x0A, (byte) 0xFF, 0x2C, (byte) 0xCC};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        HexCodec hexCodec = new HexCodec(bs.length);
        Hex hex = hexCodec.decode(buf);
        assertArrayEquals(hex.getBytes(), bs);
        assertEquals(hex.toHexString(), hexStr);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        hexCodec.encode(buf1, Hex.from(hexStr));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        HexCodec hexCodecBig = new HexCodec(reverseBytes.length, ByteOrder.BIG_ENDIAN);
        Hex hexBig = hexCodecBig.decode(bufBig);
        assertEquals(hexBig.toHexString(), hexStr);

        // encode
        ByteBuf bufBig1 = Unpooled.buffer();
        hexCodecBig.encode(bufBig1, Hex.from(hexStr));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void BIN4Test() {
        // prepare
        byte[] bs = {0x14, 0x13, 0x12, 0x09};
        Integer number = 152179476;
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BIN4Codec bin4Codec = new BIN4Codec(bs.length);
        Integer integer = bin4Codec.decode(buf);
        assertEquals(integer, number);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        bin4Codec.encode(buf1, number);
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        BIN4Codec bin4CodecBig = new BIN4Codec(bs.length, ByteOrder.BIG_ENDIAN);
        Integer integerBig = bin4CodecBig.decode(bufBig);
        assertEquals(integerBig, number);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        bin4CodecBig.encode(bufBig1, number);
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void BIN8Test() {
        // prepare
        byte[] bs = {0x14, 0x13, 0x12, 0x09, 0x11, 0x13, 0x09, 0x06};
        Long number = 434899802905514772L;
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BIN8Codec bin8Codec = new BIN8Codec(bs.length);
        Long aLong = bin8Codec.decode(buf);
        assertEquals(aLong, number);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        bin8Codec.encode(buf1, number);
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        BIN8Codec bin8CodecBig = new BIN8Codec(bs.length, ByteOrder.BIG_ENDIAN);
        Long aLongBig = bin8CodecBig.decode(bufBig);
        assertEquals(aLongBig, number);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        bin8CodecBig.encode(bufBig1, number);
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void BCDTest() {
        // prepare
        String bcdStr = "1213140591";
        byte[] bs = {0x12, 0x13, 0x14, 0x05, (byte) 0x91};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BCDCodec bcdCodec = new BCDCodec(bs.length);
        BCD bcd = bcdCodec.decode(buf);
        assertEquals(bcd.toString(), bcdStr);

        //encode
        ByteBuf buf1 = Unpooled.buffer();
        bcdCodec.encode(buf1, BCD.from(bcdStr));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        BCDCodec bcdCodecBig = new BCDCodec(reverseBytes.length, ByteOrder.BIG_ENDIAN);
        BCD bcdBig = bcdCodecBig.decode(bufBig);
        assertEquals(bcdBig.toString(), bcdStr);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        bcdCodecBig.encode(bufBig1, BCD.from(bcdStr));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void BCDNumberTest() {
        // prepare
        BigDecimal number = BigDecimal.valueOf(21235.14);
        byte[] bs = {0x02, 0x12, 0x35, 0x14};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BCDNumberCodec codec = new BCDNumberCodec(bs.length, 100);
        BCDNumber bcdNumber = codec.decode(buf);
        assertEquals(bcdNumber.bigDecimalValue(), number);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        codec.encode(buf1, BCDNumber.from(number.doubleValue(), 100, 8));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        BCDNumberCodec codecBig = new BCDNumberCodec(bs.length, ByteOrder.BIG_ENDIAN, 100);
        BCDNumber bcdNumberBig = codecBig.decode(bufBig);
        assertEquals(bcdNumberBig.bigDecimalValue(), number);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        codecBig.encode(bufBig1, BCDNumber.from(number.doubleValue(), 100, 8));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void BCDNumberOffsetTest() {
        // prepare
        int offset = -200;
        BigDecimal number = BigDecimal.valueOf(21235.14);
        number = number.subtract(BigDecimal.valueOf(200));
        byte[] bs = {0x02, 0x12, 0x35, 0x14};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BCDNumberCodec bcdNumberCodec = new BCDNumberCodec(bs.length, 100, offset);
        BCDNumber numberUnit = bcdNumberCodec.decode(buf);
        assertEquals(numberUnit.bigDecimalValue(), number);

        // encode
        ByteBuf bufOffset = Unpooled.buffer();
        bcdNumberCodec.encode(bufOffset, BCDNumber.from(number.doubleValue(), 100, offset, false, 8));
        assertArrayEquals(CodecUtil.readBytes(bufOffset, bs.length), bs);

        // reverse
        offset = 22000;
        number = BigDecimal.valueOf(21235.14);
        number = BigDecimal.valueOf(offset).subtract(number);
        buf = Unpooled.wrappedBuffer(bs);
        BCDNumberCodec codecOffset1 = new BCDNumberCodec(bs.length, 100, offset, true);
        BCDNumber numberUnit1 = codecOffset1.decode(buf);
        assertEquals(numberUnit1.bigDecimalValue(), number);

        ByteBuf bufOffset1 = Unpooled.buffer();
        codecOffset1.encode(bufOffset1, BCDNumber.from(number.doubleValue(), 100, offset, true, 8));
        assertArrayEquals(CodecUtil.readBytes(bufOffset1, bs.length), bs);
    }

    @Test
    public void BCDTimeTest() {
        // prepare
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 12, 12, 25, 8);
        byte[] bs = {0x25, 0x03, 0x12, 0x12, 0x25, 0x08};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        BCDTimeCodec codec = new BCDTimeCodec();
        BCDTime bcdTime = codec.decode(buf);
        assertEquals(bcdTime.toLocalDateTime(), dateTime);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        codec.encode(buf1, BCDTime.from(dateTime));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        BCDTimeCodec codecBig = new BCDTimeCodec(ByteOrder.BIG_ENDIAN);
        BCDTime bcdTimeBig = codecBig.decode(bufBig);
        assertEquals(bcdTimeBig.toLocalDateTime(), dateTime);

        // BIG_ENDIAN encode
        ByteBuf bufBig1 = Unpooled.buffer();
        codecBig.encode(bufBig1, BCDTime.from(dateTime));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void CP56time2aTest() {
        // prepare
        LocalDateTime dateTime = LocalDateTime.of(2020, 3, 16, 17, 14, 47);
        byte[] bs = {(byte) 0x98, (byte) 0xB7, 0x0E, 0x11, 0x10, 0x03, 0x14};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        CP56time2aCodec codec = new CP56time2aCodec();
        CP56time2a cp56time2a = codec.decode(buf);
        assertEquals(cp56time2a.toLocalDateTime(), dateTime);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        codec.encode(buf1, CP56time2a.from(dateTime));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        CP56time2aCodec codecBig = new CP56time2aCodec(ByteOrder.BIG_ENDIAN);
        CP56time2a cp56time2aBig = codecBig.decode(bufBig);
        assertEquals(cp56time2aBig.toLocalDateTime(), dateTime);

        // encode
        ByteBuf bufBig1 = Unpooled.buffer();
        codecBig.encode(bufBig1, CP56time2a.from(dateTime));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void NumberUnitTest() {
        // prepare
        BigDecimal number = BigDecimal.valueOf(1235.14);
        byte[] bs = {0x7a, (byte) 0xe2, 0x01};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        NumberUnitCodec codec = new NumberUnitCodec(bs.length, 100);
        NumberUnit numberUnit = codec.decode(buf);
        assertEquals(numberUnit.bigDecimalValue(), number);

        // encode
        ByteBuf buf1 = Unpooled.buffer();
        codec.encode(buf1, NumberUnit.from(number.doubleValue(), 100));
        assertArrayEquals(CodecUtil.readBytes(buf1, bs.length), bs);

        // BIG_ENDIAN decode
        byte[] reverseBytes = CodecUtil.reverseBytesNewOne(bs);
        ByteBuf bufBig = Unpooled.wrappedBuffer(reverseBytes);

        NumberUnitCodec codecBig = new NumberUnitCodec(bs.length, ByteOrder.BIG_ENDIAN, 100);
        NumberUnit numberUnitBig = codecBig.decode(bufBig);
        assertEquals(numberUnitBig.bigDecimalValue(), number);

        // encode
        ByteBuf bufBig1 = Unpooled.buffer();
        codecBig.encode(bufBig1, NumberUnit.from(number.doubleValue(), 100));
        assertArrayEquals(CodecUtil.readBytes(bufBig1, bs.length), reverseBytes);
    }

    @Test
    public void NumberUnitOffsetTest() {
        // prepare
        int offset = -200;
        BigDecimal number = BigDecimal.valueOf(1235.14);
        number = number.subtract(BigDecimal.valueOf(200));
        byte[] bs = {0x7a, (byte) 0xe2, 0x01};
        ByteBuf buf = Unpooled.wrappedBuffer(bs);

        // decode
        NumberUnitCodec codecOffset = new NumberUnitCodec(bs.length, 100, offset);
        NumberUnit numberUnit = codecOffset.decode(buf);
        assertEquals(numberUnit.bigDecimalValue(), number);

        // encode
        ByteBuf bufOffset = Unpooled.buffer();
        codecOffset.encode(bufOffset, NumberUnit.from(number.doubleValue(), 100, offset, false));
        assertArrayEquals(CodecUtil.readBytes(bufOffset, bs.length), bs);

        // reverse
        offset = 1500;
        number = BigDecimal.valueOf(1235.14);
        number = BigDecimal.valueOf(offset).subtract(number);
        buf = Unpooled.wrappedBuffer(bs);
        NumberUnitCodec codecOffset1 = new NumberUnitCodec(bs.length, 100, offset, true);
        NumberUnit numberUnit1 = codecOffset1.decode(buf);
        assertEquals(numberUnit1.bigDecimalValue(), number);

        ByteBuf bufOffset1 = Unpooled.buffer();
        codecOffset1.encode(bufOffset1, NumberUnit.from(number.doubleValue(), 100, offset, true));
        assertArrayEquals(CodecUtil.readBytes(bufOffset1, bs.length), bs);
    }

}
