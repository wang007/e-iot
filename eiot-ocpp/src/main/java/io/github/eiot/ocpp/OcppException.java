package io.github.eiot.ocpp;

import io.github.eiot.exception.IotException;

/**
 * created by wang007 on 2025/4/26
 */
public class OcppException extends IotException  {

    public OcppException() {
    }

    public OcppException(String message) {
        super(message);
    }

    public OcppException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcppException(Throwable cause) {
        super(cause);
    }

    public OcppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
