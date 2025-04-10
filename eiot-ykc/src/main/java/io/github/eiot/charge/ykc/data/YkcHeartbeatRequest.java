package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 充电桩心跳包 0x03
 *
 *
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcHeartbeatRequest extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 枪状态 BIN 码 1 0x00：正常 0x01：故障
     */
    @FrameField(len = 1)
    private int gunStatus;
}
