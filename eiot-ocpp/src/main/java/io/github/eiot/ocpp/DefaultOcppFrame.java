package io.github.eiot.ocpp;

import io.github.eiot.*;
import io.github.eiot.annotation.FrameUtil;
import io.github.eiot.ocpp.json.Json;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * ocpp frame impl
 * <p>
 * created by wang007 on 2025/5/8
 */
public class DefaultOcppFrame<T> implements OcppFrame<T> {

    private final OcppConnection connection;
    private final CommandDef<T> commandDef;
    private final RawOcppFrame rawFrame;

    private T data;

    public DefaultOcppFrame(IotConnection connection, CommandDef<T> commandDef) {
        this.connection = (OcppConnection) connection;
        this.commandDef = commandDef;
        this.rawFrame = RawOcppFrame.new4Sender(this.connection, commandDef.command(), null);
    }

    public DefaultOcppFrame(RawOcppFrame rawFrame, CommandDef<T> commandDef) {
        this.connection = (OcppConnection) rawFrame.iotConnection();
        this.commandDef = commandDef;
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
        return connection.terminalNo();
    }

    @Override
    public T data() {
        if (data != null) {
            return data;
        }
        if (rawFrame.side() == Side.SENDER) {
            return null;
        }
        JsonObject data = rawFrame.data();
        if (data == null) {
            return null;
        }
        T value = Json.OM.convertValue(data.getMap(), commandDef.dataType());
        this.data = value;
        return value;
    }

    @Override
    public int rawDataSize() {
        return 0;
    }

    @Override
    public Side side() {
        return rawFrame.side();
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
        return null;
    }

    @Override
    public String toRawString() {
        if (rawFrame.side() == Side.RECEIVER) {
            return rawFrame.toRawString();
        }
        Object value = this.data;
        if (value == null) {
            value = RawOcppFrame.EmptyJson;
        }
        return rawFrame.toRawString(value);
    }

    @Override
    public T newData() {
        return FrameUtil.newInstance(commandDef.dataType());
    }

    @Override
    public boolean isRaw() {
        return true;
    }

    @Override
    public <Resp> RequestFrame<T, ? extends Frame<Resp>> asRequest() throws IllegalStateException {
        // TODO
        return null;
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
    public OcppFrame<T> data(T t) {
        this.data = t;
        // not set to raw frame to reduce serialize json
        return this;
    }

    @Override
    public Future<Void> send() {
        rawFrame.checkSendAndSwitch();
        return connection.write(this);
    }

    @Override
    public boolean failed() {
        return rawFrame.failed();
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
        return null;
    }

    @Override
    public OcppFrame<Void> newResulErrorFrame(OcppError errorCode, String errorDescription, JsonObject errorDetails) throws UnsupportedOperationException {
        return null;
    }
}
