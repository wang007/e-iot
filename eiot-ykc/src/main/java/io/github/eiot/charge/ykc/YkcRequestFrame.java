package io.github.eiot.charge.ykc;

import io.github.eiot.CommandDef;
import io.github.eiot.RequestCommandDef;
import io.github.eiot.impl.RequestFrameBase;
import io.github.eiot.codec.Hex;

/**
 * created by wang007 on 2025/3/16
 */
public class YkcRequestFrame<Req, Resp> extends RequestFrameBase<Req, Resp, YkcFrame<Resp>> implements YkcFrame<Req> {

    private final YkcFrame<Req> ykcFrame;

    public YkcRequestFrame(DefaultYkcFrame<Req> frame, RequestCommandDef<Req, Resp> requestCommand) {
        super(frame, requestCommand);
        this.ykcFrame = frame;
    }

    @Override
    public YkcFrame<Resp> responseFrame() {
        CommandDef<Resp> commandDef = requestCommand.responseType();
        DefaultYkcFrame<Resp> responseFrame = new DefaultYkcFrame<>(iotConnection(), commandDef);
        responseFrame.sequenceNo(sequenceNo());
        return responseFrame;
    }

    @Override
    public YkcRequestFrame<Req, Resp> sequenceNo(int seqNo) {
        ykcFrame.sequenceNo(seqNo);
        return this;
    }

    @Override
    public YkcRequestFrame<Req, Resp> checkCode(int checkCode) {
        ykcFrame.checkCode(checkCode);
        return this;
    }

    @Override
    public YkcRequestFrame<Req, Resp> data(Req req) {
        super.data(req);
        return this;
    }

    public <Resp1> YkcRequestFrame<Req, Resp1> asRequest(RequestCommandDef<Req, Resp1> requestCommand) {
        return (YkcRequestFrame<Req, Resp1>) this;
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
    public int cryptType() {
        return ykcFrame.cryptType();
    }

    @Override
    public Hex rawCommand() {
        return ykcFrame.rawCommand();
    }

    @Override
    public int checkCode() {
        return ykcFrame.checkCode();
    }

}
