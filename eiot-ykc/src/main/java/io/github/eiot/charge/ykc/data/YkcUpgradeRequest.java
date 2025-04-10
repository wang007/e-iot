package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;
import lombok.Data;
import lombok.ToString;

/**
 * 远程更新 0x94
 * <p>
 * 对桩进行软件升级，平台升级模式为 ftp 文件升级，由桩企提供升级需要的更新文件（特定文
 * 件名，由桩企定义），平台在数据帧中提供访问更新文件相关服务器地址及下载路径信息，桩
 * 下载完更新程序后对文件进行较验，并对桩进行升级。
 * <p>
 * created by wang007 on 2025/3/21
 */
@ToString
@Data
@Frame
public class YkcUpgradeRequest extends YkcBaseData {

    /**
     * 桩类型 BIN 1  0 表示直流桩，1 表示交流桩
     */
    @FrameField(len = 1)
    private int pileType;

    /**
     * 桩功率 BIN 码 2 不足 2 位补零
     */
    @FrameField(len = 2)
    private int pileP;

    /**
     * 升级服务器地址 ASCII 码 16
     */
    @FrameField(len = 16)
    private Ascii serverHost;

    /**
     * 升级服务器端口 BIN 码 2 不足 2 位补零
     */
    @FrameField(len = 2)
    private int serverPort;

    /**
     * 用户名 ASCII 码 16 不足 16 位补零
     */
    @FrameField(len = 16)
    private Ascii username;

    /**
     * 密码 ASCII 码 16 不足 16 位补零
     */
    @FrameField(len = 16)
    private Ascii password;

    /**
     * 文件路径 ASCII 码 32 不足 32 位补零，文件路径名由平台定义
     */
    @FrameField(len = 32)
    private Ascii filePath;

    /**
     * 执行控制 BIN 码 1
     * 0x01：立即执行
     * 0x02：空闲执行
     */
    @FrameField(len = 1)
    private int execType;

    /**
     * 下载超时时间 BIN 码 1 单位：min
     */
    @FrameField(len = 1)
    private int downloadTime;
}
