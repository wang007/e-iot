package io.github.eiot.ocpp.exception;

import io.github.eiot.exception.IotException;

/**
 * created by wang007 on 2025/4/16
 */
public class OcppProtocolUnsupportedException extends IotException {

    public OcppProtocolUnsupportedException() {
    }

    public OcppProtocolUnsupportedException(String message) {
        super(message);
    }

    public OcppProtocolUnsupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcppProtocolUnsupportedException(Throwable cause) {
        super(cause);
    }

    public OcppProtocolUnsupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
