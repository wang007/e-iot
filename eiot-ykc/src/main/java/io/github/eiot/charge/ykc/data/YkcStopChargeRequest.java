package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 运营平台远程停机  0x36
 *
 * created by wang007 on 2024/11/12
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcStopChargeRequest extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;
}
