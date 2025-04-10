package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 桩应答远程下发二维码前缀指令 0xF1
 *
 * created by wang007 on 2025/3/21
 */
@ToString
@Data
@Frame
public class YkcQrCodeResponse extends YkcBaseData {

    /**
     * 下发结果 BIN 码 1 0x00：成功 0x01:失败
     *
     */
    @FrameField(len = 1)
    private int result;
}
