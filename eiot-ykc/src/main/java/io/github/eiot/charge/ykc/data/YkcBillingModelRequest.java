package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import lombok.Data;
import lombok.ToString;

/**
 * 计费模型设置，平台向桩下发  0x58
 *
 * created by wang007 on 2024/11/14
 */
@ToString
@Data
@Frame
public class YkcBillingModelRequest extends YkcPileBillingModelResponse {
}
