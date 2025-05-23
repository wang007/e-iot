package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;

/**
 * 充电握手 0x15
 *
 * BMS 相关
 *
 * @author yan
 * @since 2024-11-18
 */
@Frame
public class YkcBmsShake {

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
     * bms通信协议版本号
     * 当前版本为 V1.1，表示为：byte3，
     * byte2—0001H；
     * byte1—01H
     */
    @FrameField(len = 3)
    private byte[] bmsProtocolVersion;

    /**
     * bms电池类型
     * 01H:铅酸电池;
     * 02H:氢电池;
     * 03H:磷酸铁锂电池;
     * 04H:锰酸锂电池;
     * 05H:钴酸锂电池;
     * 06H:三元材料电池;
     * 07H:聚合物锂离子电池;
     * 08H:钛酸锂电池;
     * FFH:其他;
     */
    @FrameField(len = 1)
    private int bmsType;

    /**
     * BMS 整车动力蓄电池系统额定容量
     *
     * 0.1 Ah /位，0 Ah 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit ratedCapacity;

    /**
     * BMS 整车动力蓄电池系统额定总电压
     * 0.1V/位，0V 偏移量
     */
    @FrameField(len = 2, unit = 10)
    private NumberUnit ratedV;

    /**
     * BMS 电池组序号
     */
    @FrameField(len = 4)
    private Ascii manufacturer;

    /**
     * 电池组序号
     */
    @FrameField(len = 4)
    private BCD bmsSn;

    /**
     * BMS 电池组生产日期年
     * 1985 年偏移量，数据范围：1985～2235 年
     */
    @FrameField(len = 1)
    private int productionYear;

    /**
     * 电池生产月
     */
    @FrameField(len = 1)
    private int productionMonth;

    /**
     * 电池生产日
     */
    @FrameField(len = 1)
    private int productionDay;

    /**
     * 电池充电次数
     */
    @FrameField(len = 3)
    private int chargeCount;

    /**
     * BMS电池组产权标识
     * 0：租赁
     * 1：车自有
     */
    @FrameField(len = 1)
    private int owner;

    /**
     * 预留
     */
    @FrameField(len = 1)
    private int reverse1;

    /**
     * vin码
     */
    @FrameField(len = 17)
    private Ascii vin;

    /**
     * TODO 使用 SubByte
     *
     * BMS 软件版本号
     * Byte8、byte7、byte6—000001H～FFFFFEH，预留，填 FFFFFFH；
     * Byte5-byte2 作为 BMS 软件版本编译时间信息标记，
     * -Byte5，byte4—0001H～FFFEH 表示“年”（例如 2015 年：填写Byte5—DFH， byte4—07H）；
     * -Byte3—01H～0CH 表示“月”（例如 11 月：填写 Byte3—0BH）；
     * -Byte2—01H～1FH 表示“日”（例如 10 日：填写 Byte2—0AH）；
     * Byte1—01H～FEH 表示版本流水号（例如 16：填写 Byte1—10H）
     */
    @FrameField(len = 8)
    private byte[] bmsSoftVersion;

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
    public byte[] getBmsProtocolVersion() {
        return bmsProtocolVersion;
    }

    /**
     * setter auto generated
     */
    public void setBmsProtocolVersion(byte[] bmsProtocolVersion) {
        this.bmsProtocolVersion = bmsProtocolVersion;
    }

    /**
     * getter auto generated
     */
    public int getBmsType() {
        return bmsType;
    }

    /**
     * setter auto generated
     */
    public void setBmsType(int bmsType) {
        this.bmsType = bmsType;
    }

    /**
     * getter auto generated
     */
    public NumberUnit getRatedCapacity() {
        return ratedCapacity;
    }

    /**
     * setter auto generated
     */
    public void setRatedCapacity(NumberUnit ratedCapacity) {
        this.ratedCapacity = ratedCapacity;
    }

    /**
     * setter auto generated
     */
    public void setRatedCapacity(double ratedCapacity) {
        this.ratedCapacity = NumberUnit.from(ratedCapacity, 10);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getRatedV() {
        return ratedV;
    }

    /**
     * setter auto generated
     */
    public void setRatedV(NumberUnit ratedV) {
        this.ratedV = ratedV;
    }

    /**
     * setter auto generated
     */
    public void setRatedV(double ratedV) {
        this.ratedV = NumberUnit.from(ratedV, 10);
    }

    /**
     * getter auto generated
     */
    public Ascii getManufacturer() {
        return manufacturer;
    }

    /**
     * setter auto generated
     */
    public void setManufacturer(Ascii manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * setter auto generated
     */
    public void setManufacturer(String manufacturer) {
        io.github.eiot.utils.ValidationUtil.lteLen(manufacturer, 4, manufacturer);
        this.manufacturer = Ascii.from(manufacturer, 4);
    }

    /**
     * getter auto generated
     */
    public BCD getBmsSn() {
        return bmsSn;
    }

    /**
     * setter auto generated
     */
    public void setBmsSn(BCD bmsSn) {
        this.bmsSn = bmsSn;
    }

    /**
     * setter auto generated
     */
    public void setBmsSn(String bmsSn) {
        io.github.eiot.utils.ValidationUtil.lteLen(bmsSn, 8, bmsSn);
        this.bmsSn = BCD.from(bmsSn, 8);
    }

    /**
     * getter auto generated
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * setter auto generated
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * getter auto generated
     */
    public int getProductionMonth() {
        return productionMonth;
    }

    /**
     * setter auto generated
     */
    public void setProductionMonth(int productionMonth) {
        this.productionMonth = productionMonth;
    }

    /**
     * getter auto generated
     */
    public int getProductionDay() {
        return productionDay;
    }

    /**
     * setter auto generated
     */
    public void setProductionDay(int productionDay) {
        this.productionDay = productionDay;
    }

    /**
     * getter auto generated
     */
    public int getChargeCount() {
        return chargeCount;
    }

    /**
     * setter auto generated
     */
    public void setChargeCount(int chargeCount) {
        this.chargeCount = chargeCount;
    }

    /**
     * getter auto generated
     */
    public int getOwner() {
        return owner;
    }

    /**
     * setter auto generated
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }

    /**
     * getter auto generated
     */
    public int getReverse1() {
        return reverse1;
    }

    /**
     * setter auto generated
     */
    public void setReverse1(int reverse1) {
        this.reverse1 = reverse1;
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
    public byte[] getBmsSoftVersion() {
        return bmsSoftVersion;
    }

    /**
     * setter auto generated
     */
    public void setBmsSoftVersion(byte[] bmsSoftVersion) {
        this.bmsSoftVersion = bmsSoftVersion;
    }
}
