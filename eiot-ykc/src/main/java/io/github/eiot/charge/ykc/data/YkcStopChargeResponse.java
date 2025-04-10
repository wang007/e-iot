package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 远程停机命令回复  0x35
 *
 * created by wang007 on 2024/11/12
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcStopChargeResponse extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 成功标志 BIN 码 1 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;

    /**
     * 失败原因 BIN 码 1
     * <p>
     * 0x00 无
     * 0x01 设备编号不匹配
     * 0x02 枪未处于充电状态
     * 0x03 其他
     */
    @FrameField(len = 1)
    private int reason;

}
