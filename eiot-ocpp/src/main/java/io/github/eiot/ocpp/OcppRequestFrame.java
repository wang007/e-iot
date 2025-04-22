package io.github.eiot.ocpp;

import io.github.eiot.AbstractFrame;
import io.github.eiot.Frame;
import io.github.eiot.RequestFrameBase;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

/**
 *
 *
 * created by wang007 on 2025/4/22
 */
public class OcppRequestFrame<Req, Resp> extends RequestFrameBase<Req, OcppFrame<Resp>> implements OcppFrame<Req> {

    public OcppRequestFrame(AbstractFrame<Req, ? extends Frame<?>> frame) {
        super(frame);
    }

    @SuppressWarnings("unchecked")
    @Override
    public OcppRequestFrame<Req, Resp> asRequest() throws IllegalStateException {
        return this;
    }

    @Override
    public OcppRequestFrame<Req, Resp> data(Req req) {


        return this;
    }

    @Override
    public OcppFrame<Resp> responseFrame() {
        return null;
    }

    @Override
    public MessageTypeId messageTypeId() {
        return null;
    }

    @Override
    public String messageId() {
        return null;
    }

    @Override
    public Future<Void> send() {
        return null;
    }

    @Override
    public boolean failed() {
        return false;
    }

    @Override
    public OcppError errorCode() {
        return null;
    }

    @Override
    public String errorDescription() {
        return null;
    }

    @Override
    public JsonObject errorDetails() {
        return null;
    }

    @Override
    public OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) {
        return null;
    }

    @Override
    public OcppFrame<Void> newErrorFrame(OcppError errorCode, String errorDescription) {
        return null;
    }

    @Override
    public OcppFrame<Void> newErrorFrame(OcppError errorCode) {
        return null;
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError ocppError, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError ocppError, String errorDescription) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError ocppError) throws UnsupportedOperationException {
        return null;
    }
}
