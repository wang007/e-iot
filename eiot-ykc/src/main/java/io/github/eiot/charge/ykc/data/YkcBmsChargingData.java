package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import io.github.eiot.codec.OffsetNumberUnit;


/**
 * 充电过程 BMS 需求与充电机输出 0x23
 *
 * @author yan
 * @since 2024-11-19
 */
@Frame
public class YkcBmsChargingData {

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
    public NumberUnit getRequiredV() {
        return requiredV;
    }

    /**
     * setter auto generated
     */
    public void setRequiredV(NumberUnit requiredV) {
        this.requiredV = requiredV;
    }

    /**
     * setter auto generated
     */
    public void setRequiredV(double requiredV) {
        this.requiredV = NumberUnit.from(requiredV, 10);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getRequiredI() {
        return requiredI;
    }

    /**
     * setter auto generated
     */
    public void setRequiredI(OffsetNumberUnit requiredI) {
        this.requiredI = requiredI;
    }

    /**
     * setter auto generated
     */
    public void setRequiredI(double requiredI) {
        this.requiredI = OffsetNumberUnit.from(requiredI, 10, 400, true);
    }

    /**
     * getter auto generated
     */
    public int getChargeMode() {
        return chargeMode;
    }

    /**
     * setter auto generated
     */
    public void setChargeMode(int chargeMode) {
        this.chargeMode = chargeMode;
    }

    /**
     * getter auto generated
     */
    public NumberUnit getMeasureV() {
        return measureV;
    }

    /**
     * setter auto generated
     */
    public void setMeasureV(NumberUnit measureV) {
        this.measureV = measureV;
    }

    /**
     * setter auto generated
     */
    public void setMeasureV(double measureV) {
        this.measureV = NumberUnit.from(measureV, 10);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getMeasureI() {
        return measureI;
    }

    /**
     * setter auto generated
     */
    public void setMeasureI(OffsetNumberUnit measureI) {
        this.measureI = measureI;
    }

    /**
     * setter auto generated
     */
    public void setMeasureI(double measureI) {
        this.measureI = OffsetNumberUnit.from(measureI, 10, 400, true);
    }

    /**
     * getter auto generated
     */
    public int getCellMaxVAndNo() {
        return cellMaxVAndNo;
    }

    /**
     * setter auto generated
     */
    public void setCellMaxVAndNo(int cellMaxVAndNo) {
        this.cellMaxVAndNo = cellMaxVAndNo;
    }

    /**
     * getter auto generated
     */
    public int getCurrentSoc() {
        return currentSoc;
    }

    /**
     * setter auto generated
     */
    public void setCurrentSoc(int currentSoc) {
        this.currentSoc = currentSoc;
    }

    /**
     * getter auto generated
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * setter auto generated
     */
    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPileOutV() {
        return pileOutV;
    }

    /**
     * setter auto generated
     */
    public void setPileOutV(NumberUnit pileOutV) {
        this.pileOutV = pileOutV;
    }

    /**
     * setter auto generated
     */
    public void setPileOutV(double pileOutV) {
        this.pileOutV = NumberUnit.from(pileOutV, 10);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getPileOutI() {
        return pileOutI;
    }

    /**
     * setter auto generated
     */
    public void setPileOutI(OffsetNumberUnit pileOutI) {
        this.pileOutI = pileOutI;
    }

    /**
     * setter auto generated
     */
    public void setPileOutI(double pileOutI) {
        this.pileOutI = OffsetNumberUnit.from(pileOutI, 10, 400, true);
    }

    /**
     * getter auto generated
     */
    public int getAccumulateChargeTime() {
        return accumulateChargeTime;
    }

    /**
     * setter auto generated
     */
    public void setAccumulateChargeTime(int accumulateChargeTime) {
        this.accumulateChargeTime = accumulateChargeTime;
    }
}
