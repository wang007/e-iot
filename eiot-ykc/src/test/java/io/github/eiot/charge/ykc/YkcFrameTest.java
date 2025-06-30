package io.github.eiot.charge.ykc;

import io.github.eiot.IotConnection;
import io.github.eiot.charge.ykc.data.YkcBillingModelRequest;
import io.github.eiot.charge.ykc.data.YkcBillingModelResponse;
import io.github.eiot.charge.ykc.data.YkcLoginRequest;
import io.github.eiot.charge.ykc.data.YkcLoginResponse;
import io.github.eiot.codec.Hex;
import io.github.eiot.utils.CodecUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

/**
 * created by wang007 on 2025/6/28
 */
public class YkcFrameTest {

    private static final String terminalNo = "12345678901234";

    public static RawYkcFrame convertRaw(String hexFrame) {
        try {
            hexFrame = hexFrame.replaceAll("\\([^)]*\\)|（[^）]*）", "").replace("\n", "");
            hexFrame = hexFrame.replaceAll("-", "").replaceAll(" ", "");
            Hex hex = Hex.from(hexFrame);

            RawYkcFrame ykcFrame = RawYkcFrame.new4Receiver(newIotConnection(), Unpooled.wrappedBuffer(hex.getBytes()));
        /*if (!ykcFrame.checkCodeResult()) {
            throw new IllegalStateException("ykc frame checkCodeResult error");
        }*/
            return ykcFrame;
        } catch (Throwable e) {
            throw e;
        }
    }

    public static IotConnection newIotConnection() {
        FakeIotConnection connection = new FakeIotConnection();
        connection.put(IotConnection.TERMINAL_NO_KEY, terminalNo);
        return connection;
    }

    public static void setCheckCode(YkcFrame<?> frame) {
        RawYkcFrame rawYkcFrame;
        if (frame instanceof RawYkcFrame) {
            rawYkcFrame = (RawYkcFrame) frame;
        } else {
            DefaultYkcFrame<?> defaultYkcFrame = (DefaultYkcFrame<?>) frame;
            rawYkcFrame = defaultYkcFrame.rawFrame();
        }
        int checkCode = rawYkcFrame.calcCheckCode();
        rawYkcFrame.checkCode(checkCode);
    }

    @SuppressWarnings("unchecked")
    public static <T> YkcFrame<T> convertFrame(String hexFrame) {
        RawYkcFrame rawYkcFrame = convertRaw(hexFrame);
        return (YkcFrame<T>) YkcFramerConverter.INSTANCE.apply(rawYkcFrame);
    }

    @SuppressWarnings("unchecked")
    public static <T> YkcFrame<T> convertFrame(ByteBuf byteBuf) {
        RawYkcFrame rawYkcFrame = RawYkcFrame.new4Receiver(newIotConnection(), byteBuf);
        return (YkcFrame<T>) YkcFramerConverter.INSTANCE.apply(rawYkcFrame);
    }


    @Test
    public void testRawFrame() throws Exception {
        String str = "68（起始标志）22（数据长度）0000（序列号域）00（加密标志）01（类型）55031412782305\n" +
                "（桩编码）00（桩类型）02（充电枪数量）0F（通信协议版本：V1.5）56342E312E353000（程\n" +
                "序版本：v4.1.50）01（网络链接类型）01010101010101010101（sim 卡）04（运营商）675A\n" +
                "（帧校验域）";
        RawYkcFrame ykcFrame = convertRaw(str);
        Assert.assertEquals(ykcFrame.start().toString(), "68");
        Assert.assertEquals(ykcFrame.rawDataSize(), 34);
        Assert.assertEquals(ykcFrame.sequenceNo(), 0);
        Assert.assertEquals(ykcFrame.command(), "01");

        int code = ykcFrame.checkCode();
        byte[] bytes = CodecUtil.numberToBytes(code, 2, ByteOrder.LITTLE_ENDIAN);
        Assert.assertArrayEquals(Hex.from("675A").getBytes(), bytes);
    }


    @Test
    public void testLoginFrame() throws Exception {
        String str = "68（起始标志）22（数据长度）0000（序列号域）00（加密标志）01（类型）55031412782305\n" +
                "（桩编码）00（桩类型）02（充电枪数量）0F（通信协议版本：V1.5）56342E312E353000（程\n" +
                "序版本：v4.1.50）01（网络链接类型）01010101010101010101（sim 卡）04（运营商）675A\n" +
                "（帧校验域）";
        YkcFrame<YkcLoginRequest> loginFrame = convertFrame(str);
        YkcLoginRequest data = loginFrame.data();
        Assert.assertEquals("55031412782305", data.getTerminalNo().to0StripString());
        Assert.assertEquals(data.getPileType(), 0);
        Assert.assertEquals(data.getGunCount(), 2);
        Assert.assertEquals(data.getCommunicationVersion(), 15);
        Assert.assertEquals(data.getSoftwareVersion().toValidString(), "V4.1.50");
        Assert.assertEquals(data.getNetworkType(), 1);
        Assert.assertEquals(data.getSim().toString(), "01010101010101010101");
        Assert.assertEquals(data.getOperator(), 4);


        String str2 = "680C（数据长度）0000（序列号域）00（加密标志）02（类型）55 03 14 12 78 23" +
                "05（桩编码）00（登陆结果：成功）DA 4C（帧校验域）";
        YkcFrame<YkcLoginResponse> loginResponseFrame = convertFrame(str2);
        YkcLoginResponse response = loginResponseFrame.data();
        Assert.assertEquals(response.getResult(), 0);
    }


    @Test
    public void testBillingModelFrame() {
        YkcBillingModelRequest request = new YkcBillingModelRequest();
        request.setTerminalNo(terminalNo);
        request.setModelNo("10");
        request.setTopElectricPrice(1.11);
        request.setTopServicePrice(1.11);
        request.setPeakElectricPrice(2.22);
        request.setPeakServicePrice(2.22);
        request.setFlatElectricPrice(3.33);
        request.setFlatServicePrice(3.33);
        request.setLowElectricPrice(4.44);
        request.setLowServicePrice(4.44);
        byte[] rateTimes = new byte[48];
        for (int i = 0; i < 48; i++) {
            rateTimes[i] = (byte) (i % 4);
        }
        request.setRateTimes(rateTimes);

        YkcFrame<YkcBillingModelRequest> requestYkcFrame = YkcFrame.create(newIotConnection(), YkcCommand.BillingModelRequest);
        requestYkcFrame.data(request);
        setCheckCode(requestYkcFrame);

        ByteBuf byteBuf = requestYkcFrame.toByteBuf();
        requestYkcFrame = convertFrame(byteBuf);

        Assert.assertTrue(requestYkcFrame.checkCodeResult());
        Assert.assertEquals(requestYkcFrame.command(), YkcCommand.BillingModelRequest.command());
        Assert.assertEquals(requestYkcFrame.sequenceNo(), 0);
        YkcBillingModelRequest data = requestYkcFrame.data();
        Assert.assertEquals(data.getModelNo().to0StripString(), "10");
        Assert.assertEquals(data.getTopElectricPrice().doubleValue(), 1.11, 0.001d);
        Assert.assertEquals(data.getTopServicePrice().doubleValue(), 1.11, 0.001d);
        Assert.assertEquals(data.getPeakElectricPrice().doubleValue(), 2.22, 0.001d);
        Assert.assertEquals(data.getPeakServicePrice().doubleValue(), 2.22, 0.001d);

        Assert.assertEquals(data.getFlatElectricPrice().doubleValue(), 3.33, 0.001d);
        Assert.assertEquals(data.getFlatServicePrice().doubleValue(), 3.33, 0.001d);
        Assert.assertEquals(data.getLowElectricPrice().doubleValue(), 4.44, 0.001d);
        Assert.assertEquals(data.getLowServicePrice().doubleValue(), 4.44, 0.001d);

        byte[] times = data.getRateTimes();
        for (int i = 0; i < 48; i++) {
            Assert.assertEquals(times[i], rateTimes[i]);
        }


        YkcFrame<YkcBillingModelResponse> responseFrame = requestYkcFrame.asRequest(YkcCommand.BillingModelResponse.dataType()).responseFrame();
        YkcBillingModelResponse response = responseFrame.newData();
        response.setResult(1);
        responseFrame.data(response);
        byteBuf = responseFrame.toByteBuf();

        responseFrame = convertFrame(byteBuf);
        response = responseFrame.data();
        Assert.assertEquals(response.getResult(), 1);
    }



    //@Test
    public void testFrame() {
        List<String> stringFrames = Arrays.asList("68（起始标志）0D（数据长度）0001（序列号域）00（加密标志）03（类型）32010200000001（桩\n" +
                        "编码）01（枪号：1 号枪）00（枪状态：正常）6890（帧校验域）",
                "68（起始标志）0D（数据长度）3600（序列号域）00（加密标志）04（类型）55031412782305（桩\n" +
                        "编码）01(枪号) 00（心跳应答）65B2（帧校验域）",
                "68（起始标志）0D（数据长度）0002（序列号域）00（加密标志）05（类型）32010200000001（桩\n" +
                        "编码）0001（计费模型编码）9C00（帧校验域）",
                "68(起始标志) 0E(数据长度) CE 04(序列号域) 00( 加密标志) 06(帧类型标志) 55 03 14 12 \n" +
                        "78 23 05（桩编码） 00 00（计费模型编号） 00（验证结果） 8E 2F（帧校验域）",
                "68（起始标志）0B（数据长度）0200（序列号域）00（加密标志）09（类型）55031412782305（桩\n" +
                        "编码）DD25（帧校验域）",
                "68(起始标志) 5E(数据长度) 02 00(序列号域) 00( 加密标志) 0A(帧类型标志) 55 03 14 12 \n" +
                        "78 23 05（桩编码） 01 00（计费模型编号） 40 0D 03 00（尖电费费率）9C 40 00 00（尖服\n" +
                        "务费费率） E0 93 04 00（峰电费费率）9C 40 00 00（峰服务费费率）80 1A 06 00（平电费\n" +
                        "费率）9C 40 00 00（平服务费费率）20 A1 07 00（谷电费费率）9C 40 00 00（谷服务费费率）\n" +
                        "00（计损比例） 00（时段费率号 48 个）00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                        "00 00 00 5E 60（帧校验域）",
                "68（起始标志）0C（数据长度）0000（序列号域）00（加密标志）12（类型）32010200000001（桩\n" +
                        "编码）01（枪号：1 枪）0069（帧校验域）",
                "68 （起始标志） 40 （数据长度） 1A03 （序列号域） 00 （加密标志） 13 （类型）\n" +
                        "00000000000000000000000000000000（交易流水号）55031412782305（桩编码）02（枪号：1 号\n" +
                        "枪）00（状态：离线）01（是否归位：已归位）01（是否插枪：是）0200（输出电压：0）0000\n" +
                        "（输出电流：0）00（枪线温度：10）0000000000000000（枪线编码）00（soc：0）00（电池组\n" +
                        "最高温度：0）00 00（累计充电时间：0）00 00（剩余时间：0）00 00 00 00（充电度数：0）\n" +
                        "00 00 00 00（计损充电度数：0）00 00 00 00（已充金额：0）0000（硬件故障：无）9DAC（帧\n" +
                        "校验域）",
                "68 （起始标志） 4D （数据长度） 0015 （序列号域） 00 （加密标志） 15 （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）\n" +
                        "000000(BMS 通信协议版本号)00( BMS 电池类型) 0000 (BMS 整车动力蓄电池系统额定容量)" +
                        "0000(BMS 整车动力蓄电池系统额定总电压) 00000000(BMS 电池生产厂商名称) 00000000(BMS\n" +
                        "电池组序号) 00(BMS 电池组生产日期年)00(BMS 电池组生产日期月)00(BMS 电池组生产日期\n" +
                        "日 )000000(BMS 电 池 组 充 电 次 数 )00(BMS 电 池 组 产 权 标 识 )00( 预留位 ) \n" +
                        "0000000000000000000000000000000000 (BMS 车辆识别码) 0000000000000000(BMS 软件版本号) \n" +
                        "FED2（帧校验域）",
                "68（起始标志）31（数据长度）0016（序列号域）00（加密标志）17（类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）\n" +
                        "0000(BMS 单体动力蓄电池最高允许充电电压)0000(BMS 最高允许充电电流) 0000 (BMS 动力蓄\n" +
                        "电池标称总能量) 0000(BMS 最高允许充电总电压) 00(BMS 最高允许温度) 0000(BMS 整车动力\n" +
                        "蓄电池荷电状态soc) 0000(BMS 整车动力蓄电池当前电池电压)0000(电桩最高输出电压)0000(电桩最低输出电压) 0000(电桩最大输出电流)0000(电桩最小输出电流) D18A（帧校验域）",
                "68 （起始标志） 2B （数据长度） 0016 （序列号域） 00 （加密标志） 19 （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）00(BMS\n" +
                        "中止荷电状态 SOC)0000(BMS 动力蓄电池单体最低电压) 0000 (BMS 动力蓄电池单体最高电压) \n" +
                        "00(BMS 动力蓄电池最低温度) 00(BMS 动力蓄电池最高温度) 0000(电桩累计充电时间) 0000(电\n" +
                        "桩输出能量)00000000(电桩充电机编号) AE36（帧校验域）",
                "68 （起始标志） 24 （数据长度） 0017 （序列号域） 00 （加密标志） 1B （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）00(序 号 4-6) 00 (序号 7-9) 00 (序号 10-12) 00(13-14) 00(15-16) 00(17-19) 00(20-23)00 (24-\n" +
                        "25) A2F3（帧校验域）",
                "68 （起始标志） 20 （数据长度） 0018 （序列号域） 00 （加密标志） 1D （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）00(BMS \n" +
                        "中止充电原因) 0000 (BMS 中止充电故障原因) 00 (BMS 中止充电错误原因) 8445（帧校验域）",
                "68 （起始标志） 20 （数据长度） 0018 （序列号域） 00 （加密标志） 21 （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）00(BMS \n" +
                        "中止充电原因) 0000 (BMS 中止充电故障原因) 00 (BMS 中止充电错误原因) 8445（帧校验域）",
                "68 （起始标志） 30 （数据长度） 0019 （序列号域） 00 （加密标志） 23 （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）0000(BMS\n" +
                        "电压需求) 0000 (BMS 电流需求) 00 (BMS 充电模式) 0000（BMS 充电电压测量值）0000（BMS\n" +
                        "充电电流测量值）0000 （BMS 最高单体动力蓄电池电压及组号）00（BMS 当前荷电状态 SOC % ）\n" +
                        "0000（BMS 估算剩余充电时间）0000（电桩电压输出值）0000（电桩电流输出值）0000（累计充\n" +
                        "电时间）1D57（帧校验域）",
                "68 （起始标志） 23 （数据长度） 0021 （序列号域） 00 （加密标志） 25 （类型）\n" +
                        "3201020000000011151116155535026（交易流水号）32010200000001（桩编码）01（枪号）00(BMS\n" +
                        "最高单体动力蓄电池电压所在编号) 00 (BMS 最高动力蓄电池温度) 00 (最高温度检测点编号) \n" +
                        "00（最低动力蓄电池温度）00（最低动力蓄电池温度检测点编号）00（9-12）00（13-16）72B9\n" +
                        "（帧校验域）",
                "68（起始标志）37（数据长度）0004（序列号域）00（加密标志）31（类型）32010200000001\n" +
                        "（桩编码）01（枪号：1 枪）01（启动方式：刷卡启动）00（是否需要密码：不需要）\n" +
                        "00000000D14B0A54（物理卡号：D14B0A54）00000000000000000000000000000000（输入密码）\n" +
                        "0000000000000000000000000000000000（VIN 码）F496",
                "68（起始标志）2A（数据长度）00 04（系列号域）00（加密标志）32（标志）32 01 02 00 00 \n" +
                        "00 01 01 20 18 06 12 19 59 57 85（交易流水号） 32 01 02 00 00 00 01（桩编码） 01（枪\n" +
                        "号：1 枪） 00 00 00 00 00 00 00 00（逻辑卡号） 00 00 00 00（账户余额） 00（鉴权成功\n" +
                        "标志） 01（失败原因）E8 29（帧校验域）",
                "68 （起始标志） 30 （数据长度） 007C （序列号域） 00 （加密标志） 34 （类型）\n" +
                        "55031412782305012018061914444680（交易流水号）55031412782305（桩编码）01（枪号：1\n" +
                        "枪）0000001000000573（逻辑卡号：1000000573）00000000D14B0A54（物理卡号：D14B0A54）\n" +
                        "A0860100（账户余额：1000.00）4622",
                "68（起始标志）1E（数据长度）0002（序列号域）00（加密标志）33（类型）\n" +
                        "32010200000000111511161555350260（交易流水号）32010200000001（桩编码）01（枪号：1\n" +
                        "枪）01（启动结果：成功）00（失败原因：无）0FE2（帧校验域）",
                "68（起始标志）0C（数据长度）0003（序列号域）00（加密标志）36（类型）32010200000001\n" +
                        "（桩编码）01（枪号：1 枪）C1A9（帧校验域）",
                "68（起始标志）0E（数据长度）0003（序列号域）00（加密标志）35（类型）32010200000001\n" +
                        "（桩编码）01（枪号：1 枪）01（停止结果：成功）00（失败原因：00）907E（帧校验域）",
                "68 （起始标志） A2 （数据长度） 8001 （序列号域） 00 （加密标志） 3B （类型）\n" +
                        "55031412782305012018061910262392（交易流水号）55031412782305（桩编码）01（枪号：1\n" +
                        "枪）98B70E11100314（开始时间：2020-03-16 17:14:47）98B70E11100314（结束时间：2020-03-16 \n" +
                        "17:14:47）D0FB0100（尖单价:1.30000）00000000（尖电量：0）00000000（计损尖电量：0）\n" +
                        "00000000（尖金额：0）D0FB0100（峰单价: 1.30000）00000000（峰电量：0）00000000（计损\n" +
                        "峰电量：0）00000000（峰金额：0）D0FB0100（平单价: 1.30000）00000000（平电量：0）00000000\n" +
                        "（计损平电量：0）00000000（平金额：0）D0FB0100（谷单价: 1.30000）00000000（谷电量：\n" +
                        "0）00000000（计损谷电量：0）00000000（谷金额：0）0000000000（电表总起值：0）0000000000\n" +
                        "（电表总止值：0）00000000（总电量：0）00000000（计损总电量：0）00000000（消费金额：\n" +
                        "0）0000000000000000000000000000000000（VIN 码）02（交易标识：app 启动）98B70E11100314\n" +
                        "（交易时间：2020-03-16 17:14:47）00（停止原因：无）00000000D14B0A54（物理卡号：D14B0A54）\n" +
                        "388C（帧校验域）",
                "68（起始标志）15（数据长度）0002（序列号域）00（加密标志）40（类型）\n" +
                        "55031412782305012018061910262392（交易流水号）00（确认结果）48B1（帧校验域）",
                "68（起始标志）18（数据长度）0006（序列号域）00（加密标志）42（类型）32010200000001\n" +
                        "（桩编码）01（枪号）00000000D14B0A54（物理卡号：D14B0A54）\n" +
                        "00000000（修改后账户金额：0）72EA（帧校验域）",
                "68（起始标志）13（数据长度）0006（序列号域）00（加密标志）41（类型）32010200000001\n" +
                        "（桩编码）00000000D14B0A54（物理卡号：D14B0A54）0x01 (修改结果) 4AC4（帧校验域）",
                "68（起始标志）2C（数据长度）0007（序列号域）00（加密标志）44（类型）32010200000001\n" +
                        "（桩编码）0x01(下发卡个数) 0000000010000001（逻辑卡号）00000000D14B0A54（物理卡号：\n" +
                        "D14B0A54）F264（帧校验域）",
                "68（起始标志）2C（数据长度）0007（序列号域）00（加密标志）46（类型）32010200000001\n" +
                        "（桩编码）0x01(清除离线卡的个数) 00000000D14B0A54（物理卡号：D14B0A54）F264（帧校验\n" +
                        "域）",
                "68（起始标志）0D（数据长度）0007（序列号域）00（加密标志）45（类型）32010200000001\n" +
                        "（桩编码）00000000D14B0A54（物理卡号：D14B0A54）00（失败原因）00000000E14C0A54（物\n" +
                        "理卡号：540A4CE1）00（失败原因）6890（帧校验域）",
                "68（起始标志）2C（数据长度）0007（序列号域）00（加密标志）48（类型）32010200000001\n" +
                        "29\n" +
                        "（桩编码）0x01(查询的离线卡个数) 00000000D14B0A54（物理卡号：D14B0A54）F264（帧校验域）",
                "68（起始标志）0D（数据长度）0007（序列号域）00（加密标志）47（类型）32010200000001（桩\n" +
                        "编码）00000000D14B0A54（物理卡号：D14B0A54）01(查询结果) 00000000E14C0A54（物理卡号：\n" +
                        "540A4CE1）00（查询结果）6890（帧校验域）",
                "68（起始标志）0D（数据长度）0008（序列号域）00（加密标志）52（类型）32010200000001\n" +
                        "（桩编码）0x01(是否允许工作) 0x00（充电桩最大允许输出功率）6890（帧校验域）",
                "68（起始标志）0C（数据长度）0008（序列号域）00（加密标志）51（类型）32010200000001\n" +
                        "（桩编码）0x01(设置结果) C1A9（帧校验域）",
                "68（起始标志）12（数据长度）00DF（序列号域）00（加密标志）56（类型）55031412782305\n" +
                        "（桩编码）98B70E11100314（当前时间：2020-03-16 17:14:47）8A13（帧校验域）",
                "68（起始标志）12（数据长度）A101（序列号域）00（加密标志）55（类型）55031412782305\n" +
                        "（桩编码）98B70E11100314（当前时间：2020-03-16 17:14:47）0E9B（帧校验域）",
                "68（起始标志）5E（数据长度）0025（序列号域）00（加密标志）58（类型）55031412782305\n" +
                        "（桩编码）0100(计费模型编码）40 0D 03 00（尖电费费率,2 元/度）9C 40 00 00（尖服务费\n" +
                        "费率,0.4 元/度） E0 93 04 00（峰电费费率,2 元/度）9C 40 00 00（峰服务费费率,0.4 元/\n" +
                        "度）80 1A 06 00（平电费费率,4 元/度）9C 40 00 00（平服务费费率,0.4 元/度）20 A1 07 00\n" +
                        "（谷电费费率,5 元/度）9C 40 00 00（谷服务费费率,0.4 元/度）00(计损比例) 00(0：00～0：\n" +
                        "30 时段费率号) 00(0：30～1：00 时段费率\n" +
                        "号)0000000000000000000000000000000000000000000000000000000000000000000000000000000\n" +
                        "00000000000005E60",
                "68（起始标志）0C（数据长度）0009（序列号域）00（加密标志）57（类型）32010200000001\n" +
                        "（桩编码）01（设置结果）C1A9（桢校验域）",
                "68（起始标志）14（数据长度）0001（序列号域）00（加密标志）61（类型）32010200000001\n" +
                        "（桩编码）0x01（枪号：1 号枪）00（车位状态：无车辆）00（地锁电量状态：0）00（报警状\n" +
                        "态）00000000（预留位）6890（帧校验域）",
                "68（起始标志）0D（数据长度）0001（序列号域）00（加密标志）62（类型）32010200000001\n" +
                        "（桩编码）0x01（枪号：1 号枪）55（升/降地锁）00000000（预留位）6890（帧校验域）",
                "68（起始标志）0D（数据长度）0001（序列号域）00（加密标志）63（类型）32010200000001\n" +
                        "（桩编码）0x01（枪号：1 号枪）00（地锁控制返回标志）00000000（预留位）6890（帧校验域）",
                "68（起始标志）0C（数据长度）0011（序列号域）00（加密标志）92（类型）32010200000001\n" +
                        "（桩编码）01（执行控制）C1A9（帧校验域）",
                "68（起始标志）0C（数据长度）0011（序列号域）00（加密标志）91（类型）32010200000001\n" +
                        "（桩编码）01（设置结果）C1A9（帧校验域）",
                "68（起始标志）62（数据长度）0026（序列号域）00（加密标志）94（类型）55031412782305\n" +
                        "（桩编码）01（桩型号）0F00(桩功率) 3131342E35352E3131342E3137340000(升级服务器地址) \n" +
                        "1500(升级服务器端口) 73720000000000000000000000000000(用户\n" +
                        "名)73723132330000000000000000000000(密码) \n" +
                        "41432D374B572F32303138303133310000000000000000000000000000000000(文件路径)02(执行\n" +
                        "控制) 3C(下载超时时间)7A2C",
                "68（起始标志）0C（数据长度）0012（序列号域）00（加密标志）93（类型）32010200000001\n" +
                        "（桩编码）01（升级状态）C1A9（帧校验域）",
                "68（起始标志）3E（数据长度）0004（序列号域）00（加密标志）A1（类型）32010200000001\n" +
                        "（桩编码）01（枪号：1 枪）01（启动方式：刷卡启动）00（是否需要密码：不需要）00000000D14B0A54\n" +
                        "（物理卡号：D14B0A54）00000000000000000000000000000000（输入密码）\n" +
                        "0000000000000000000000000000000000（VIN 码）00(主枪)201029112801(并充序号)F496",
                "68（起始标志）30（数据长度）00 04（系列号域）00（加密标志）32（标志）32 01 02 00 00 \n" +
                        "00 01 01 20 18 06 12 19 59 57 85（交易流水号） 32 01 02 00 00 00 01（桩编码） 01（枪\n" +
                        "号：1 枪） 00 00 00 00 00 00 00 00（逻辑卡号） 00 00 00 00（账户余额） 00（鉴权成功\n" +
                        "标志） 01（失败原因）201029112801(并充序号)E8 29（帧校验域）",
                "68 （起始标志） 36 （数据长度） 007C （序列号域） 00 （加密标志） A4 （类型）\n" +
                        "55031412782305012018061914444680（交易流水号）55031412782305（桩编码）01（枪号：1\n" +
                        "枪）0000001000000573（逻辑卡号：1000000573）00000000D14B0A54（物理卡号：D14B0A54）\n" +
                        "A0860100（账户余额：1000.00）201029112801(并充序号)4622",
                "68（起始标志）25（数据长度）0002（序列号域）00（加密标志）A3（类型）\n" +
                        "32010200000000111511161555350260（交易流水号）32010200000001（桩编码）01（枪号：1\n" +
                        "枪）01（启动结果：成功）00（失败原因：无）00（主辅枪标记）201029112801(并充序号)0FE2\n" +
                        "（帧校验域）");

        for (String s : stringFrames) {
            System.out.println("-----------------");
            System.out.println(s);
            System.out.println();
            YkcFrame<Object> frame = convertFrame(s);
            Object data = frame.data();
            if (data instanceof ByteBuf) {
                System.err.println("command: " + frame.command() + " not support!");
                continue;
            }
            Assert.assertNotNull(data);
        }
    }



}
