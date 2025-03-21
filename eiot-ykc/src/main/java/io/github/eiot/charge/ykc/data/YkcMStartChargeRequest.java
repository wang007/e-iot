package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 运营平台远程控制并充启机  0xA4
 *
 * created by wang007 on 2024/11/14
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcMStartChargeRequest extends YkcStartChargeRequest {

    /**
     * 并充序号 BCD 码 6 0xA1上送并充序号
     */
    @FrameField( len = 6)
    private BCD serialNo;


}
