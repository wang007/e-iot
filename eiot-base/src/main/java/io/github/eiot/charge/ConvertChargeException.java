package io.github.eiot.charge;

/**
 * created by wang007 on 2025/3/9
 */
public class ConvertChargeException extends ChargeException {

    private final String terminalNo;
    private final Frame<?> frame;

    public ConvertChargeException(String terminalNo, Frame<?> frame) {
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public ConvertChargeException(String terminalNo, Frame<?> frame, String message) {
        super("terminalNo: " + terminalNo + " " + message);
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public ConvertChargeException(String terminalNo, Frame<?> frame, String message, Throwable cause) {
        super("terminalNo: " + terminalNo + " " + message, cause);
        this.terminalNo = terminalNo;
        this.frame = frame;
    }

    public ConvertChargeException(String terminalNo, Frame<?> frame, Throwable cause) {
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
