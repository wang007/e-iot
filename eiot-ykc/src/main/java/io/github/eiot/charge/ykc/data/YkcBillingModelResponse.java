package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 计费模型应答 0x57
 *
 * created by wang007 on 2024/11/14
 */
@ToString
@Data
@Frame
public class YkcBillingModelResponse extends YkcBaseData {

    /**
     * 设置结果
     * BIN 码 1
     * 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;
}
