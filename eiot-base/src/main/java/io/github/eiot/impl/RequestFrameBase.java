package io.github.eiot.impl;

import io.github.eiot.Frame;
import io.github.eiot.IotConnection;
import io.github.eiot.RequestFrame;
import io.github.eiot.Side;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.util.Map;

/**
 * created by wang007 on 2025/3/15
 */
public abstract class RequestFrameBase<Req, ResFrame extends Frame<?>> implements RequestFrame<Req, ResFrame> {

    private final Promise<ResFrame> promise;

    protected final CommandDefFrame<Req> frame;

    public RequestFrameBase(CommandDefFrame<Req> frame) {
        if (frame.commandDef().responseType() == null) {
            throw new IllegalStateException("Current frame is not request type");
        }
        promise = frame.side() == Side.SENDER ? Promise.promise() : null;
        this.frame = frame;
    }

    public Frame<Req> delegateFrame() {
        return frame;
    }

    @Override
    public String responseCommand() {
        return frame.commandDef().responseType().command();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Future<ResFrame> request() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
        }
        Future<Frame<?>> future = iotConnection().request((RequestFrame<?, Frame<?>>) this);
        return (Future<ResFrame>) future;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Future<ResFrame> request(int timeout) {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
        }
        Future<Frame<?>> future = iotConnection().request((RequestFrame<?, Frame<?>>) this, timeout);
        return (Future<ResFrame>) future;
    }

    @Override
    public Future<ResFrame> requestResult() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
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
        return frame.isRaw();
    }


    @Override
    public Map<String, Object> attributes() {
        return frame.attributes();
    }

    @Override
    public String command() {
        return frame.command();
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
