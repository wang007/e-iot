package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;

/**
 * 远程更新 0x94
 * <p>
 * 对桩进行软件升级，平台升级模式为 ftp 文件升级，由桩企提供升级需要的更新文件（特定文
 * 件名，由桩企定义），平台在数据帧中提供访问更新文件相关服务器地址及下载路径信息，桩
 * 下载完更新程序后对文件进行较验，并对桩进行升级。
 * <p>
 * created by wang007 on 2025/3/21
 */
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

    /**
     * getter auto generated
     */
    public int getPileType() {
        return pileType;
    }

    /**
     * setter auto generated
     */
    public void setPileType(int pileType) {
        this.pileType = pileType;
    }

    /**
     * getter auto generated
     */
    public int getPileP() {
        return pileP;
    }

    /**
     * setter auto generated
     */
    public void setPileP(int pileP) {
        this.pileP = pileP;
    }

    /**
     * getter auto generated
     */
    public Ascii getServerHost() {
        return serverHost;
    }

    /**
     * setter auto generated
     */
    public void setServerHost(Ascii serverHost) {
        this.serverHost = serverHost;
    }

    /**
     * setter auto generated
     */
    public void setServerHost(String serverHost) {
        io.github.eiot.utils.ValidationUtil.lteLen(serverHost, 16, serverHost);
        this.serverHost = Ascii.from(serverHost, 16);
    }

    /**
     * getter auto generated
     */
    public int getServerPort() {
        return serverPort;
    }

    /**
     * setter auto generated
     */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * getter auto generated
     */
    public Ascii getUsername() {
        return username;
    }

    /**
     * setter auto generated
     */
    public void setUsername(Ascii username) {
        this.username = username;
    }

    /**
     * setter auto generated
     */
    public void setUsername(String username) {
        io.github.eiot.utils.ValidationUtil.lteLen(username, 16, username);
        this.username = Ascii.from(username, 16);
    }

    /**
     * getter auto generated
     */
    public Ascii getPassword() {
        return password;
    }

    /**
     * setter auto generated
     */
    public void setPassword(Ascii password) {
        this.password = password;
    }

    /**
     * setter auto generated
     */
    public void setPassword(String password) {
        io.github.eiot.utils.ValidationUtil.lteLen(password, 16, password);
        this.password = Ascii.from(password, 16);
    }

    /**
     * getter auto generated
     */
    public Ascii getFilePath() {
        return filePath;
    }

    /**
     * setter auto generated
     */
    public void setFilePath(Ascii filePath) {
        this.filePath = filePath;
    }

    /**
     * setter auto generated
     */
    public void setFilePath(String filePath) {
        io.github.eiot.utils.ValidationUtil.lteLen(filePath, 32, filePath);
        this.filePath = Ascii.from(filePath, 32);
    }

    /**
     * getter auto generated
     */
    public int getExecType() {
        return execType;
    }

    /**
     * setter auto generated
     */
    public void setExecType(int execType) {
        this.execType = execType;
    }

    /**
     * getter auto generated
     */
    public int getDownloadTime() {
        return downloadTime;
    }

    /**
     * setter auto generated
     */
    public void setDownloadTime(int downloadTime) {
        this.downloadTime = downloadTime;
    }
}
