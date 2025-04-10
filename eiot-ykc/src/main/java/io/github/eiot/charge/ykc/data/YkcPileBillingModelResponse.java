package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.NumberUnit;
import lombok.Data;
import lombok.ToString;

/**
 * 计费模型请求应答 0x0A
 * <p>
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcPileBillingModelResponse extends YkcBaseData {

    /**
     * 计费模型编号 BCD 码 2 首次连接到平台时置零
     */
    @FrameField(len = 2)
    private BCD modelNo;

    /**
     * 尖电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topElectricPrice;

    /**
     * 尖服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topServicePrice;

    /**
     * 峰电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakElectricPrice;

    /**
     * 峰服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakServicePrice;

    /**
     * 平电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatElectricPrice;

    /**
     * 平服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatServicePrice;

    /**
     * 谷电费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowElectricPrice;

    /**
     * 尖服务费
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowServicePrice;

    /**
     * 计损比例 BIN 码 1 默认值 0
     */
    @FrameField(len = 1)
    private int loseRate;

    /**
     * 0：00～0：30 时段费率号 BIN 码 1 0x00：尖费率 0x01：峰费率 0x02：
     * 平费率 0x03：谷费率
     */
    @FrameField(len = 48)
    private byte[] rateTimes;
}
