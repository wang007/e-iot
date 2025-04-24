package io.github.eiot;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.vertx.core.Future;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * abstract for raw frame
 * <p>
 * The data field is usually byteBuf
 * <p>
 * {@link #isRaw()} must be true
 * <p>
 * created by wang007 on 2025/3/14
 */
public abstract class AbstractRawFrame<T> implements Frame<T> {

    private final Map<String, Object> attributes = new ConcurrentHashMap<>(4, 1.0f);

    protected final IotConnection connection;
    protected final Side side;
    protected final String messageType;

    private ByteBuf frameByteBuf;
    // control call genByteBuf()
    private boolean dirty;

    private T data;

    public AbstractRawFrame(IotConnection connection, Side side, String messageType) {
        this.connection = connection;
        this.side = side;
        this.messageType = messageType;
    }

    @Override
    public Map<String, Object> attributes() {
        return this.attributes;
    }

    @Override
    public String messageType() {
        return messageType;
    }

    @Override
    public final T data() {
        if (this.data != null) {
            return this.data;
        }
        this.data = decodeData();
        return data;
    }

    protected abstract T decodeData();

    @Override
    public Frame<T> data(T t) {
        ensureWriteable(true);
        encodeData(t);
        this.data = t;
        return this;
    }

    protected abstract void encodeData(T t);


    @Override
    public Side side() {
        return side;
    }

    protected void ensureWriteable(boolean update) {
        if (side == Side.RECEIVER) {
            throw new IllegalStateException("receiver frame not write");
        }
        if (update) {
            dirty = true;
        }
    }

    protected final boolean isReceiver() {
        return side == Side.RECEIVER;
    }

    protected final boolean isSender() {
        return side == Side.SENDER;
    }

    @Override
    public final ByteBuf toByteBuf() {
        ByteBuf byteBuf;
        if (dirty || this.frameByteBuf == null) {
            byteBuf = genByteBuf();
            this.frameByteBuf = byteBuf;
            this.dirty = false;
        } else {
            byteBuf = this.frameByteBuf;
        }
        return byteBuf.slice();
    }

    @Override
    public String toRawString() {
        ByteBuf byteBuf = toByteBuf();
        if (byteBuf == null) {
            return null;
        }
        return ByteBufUtil.hexDump(byteBuf);
    }

    protected abstract ByteBuf genByteBuf();


    @Override
    public Future<Void> write() {
        ensureWriteable(false);
        return connection.write(this);
    }

    @Override
    public IotConnection iotConnection() {
        return connection;
    }

    @Override
    public boolean isRaw() {
        return true;
    }


}
