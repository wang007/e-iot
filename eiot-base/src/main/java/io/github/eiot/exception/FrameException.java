package io.github.eiot.exception;

import io.github.eiot.Frame;

/**
 * created by wang007 on 2025/6/30
 */
public class FrameException  extends IotException {

    private final String terminalNo;
    private final Frame<?> frame;

    public FrameException(String terminalNo, Frame<?> frame) {
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public FrameException(String terminalNo, Frame<?> frame, String message) {
        super("terminalNo: " + terminalNo + " " + message);
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public FrameException(String terminalNo, Frame<?> frame, String message, Throwable cause) {
        super("terminalNo: " + terminalNo + " " + message, cause);
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public FrameException(String terminalNo, Frame<?> frame, Throwable cause) {
        super(cause);
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public Frame<?> getFrame() {
        return frame;
    }
}
