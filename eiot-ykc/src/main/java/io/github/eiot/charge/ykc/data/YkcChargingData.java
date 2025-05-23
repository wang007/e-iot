package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import io.github.eiot.codec.OffsetNumberUnit;

/**
 * 上传实时监测数据  0x13
 *
 * 过程数据
 *
 * created by wang007 on 2024/11/11
 */
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
    public int getGunStatus() {
        return gunStatus;
    }

    /**
     * setter auto generated
     */
    public void setGunStatus(int gunStatus) {
        this.gunStatus = gunStatus;
    }

    /**
     * getter auto generated
     */
    public int getGunReset() {
        return gunReset;
    }

    /**
     * setter auto generated
     */
    public void setGunReset(int gunReset) {
        this.gunReset = gunReset;
    }

    /**
     * getter auto generated
     */
    public int getGunPlug() {
        return gunPlug;
    }

    /**
     * setter auto generated
     */
    public void setGunPlug(int gunPlug) {
        this.gunPlug = gunPlug;
    }

    /**
     * getter auto generated
     */
    public NumberUnit getV() {
        return v;
    }

    /**
     * setter auto generated
     */
    public void setV(NumberUnit v) {
        this.v = v;
    }

    /**
     * setter auto generated
     */
    public void setV(double v) {
        this.v = NumberUnit.from(v, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getI() {
        return i;
    }

    /**
     * setter auto generated
     */
    public void setI(NumberUnit i) {
        this.i = i;
    }

    /**
     * setter auto generated
     */
    public void setI(double i) {
        this.i = NumberUnit.from(i, 10);
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getGunTemp() {
        return gunTemp;
    }

    /**
     * setter auto generated
     */
    public void setGunTemp(OffsetNumberUnit gunTemp) {
        this.gunTemp = gunTemp;
    }

    /**
     * setter auto generated
     */
    public void setGunTemp(double gunTemp) {
        this.gunTemp = OffsetNumberUnit.from(gunTemp, 1, -50, false);
    }

    /**
     * getter auto generated
     */
    public long getGunCode() {
        return gunCode;
    }

    /**
     * setter auto generated
     */
    public void setGunCode(long gunCode) {
        this.gunCode = gunCode;
    }

    /**
     * getter auto generated
     */
    public int getSoc() {
        return soc;
    }

    /**
     * setter auto generated
     */
    public void setSoc(int soc) {
        this.soc = soc;
    }

    /**
     * getter auto generated
     */
    public OffsetNumberUnit getBatteryTempMax() {
        return batteryTempMax;
    }

    /**
     * setter auto generated
     */
    public void setBatteryTempMax(OffsetNumberUnit batteryTempMax) {
        this.batteryTempMax = batteryTempMax;
    }

    /**
     * setter auto generated
     */
    public void setBatteryTempMax(double batteryTempMax) {
        this.batteryTempMax = OffsetNumberUnit.from(batteryTempMax, 1, -50, false);
    }

    /**
     * getter auto generated
     */
    public int getChargeDuration() {
        return chargeDuration;
    }

    /**
     * setter auto generated
     */
    public void setChargeDuration(int chargeDuration) {
        this.chargeDuration = chargeDuration;
    }

    /**
     * getter auto generated
     */
    public int getRemainTime() {
        return remainTime;
    }

    /**
     * setter auto generated
     */
    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
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
    public NumberUnit getLosePower() {
        return losePower;
    }

    /**
     * setter auto generated
     */
    public void setLosePower(NumberUnit losePower) {
        this.losePower = losePower;
    }

    /**
     * setter auto generated
     */
    public void setLosePower(double losePower) {
        this.losePower = NumberUnit.from(losePower, 10000);
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
    public int getHardwareFault() {
        return hardwareFault;
    }

    /**
     * setter auto generated
     */
    public void setHardwareFault(int hardwareFault) {
        this.hardwareFault = hardwareFault;
    }
}
