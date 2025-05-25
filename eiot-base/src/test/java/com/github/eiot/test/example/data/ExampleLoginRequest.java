package com.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.*;

/**
 * created by wang007 on 2025/4/12
 */
@Frame
public class ExampleLoginRequest {

    @FrameField(len = 10)
    public Ascii username;

    @FrameField(len = 8)
    private BCD card;

    @FrameField(len = 1)
    public int safeMode;

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
        io.github.eiot.utils.ValidationUtil.lteLen(username, 10, username);
        this.username = Ascii.from(username, 10);
    }

    /**
     * getter auto generated
     */
    public BCD getCard() {
        return card;
    }

    /**
     * setter auto generated
     */
    public void setCard(BCD card) {
        this.card = card;
    }

    /**
     * setter auto generated
     */
    public void setCard(String card) {
        io.github.eiot.utils.ValidationUtil.lteLen(card, 16, card);
        this.card = BCD.from(card, 16);
    }

    /**
     * getter auto generated
     */
    public int getSafeMode() {
        return safeMode;
    }

    /**
     * setter auto generated
     */
    public void setSafeMode(int safeMode) {
        this.safeMode = safeMode;
    }
}
