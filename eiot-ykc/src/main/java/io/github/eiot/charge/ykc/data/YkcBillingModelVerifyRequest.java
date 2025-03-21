package io.github.eiot.charge.ykc.data;


import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 计费模型验证请求 0x05
 * <p>
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcBillingModelVerifyRequest extends YkcBaseData {

    /**
     * 计费模型编号 BCD 码 2 首次连接到平台时置零
     */
    @FrameField(len = 2)
    private BCD modelNo;
}
