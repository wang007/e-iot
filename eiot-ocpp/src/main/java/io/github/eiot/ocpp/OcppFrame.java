package io.github.eiot.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.RequestFrame;
import io.github.eiot.ocpp.exception.OcppProtocolUnsupportedException;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

/**
 * ocpp frame represent ocpp message
 * <p>
 * created by wang007 on 2025/2/26
 */
public interface OcppFrame<T> extends Frame<T> {

    static <T> OcppFrame<T> create(IotConnection connection, CommandDef<T> commandDef) {
        return new DefaultOcppFrame<T>(connection, commandDef);
    }

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
        return command();
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
     * Write {@link MessageTypeId#CALLRESULT} frame and await {@link MessageTypeId#CALLRESULTERROR} frame response.
     * If ignore {@link MessageTypeId#CALLRESULT} frame result, just use it {@link #write()} instead of.
     *
     * <p>
     * When the peer receives a {@link MessageTypeId#CALLRESULT} frame and processes it, it may return a {@link MessageTypeId#CALLRESULTERROR} frame or not.
     * <p>
     * When the peer returns {@link MessageTypeId#CALLRESULTERROR} frame, future result will return {@link MessageTypeId#CALLRESULTERROR} frame.
     * <p>
     * When the peer does not return, the local waiting for the result of the call result error will time out. At this time, the future result will return null,
     * indicating that the peer has not returned the call Result error frame or the response has timed out
     * <p>
     * NOTE: only supoort ocpp2.1 or later
     *
     * @return the future
     */
    default Future<ErrorOcppFrame> writeResultAwaitError() {
        return writeResultAwaitError(0);
    }

    /**
     * {@link #writeResultAwaitError()} but timeout can be declared
     *
     * @param timeoutMs the timeout ms
     * @return the future
     */
    Future<ErrorOcppFrame> writeResultAwaitError(int timeoutMs);

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
     *
     * @param errorCode        the error code
     * @param errorDescription the errorDescription
     * @return new error frame
     */
    default OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription) {
        return newErrorFrame(errorCode, errorDescription, null);
    }

    /**
     * like {@link #newErrorFrame(OcppError, String, JsonObject)}
     *
     * @param errorCode the error code
     * @return new error frame
     */
    default OcppFrame<Void> newErrorFrame(OcppError errorCode) {
        return newErrorFrame(errorCode, null);
    }


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
     * @param errorCode        the error code
     * @param errorDescription the errorDescription
     * @param errorDetails     the errorDetails
     * @return new result error frame
     * @throws UnsupportedOperationException if not support
     */
    OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException;

    /**
     * like {@link #newResulErrorFrame(OcppError, String, JsonObject)}
     *
     * @param errorCode        the error code
     * @param errorDescription the errorDescription
     * @return new result error frame
     */
    default OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription) throws UnsupportedOperationException {
        return newResulErrorFrame(errorCode, errorDescription, null);
    }

    /**
     * like {@link #newResulErrorFrame(OcppError, String, JsonObject)}
     *
     * @param errorCode the error code
     * @return new result error frame
     */
    default OcppFrame<Void> newResulErrorFrame(OcppError errorCode) throws UnsupportedOperationException {
        return newResulErrorFrame(errorCode, null);
    }

    @Override
    <Resp> OcppRequestFrame<T, Resp> asRequest() throws IllegalStateException;

    @Override
    default <Resp> OcppRequestFrame<T, Resp> asRequest(Class<Resp> responseType) throws IllegalStateException {
        return asRequest();
    }
}
