package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.OffsetNumberUnit;

/**
 * 充电过程 BMS 信息 0x25
 *
 * @author yan
 * @since 2024-11-20
 */
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
    private OffsetNumberUnit maxTemp;

    /**
     * 最高温度检测点编号
     */
    @FrameField(len = 1)
    private int maxTempNo;

    /**
     * 最低动力蓄电池温度;1ºC/位，-50 ºC 偏移量；
     */
    @FrameField(len = 1, offset = -50)
    private OffsetNumberUnit minTemp;

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

    /**
     * getter auto generated
     */
    public BCD getOrderNo() {
        return orderNo;
    }

    /**
     * setter auto generated
     */
    public void setOrderNo(BCD orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * setter auto generated
     */
    public void setOrderNo(String orderNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(orderNo, 32, orderNo);
        this.orderNo = BCD.from(orderNo, 32);
    }

    /**
     * getter auto generated
     */
    public BCD getTerminalNo() {
        return terminalNo;
    }

    /**
     * setter auto generated
     */
    public void setTerminalNo(BCD terminalNo) {
        this.terminalNo = terminalNo;
    }

    /**
     * setter auto generated
     */
    public void setTerminalNo(String terminalNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(terminalNo, 14, terminalNo);
        this.terminalNo = BCD.from(terminalNo, 14);
    }

    /**
     * getter auto generated
     */
    public int getGunNo() {
        return gunNo;
    }

    /**
     * setter auto generated
     */
    public void setGunNo(int gunNo) {
        this.gunNo = gunNo;
    }

    /**
     * getter auto generated
     */
    public int getCellMaxNo() {
        return cellMaxNo;
    }

    /**
     * setter auto generated
     */
    public void setCellMaxNo(int cellMaxNo) {
        this.cellMaxNo = cellMaxNo;
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getMaxTemp() {
        return maxTemp;
    }

    /**
     * setter auto generated
     */
    public void setMaxTemp(OffsetNumberUnit maxTemp) {
        this.maxTemp = maxTemp;
    }

    /**
     * setter auto generated
     */
    public void setMaxTemp(double maxTemp) {
        this.maxTemp = OffsetNumberUnit.from(maxTemp, 1, -50, false);
    }

    /**
     * getter auto generated
     */
    public int getMaxTempNo() {
        return maxTempNo;
    }

    /**
     * setter auto generated
     */
    public void setMaxTempNo(int maxTempNo) {
        this.maxTempNo = maxTempNo;
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getMinTemp() {
        return minTemp;
    }

    /**
     * setter auto generated
     */
    public void setMinTemp(OffsetNumberUnit minTemp) {
        this.minTemp = minTemp;
    }

    /**
     * setter auto generated
     */
    public void setMinTemp(double minTemp) {
        this.minTemp = OffsetNumberUnit.from(minTemp, 1, -50, false);
    }

    /**
     * getter auto generated
     */
    public int getMinTempNo() {
        return minTempNo;
    }

    /**
     * setter auto generated
     */
    public void setMinTempNo(int minTempNo) {
        this.minTempNo = minTempNo;
    }

    /**
     * getter auto generated
     */
    public int getStatus() {
        return status;
    }

    /**
     * setter auto generated
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
