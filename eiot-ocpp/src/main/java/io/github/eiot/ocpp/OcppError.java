package io.github.eiot.ocpp;

/**
 * ocpp error
 *
 * created by wang007 on 2025/4/16
 */
public enum OcppError {

    /**
     * Payload for Action is syntactically incorrect
     */
    FormatViolation("FormatViolation"),

    /**
     * Any other error not covered by the more specific error codes in this table
     */
    GenericError("GenericError"),

    /**
     * An internal error occurred and the receiver was not able to process the requested Action
     * successfully
     */
    InternalError("InternalError"),

    /**
     * Requested Action is not known by receiver
     */
    NotImplemented("NotImplemented"),

    /**
     * Requested Action is recognized but not supported by the receiver
     */
    NotSupported("NotSupported"),

    /**
     * Payload for Action is syntactically correct but at least one of the fields violates occurrence
     * constraints
     */
    OccurrenceConstraintViolation("OccurrenceConstraintViolation"),

    /**
     * Payload is syntactically correct but at least one field contains an invalid value
     */
    PropertyConstraintViolation("PropertyConstraintViolation"),

    /**
     * Payload for Action is not conform the PDU structure
     */
    ProtocolError("ProtocolError"),

    /**
     * During the processing of Action a security issue occurred preventing receiver from
     * completing the Action successfully
     */
    SecurityError("SecurityError"),

    /**
     * Payload for Action is syntactically correct but at least one of the fields violates data type
     * constraints (e.g. "somestring": 12)
     *
     *
     */
    TypeConstraintViolation("TypeConstraintViolation"),

    /**
     * Content of the call is not a valid RPC Request, for example: MessageId could not be read.
     *
     * ONTE: only support ocpp 2.1 or later
     */
    RpcFrameworkError("RpcFrameworkError"),

    /**
     * A message with an Message Type Number received that is not supported by this
     * implementation.
     *
     * ONTE: only support ocpp 2.1 or later
     */
    MessageTypeNotSupported("MessageTypeNotSupported"),
    ;


    public final String value;

    OcppError(String value) {
        this.value = value;
    }
}
