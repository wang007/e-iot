package io.github.eiot.exception;

/**
 * created by wang007 on 2025/3/9
 */
public class IotException extends RuntimeException {

    public IotException() {
    }

    public IotException(String message) {
        super(message);
    }

    public IotException(String message, Throwable cause) {
        super(message, cause);
    }

    public IotException(Throwable cause) {
        super(cause);
    }

    public IotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
