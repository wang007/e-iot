package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.CP56time2a;

/**
 * 对时设置  0x56
 * <p>
 * created by wang007 on 2024/11/14
 */

@Frame
public class YkcSyncTimeRequest extends YkcBaseData {

    /**
     * 当前时间 BIN 码 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a time;

    /**
     * getter auto generated
     */
    public CP56time2a getTime() {
        return time;
    }

    /**
     * setter auto generated
     */
    public void setTime(CP56time2a time) {
        this.time = time;
    }
}
