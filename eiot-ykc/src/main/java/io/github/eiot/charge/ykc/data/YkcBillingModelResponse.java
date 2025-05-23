package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;

/**
 * 计费模型应答 0x57
 *
 * created by wang007 on 2024/11/14
 */
@Frame
public class YkcBillingModelResponse extends YkcBaseData {

    /**
     * 设置结果
     * BIN 码 1
     * 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;

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
