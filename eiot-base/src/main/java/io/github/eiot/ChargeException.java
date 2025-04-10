package io.github.eiot;

/**
 * created by wang007 on 2025/3/9
 */
public class ChargeException extends RuntimeException {

    public ChargeException() {
    }

    public ChargeException(String message) {
        super(message);
    }

    public ChargeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChargeException(Throwable cause) {
        super(cause);
    }

    public ChargeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
