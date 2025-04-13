package com.github.eiot.test.example.data;

import io.github.eiot.annotation.Frame;
import io.github.eiot.annotation.FrameField;
import io.github.eiot.codec.Ascii;
import io.github.eiot.codec.BCD;
import io.github.eiot.utils.StringUtil;

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

    public Ascii getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("username");
        }
        username = StringUtil.leftPad(username, 10, '0');
        setUsername(Ascii.from(username));
    }

    public void setUsername(Ascii username) {
        this.username = username;
    }

    public BCD getCard() {
        return card;
    }

    public void setCard(String card) {
        if (card.length() > 16) {
            throw new IllegalArgumentException("username");
        }
        card = StringUtil.leftPad(card, 16, '0');
        setCard(BCD.from(card));
    }

    public void setCard(BCD card) {
        this.card = card;
    }

    public int getSafeMode() {
        return safeMode;
    }

    public void setSafeMode(int safeMode) {
        this.safeMode = safeMode;
    }
}
