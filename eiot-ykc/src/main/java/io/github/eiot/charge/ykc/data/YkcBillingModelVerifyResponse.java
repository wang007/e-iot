package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;


/**
 * 计费模型验证请求应答 0x06
 * <p>
 * 平台判断当前接收的计费模型是否为桩最新的计费模型，如果不一致需要向平台请求新计费模
 * 型，在桩空闲期间下发费率, 其他期间无需下发
 * <p>
 * created by wang007 on 2024/11/11
 */
@Frame
public class YkcBillingModelVerifyResponse extends YkcBaseData {

    /**
     * 计费模型编号 BCD 码 2 首次连接到平台时置零
     */
    @FrameField(len = 2)
    private BCD modelNo;

    /**
     * 验证结果 BIN 码 1
     * 0x00 桩计费模型与平台一致
     * 0x01 桩计费模型与平台不一致
     */
    @FrameField(len = 1)
    private int result;

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

    /**
     * getter auto generated
     */
    public int getResult() {
        return result;
    }

    /**
     * setter auto generated
     */
    public void setResult(int result) {
        this.result = result;
    }
}
