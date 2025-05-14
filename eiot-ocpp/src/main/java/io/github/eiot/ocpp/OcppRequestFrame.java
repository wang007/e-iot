package io.github.eiot.ocpp;

import io.github.eiot.CommandDef;
import io.github.eiot.impl.RequestFrameBase;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

/**
 * created by wang007 on 2025/4/22
 */
public class OcppRequestFrame<Req, Resp> extends RequestFrameBase<Req, OcppFrame<Resp>> implements OcppFrame<Req> {

    public static final String REQUEST_FRAME_COMMAND_KEY = "__request_command";

    private final DefaultOcppFrame<Req> ocppFrame;

    public OcppRequestFrame(DefaultOcppFrame<Req> frame) {
        super(frame);
        this.ocppFrame = frame;
    }

    @SuppressWarnings("unchecked")
    @Override
    public OcppRequestFrame<Req, Resp> asRequest() throws IllegalStateException {
        return this;
    }

    @Override
    public OcppRequestFrame<Req, Resp> data(Req req) {
        ocppFrame.data(req);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public OcppFrame<Resp> responseFrame() {
        CommandDef<Resp> commandDef = (CommandDef<Resp>) ocppFrame.commandDef().responseType();
        return new DefaultOcppFrame<>(ocppFrame.iotConnection(), commandDef);
    }

    @Override
    public MessageTypeId messageTypeId() {
        return ocppFrame.messageTypeId();
    }

    @Override
    public String messageId() {
        return ocppFrame.messageId();
    }

    @Override
    public Future<Void> send() {
        return ocppFrame.send();
    }

    @Override
    public boolean failed() {
        return ocppFrame.failed();
    }

    @Override
    public OcppError errorCode() {
        return ocppFrame.errorCode();
    }

    @Override
    public String errorDescription() {
        return ocppFrame.errorDescription();
    }

    @Override
    public JsonObject errorDetails() {
        return ocppFrame.errorDetails();
    }

    @Override
    public OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        return ocppFrame.newErrorFrame(errorCode, errorDescription, errorDetails);
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError ocppError, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
        return ocppFrame.newResulErrorFrame(ocppError, errorDescription, errorDetails);
    }

    @Override
    public Future<ErrorOcppFrame> writeResultAwaitError(int timeoutMs) {
        return ocppFrame.writeResultAwaitError(timeoutMs);
    }
}
