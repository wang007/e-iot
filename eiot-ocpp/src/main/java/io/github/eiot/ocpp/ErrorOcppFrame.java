package io.github.eiot.ocpp;

import io.github.eiot.IotConnection;
import io.github.eiot.Side;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * created by wang007 on 2025/4/26
 */
public class ErrorOcppFrame implements OcppFrame<Void> {

    private final RawOcppFrame rawFrame;

    public ErrorOcppFrame(RawOcppFrame rawFrame) {
        this.rawFrame = rawFrame;
    }

    @Override
    public Map<String, Object> attributes() {
        return rawFrame.attributes();
    }

    @Override
    public String command() {
        return rawFrame.command();
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
    public OcppConnection iotConnection() {
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
    public <Resp> OcppRequestFrame<Void, Resp> asRequest() throws IllegalStateException {
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

    @Override
    public Future<ErrorOcppFrame> writeResultAwaitError(int timeoutMs) {
        throw new IllegalStateException("error ocpp frame not allow write as result");
    }

    @Override
    public String toString() {
        return rawFrame.toString();
    }
}
