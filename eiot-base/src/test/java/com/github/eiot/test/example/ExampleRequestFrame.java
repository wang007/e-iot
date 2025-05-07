package com.github.eiot.test.example;

import io.github.eiot.*;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.Hex;

/**
 * created by wang007 on 2025/4/12
 */
public class ExampleRequestFrame<Req, Resp> extends RequestFrameBase<Req, ExampleFrame<Resp>> implements ExampleFrame<Req> {

    private final DefaultExampleFrame<Req> frame;

    public ExampleRequestFrame(DefaultExampleFrame<Req> frame) {
        super(frame);
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RequestFrame<Req, ExampleFrame<Resp>> asRequest() throws IllegalStateException {
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ExampleFrame<Resp> responseFrame() {
        CommandDef<Resp> messageType = (CommandDef<Resp>) frame.commandDef().responseType();
        DefaultExampleFrame<Resp> responseFrame = new DefaultExampleFrame<Resp>(iotConnection(), messageType);
        responseFrame.sequenceNo(sequenceNo());
        return responseFrame;
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
