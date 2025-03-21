package io.github.eiot.charge.ykc.data;


import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import io.github.eiot.charge.codec.NumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 参数配置 0x17
 * bms 相关
 *
 * @author yan
 * @since 2024-11-19
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcBmsParamConfig {
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
     * BMS 单体动力蓄电池最高允许充电电压
     * 0.01 V/位，0 V 偏移量； 数据范围：0~24 V
     */
    @FrameField(len = 2, unit = 100)
    private NumberUnit cellMaxV;

    /**
     * BMS 最高允许充电电流
     * 0.1 A/位，-400A 偏移量
     */
    @FrameField(len = 2, unit = 10, offset = -400)
    private NumberUnit maxI;

    /**
     * BMS 动力蓄电池标称总能量
     * 0.1 kWh/位，0 kWh 偏移量； 数据范围：0~1000 kWh
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit totalPower;

    /**
     * BMS 最高允许充电总电压
     * 0.1 V/位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit maxV;

    /**
     * BMS 最高允许温度
     * 1ºC/位，-50 ºC 偏移量；数据范围：-50 ºC ~+200 ºC
     */
    @FrameField(len = 1, offset = -50)
    private long maxTemp;

    /**
     * BMS 整车动力蓄电池荷电状态(soc)
     * 0.1%/位，0%偏移量；数据范围：0~100%
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit currentSoc;

    /**
     * BMS 整车动力蓄电池当前电池电压
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit currentV;

    /**
     * 电桩最高输出电压
     * 0.1 V /位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit pileMaxV;

    /**
     * 电桩最低输出电压
     * 0.1 V /位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit pileMinV;

    /**
     * 电桩最高输出电流
     * 0.1 V /位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10, offset = -400)
    private NumberUnit pileMaxI;

    /**
     * 电桩最低输出电流
     * 0.1 V /位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10, offset = -400)
    private NumberUnit pileMinI;
}
