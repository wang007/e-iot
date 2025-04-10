package io.github.eiot.charge.ykc.data;


import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import lombok.Data;
import lombok.ToString;

/**
 * 登录认证应答 0x02
 *
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcLoginResponse extends YkcBaseData {

    /**
     * 登陆结果 BIN 码 1 0x00：登陆成功 0x01:登陆失败
     */
    @FrameField(len = 1)
    private int result;

}
