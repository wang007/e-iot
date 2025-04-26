package io.github.eiot.ocpp.exception;

import io.github.eiot.exception.IotException;

/**
 * created by wang007 on 2025/4/26
 */
public class OcppErrorCodeMissException extends IotException {

    public OcppErrorCodeMissException() {
    }

    public OcppErrorCodeMissException(String message) {
        super(message);
    }

    public OcppErrorCodeMissException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcppErrorCodeMissException(Throwable cause) {
        super(cause);
    }

    public OcppErrorCodeMissException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
