package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;
import io.github.eiot.codec.BCD;
import lombok.Data;
import lombok.ToString;

/**
 * 充电桩登录认证 0x01
 *
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcLoginRequest extends YkcBaseData {

    /**
     * 桩类型 BIN 1  0 表示直流桩，1 表示交流桩
     */
    @FrameField(len = 1)
    private int pileType;

    /**
     * 充电枪数量
     */
    @FrameField(len = 1)
    private int gunCount;

    /**
     * 通信协议版本 BIN 码 1 版本号乘 10，v1.0 表示 0x0A
     */
    @FrameField(len = 1)
    private int communicationVersion;

    /**
     * 程序版本 ASCII 码 8 不足 8 位补零
     */
    @FrameField(len = 8)
    private Ascii softwareVersion;

    /**
     * 网络链接类型 BIN 码 1 0x00 SIM 卡
     * 0x01 LAN
     * 0x02 WAN
     * 0x03 其他
     */
    @FrameField(len = 1)
    private int networkType;

    /**
     * Sim 卡 BCD 码 10 不足 10 位补零，取不到置零
     */
    @FrameField(len = 10)
    private BCD sim;

    /**
     * 运营商 BIN 码 1 0x00 移动
     * 0x02 电信
     * 0x03 联通
     * 0x04 其他
     */
    @FrameField(len = 1)
    private int operator;
}
