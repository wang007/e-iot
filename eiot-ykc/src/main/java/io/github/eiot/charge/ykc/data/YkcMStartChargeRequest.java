package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;

/**
 * 运营平台远程控制并充启机  0xA4
 *
 * created by wang007 on 2024/11/14
 */
@Frame
public class YkcMStartChargeRequest extends YkcStartChargeRequest {

    /**
     * 并充序号 BCD 码 6 0xA1上送并充序号
     */
    @FrameField(len = 6)
    private BCD serialNo;

    /**
     * getter auto generated
     */
    public BCD getSerialNo() {
        return serialNo;
    }

    /**
     * setter auto generated
     */
    public void setSerialNo(BCD serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * setter auto generated
     */
    public void setSerialNo(String serialNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(serialNo, 12, serialNo);
        this.serialNo = BCD.from(serialNo, 12);
    }
}
