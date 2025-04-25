package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.github.eiot.ocpp.impl.OcppConnectionImpl;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * created by wang007 on 2025/4/25
 */
public class RawOcppFrame extends AbstractRawFrame<String> implements OcppFrame<String> {

    private static final JsonObject EmptyJson = new JsonObject(Collections.emptyMap());

    private MessageTypeId messageTypeId;
    private String messageId;
    private String messageType; // action
    private String data;        // payload
    private OcppError errorCode;
    private String errorDescription;
    private JsonObject errorDetails;

    RawOcppFrame(OcppConnection connection, Side side,
                        MessageTypeId messageTypeId, String messageId,
                        String messageType, String data,
                        OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        super(connection, side, messageType);
        this.messageTypeId = messageTypeId;
        this.messageId = messageId;
        this.messageType = messageType;
        this.data = data;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorDetails = errorDetails;
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

    public static RawOcppFrame new4Sender(OcppConnection connection, String messageType, OcppFrame<?> receiver) {
        // not response frame
        if (receiver == null) {
            // TODO ((OcppConnectionImpl)connection).nextMessageId()
            return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALL, null,
                    messageType, null, null, null, null);
        }
        // for new response frame
        String messageId = receiver.messageId();
        return new RawOcppFrame(connection, Side.SENDER, MessageTypeId.CALLRESULT, messageId,
                null, null, null, null, null);
    }

    public static RawOcppFrame new4Receiver(OcppConnection connection, String frameData) {

        return null;
    }

    @Override
    public OcppFrame<String> data(String s) {
        super.data(s);
        return this;
    }

    @Override
    protected String decodeData() {
        return data;
    }

    @Override
    protected void encodeData(String s) {
        this.data = s;
    }

    @Override
    protected ByteBuf genByteBuf() {
        // TODO
        return null;
    }

    @Override
    public String terminalNo() {
        return ((OcppConnection)connection).terminalNo();
    }

    @Override
    public int rawDataSize() {
        return 0;
    }

    @Override
    public boolean checkCodeResult() {
        return true;
    }

    @Override
    public String newData() {
        return "";
    }

    @Override
    public <Resp> RequestFrame<String, ? extends Frame<Resp>> asRequest() throws IllegalStateException {
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
    public String toRawString() {
        List<Object> list = new ArrayList<>();
        list.add(messageTypeId.value);
        // TODO toString
        return null;
    }

    @Override
    public Future<Void> send() {
        if (isReceiver()) {
            throw new IllegalStateException("receiver frame not support to send");
        }
        if (!ocppVersion().supportSend()) {
            throw new IllegalStateException("current connection ocpp version: " + ocppVersion().versionName + " not support to send");
        }
        if (messageTypeId != MessageTypeId.CALL && messageTypeId != MessageTypeId.SEND) {
            throw new IllegalStateException("messageTypeId: " + messageTypeId.name() + " not support to send");
        }
        messageTypeId = MessageTypeId.SEND; // maybe current CALL
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
        RawOcppFrame rawOcppFrame = new4ErrorFrame((OcppConnection) connection, messageId, errorCode, errorDescription, errorDetails);
        return new ErrorOcppFrame(rawOcppFrame);
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
        if (isSender()) {
            throw new IllegalStateException("sender frame not support to send result error frame");
        }
        if (!ocppVersion().supportResultError()) {
            throw new IllegalStateException("current connection ocpp version: " + ocppVersion().versionName + " not support result error frame");
        }
        RawOcppFrame rawOcppFrame = new4ErrorResultFrame((OcppConnection) connection, messageId, errorCode, errorDescription, errorDetails);
        return new ErrorOcppFrame(rawOcppFrame);
    }


    static class ErrorOcppFrame implements OcppFrame<Void> {

        private final RawOcppFrame rawFrame;

        ErrorOcppFrame(RawOcppFrame rawFrame) {
            this.rawFrame = rawFrame;
        }

        @Override
        public Map<String, Object> attributes() {
            return rawFrame.attributes();
        }

        @Override
        public String messageType() {
            return rawFrame.messageType();
        }

        @Override
        public String terminalNo() {
            return rawFrame.terminalNo();
        }

        @Override
        public Void data() {
            return null;
        }

        @Override
        public int rawDataSize() {
            return rawFrame.rawDataSize();
        }

        @Override
        public Side side() {
            return rawFrame.side();
        }

        @Override
        public boolean checkCodeResult() {
            return rawFrame.checkCodeResult();
        }

        @Override
        public Future<Void> write() {
            return rawFrame.write();
        }

        @Override
        public IotConnection iotConnection() {
            return rawFrame.iotConnection();
        }

        @Override
        public ByteBuf toByteBuf() {
            return rawFrame.toByteBuf();
        }

        @Override
        public String toRawString() {
            return rawFrame.toRawString();
        }

        @Override
        public Void newData() {
            return null;
        }

        @Override
        public boolean isRaw() {
            return rawFrame.isRaw();
        }

        @Override
        public <Resp> RequestFrame<Void, ? extends Frame<Resp>> asRequest() throws IllegalStateException {
            throw new IllegalStateException("error frame not support request");
        }

        @Override
        public MessageTypeId messageTypeId() {
            return rawFrame.messageTypeId();
        }

        @Override
        public String messageId() {
            return rawFrame.messageId();
        }

        @Override
        public OcppFrame<Void> data(Void unused) {
            return null;
        }

        @Override
        public Future<Void> send() {
            return rawFrame.send();
        }

        @Override
        public boolean failed() {
            return true;
        }

        @Override
        public OcppError errorCode() {
            return rawFrame.errorCode();
        }

        @Override
        public String errorDescription() {
            return rawFrame.errorDescription();
        }

        @Override
        public JsonObject errorDetails() {
            return rawFrame.errorDetails();
        }

        @Override
        public OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) {
            return rawFrame.newErrorFrame(errorCode, errorDescription, errorDetails);
        }

        @Override
        public OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
            return rawFrame.newResulErrorFrame(errorCode, errorDescription, errorDetails);
        }

    }
}
