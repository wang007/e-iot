package io.github.eiot.charge.ykc;

import io.github.eiot.charge.*;
import io.github.eiot.charge.codec.Hex;
import io.vertx.core.Promise;

/**
 * created by wang007 on 2025/3/16
 */
public class YkcRequestFrame<Req, Resp> extends RequestFrameBase<Req, YkcFrame<Resp>> implements YkcFrame<Req> {

    private final YkcFrame<Req> ykcFrame;

    public YkcRequestFrame(DefaultYkcFrame<Req> frame) {
        super(frame);
        this.ykcFrame = frame;
    }

    @SuppressWarnings("unchecked")
    @Override
    public YkcFrame<Resp> responseFrame() {
        MessageType<Resp> messageType = (MessageType<Resp>) frame.messageTypeEnum().responseType();
        DefaultYkcFrame<Resp> responseFrame = new DefaultYkcFrame<Resp>(chargeConnection(), messageType);
        responseFrame.sequenceNo(sequenceNo());
        return responseFrame;
    }

    @Override
    public Hex start() {
        return ykcFrame.start();
    }

    @Override
    public int sequenceNo() {
        return ykcFrame.sequenceNo();
    }

    @Override
    public YkcFrame<Req> sequenceNo(int seqNo) {
        return ykcFrame.sequenceNo(seqNo);
    }

    @Override
    public int cryptType() {
        return ykcFrame.cryptType();
    }

    @Override
    public Hex rawMessageType() {
        return ykcFrame.rawMessageType();
    }

    @Override
    public int checkCode() {
        return ykcFrame.checkCode();
    }

    @Override
    public YkcFrame<Req> checkCode(int checkCode) {
        return ykcFrame.checkCode(checkCode);
    }

    @SuppressWarnings("unchecked")
    @Override
    public RequestFrame<Req, YkcFrame<Resp>> asRequest() {
        return this;
    }

}
