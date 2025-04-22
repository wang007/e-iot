package io.github.eiot.ocpp;

import io.github.eiot.Frame;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

/**
 * ocpp frame represent ocpp message
 * <p>
 * created by wang007 on 2025/2/26
 */
public interface OcppFrame<T> extends Frame<T> {

    /**
     * @return @return the ocpp version
     */
    default OcppVersion ocppVersion() {
        OcppConnection connection = (OcppConnection) iotConnection();
        return connection.ocppVersion();
    }

    /**
     * @return message type id
     */
    MessageTypeId messageTypeId();

    /**
     * In ocpp1.6, it is also called UniqueId
     *
     * @return messageId(UniqueId)
     */
    String messageId();

    /**
     * @return ocpp message action
     */
    default String action() {
        return messageType();
    }

    /**
     * @return alias for {@link #data()}
     */
    default T payload() {
        return data();
    }

    /**
     * alias for {@link #data(Object)}
     *
     * @param payload the payload
     * @return this
     */
    default OcppFrame<T> payload(T payload) {
        return data(payload);
    }

    @Override
    OcppFrame<T> data(T t);

    /**
     * send current frame.
     * Call {@link OcppVersion#supportSend()} method to determine whether the current method is supported
     * <p>
     * NOTE: only support ocpp2.1 or later
     *
     * @return send result if unsupported send()
     * return {@link Future#failedFuture(Throwable)} carries an {@link OcppProtocolUnsupportedException}
     */
    Future<Void> send();

    /**
     * the current frame is error frame or result error frame.
     * see {@link MessageTypeId#CALLERROR} and {@link MessageTypeId#CALLRESULTERROR}
     *
     * @return whether the current frame is error frame or result error frame.
     */
    boolean failed();

    /**
     * return error code if the current frame messageTypeId is {@link MessageTypeId#CALLERROR} or {@link MessageTypeId#CALLRESULTERROR}
     *
     * @return if not {@link #failed()} return null
     */
    OcppError errorCode();

    /**
     * return error description if the current frame messageTypeId is {@link MessageTypeId#CALLERROR} or {@link MessageTypeId#CALLRESULTERROR}
     *
     * @return if not {@link #failed()} return null
     */
    String errorDescription();

    /**
     * return error details if the current frame messageTypeId is {@link MessageTypeId#CALLERROR} or {@link MessageTypeId#CALLRESULTERROR}
     *
     * @return if not {@link #failed()} return null
     */
    JsonObject errorDetails();


    /**
     * new error frame for current frame to response error result.
     * ocpp error frame format: [<MessageTypeId>, "<MessageId>", "<errorCode>", "<errorDescription>", {<errorDetails>}]
     *
     * @param errorCode        the error code
     * @param errorDescription the errorDescription
     * @param errorDetails     the errorDetails
     * @return new error frame
     */
    OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails);

    /**
     * like {@link #newErrorFrame(OcppError, String, JsonObject)}
     */
    OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription);


    OcppFrame<Void> newErrorFrame(OcppError errorCode);


    /**
     * Error response to a response message.
     * ocpp result error frame format: [<MessageTypeId>, "<MessageId>", "<errorCode>", "<errorDescription>", {<errorDetails>}]
     *
     * <p>
     * see {@link MessageTypeId#CALLERROR}
     * Call {@link OcppVersion#supportResultError()} method to determine whether the current method is supported
     * <p>
     * NOTE: only support {@link OcppVersion#OCPP2_1} or later
     *
     * @return new result error frame
     * @throws UnsupportedOperationException if not support
     */
    OcppFrame<Void> newResulErrorFrame(OcppError ocppError, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException;

    /**
     * like {@link #newResulErrorFrame(OcppError, String, JsonObject)}
     */
    OcppFrame<Void> newResulErrorFrame(OcppError ocppError, String errorDescription) throws UnsupportedOperationException;

    /**
     * like {@link #newResulErrorFrame(OcppError, String, JsonObject)}
     */
    OcppFrame<Void> newResulErrorFrame(OcppError ocppError) throws UnsupportedOperationException;
}
