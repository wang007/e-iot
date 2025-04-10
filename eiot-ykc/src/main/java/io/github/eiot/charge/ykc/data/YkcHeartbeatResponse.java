package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 心跳包应答 0x04
 *
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcHeartbeatResponse extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 心跳应答 BIN 码 1 置 0
     */
    @FrameField(len = 1)
    private int result;

}
