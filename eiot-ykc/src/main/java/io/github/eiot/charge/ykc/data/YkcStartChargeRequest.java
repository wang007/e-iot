package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import io.github.eiot.charge.codec.NumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 运营平台远程控制启机  0x34
 * <p>
 * created by wang007 on 2024/11/12
 */
@ToString(callSuper = true)
@Data
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

}
