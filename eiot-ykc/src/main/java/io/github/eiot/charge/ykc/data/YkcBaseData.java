package io.github.eiot.charge.ykc.data;

import io.github.eiot.charge.annotation.Frame;
import io.github.eiot.charge.annotation.FrameField;
import io.github.eiot.charge.codec.BCD;
import io.github.eiot.charge.utils.StringUtil;
import lombok.Data;
import lombok.ToString;

/**
 * created by wang007 on 2024/11/11
 */
@ToString
@Data
@Frame
public class YkcBaseData {

    /**
     * 桩编码 BCD 码 7byte
     */
    @FrameField(len = 7)
    private BCD terminalNo;

    public void setTerminalNoString(String terminalNo) {
        terminalNo = StringUtil.leftPad(terminalNo, 14, '0');
        setTerminalNo(BCD.from(terminalNo));
    }
}
