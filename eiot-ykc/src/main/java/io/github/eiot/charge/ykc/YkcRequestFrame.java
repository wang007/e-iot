package io.github.eiot.charge.ykc;

import io.github.eiot.MessageType;
import io.github.eiot.RequestFrame;
import io.github.eiot.RequestFrameBase;
import io.github.eiot.codec.Hex;

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
        DefaultYkcFrame<Resp> responseFrame = new DefaultYkcFrame<>(iotConnection(), messageType);
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
    public YkcRequestFrame<Req, Resp> sequenceNo(int seqNo) {
        ykcFrame.sequenceNo(seqNo);
        return this;
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
    public YkcRequestFrame<Req, Resp> checkCode(int checkCode) {
        ykcFrame.checkCode(checkCode);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RequestFrame<Req, YkcFrame<Resp>> asRequest() {
        return this;
    }

}
