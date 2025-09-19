package io.github.eiot.impl;

import io.github.eiot.*;
import io.netty.buffer.ByteBuf;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.util.Map;

/**
 * created by wang007 on 2025/3/15
 */
public abstract class RequestFrameBase<Req, Resp, RespFrame extends Frame<Resp>> implements RequestFrame<Req, Resp> {

    private final Promise<RespFrame> promise;

    protected final CommandDefFrame<Req> frame;

    protected final RequestCommandDef<Req, Resp> requestCommand;

    public RequestFrameBase(CommandDefFrame<Req> frame, RequestCommandDef<Req, Resp> requestCommand) {
        this.requestCommand = requestCommand;
        promise = frame.side() == Side.SENDER ? Promise.promise() : null;
        this.frame = frame;
    }

    public Frame<Req> delegateFrame() {
        return frame;
    }

    @Override
    public String responseCommand() {
        return requestCommand.responseType().command();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Future<RespFrame> request() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
        }
        Future<Frame<?>> future = iotConnection().request(this);
        return (Future<RespFrame>) future;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Future<RespFrame> request(int timeout) {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
        }
        Future<Frame<?>> future = iotConnection().request(this, timeout);
        return (Future<RespFrame>) future;
    }

    @Override
    public Future<RespFrame> requestResult() {
        if (promise == null) {
            throw new IllegalStateException("receiver frame not request.");
        }
        return promise.future();
    }

    @Override
    public RequestFrameBase<Req, Resp, RespFrame> data(Req req) {
        frame.data(req);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean trySetResponseResult(Frame<?> frame, Throwable ex) {
        if (ex != null) {
            return promise.tryFail(ex);
        }
        return promise.tryComplete((RespFrame) frame);
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
