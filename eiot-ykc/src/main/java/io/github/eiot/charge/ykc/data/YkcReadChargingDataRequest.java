package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 读取实时监测数据  0x12
 *
 *
 * created by wang007 on 2024/11/11
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcReadChargingDataRequest extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField( len = 1)
    private int gunNo;

}
