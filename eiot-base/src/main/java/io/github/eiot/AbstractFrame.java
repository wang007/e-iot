package io.github.eiot;


import io.github.eiot.annotation.FrameUtil;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;

import java.util.Map;

/**
 * abstract frame for concrete frame
 * <p>
 * {@link #isRaw()} must be false
 * <p>
 * created by wang007 on 2025/3/15
 */
public abstract class AbstractFrame<V, F extends AbstractRawFrame> implements Frame<V> {

    private final F rawFrame;
    private final CommandDef<V> commandDef;

    private V data;

    /**
     * use for {@link Side#SENDER} write.
     *
     * @param connection the connection
     * @param commandDef the command
     */
    public AbstractFrame(IotConnection connection, CommandDef<V> commandDef) {
        rawFrame = initRawFrame(connection, commandDef.command());
        this.commandDef = commandDef;
    }

    public AbstractFrame(F frame, CommandDef<V> commandDef) {
        this.rawFrame = frame;
        this.commandDef = commandDef;
    }

    /**
     * init raw frame for {@link Side#SENDER}
     *
     * @param connection the connection
     * @param command    the command
     * @return
     */
    protected abstract F initRawFrame(IotConnection connection, String command);

    public CommandDef<V> commandDef() {
        return this.commandDef;
    }

    /**
     * @return the delegate frame
     */
    public final F rawFrame() {
        return rawFrame;
    }

    @Override
    public Map<String, Object> attributes() {
        return rawFrame().attributes();
    }

    @Override
    public String command() {
        return rawFrame().command();
    }

    @Override
    public String terminalNo() {
        return rawFrame().terminalNo();
    }

    @Override
    public Side side() {
        return rawFrame().side();
    }

    @Override
    public boolean checkCodeResult() {
        return rawFrame().checkCodeResult();
    }

    @Override
    public Future<Void> write() {
        return iotConnection().write(this);
    }

    @Override
    public IotConnection iotConnection() {
        return rawFrame().iotConnection();
    }

    @Override
    public ByteBuf toByteBuf() {
        return rawFrame().toByteBuf();
    }

    @Override
    public int rawDataSize() {
        return rawFrame().rawDataSize();
    }

    @Override
    public V data() {
        if (this.data != null) {
            return this.data;
        }
        // sender without data
        if (rawFrame.isSender()) {
            return null;
        }
        ByteBuf byteBuf = rawFrame.data();
        V v = FrameUtil.decode(commandDef.dataType(), byteBuf);
        this.data = v;
        return v;
    }

    @Override
    public Frame<V> data(V v) {
        ByteBuf byteBuf = FrameUtil.encode(commandDef().dataType(), v);
        rawFrame.data(byteBuf);
        this.data = v;
        return this;
    }

    @Override
    public V newData() {
        return FrameUtil.newInstance(commandDef.dataType());
    }

    @Override
    public boolean isRaw() {
        return false;
    }

    @Override
    public String toRawString() {
        return rawFrame.toRawString();
    }
}
