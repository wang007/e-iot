package io.github.eiot.exception;

import io.github.eiot.Frame;

/**
 * created by wang007 on 2025/3/9
 */
public class ConvertIotException extends FrameException {

    public ConvertIotException(String terminalNo, Frame<?> frame) {
        super(terminalNo, frame);
    }

    public ConvertIotException(String terminalNo, Frame<?> frame, String message) {
        super(terminalNo, frame, message);
    }

    public ConvertIotException(String terminalNo, Frame<?> frame, String message, Throwable cause) {
        super(terminalNo, frame, message, cause);
    }

    public ConvertIotException(String terminalNo, Frame<?> frame, Throwable cause) {
        super(terminalNo, frame, cause);
    }
}
