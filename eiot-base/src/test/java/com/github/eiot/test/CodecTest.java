package com.github.eiot.test;

import io.github.eiot.charge.codec.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * @author yan
 * @since 2025-03-15
 */
public class CodecTest {

    @Test
    public void AsciiTest(){
        String str = "ABCabc1234";
        Ascii ascii = new Ascii(str);

        ByteBuf buffer = Unpooled.buffer();
        AsciiCodec asciiCodec = new AsciiCodec(str.length());
        asciiCodec.encode(buffer, ascii, CodecContext.EMPTY);
        Ascii ascii1 = asciiCodec.decode(buffer);
        System.out.println(ascii1.toCompleteString().equals(ascii.toCompleteString()));
    }

    @Test
    public void BCDTest(){
        String str = "1234567";
        int len = 8;
        BCD bcd = BCD.from(str, len);
        ByteBuf buffer = Unpooled.buffer();
        BCDCodec codec = new BCDCodec(len);
        codec.encode(buffer, bcd, CodecContext.EMPTY);
        BCD bcd1 = codec.decode(buffer);
        System.out.println(bcd1.toString().equals(bcd.toString()));
    }
}
