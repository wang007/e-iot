package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.github.eiot.ocpp.exception.OcppErrorCodeMissException;
import io.github.eiot.ocpp.exception.OcppProtocolUnsupportedException;
import io.github.eiot.ocpp.impl.OcppConnectionImpl;
import io.github.eiot.ocpp.json.Json;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * created by wang007 on 2025/4/25
 */
public class RawOcppFrame implements OcppFrame<JsonObject> {

    private static final JsonObject EmptyJson = new JsonObject(Collections.emptyMap());


    private final Map<String, Object> attributes = new ConcurrentHashMap<>(4, 1.0f);
    private final OcppConnection connection;
    private final Side side;
    private final String command;

    private MessageTypeId messageTypeId;
    private String messageId;
    private JsonObject data;        // payload
    private OcppError errorCode;
    private String errorDescription;
    private JsonObject errorDetails;

    RawOcppFrame(OcppConnection connection, Side side,
                 MessageTypeId messageTypeId, String messageId,
                 String command, JsonObject data,
                 OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        this.connection = connection;
        this.side = side;
        this.messageTypeId = messageTypeId;
        this.messageId = messageId;
        this.command = command;
        this.data = data;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorDetails = errorDetails;
    }

    RawOcppFrame(OcppConnection connection, Side side,
                 MessageTypeId messageTypeId, String messageId,
                 String command, JsonObject data) {
        this(connection, side, messageTypeId, messageId, command, data, null, null, null);
    }

    public static RawOcppFrame new4ErrorResultFrame(OcppConnection connection, String messageId,
                                                    OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALLRESULTERROR, messageId,
                null, null,
                errorCode, errorDescription, errorDetails);
    }

    public static RawOcppFrame new4ErrorFrame(OcppConnection connection, String messageId,
                                              OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALLERROR, messageId,
                null, null,
                errorCode, errorDescription, errorDetails);
    }

    public static RawOcppFrame new4Sender(OcppConnection connection, String command, OcppFrame<?> receiver) {
        // not response frame
        if (receiver == null) {
            return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALL, ((OcppConnectionImpl) connection).nextMessageId(), command, null);
        }
        // for new response frame
        String messageId = receiver.messageId();
        return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALLRESULT, messageId, null, null);
    }

    public static RawOcppFrame new4Receiver(OcppConnection connection, String frameData) {
        JsonArray array = new JsonArray(frameData);
        Integer messageTypIdNum = array.getInteger(0);

        MessageTypeId messageTypeId = MessageTypeId.match(messageTypIdNum);
        // maybe later version not support.
        if (messageTypeId == null) {
            return null;
        }

        String messageId = array.getString(1);
        switch (messageTypeId) {
            case SEND:
                if (!connection.ocppVersion().supportSend()) {
                    throw new OcppProtocolUnsupportedException("current connection ocpp version: " + connection.ocppVersion().versionName + " not support to receive sendFrame");
                }
            case CALL:
                String messageType = array.getString(2);
                JsonObject data = array.size() > 3 ? array.getJsonObject(3) : new JsonObject();
                return new RawOcppFrame(connection, Side.RECEIVER, messageTypeId, messageId, messageType, data);
            case CALLRESULT:
                String resultMessageType = array.getString(2);
                JsonObject resultData = array.size() > 2 ? array.getJsonObject(2) : new JsonObject();
                return new RawOcppFrame(connection, Side.RECEIVER, messageTypeId, messageId, resultMessageType, resultData);
            case CALLRESULTERROR:
                if (!connection.ocppVersion().supportResultError()) {
                    throw new OcppProtocolUnsupportedException("current connection ocpp version: " + connection.ocppVersion().versionName + " not support to receive resultErrorFrame");
                }
            case CALLERROR:
                int size = array.size();
                OcppError errorCode = null;
                if (size > 2) {
                    String errorCodeStr = array.getString(2);
                    errorCode = OcppError.match(errorCodeStr);
                    if (errorCode == null) {
                        throw new OcppErrorCodeMissException("errorCode: " + errorCodeStr + " not match");
                    }
                }
                String errorDescription = null;
                if (size > 3) {
                    errorDescription = array.getString(3);
                }
                JsonObject errorDetails = null;
                if (size > 4) {
                    errorDetails = array.getJsonObject(4);
                }
                return new RawOcppFrame(connection, Side.RECEIVER, messageTypeId, messageId, null, null,
                        errorCode, errorDescription, errorDetails);
        }
        return null;
    }


    @Override
    public Map<String, Object> attributes() {
        return attributes;
    }


    @Override
    public String command() {
        return command;
    }

    @Override
    public String terminalNo() {
        return connection.terminalNo();
    }

    @Override
    public JsonObject data() {
        return data != null ? data : new JsonObject();
    }

    @Override
    public int rawDataSize() {
        return 0;
    }

    @Override
    public Side side() {
        return side;
    }

    @Override
    public boolean checkCodeResult() {
        return true;
    }

    @Override
    public Future<Void> write() {
        return connection.write(this);
    }

    @Override
    public IotConnection iotConnection() {
        return connection;
    }

    @Override
    public ByteBuf toByteBuf() {
        byte[] bytes = toRawString().getBytes(StandardCharsets.UTF_8);
        return Unpooled.wrappedBuffer(bytes);
    }

    @Override
    public String toRawString() {
        return toRawString(data);
    }

    public String toRawString(Object data) {
        List<Object> list = new ArrayList<>();
        list.add(messageTypeId.value);
        list.add(messageId);
        switch (messageTypeId) {
            case SEND:
            case CALL:
                list.add(command);
            case CALLRESULT:
                list.add(data == null ? EmptyJson : data);
                break;
            case CALLRESULTERROR:
            case CALLERROR:
                list.add(errorCode.value);
                list.add(errorDescription != null ? errorDescription : "");
                list.add(errorDetails != null ? errorDetails : EmptyJson);
        }
        return Json.toJson(list);
    }



    @Override
    public JsonObject newData() {
        return new JsonObject();
    }

    @Override
    public boolean isRaw() {
        return true;
    }

    @Override
    public <Resp> OcppRequestFrame<JsonObject, Resp> asRequest() throws IllegalStateException {
        throw new IllegalStateException("raw frame not support");
    }

    @Override
    public MessageTypeId messageTypeId() {
        return messageTypeId;
    }

    @Override
    public String messageId() {
        return messageId;
    }

    @Override
    public OcppFrame<JsonObject> data(JsonObject data) {
        this.data = data;
        return this;
    }

    private boolean isReceiver() {
        return side == Side.RECEIVER;
    }

    private boolean isSender() {
        return side == Side.SENDER;
    }


    protected void checkSendAndSwitch() {
        if (isReceiver()) {
            throw new IllegalStateException("receiver frame not support to send");
        }
        if (!ocppVersion().supportSend()) {
            throw new UnsupportedOperationException("current connection ocpp version: " + ocppVersion().versionName + " not support to send");
        }
        if (messageTypeId != MessageTypeId.CALL && messageTypeId != MessageTypeId.SEND) {
            throw new IllegalStateException("messageTypeId: " + messageTypeId.name() + " not support to send");
        }
        messageTypeId = MessageTypeId.SEND; // maybe current CALL
    }

    @Override
    public Future<Void> send() {
        checkSendAndSwitch();
        return connection.write(this);
    }

    @Override
    public boolean failed() {
        return messageTypeId == MessageTypeId.CALLERROR || messageTypeId == MessageTypeId.CALLRESULTERROR;
    }

    @Override
    public OcppError errorCode() {
        return errorCode;
    }

    @Override
    public String errorDescription() {
        return errorDescription;
    }

    @Override
    public JsonObject errorDetails() {
        return errorDetails;
    }

    @Override
    public OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        if (isSender()) {
            throw new IllegalStateException("sender frame not support to send error frame");
        }
        RawOcppFrame rawOcppFrame = new4ErrorFrame(connection, messageId, errorCode, errorDescription, errorDetails);
        return new ErrorOcppFrame(rawOcppFrame);
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
        if (isSender()) {
            throw new IllegalStateException("sender frame not support to send result error frame");
        }
        if (!ocppVersion().supportResultError()) {
            throw new UnsupportedOperationException("current connection ocpp version: " + ocppVersion().versionName + " not support result error frame");
        }
        RawOcppFrame rawOcppFrame = new4ErrorResultFrame(connection, messageId, errorCode, errorDescription, errorDetails);
        return new ErrorOcppFrame(rawOcppFrame);
    }
}
