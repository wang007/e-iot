package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.ByteOrder;
import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.Ascii;
import lombok.Data;
import lombok.ToString;

/**
 * 充电桩主动申请启动充电 0x31
 * <p>
 * created by wang007 on 2024/11/12
 */
@ToString
@Data
@Frame
public class YkcPileStartChargeRequest extends YkcBaseData {

    /**
     * 枪号 BCD 码 1
     */
    @FrameField(len = 1)
    private int gunNo;

    /**
     * 启动方式 BIN 码 1
     * 0x01 表示通过刷卡启动充电
     * 0x02 表求通过帐号启动充电（暂
     * 不支持）
     * 0x03 表示vin码启动充电
     */
    @FrameField(len = 1)
    private int startType;

    /**
     * 是否需要密码 BIN 码 1 0x00 不需要 0x01 需要
     */
    @FrameField(len = 1)
    private int requirePassword;

    /**
     * 账号或者物理卡号 BIN 码 8 不足 8 位补 0，具体见示例
     */
    @FrameField(len = 8)
    private long cardNo;

    /**
     * 输入密码 BIN 码 16 对用户输入的密码进行16 位MD5
     * 加密，采用小写上传
     * <p>
     * 占位，不解析就好。
     */
    @FrameField(len = 16)
    private byte[] inputPassword;

    /**
     * VIN 码 ASCII 码 17 位 启动方式为vin码启动充电时上
     * 送,其他方式置零( ASCII码)，
     * VIN码需要反序上送
     */
    @FrameField(byteOrder = ByteOrder.BIG_ENDIAN, len = 17)
    private Ascii vin;
}
