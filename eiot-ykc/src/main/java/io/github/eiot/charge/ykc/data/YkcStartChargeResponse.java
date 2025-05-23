package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;

/**
 * 远程启动充电命令回复  0x33
 * <p>
 * created by wang007 on 2024/11/12
 */
@Frame
public class YkcStartChargeResponse {

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
     * 鉴权成功标志 BIN 码 1 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;

    /**
     * 失败原因 BIN 码 1 0x00 无
     * 0x01 设备编号不匹配
     * 0x02 枪已在充电
     * 0x03 设备故障
     * 0x04 设备离线
     * 0x05 未插枪
     * 桩在收到启充命令后,检测到未插枪则发送 0x33 报文回复充电失败。
     * 若在 60 秒（以收到 0x34 时间开始计算）内检测到枪重新连接，则补送 0x33 成功报文;超时或者离线等其他异常，桩不启充、不补发 0x33 报文
     */
    @FrameField(len = 1)
    private int reason;

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
    public int getResult() {
        return result;
    }

    /**
     * setter auto generated
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * getter auto generated
     */
    public int getReason() {
        return reason;
    }

    /**
     * setter auto generated
     */
    public void setReason(int reason) {
        this.reason = reason;
    }
}
