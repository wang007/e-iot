package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.*;

/**
 * 交易记录 0x3B
 *
 * created by wang007 on 2024/11/12
 */
@Frame
public class YkcChargeEventRequest {

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
     * 开始时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a startTime;

    /**
     * 结束时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a endTime;

    /**
     * 尖单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topPrice;

    /**
     * 尖电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topPower;

    /**
     * 计损尖电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topLosePower;

    /**
     * 尖金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topMoney;

    /**
     * 峰单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakPrice;

    /**
     * 峰电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakPower;

    /**
     * 计损峰电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakLosePower;

    /**
     * 峰金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakMoney;

    /**
     * 平单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatPrice;

    /**
     * 平电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatPower;

    /**
     * 计损平电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatLosePower;

    /**
     * 平金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatMoney;

    /**
     * 谷单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowPrice;

    /**
     * 谷电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowPower;

    /**
     * 计损谷电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowLosePower;

    /**
     * 谷金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowMoney;

    /**
     * 电表总起值 BIN 5 精确到小数点后四位
     */
    @FrameField(len = 5, unit = 10000)
    private NumberUnit startMeter;

    /**
     * 电表总止值 BIN 5 精确到小数点后四位
     */
    @FrameField(len = 5, unit = 10000)
    private NumberUnit endMeter;

    /**
     * 总电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalPower;

    /**
     * 计损总电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit loseTotalPower;

    /**
     * 消费金额 BIN 4
     * 精确到小数点后四位，包含电费、
     * 服务费
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalMoney;

    /**
     * 电动汽车唯一标识 ASCII 17VIN 码，此处 VIN 码和充电时 VIN码不同，正序直接上传，无需补 0 和反序
     */
    @FrameField(len = 17)
    private Ascii vin;

    /**
     * 交易标识 BIN 1
     * 0x01：app 启动
     * 0x02：卡启动
     * 0x04：离线卡启动
     * 0x05: vin 码启动充电
     */
    @FrameField(len = 1)
    private int startType;

    /**
     * 交易日期、时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a dealTime;

    /**
     * 停止原因 BIN 1 见附录 11.1
     */
    @FrameField(len = 1)
    private Hex stopCode;

    /**
     * 物理卡号 BIN 码 8 不足补零，桩与平台交互需使用的物理卡号
     */
    @FrameField(len = 8)
    private long physicalCardNo;

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
    public CP56time2a getStartTime() {
        return startTime;
    }

    /**
     * setter auto generated
     */
    public void setStartTime(CP56time2a startTime) {
        this.startTime = startTime;
    }

    /**
     * getter auto generated
     */
    public CP56time2a getEndTime() {
        return endTime;
    }

    /**
     * setter auto generated
     */
    public void setEndTime(CP56time2a endTime) {
        this.endTime = endTime;
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopPrice() {
        return topPrice;
    }

    /**
     * setter auto generated
     */
    public void setTopPrice(NumberUnit topPrice) {
        this.topPrice = topPrice;
    }

    /**
     * setter auto generated
     */
    public void setTopPrice(double topPrice) {
        this.topPrice = NumberUnit.from(topPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopPower() {
        return topPower;
    }

    /**
     * setter auto generated
     */
    public void setTopPower(NumberUnit topPower) {
        this.topPower = topPower;
    }

    /**
     * setter auto generated
     */
    public void setTopPower(double topPower) {
        this.topPower = NumberUnit.from(topPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopLosePower() {
        return topLosePower;
    }

    /**
     * setter auto generated
     */
    public void setTopLosePower(NumberUnit topLosePower) {
        this.topLosePower = topLosePower;
    }

    /**
     * setter auto generated
     */
    public void setTopLosePower(double topLosePower) {
        this.topLosePower = NumberUnit.from(topLosePower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopMoney() {
        return topMoney;
    }

    /**
     * setter auto generated
     */
    public void setTopMoney(NumberUnit topMoney) {
        this.topMoney = topMoney;
    }

    /**
     * setter auto generated
     */
    public void setTopMoney(double topMoney) {
        this.topMoney = NumberUnit.from(topMoney, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakPrice() {
        return peakPrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakPrice(NumberUnit peakPrice) {
        this.peakPrice = peakPrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakPrice(double peakPrice) {
        this.peakPrice = NumberUnit.from(peakPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakPower() {
        return peakPower;
    }

    /**
     * setter auto generated
     */
    public void setPeakPower(NumberUnit peakPower) {
        this.peakPower = peakPower;
    }

    /**
     * setter auto generated
     */
    public void setPeakPower(double peakPower) {
        this.peakPower = NumberUnit.from(peakPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakLosePower() {
        return peakLosePower;
    }

    /**
     * setter auto generated
     */
    public void setPeakLosePower(NumberUnit peakLosePower) {
        this.peakLosePower = peakLosePower;
    }

    /**
     * setter auto generated
     */
    public void setPeakLosePower(double peakLosePower) {
        this.peakLosePower = NumberUnit.from(peakLosePower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakMoney() {
        return peakMoney;
    }

    /**
     * setter auto generated
     */
    public void setPeakMoney(NumberUnit peakMoney) {
        this.peakMoney = peakMoney;
    }

    /**
     * setter auto generated
     */
    public void setPeakMoney(double peakMoney) {
        this.peakMoney = NumberUnit.from(peakMoney, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatPrice() {
        return flatPrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatPrice(NumberUnit flatPrice) {
        this.flatPrice = flatPrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatPrice(double flatPrice) {
        this.flatPrice = NumberUnit.from(flatPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatPower() {
        return flatPower;
    }

    /**
     * setter auto generated
     */
    public void setFlatPower(NumberUnit flatPower) {
        this.flatPower = flatPower;
    }

    /**
     * setter auto generated
     */
    public void setFlatPower(double flatPower) {
        this.flatPower = NumberUnit.from(flatPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatLosePower() {
        return flatLosePower;
    }

    /**
     * setter auto generated
     */
    public void setFlatLosePower(NumberUnit flatLosePower) {
        this.flatLosePower = flatLosePower;
    }

    /**
     * setter auto generated
     */
    public void setFlatLosePower(double flatLosePower) {
        this.flatLosePower = NumberUnit.from(flatLosePower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatMoney() {
        return flatMoney;
    }

    /**
     * setter auto generated
     */
    public void setFlatMoney(NumberUnit flatMoney) {
        this.flatMoney = flatMoney;
    }

    /**
     * setter auto generated
     */
    public void setFlatMoney(double flatMoney) {
        this.flatMoney = NumberUnit.from(flatMoney, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowPrice() {
        return lowPrice;
    }

    /**
     * setter auto generated
     */
    public void setLowPrice(NumberUnit lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * setter auto generated
     */
    public void setLowPrice(double lowPrice) {
        this.lowPrice = NumberUnit.from(lowPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowPower() {
        return lowPower;
    }

    /**
     * setter auto generated
     */
    public void setLowPower(NumberUnit lowPower) {
        this.lowPower = lowPower;
    }

    /**
     * setter auto generated
     */
    public void setLowPower(double lowPower) {
        this.lowPower = NumberUnit.from(lowPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowLosePower() {
        return lowLosePower;
    }

    /**
     * setter auto generated
     */
    public void setLowLosePower(NumberUnit lowLosePower) {
        this.lowLosePower = lowLosePower;
    }

    /**
     * setter auto generated
     */
    public void setLowLosePower(double lowLosePower) {
        this.lowLosePower = NumberUnit.from(lowLosePower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowMoney() {
        return lowMoney;
    }

    /**
     * setter auto generated
     */
    public void setLowMoney(NumberUnit lowMoney) {
        this.lowMoney = lowMoney;
    }

    /**
     * setter auto generated
     */
    public void setLowMoney(double lowMoney) {
        this.lowMoney = NumberUnit.from(lowMoney, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getStartMeter() {
        return startMeter;
    }

    /**
     * setter auto generated
     */
    public void setStartMeter(NumberUnit startMeter) {
        this.startMeter = startMeter;
    }

    /**
     * setter auto generated
     */
    public void setStartMeter(double startMeter) {
        this.startMeter = NumberUnit.from(startMeter, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getEndMeter() {
        return endMeter;
    }

    /**
     * setter auto generated
     */
    public void setEndMeter(NumberUnit endMeter) {
        this.endMeter = endMeter;
    }

    /**
     * setter auto generated
     */
    public void setEndMeter(double endMeter) {
        this.endMeter = NumberUnit.from(endMeter, 10000);
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
        this.totalPower = NumberUnit.from(totalPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLoseTotalPower() {
        return loseTotalPower;
    }

    /**
     * setter auto generated
     */
    public void setLoseTotalPower(NumberUnit loseTotalPower) {
        this.loseTotalPower = loseTotalPower;
    }

    /**
     * setter auto generated
     */
    public void setLoseTotalPower(double loseTotalPower) {
        this.loseTotalPower = NumberUnit.from(loseTotalPower, 10000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTotalMoney() {
        return totalMoney;
    }

    /**
     * setter auto generated
     */
    public void setTotalMoney(NumberUnit totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * setter auto generated
     */
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = NumberUnit.from(totalMoney, 10000);
    }

    /**
     * getter auto generated
     */
    public Ascii getVin() {
        return vin;
    }

    /**
     * setter auto generated
     */
    public void setVin(Ascii vin) {
        this.vin = vin;
    }

    /**
     * setter auto generated
     */
    public void setVin(String vin) {
        io.github.eiot.utils.ValidationUtil.lteLen(vin, 17, vin);
        this.vin = Ascii.from(vin, 17);
    }

    /**
     * getter auto generated
     */
    public int getStartType() {
        return startType;
    }

    /**
     * setter auto generated
     */
    public void setStartType(int startType) {
        this.startType = startType;
    }

    /**
     * getter auto generated
     */
    public CP56time2a getDealTime() {
        return dealTime;
    }

    /**
     * setter auto generated
     */
    public void setDealTime(CP56time2a dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * getter auto generated
     */
    public Hex getStopCode() {
        return stopCode;
    }

    /**
     * setter auto generated
     */
    public void setStopCode(Hex stopCode) {
        this.stopCode = stopCode;
    }

    /**
     * setter auto generated
     */
    public void setStopCode(String stopCode) {
        io.github.eiot.utils.ValidationUtil.lteLen(stopCode, 2, stopCode);
        this.stopCode = Hex.from(stopCode, 2);
    }

    /**
     * getter auto generated
     */
    public long getPhysicalCardNo() {
        return physicalCardNo;
    }

    /**
     * setter auto generated
     */
    public void setPhysicalCardNo(long physicalCardNo) {
        this.physicalCardNo = physicalCardNo;
    }
}
