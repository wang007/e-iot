package io.github.eiot.test.frame;


import io.github.eiot.test.example.*;
import io.github.eiot.test.example.data.AllFieldTypeTest;
import io.github.eiot.test.example.data.ExampleHeartbeatRequest;
import io.github.eiot.test.example.data.ExampleLoginRequest;
import io.github.eiot.CommandDef;
import io.github.eiot.IotConnection;
import io.github.eiot.annotation.FrameUtil;
import io.github.eiot.codec.*;
import io.github.eiot.exception.IotException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * created by wang007 on 2025/5/25
 */
public class FrameUtilTest {


    public static <T> ExampleFrame<T> newFrame(CommandDef<T> command) {
        FakeIotConnection connection = new FakeIotConnection("example");
        connection.put(IotConnection.TERMINAL_NO_KEY, "123456789012");
        return new DefaultExampleFrame<T>(connection, command);
    }

    @Test
    public void newInstanceTest() {
        ExampleLoginRequest request = FrameUtil.newInstance(ExampleLoginRequest.class);
        Assert.assertNotNull(request);

        ExampleHeartbeatRequest heartbeatRequest = FrameUtil.newInstance(ExampleHeartbeatRequest.class);
        Assert.assertNotNull(heartbeatRequest);

        Assert.assertThrows(IotException.class, () -> FrameUtil.newInstance(this.getClass()));
    }


    @Test
    @SuppressWarnings("unchecked")
    public void encodeAndDeCodeTest() {
        ExampleFrame<AllFieldTypeTest> frame = newFrame(ExampleCommand.Test);
        BCDTime bcdTime = BCDTime.now();
        LocalDateTime now = bcdTime.toLocalDateTime();

        AllFieldTypeTest request = frame.newData();

        request.setAsciiTest("abcd1234");
        request.setBcdTest("123456");
        request.setBin4Test(1234);
        request.setBin8Test(12345678);
        byte[] bytes = new byte[]{9, 8, 7, 6, 5, 4, 3};
        request.setBytesLen(bytes.length);
        request.setBytesTest(bytes);
        request.setBcdTimeTest(bcdTime);
        request.setHexTest("1616");

        request.setBcdNumberTest(1234);
        request.setOffsetBCDNumberTest(1234567);
        request.setNumberUnitTest(12345678);
        request.setOffsetNumberUnitTest(123456789);

        // count
        request.setCount(3);
        request.setNumList(Arrays.asList(1, 2, 3));
        request.setStringList(Arrays.asList(Ascii.from("1", 10), Ascii.from("2", 10), Ascii.from("3", 10)));

        request.setReversed(ByteBufRef.from(Unpooled.wrappedBuffer(new byte[]{1, 2, 3, 4})));

        ByteBuf byteBuf = frame.data(request).toByteBuf();

        RawExampleFrame rawFrame = RawExampleFrame.new4Receiver(frame.iotConnection(), byteBuf);
        ExampleFrame<AllFieldTypeTest>  receiverFrame = (ExampleFrame<AllFieldTypeTest>) ExampleFrameConverter.INSTANCE.apply(rawFrame);
        Assert.assertEquals(receiverFrame.header().toHexString(), "aaf5");
        Assert.assertEquals(receiverFrame.sequenceNo(), 0);

        AllFieldTypeTest data = receiverFrame.data();


        Assert.assertEquals(data.getAsciiTest().toValidString(), "abcd1234");
        Assert.assertEquals(data.getBcdTest().to0StripString(), "123456");
        Assert.assertEquals(data.getBin4Test(), 1234);
        Assert.assertEquals(data.getBin8Test(), 12345678);
        Assert.assertEquals(data.getBytesLen(), bytes.length);
        Assert.assertArrayEquals(data.getBytesTest(), bytes);
        Assert.assertEquals(data.getBcdTimeTest().toLocalDateTime(), now);
        Assert.assertEquals(data.getHexTest().toHexString(),  "1616");

        // bcdNumber
        BCDNumber bcdNumberTest = request.getBcdNumberTest();
        Assert.assertEquals(bcdNumberTest.intValue(), 1234);
        Assert.assertEquals(bcdNumberTest.originNumber(), 123400);

        // offset bcdNumber
        OffsetBCDNumber offsetBCDNumberTest = request.getOffsetBCDNumberTest();
        Assert.assertEquals(offsetBCDNumberTest.intValue(), 1234567);

        // numberUnit
        NumberUnit numberUnitTest = request.getNumberUnitTest();
        Assert.assertEquals(numberUnitTest.intValue(), 12345678);

        // offset numberUnit
        OffsetNumberUnit offsetNumberUnitTest = request.getOffsetNumberUnitTest();
        Assert.assertEquals(offsetNumberUnitTest.intValue(), 123456789);

        Assert.assertEquals(request.getCount(), 3);
        Assert.assertArrayEquals(request.getNumList().toArray(new Integer[0]), new Integer[]{1, 2, 3});
        Assert.assertArrayEquals(request.getStringList().stream().map(Ascii::toValidString).toArray(), new String[]{"1", "2", "3"});
        Assert.assertEquals(request.getReversed().byteBuf().readableBytes(), 4);
    }




}
