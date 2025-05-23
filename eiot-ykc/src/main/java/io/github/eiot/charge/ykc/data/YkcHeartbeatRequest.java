package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;

/**
 * 充电桩心跳包 0x03
 *
 * created by wang007 on 2024/11/11
 */
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

    /**
     * getter auto generated
     */
    public int getGunNo() {
        return gunNo;
    }

    /**
     * setter auto generated
     */
    public void setGunNo(int gunNo) {
        this.gunNo = gunNo;
    }

    /**
     * getter auto generated
     */
    public int getGunStatus() {
        return gunStatus;
    }

    /**
     * setter auto generated
     */
    public void setGunStatus(int gunStatus) {
        this.gunStatus = gunStatus;
    }
}
