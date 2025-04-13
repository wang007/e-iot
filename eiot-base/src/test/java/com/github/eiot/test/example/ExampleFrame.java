package com.github.eiot.test.example;

import io.github.eiot.Frame;
import io.github.eiot.RequestFrame;
import io.github.eiot.codec.BCD;
import io.github.eiot.codec.Hex;

/**
 * byteOrder: LITTLE_ENDIAN
 * format:
 * 2 byte type: Hex, header: AAF5
 * 6 byte type: BCD, terminalNo
 * 1 byte messageType
 * 2 byte seqNo
 * 2 byte len
 * N byte data.
 *
 * created by wang007 on 2025/4/12
 */
public interface ExampleFrame<T> extends Frame<T> {

    Hex header();

    /**
     * rename terminalNo
     */
    BCD terminalNo0();

    int sequenceNo();

    ExampleFrame<T> sequenceNo(int seqNo);

    <Resp> RequestFrame<T, ExampleFrame<Resp>> asRequest() throws IllegalStateException;
}
