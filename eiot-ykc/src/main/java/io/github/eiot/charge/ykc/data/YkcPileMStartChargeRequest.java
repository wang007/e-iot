package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 充电桩主动申请并充充电 0xA1
 *
 * created by wang007 on 2024/11/14
 */
@ToString
@Data
@Frame
public class YkcPileMStartChargeRequest extends YkcPileStartChargeRequest {

    /**
     * 主辅枪标记 BIN 码 1 0x00 主枪 0x01辅枪
     */
    @FrameField(len = 1)
    private int mainGun;

    /**
     * 并充序号 BCD 码 6 由桩生成，生成规则：年月日时分
     * 秒，多个枪并充时上送并充序号一
     * 致，标志为同一次并充操作
     */
    @FrameField(len = 6)
    private BCD serialNo;

}
