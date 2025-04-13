package com.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;

/**
 * created by wang007 on 2025/4/13
 */
@Frame
public class ExampleHeartbeatResponse {

    @FrameField(len = 1)
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
