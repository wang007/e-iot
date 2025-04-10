package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 远程重启应答 0x91
 *
 * created by wang007 on 2025/3/21
 */
@ToString
@Data
@Frame
public class YkcReStartResponse extends YkcBaseData {

    /**
     * 设置结果 BIN 码 1
     * <p>
     * 0x00 失败 0x01 成功
     */
    @FrameField(len = 1)
    private int result;
}
