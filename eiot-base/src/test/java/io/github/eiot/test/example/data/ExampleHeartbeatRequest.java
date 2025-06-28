package io.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.BCDTime;
import java.time.LocalDateTime;

/**
 * created by wang007 on 2025/4/13
 */
@Frame
public class ExampleHeartbeatRequest {

    @FrameField
    private BCDTime time;

    /**
     * 0: ok
     * 1. fault
     */
    @FrameField(len = 1)
    private int status;

    /**
     * getter auto generated
     */
    public BCDTime getTime() {
        return time;
    }

    /**
     * setter auto generated
     */
    public void setTime(BCDTime time) {
        this.time = time;
    }

    /**
     * getter auto generated
     */
    public int getStatus() {
        return status;
    }

    /**
     * setter auto generated
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
