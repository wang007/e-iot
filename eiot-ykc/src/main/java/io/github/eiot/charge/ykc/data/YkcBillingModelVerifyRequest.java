package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;


/**
 * 计费模型验证请求 0x05
 * <p>
 * created by wang007 on 2024/11/11
 */
@Frame
public class YkcBillingModelVerifyRequest extends YkcBaseData {

    /**
     * 计费模型编号 BCD 码 2 首次连接到平台时置零
     */
    @FrameField(len = 2)
    private BCD modelNo;

    /**
     * getter auto generated
     */
    public BCD getModelNo() {
        return modelNo;
    }

    /**
     * setter auto generated
     */
    public void setModelNo(BCD modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * setter auto generated
     */
    public void setModelNo(String modelNo) {
        io.github.eiot.utils.ValidationUtil.lteLen(modelNo, 4, modelNo);
        this.modelNo = BCD.from(modelNo, 4);
    }
}
