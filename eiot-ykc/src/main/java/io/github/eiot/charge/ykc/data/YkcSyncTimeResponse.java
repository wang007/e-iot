package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import lombok.Data;
import lombok.ToString;

/**
 * 对时设置应答 0x55
 *
 * created by wang007 on 2024/11/14
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcSyncTimeResponse extends YkcSyncTimeRequest {
}
