package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 远程更新应答  0x93
 * <p>
 * created by wang007 on 2025/3/21
 */
@ToString
@Data
@Frame
public class YkcUpgradeResponse extends YkcBaseData {

    /**
     * 升级状态 BIN 码 1
     * 0x00-成功
     * 0x01-编号错误
     * 0x02-程序与桩型号不符
     * 0x03-下载更新文件超时
     */
    @FrameField(len = 1)
    private int upgradeStatus;
}
