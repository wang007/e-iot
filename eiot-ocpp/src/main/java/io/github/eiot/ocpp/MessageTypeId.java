package io.github.eiot.ocpp;

/**
 * ocpp message type id
 * <p>
 * <p>
 * <p>
 * 4.4. Extension fallback mechanism
 * (Updated in OCPP 2.1)
 * Future versions of OCPP might add extra Message Types (other then CALL, CALLRESULT, CALLERROR, CALLRESULTERROR and
 * SEND.)
 * When a system receives a message with a Message Type Number not in this list, it SHALL ignore the message payload. (See also
 * paragraph The message type).
 * <p>
 * <p>
 * created by wang007 on 2025/4/15
 */
public enum MessageTypeId {

    /**
     * Request message, i.e. messages ending in "Request"
     */
    CALL(2),

    /**
     * Response message, i.e. message ending in "Response"
     */
    CALLRESULT(3),

    /**
     * Error response to a request message
     */
    CALLERROR(4),

    /**
     * (2.1) Error response to a response message
     * NOTE: only support ocpp2.1 or later
     */
    CALLRESULTERROR(5),

    /**
     * (2.1) Unconfirmed message without response, i.e. messages not ending in
     * "Request" or "Response"
     * NOTE: only support ocpp2.1 or later
     */
    SEND(6),
    ;

    public final int value;

    MessageTypeId(int value) {
        this.value = value;
    }

    /**
     * match message type id, error value or new version value return null
     *
     * @param value the value
     * @return the message type id
     */
    public static MessageTypeId match(int value) {
        for (MessageTypeId messageTypeId : values()) {
            if (messageTypeId.value == value) {
                return messageTypeId;
            }
        }
        return null;
    }
}
