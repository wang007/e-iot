package com.github.eiot.test.example.data;

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

    public BCDTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = BCDTime.from(time);
    }

    public void setTime(BCDTime time) {
        this.time = time;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
