package io.github.eiot.charge;


import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;

import java.util.Map;

/**
 * abstract frame for concrete frame
 *
 * {@link #isRaw()} must be false
 *
 * created by wang007 on 2025/3/15
 */
public abstract class AbstractFrame<V, F extends Frame<?>> implements Frame<V> {

    private final F rawFrame;
    private final MessageTypeEnum messageTypeEnum;

    /**
     * use for {@link Side#SENDER} write.
     *
     * @param connection  the connection
     * @param messageTypeEnum the messageType
     */
    public AbstractFrame(ChargeConnection connection, MessageTypeEnum messageTypeEnum) {
        rawFrame = initRawFrame(connection, messageTypeEnum.messageType());
        this.messageTypeEnum = messageTypeEnum;
    }

    public AbstractFrame(F frame, MessageTypeEnum messageTypeEnum) {
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
    protected abstract F initRawFrame(ChargeConnection connection, String messageType);

    public MessageTypeEnum messageTypeEnum() {
        return this.messageTypeEnum;
    }

    /**
     * @return the delegate frame
     */
    protected final F rawFrame() {
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
        return rawFrame().write();
    }

    @Override
    public ChargeConnection chargeConnection() {
        return rawFrame().chargeConnection();
    }

    @Override
    public ByteBuf toByteBuf() {
        return rawFrame().toByteBuf();
    }

    @Override
    public V data() {
        // TODO
        return null;
    }

    @Override
    public Frame<V> data(V v) {
        // TODO
        return this;
    }

    @Override
    public V newDate() {
        // TODO 反射获取

        return null;
    }

    @Override
    public boolean isRaw() {
        return false;
    }

}
