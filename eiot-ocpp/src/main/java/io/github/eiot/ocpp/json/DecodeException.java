package io.github.eiot.ocpp.json;

/**
 * json解码异常
 *
 * created by wang007 on 2019/8/1
 */
public class DecodeException extends RuntimeException {

    public DecodeException() {
    }

    public DecodeException(String message) {
        super(message);
    }

    public DecodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecodeException(Throwable cause) {
        super(cause);
    }

    public DecodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
