package io.github.eiot.charge.ykc.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;

/**
 * 后台远程下发二维码前缀指令  0xF0
 *
 * created by wang007 on 2025/3/21
 */
@Frame(withContext = true)
public class YkcQrCodeRequest extends YkcBaseData {

    /**
     * 二维码格式 BIN 码 1
     * 0x00：第一种前缀+桩编号
     * 0x01：第二种前缀+桩编号+枪编号
     */
    @FrameField(len = 1)
    private int type;

    /**
     * 二维码前缀长度
     * BIN 码 1 二维码前缀长度长度最大不超过
     * 200 字节
     */
    @FrameField(len = 1, intoContext = true)
    private int prefixLen;

    /**
     * 二维码前缀 ASCII 可变 如：“www.baidu.com？No=”
     */
    @FrameField(lenByField = "prefixLen")
    private Ascii qrCodePrefix;

    /**
     * getter auto generated
     */
    public int getType() {
        return type;
    }

    /**
     * setter auto generated
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * getter auto generated
     */
    public int getPrefixLen() {
        return prefixLen;
    }

    /**
     * setter auto generated
     */
    public void setPrefixLen(int prefixLen) {
        this.prefixLen = prefixLen;
    }

    /**
     * getter auto generated
     */
    public Ascii getQrCodePrefix() {
        return qrCodePrefix;
    }

    /**
     * setter auto generated
     */
    public void setQrCodePrefix(Ascii qrCodePrefix) {
        this.qrCodePrefix = qrCodePrefix;
    }

    /**
     * setter auto generated
     */
    public void setQrCodePrefix(String qrCodePrefix) {
        this.qrCodePrefix = Ascii.from(qrCodePrefix);
    }
}
