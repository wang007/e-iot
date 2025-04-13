package com.github.eiot.test.example;

import io.github.eiot.*;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.Hex;

/**
 * created by wang007 on 2025/4/12
 */
public class DefaultExampleFrame<T> extends AbstractFrame<T, RawExampleFrame> implements ExampleFrame<T> {

    public DefaultExampleFrame(IotConnection connection, MessageType<T> messageTypeEnum) {
        super(connection, messageTypeEnum);
    }

    public DefaultExampleFrame(RawExampleFrame frame, MessageType<T> messageTypeEnum) {
        super(frame, messageTypeEnum);
    }

    @Override
    protected RawExampleFrame initRawFrame(IotConnection connection, String messageType) {
        return RawExampleFrame.new4Sender(connection, messageType);
    }

    @Override
    public <Resp> RequestFrame<T, ExampleFrame<Resp>> asRequest() throws IllegalStateException {
        return new ExampleRequestFrame<>(this);
    }

    @Override
    public Hex header() {
        return rawFrame().header();
    }

    @Override
    public BCD terminalNo0() {
        return rawFrame().terminalNo0();
    }

    @Override
    public int sequenceNo() {
        return rawFrame().sequenceNo();
    }

    @Override
    public ExampleFrame<T> sequenceNo(int seqNo) {
        rawFrame().sequenceNo(seqNo);
        return this;
    }
}
