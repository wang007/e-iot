package io.github.eiot.charge.ykc.data;


import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 运营平台确认并充启动充电 0xA2
 *
 * created by wang007 on 2024/11/14
 */
@ToString
@Data
@Frame
public class YkcPileMStartChargeResponse extends YkcPileStartChargeResponse {

    /**
     * 并充序号 BCD 码 6 0xA1上送并充序号
     */
    @FrameField(len = 6)
    private BCD serialNo;
}
