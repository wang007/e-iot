package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.CP56time2a;
import lombok.Data;
import lombok.ToString;

/**
 * 对时设置  0x56
 * <p>
 * created by wang007 on 2024/11/14
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcSyncTimeRequest extends YkcBaseData {

    /**
     * 当前时间 BIN 码 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a time;

}
