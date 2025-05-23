package io.github.eiot.charge.ykc.data;


import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import io.github.eiot.codec.OffsetNumberUnit;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 充电过程 BMS 需求与充电机输出 0x23
 *
 * @author yan
 * @since 2024-11-19
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcBmsChargingData {
    /**
     * 交易流水号 BCD 码 16 见名词解释
     */
    @FrameField(len = 16)
    private BCD orderNo;

    public BCD getOrderNo() {
        return orderNo;
    }

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
     * 需求电压
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit requiredV;

    /**
     * 需求电流
     */
    @FrameField(len = 2, unit = 10, offset = 400, offsetReverse = true)
    private OffsetNumberUnit requiredI;

    /**
     * BMS 充电模式
     * 0x01：恒压充电；
     * 0x02：恒流充电
     */
    @FrameField(len = 1)
    private int chargeMode;

    /**
     * 测量电压
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit measureV;

    /**
     * 测量电流
     */
    @FrameField(len = 2, unit = 10, offset = 400, offsetReverse = true)
    private OffsetNumberUnit measureI;

    /**
     * BMS 最高单体动力蓄电池电压及组号
     * 1-12 位：最高单体动力蓄电池电压，数据分辨率：0.01 V/位，0 V偏移量；数据范围：0~24 V；
     * 13-16 位：最高单体动力蓄电池电压所在组号，数据分辨率：1/位，0 偏移量；数据范围：0~15；
     */
    @FrameField(len = 2)
    private int cellMaxVAndNo;

    /**
     * 当前SOC
     */
    @FrameField(len = 1)
    private int currentSoc;

    /**
     * 估计剩余充电时长(min)
     */
    @FrameField(len = 2)
    private int remainingTime;

    /**
     * 电桩电压输出值
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit pileOutV;

    /**
     * 电桩电流输出值
     */
    @FrameField(len = 2, unit = 10, offset = 400, offsetReverse = true)
    private OffsetNumberUnit pileOutI;

    /**
     * 累计充电时长(min)
     */
    @FrameField(len = 2)
    private int accumulateChargeTime;

    private List<String> testList;
}
