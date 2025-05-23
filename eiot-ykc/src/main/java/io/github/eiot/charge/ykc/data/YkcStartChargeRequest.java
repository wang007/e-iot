package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;

/**
 * 运营平台远程控制启机  0x34
 * <p>
 * created by wang007 on 2024/11/12
 */
@Frame
public class YkcStartChargeRequest {

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
     * 逻辑卡号 BCD 码 8 显示在屏幕上，不足 8 位补零
     */
    @FrameField(len = 8)
    private BCD cardNo;

    /**
     * 物理卡号 BIN 码 8 不足补零，桩与平台交互需使用的物理卡号
     */
    @FrameField(len = 8)
    private long physicalCardNo;

    /**
     * 账户余额 BIN 码 4 保留两位小数
     */
    @FrameField(len = 4, unit = 100)
    private NumberUnit balance;

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
    public BCD getCardNo() {
        return cardNo;
    }

    /**
     * setter auto generated
     */
    public void setCardNo(BCD cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * setter auto generated
     */
    public void setCardNo(String cardNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(cardNo, 16, cardNo);
        this.cardNo = BCD.from(cardNo, 16);
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

    /**
     * getter auto generated
     */
    public NumberUnit getBalance() {
        return balance;
    }

    /**
     * setter auto generated
     */
    public void setBalance(NumberUnit balance) {
        this.balance = balance;
    }

    /**
     * setter auto generated
     */
    public void setBalance(double balance) {
        this.balance = NumberUnit.from(balance, 100);
    }
}
