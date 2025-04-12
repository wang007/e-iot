package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.*;
import lombok.Data;
import lombok.ToString;

/**
 * 交易记录 0x3B
 *
 * created by wang007 on 2024/11/12
 */
@ToString(callSuper = true)
@Data
@Frame
public class YkcChargeEventRequest {

    /**
     * 交易流水号 BCD 码 16 见名词解释
     */
    @FrameField(len = 16)
    private BCD orderNo;

    /**
     * 桩编码 BCD 码 7byte
     */
    @FrameField(len = 7)
    private BCD terminalNo;

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 开始时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a startTime;

    /**
     * 结束时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a endTime;

    /**
     * 尖单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit topPrice;

    /**
     * 尖电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topPower;

    /**
     * 计损尖电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topLosePower;

    /**
     * 尖金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit topMoney;

    /**
     * 峰单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit peakPrice;

    /**
     * 峰电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakPower;

    /**
     * 计损峰电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakLosePower;

    /**
     * 峰金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit peakMoney;

    /**
     * 平单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit flatPrice;

    /**
     * 平电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatPower;

    /**
     * 计损平电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatLosePower;

    /**
     * 平金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit flatMoney;

    /**
     * 谷单价 BIN 4
     * 精确到小数点后五位（尖电费+尖服务费，见费率帧）
     */
    @FrameField(len = 4, unit = 100000)
    private NumberUnit lowPrice;

    /**
     * 谷电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowPower;

    /**
     * 计损谷电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowLosePower;

    /**
     * 谷金额 BIN 4
     * 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit lowMoney;

    /**
     * 电表总起值 BIN 5 精确到小数点后四位
     */
    @FrameField(len = 5, unit = 10000)
    private NumberUnit startMeter;

    /**
     * 电表总止值 BIN 5 精确到小数点后四位
     */
    @FrameField(len = 5, unit = 10000)
    private NumberUnit endMeter;

    /**
     * 总电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalPower;

    /**
     * 计损总电量 BIN 4 精确到小数点后四位
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit loseTotalPower;

    /**
     * 消费金额 BIN 4
     * 精确到小数点后四位，包含电费、
     * 服务费
     */
    @FrameField(len = 4, unit = 10000)
    private NumberUnit totalMoney;

    /**
     * 电动汽车唯一标识 ASCII 17VIN 码，此处 VIN 码和充电时 VIN码不同，正序直接上传，无需补 0 和反序
     */
    @FrameField(len = 17)
    private Ascii vin;

    /**
     * 交易标识 BIN 1
     * 0x01：app 启动
     * 0x02：卡启动
     * 0x04：离线卡启动
     * 0x05: vin 码启动充电
     */
    @FrameField(len = 1)
    private int startType;

    /**
     * 交易日期、时间 BIN 7 CP56Time2a 格式
     */
    @FrameField
    private CP56time2a dealTime;

    /**
     * 停止原因 BIN 1 见附录 11.1
     */
    @FrameField(len = 1)
    private Hex stopCode;

    /**
     * 物理卡号 BIN 码 8 不足补零，桩与平台交互需使用的物理卡号
     */
    @FrameField(len = 8)
    private long physicalCardNo;
}
