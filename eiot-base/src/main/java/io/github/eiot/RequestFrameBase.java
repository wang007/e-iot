package io.github.eiot;

import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.util.Map;

/**
 * created by wang007 on 2025/3/15
 */
public abstract class RequestFrameBase<Req, ResFrame extends Frame<?>> implements RequestFrame<Req, ResFrame> {

    private final Promise<ResFrame> promise;

    protected final AbstractFrame<Req, ? extends Frame<?>> frame;

    public RequestFrameBase(AbstractFrame<Req, ? extends Frame<?>> frame) {
        if (frame.messageTypeEnum().responseType() == null) {
            throw new IllegalStateException("Current frame is not request type");
        }
        promise = frame.side() == Side.SENDER ? Promise.promise() : null;
        this.frame = frame;
    }

    public Frame<Req> delegateFrame() {
        return frame;
    }

    @Override
    public String responseMessageType() {
        return frame.messageTypeEnum().responseType().messageType();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Future<ResFrame> send() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not send.");
        }
        Future<Frame<?>> future = iotConnection().send((RequestFrame<?, Frame<?>>) this);
        return (Future<ResFrame>) future;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Future<ResFrame> send(int timeout) {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not send.");
        }
        Future<Frame<?>> future = iotConnection().send((RequestFrame<?, Frame<?>>) this, timeout);
        return (Future<ResFrame>) future;
    }

    @Override
    public Future<ResFrame> sendResult() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not send.");
        }
        return promise.future();
    }

    @Override
    public boolean trySetResponseResult(ResFrame frame, Throwable ex) {
        if (ex != null) {
            return promise.tryFail(ex);
        }
        return promise.tryComplete(frame);
    }

    @Override
    public boolean isRaw() {
        return false;
    }


    @Override
    public Map<String, Object> attributes() {
        return frame.attributes();
    }

    @Override
    public String messageType() {
        return frame.messageType();
    }

    @Override
    public String terminalNo() {
        return frame.terminalNo();
    }

    @Override
    public Req data() {
        return frame.data();
    }

    @Override
    public RequestFrameBase<Req, ResFrame> data(Req req) {
         frame.data(req);
         return this;
    }

    @Override
    public int rawDataSize() {
        return frame.rawDataSize();
    }

    @Override
    public Side side() {
        return frame.side();
    }

    @Override
    public boolean checkCodeResult() {
        return frame.checkCodeResult();
    }

    @Override
    public Future<Void> write() {
        return frame.write();
    }

    @Override
    public IotConnection iotConnection() {
        return frame.iotConnection();
    }

    @Override
    public ByteBuf toByteBuf() {
        return frame.toByteBuf();
    }

    @Override
    public String toRawString() {
        return frame.toRawString();
    }

    @Override
    public Req newData() {
        return frame.newData();
    }
}
