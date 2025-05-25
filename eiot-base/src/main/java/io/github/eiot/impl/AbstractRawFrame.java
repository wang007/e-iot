package io.github.eiot.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.Side;
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
public abstract class AbstractRawFrame implements Frame<ByteBuf> {

    private final Map<String, Object> attributes = new ConcurrentHashMap<>(4, 1.0f);

    protected final IotConnection connection;
    protected final Side side;
    protected final String command;

    private ByteBuf frameByteBuf;
    // control call genByteBuf()
    private boolean dirty;

    private ByteBuf data;

    public AbstractRawFrame(IotConnection connection, Side side, String command) {
        this.connection = connection;
        this.side = side;
        this.command = command;
    }

    @Override
    public Map<String, Object> attributes() {
        return this.attributes;
    }

    @Override
    public String command() {
        return command;
    }

    @Override
    public final ByteBuf data() {
        if (this.data != null) {
            return this.data.retainedSlice();
        }
        this.data = decodeData();
        return data.retainedSlice();
    }

    protected abstract ByteBuf decodeData();

    @Override
    public final Frame<ByteBuf> data(ByteBuf t) {
        ensureWriteable(true);
        encodeData(t);
        this.data = t;
        return this;
    }

    protected abstract void encodeData(ByteBuf t);


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
        return byteBuf.retainedSlice();
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
