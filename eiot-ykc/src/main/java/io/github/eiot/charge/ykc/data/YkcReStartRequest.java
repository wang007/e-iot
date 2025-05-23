package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;

/**
 * 远程重启  0x92
 * <p>
 * created by wang007 on 2025/3/21
 */
@Frame
public class YkcReStartRequest extends YkcBaseData {

    /**
     * 执行控制
     * 0x01：立即执行
     * 0x02：空闲执行
     */
    @FrameField(len = 1)
    private int controlType;

    /**
     * getter auto generated
     */
    public int getControlType() {
        return controlType;
    }

    /**
     * setter auto generated
     */
    public void setControlType(int controlType) {
        this.controlType = controlType;
    }
}
