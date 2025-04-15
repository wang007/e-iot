package io.github.eiot.exception;

/**
 * created by wang007 on 2025/4/16
 */
public class EncodeException extends IotException {

    public EncodeException() {
    }

    public EncodeException(String message) {
        super(message);
    }

    public EncodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EncodeException(Throwable cause) {
        super(cause);
    }

    public EncodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
