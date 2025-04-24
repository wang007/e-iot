package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * created by wang007 on 2025/4/25
 */
public class RawOcppFrame extends AbstractRawFrame<String> implements OcppFrame<String> {


    public RawOcppFrame(OcppConnection connection, Side side, String messageType) {
        super(connection, side, messageType);
    }


    @Override
    public OcppFrame<String> data(String s) {
        super.data(s);
        return this;
    }

    @Override
    protected String decodeData() {
        return null;
    }

    @Override
    protected void encodeData(String s) {

    }

    @Override
    protected ByteBuf genByteBuf() {
        return null;
    }

    @Override
    public String terminalNo() {
        return null;
    }

    @Override
    public int rawDataSize() {
        return 0;
    }

    @Override
    public boolean checkCodeResult() {
        return false;
    }

    @Override
    public String newData() {
        return null;
    }

    @Override
    public <Resp> RequestFrame<String, ? extends Frame<Resp>> asRequest() throws IllegalStateException {
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
