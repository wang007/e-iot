package io.github.eiot.charge.ykc.data;


import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import io.github.eiot.charge.codec.NumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 运营平台确认启动充电  0x32
 * <p>
 * created by wang007 on 2024/11/12
 */
@ToString
@Data
@Frame
public class YkcPileStartChargeResponse {

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
     * 账户余额 BIN 码 4 保留两位小数
     */
    @FrameField(len = 4, unit = 100)
    private NumberUnit balance;

    /**
     * 鉴权成功标志 BIN 码 1 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;

    /**
     * 失败原因 BCD 码 1
     * <p>
     * 0x01 账户不存在
     * 0x02 账户冻结
     * 0x03 账户余额不足
     * 0x04 该卡存在未结账记录
     * 0x05 桩停用
     * 0x06 该账户不能在此桩上充电
     * 0x07 密码错误
     * 0x08 电站电容不足
     * 0x09 系统中 vin 码不存在
     * 0x0A 该桩存在未结账记录
     * 0x0B 该桩不支持刷卡
     */
    @FrameField(len = 1)
    private int reason;
}
