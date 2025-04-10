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
    private final MessageType<V> messageTypeEnum;

    private V data;

    /**
     * use for {@link Side#SENDER} write.
     *
     * @param connection      the connection
     * @param messageTypeEnum the messageType
     */
    public AbstractFrame(IotConnection connection, MessageType<V> messageTypeEnum) {
        rawFrame = initRawFrame(connection, messageTypeEnum.messageType());
        this.messageTypeEnum = messageTypeEnum;
    }

    public AbstractFrame(F frame, MessageType<V> messageTypeEnum) {
        this.rawFrame = frame;
        this.messageTypeEnum = messageTypeEnum;
    }

    /**
     * init raw frame for {@link Side#SENDER}
     *
     * @param connection  the connection
     * @param messageType the messageType
     * @return
     */
    protected abstract F initRawFrame(IotConnection connection, String messageType);

    public MessageType<V> messageTypeEnum() {
        return this.messageTypeEnum;
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
    public String messageType() {
        return rawFrame().messageType();
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
    public V data() {
        if (this.data != null) {
            return this.data;
        }
        ByteBuf byteBuf = rawFrame.data();
        V v = newDate();
        FrameUtil.decode(messageTypeEnum.dataType(), v, byteBuf);
        this.data = v;
        return v;
    }

    @Override
    public Frame<V> data(V v) {
        ByteBuf byteBuf = FrameUtil.encode(messageTypeEnum().dataType(), v);
        rawFrame.data(byteBuf);
        this.data = v;
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V newDate() {
        return (V) FrameUtil.newInstance(messageTypeEnum.dataType());
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
