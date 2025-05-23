package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import io.github.eiot.codec.OffsetNumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 上传实时监测数据  0x13
 *
 * 过程数据
 *
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcChargingData {

    /**
     * 交易流水号 BCD 码 16 见名词解释
     */
    @FrameField(len = 16)
    private BCD orderNo;

    /**
     * 桩编码 BCD 码 7byte
     */
    @FrameField(len = 7)
    private BCD terminalNo;

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 枪状态 BIN 码 1
     * <p>
     * 0x00：离线
     * 0x01：故障
     * 0x02：空闲
     * 0x03：充电
     * 需做到变位上送
     */
    @FrameField(len = 1)
    private int gunStatus;

    /**
     * 枪是否归位 BIN 码 1 0x00 否 0x01 是 0x02 未知
     * （无法检测到枪是否插回枪座即未知）
     */
    @FrameField(len = 1)
    private int gunReset;

    /**
     * 是否插枪 BIN 码 1 0x00 否 0x01 是
     * 需做到变位上送
     */
    @FrameField(len = 1)
    private int gunPlug;

    /**
     * 输出电压 BIN 码 2 精确到小数点后一位；待机置零
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit v;

    /**
     * 输出电流 BIN 码 2 精确到小数点后一位；待机置零
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit i;

    /**
     * 枪线温度 BIN 码 1 整形，偏移量-50；待机置零
     */
    @FrameField(len = 1, offset = -50)
    private OffsetNumberUnit gunTemp;

    /**
     * 枪线编码 BIN 码 8 没有置零
     */
    @FrameField(len = 8)
    private long gunCode;

    /**
     * SOC BIN 码 1 待机置零；交流桩置零
     */
    @FrameField(len = 1)
    private int soc;

    /**
     * 电池组最高温度 BIN 码 1 整形，偏移量-50 ºC；待机置零；
     * 交流桩置零
     */
    @FrameField(len = 1, offset = -50)
    private OffsetNumberUnit batteryTempMax;

    /**
     * 累计充电时间 BIN 码 2 单位：min；待机置零
     */
    @FrameField(len = 2)
    private int chargeDuration;

    /**
     * 剩余时间 BIN 码 2 单位：min；待机置零、交流桩置
     * 零
     */
    @FrameField(len = 2)
    private int remainTime;

    /**
     * 充电度数 BIN 码 4 精确到小数点后四位；待机置零
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalPower;

    /**
     * 计损充电度数 BIN 码 4 精确到小数点后四位；待机置零
     * 未设置计损比例时等于充电度数
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit losePower;

    /**
     * 已充金额 BIN 码 4 精确到小数点后四位；待机置零
     * （电费+服务费）*计损充电度数
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalMoney;

    /**
     * 硬件故障 BIN 码 2 Bit 位表示（0 否 1 是），低位到高位顺序
     * Bit1：急停按钮动作故障；
     * Bit2：无可用整流模块；
     * Bit3：出风口温度过高；
     * Bit4：交流防雷故障；
     * Bit5：交直流模块 DC20 通信中断；
     * Bit6：绝缘检测模块 FC08 通信中断；
     * Bit7：电度表通信中断；
     * Bit8：读卡器通信中断；
     * Bit9：RC10 通信中断；
     * Bit10：风扇调速板故障；
     * Bit11：直流熔断器故障；
     * Bit12：高压接触器故障；
     * Bit13：门打开；
     */
    @FrameField(len = 2)
    private int hardwareFault;
}
