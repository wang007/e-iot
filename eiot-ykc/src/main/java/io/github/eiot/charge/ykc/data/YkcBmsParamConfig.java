package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import io.github.eiot.codec.OffsetNumberUnit;

/**
 * 参数配置 0x17
 * bms 相关
 *
 * @author yan
 * @since 2024-11-19
 */
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
    private OffsetNumberUnit maxI;

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
    private OffsetNumberUnit maxTemp;

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
    private OffsetNumberUnit pileMaxI;

    /**
     * 电桩最低输出电流
     * 0.1 V /位，0 V 偏移量
     */
    @FrameField(len = 2, unit = 10, offset = -400)
    private OffsetNumberUnit pileMinI;

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
    public NumberUnit getCellMaxV() {
        return cellMaxV;
    }

    /**
     * setter auto generated
     */
    public void setCellMaxV(NumberUnit cellMaxV) {
        this.cellMaxV = cellMaxV;
    }

    /**
     * setter auto generated
     */
    public void setCellMaxV(double cellMaxV) {
        this.cellMaxV = NumberUnit.from(cellMaxV, 100);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getMaxI() {
        return maxI;
    }

    /**
     * setter auto generated
     */
    public void setMaxI(OffsetNumberUnit maxI) {
        this.maxI = maxI;
    }

    /**
     * setter auto generated
     */
    public void setMaxI(double maxI) {
        this.maxI = OffsetNumberUnit.from(maxI, 10, -400, false);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTotalPower() {
        return totalPower;
    }

    /**
     * setter auto generated
     */
    public void setTotalPower(NumberUnit totalPower) {
        this.totalPower = totalPower;
    }

    /**
     * setter auto generated
     */
    public void setTotalPower(double totalPower) {
        this.totalPower = NumberUnit.from(totalPower, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getMaxV() {
        return maxV;
    }

    /**
     * setter auto generated
     */
    public void setMaxV(NumberUnit maxV) {
        this.maxV = maxV;
    }

    /**
     * setter auto generated
     */
    public void setMaxV(double maxV) {
        this.maxV = NumberUnit.from(maxV, 10);
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
    public NumberUnit getCurrentSoc() {
        return currentSoc;
    }

    /**
     * setter auto generated
     */
    public void setCurrentSoc(NumberUnit currentSoc) {
        this.currentSoc = currentSoc;
    }

    /**
     * setter auto generated
     */
    public void setCurrentSoc(double currentSoc) {
        this.currentSoc = NumberUnit.from(currentSoc, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getCurrentV() {
        return currentV;
    }

    /**
     * setter auto generated
     */
    public void setCurrentV(NumberUnit currentV) {
        this.currentV = currentV;
    }

    /**
     * setter auto generated
     */
    public void setCurrentV(double currentV) {
        this.currentV = NumberUnit.from(currentV, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPileMaxV() {
        return pileMaxV;
    }

    /**
     * setter auto generated
     */
    public void setPileMaxV(NumberUnit pileMaxV) {
        this.pileMaxV = pileMaxV;
    }

    /**
     * setter auto generated
     */
    public void setPileMaxV(double pileMaxV) {
        this.pileMaxV = NumberUnit.from(pileMaxV, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPileMinV() {
        return pileMinV;
    }

    /**
     * setter auto generated
     */
    public void setPileMinV(NumberUnit pileMinV) {
        this.pileMinV = pileMinV;
    }

    /**
     * setter auto generated
     */
    public void setPileMinV(double pileMinV) {
        this.pileMinV = NumberUnit.from(pileMinV, 10);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getPileMaxI() {
        return pileMaxI;
    }

    /**
     * setter auto generated
     */
    public void setPileMaxI(OffsetNumberUnit pileMaxI) {
        this.pileMaxI = pileMaxI;
    }

    /**
     * setter auto generated
     */
    public void setPileMaxI(double pileMaxI) {
        this.pileMaxI = OffsetNumberUnit.from(pileMaxI, 10, -400, false);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getPileMinI() {
        return pileMinI;
    }

    /**
     * setter auto generated
     */
    public void setPileMinI(OffsetNumberUnit pileMinI) {
        this.pileMinI = pileMinI;
    }

    /**
     * setter auto generated
     */
    public void setPileMinI(double pileMinI) {
        this.pileMinI = OffsetNumberUnit.from(pileMinI, 10, -400, false);
    }
}
