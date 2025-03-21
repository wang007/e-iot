package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 充电过程 BMS 信息 0x25
 *
 * @author yan
 * @since 2024-11-20
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcBmsChargingStatus {
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
     * BMS 最高单体动力蓄电池电压所在编号
     */
    @FrameField(len = 1)
    private int cellMaxNo;

    /**
     * BMS 最高动力蓄电池温度; 1ºC/位，-50 ºC 偏移量；
     */
    @FrameField(len = 1, offset = -50)
    private int maxTemp;

    /**
     * 最高温度检测点编号
     */
    @FrameField(len = 1)
    private int maxTempNo;

    /**
     * 最低动力蓄电池温度;1ºC/位，-50 ºC 偏移量；
     */
    @FrameField(len = 1, offset = -50)
    private int minTemp;

    /**
     * 最低温度检测点编号
     */
    @FrameField(len = 1)
    private int minTempNo;

    /**
     * TODO 使用 subByte
     *
     * BMS 单体动力蓄电池电压 过高/过低 2 位 (<00>：=正常; <01>：=过高;<10>：=过低)
     * BMS 整车动力蓄电池荷电状态 SOC 过高/过低  2 位 (<00>：=正常; <01>：=过高;<10>：=过低)
     * BMS 动力蓄电池充电过电流  2 位 (<00>：=正常; <01>：=过流; <10>：=不可信状态)
     * BMS 动力蓄电池温度过高 2 位 (<00>：=正常; <01>：=过流; <10>：=不可信状态)
     * BMS 动力蓄电池绝缘状态 2 位 (<00>：=正常; <01>：=过流; <10>：=不可信状态)
     * BMS 动力蓄电池组输出连接器 连接状态 2 位 (<00>：=正常; <01>：=过流; <10>：=不可信状态)
     * 充电禁止 2 位 (<00>：=禁止; <01>：=允许)
     * 预留位 2 位 00
     */
    @FrameField(len = 2)
    private int status;
}
