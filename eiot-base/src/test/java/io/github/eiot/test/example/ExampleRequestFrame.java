package io.github.eiot.test.example;

import io.github.eiot.*;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.Hex;
import io.github.eiot.impl.RequestFrameBase;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleRequestFrame<Req, Resp> extends RequestFrameBase<Req, Resp, ExampleFrame<Resp>> implements ExampleFrame<Req> {

    private final DefaultExampleFrame<Req> frame;

    public ExampleRequestFrame(DefaultExampleFrame<Req> frame, RequestCommandDef<Req, Resp> requestCommand) {
        super(frame, requestCommand);
        this.frame = frame;
    }

    @Override
    public ExampleFrame<Resp> responseFrame() {
        CommandDef<Resp> responseCommand = requestCommand.responseType();
        DefaultExampleFrame<Resp> responseFrame = new DefaultExampleFrame<Resp>(iotConnection(), responseCommand);
        responseFrame.sequenceNo(sequenceNo());
        return responseFrame;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <Resp> ExampleRequestFrame<Req, Resp> asRequest(RequestCommandDef<Req, Resp> requestCommand) {
        return (ExampleRequestFrame<Req, Resp>) this;
    }

    @Override
    public ExampleRequestFrame<Req, Resp> data(Req data) {
        super.data(data);
        return this;
    }

    @Override
    public Hex header() {
        return frame.header();
    }

    @Override
    public BCD terminalNo0() {
        return frame.terminalNo0();
    }

    @Override
    public int sequenceNo() {
        return frame.sequenceNo();
    }

    @Override
    public ExampleRequestFrame<Req, Resp> sequenceNo(int seqNo) {
        frame.sequenceNo(seqNo);
        return this;
    }

}
