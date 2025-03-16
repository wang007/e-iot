package io.github.eiot.charge;

import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * abstract for raw frame
 *
 * The data field is usually byteBuf
 *
 * {@link #isRaw()} must be true
 *
 * created by wang007 on 2025/3/14
 */
public abstract class AbstractRawFrame<T> implements Frame<T> {

    private final Map<String, Object> attributes = new ConcurrentHashMap<>(4, 1.0f);

    protected final ChargeConnection connection;
    protected final Side side;
    protected final String messageType;

    private ByteBuf frameByteBuf;
    // control call genByteBuf()
    private boolean dirty;

    private T data;

    public AbstractRawFrame(ChargeConnection connection, Side side, String messageType) {
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
        T data;
        synchronized (this) {
            if (this.data != null) {
                return this.data;
            }
            data = decodeData();
            this.data = data;
        }
        return data;
    }

    protected abstract T decodeData();

    @Override
    public final Frame<T> data(T t) {
        ensureWriteable(true);
        encodeData(t);
        synchronized (this) {
            this.data = t;
        }
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
            synchronized (this) {
                dirty = true;
            }
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
        synchronized (this) {
            if (dirty || this.frameByteBuf == null) {
                byteBuf = genByteBuf();
                this.frameByteBuf = byteBuf;
                this.dirty = false;
            } else {
                byteBuf = this.frameByteBuf;
            }
        }
        return byteBuf.slice();
    }

    protected abstract ByteBuf genByteBuf();


    @Override
    public Future<Void> write() {
        ensureWriteable(false);
        return connection.write(this);
    }

    @Override
    public ChargeConnection chargeConnection() {
        return connection;
    }

    @Override
    public boolean isRaw() {
        return true;
    }


}
