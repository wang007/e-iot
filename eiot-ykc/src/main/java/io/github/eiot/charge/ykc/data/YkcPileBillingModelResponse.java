package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;

/**
 * 计费模型请求应答 0x0A
 * <p>
 * created by wang007 on 2024/11/11
 */
@Frame
public class YkcPileBillingModelResponse extends YkcBaseData {

    /**
     * 计费模型编号 BCD 码 2 首次连接到平台时置零
     */
    @FrameField(len = 2)
    private BCD modelNo;

    /**
     * 尖电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topElectricPrice;

    /**
     * 尖服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topServicePrice;

    /**
     * 峰电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakElectricPrice;

    /**
     * 峰服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakServicePrice;

    /**
     * 平电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatElectricPrice;

    /**
     * 平服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatServicePrice;

    /**
     * 谷电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowElectricPrice;

    /**
     * 尖服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowServicePrice;

    /**
     * 计损比例 BIN 码 1 默认值 0
     */
    @FrameField(len = 1)
    private int loseRate;

    /**
     * 0：00～0：30 时段费率号 BIN 码 1 0x00：尖费率 0x01：峰费率 0x02：
     * 平费率 0x03：谷费率
     */
    @FrameField(len = 48)
    private byte[] rateTimes;

    /**
     * getter auto generated
     */
    public BCD getModelNo() {
        return modelNo;
    }

    /**
     * setter auto generated
     */
    public void setModelNo(BCD modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * setter auto generated
     */
    public void setModelNo(String modelNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(modelNo, 4, modelNo);
        this.modelNo = BCD.from(modelNo, 4);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopElectricPrice() {
        return topElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setTopElectricPrice(NumberUnit topElectricPrice) {
        this.topElectricPrice = topElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setTopElectricPrice(double topElectricPrice) {
        this.topElectricPrice = NumberUnit.from(topElectricPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getTopServicePrice() {
        return topServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setTopServicePrice(NumberUnit topServicePrice) {
        this.topServicePrice = topServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setTopServicePrice(double topServicePrice) {
        this.topServicePrice = NumberUnit.from(topServicePrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakElectricPrice() {
        return peakElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakElectricPrice(NumberUnit peakElectricPrice) {
        this.peakElectricPrice = peakElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakElectricPrice(double peakElectricPrice) {
        this.peakElectricPrice = NumberUnit.from(peakElectricPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getPeakServicePrice() {
        return peakServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakServicePrice(NumberUnit peakServicePrice) {
        this.peakServicePrice = peakServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setPeakServicePrice(double peakServicePrice) {
        this.peakServicePrice = NumberUnit.from(peakServicePrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatElectricPrice() {
        return flatElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatElectricPrice(NumberUnit flatElectricPrice) {
        this.flatElectricPrice = flatElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatElectricPrice(double flatElectricPrice) {
        this.flatElectricPrice = NumberUnit.from(flatElectricPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getFlatServicePrice() {
        return flatServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatServicePrice(NumberUnit flatServicePrice) {
        this.flatServicePrice = flatServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setFlatServicePrice(double flatServicePrice) {
        this.flatServicePrice = NumberUnit.from(flatServicePrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowElectricPrice() {
        return lowElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setLowElectricPrice(NumberUnit lowElectricPrice) {
        this.lowElectricPrice = lowElectricPrice;
    }

    /**
     * setter auto generated
     */
    public void setLowElectricPrice(double lowElectricPrice) {
        this.lowElectricPrice = NumberUnit.from(lowElectricPrice, 100000);
    }

    /**
     * getter auto generated
     */
    public NumberUnit getLowServicePrice() {
        return lowServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setLowServicePrice(NumberUnit lowServicePrice) {
        this.lowServicePrice = lowServicePrice;
    }

    /**
     * setter auto generated
     */
    public void setLowServicePrice(double lowServicePrice) {
        this.lowServicePrice = NumberUnit.from(lowServicePrice, 100000);
    }

    /**
     * getter auto generated
     */
    public int getLoseRate() {
        return loseRate;
    }

    /**
     * setter auto generated
     */
    public void setLoseRate(int loseRate) {
        this.loseRate = loseRate;
    }

    /**
     * getter auto generated
     */
    public byte[] getRateTimes() {
        return rateTimes;
    }

    /**
     * setter auto generated
     */
    public void setRateTimes(byte[] rateTimes) {
        this.rateTimes = rateTimes;
    }
}
