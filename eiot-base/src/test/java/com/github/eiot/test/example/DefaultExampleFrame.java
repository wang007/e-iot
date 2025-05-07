package com.github.eiot.test.example;

import io.github.eiot.*;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.Hex;

/**
 * created by wang007 on 2025/4/12
 */
public class DefaultExampleFrame<T> extends AbstractFrame<T, RawExampleFrame> implements ExampleFrame<T> {

    public DefaultExampleFrame(IotConnection connection, CommandDef<T> commandDef) {
        super(connection, commandDef);
    }

    public DefaultExampleFrame(RawExampleFrame frame, CommandDef<T> commandDef) {
        super(frame, commandDef);
    }

    @Override
    protected RawExampleFrame initRawFrame(IotConnection connection, String command) {
        return RawExampleFrame.new4Sender(connection, command);
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
