package io.github.eiot.exception;

import io.github.eiot.Frame;

/**
 * created by wang007 on 2025/6/30
 */
public class CheckCodeException extends FrameException {


    public CheckCodeException(String terminalNo, Frame<?> frame) {
        super(terminalNo, frame);
    }

    public CheckCodeException(String terminalNo, Frame<?> frame, String message) {
        super(terminalNo, frame, message);
    }

    public CheckCodeException(String terminalNo, Frame<?> frame, String message, Throwable cause) {
        super(terminalNo, frame, message, cause);
    }

    public CheckCodeException(String terminalNo, Frame<?> frame, Throwable cause) {
        super(terminalNo, frame, cause);
    }
}
