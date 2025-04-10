package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 交易记录确认 0x40
 *
 * created by wang007 on 2024/11/14
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcChargeEventResponse {

    /**
     * 交易流水号 BCD 码 16 见名词解释
     */
    @FrameField(len = 16)
    private BCD orderNo;

    /**
     * 确认结果 BIN 码 1 0x00 上传成功 0x01 非法账单
     */
    @FrameField(len = 1)
    private int result;
}
