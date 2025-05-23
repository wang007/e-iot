package com.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;

/**
 * created by wang007 on 2025/4/13
 */
@Frame
public class ExampleLoginResponse {

    /**
     * 0: success 1. failed
     */
    @FrameField(len = 1)
    private int result;

    /**
     * getter auto generated
     */
    public int getResult() {
        return result;
    }

    /**
     * setter auto generated
     */
    public void setResult(int result) {
        this.result = result;
    }
}
