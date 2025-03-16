package io.github.eiot.charge.ykc;

import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Frame;
import io.github.eiot.charge.AbstractFrame;
import io.github.eiot.charge.MessageTypeEnum;
import io.github.eiot.charge.codec.Hex;

/**
 * created by wang007 on 2025/3/16
 */
public class DefaultYkcFrame<T> extends AbstractFrame<T, RawYkcFrame> implements YkcFrame<T> {


    public DefaultYkcFrame(ChargeConnection connection, MessageTypeEnum messageTypeEnum) {
        super(connection, messageTypeEnum);
    }

    public DefaultYkcFrame(RawYkcFrame frame, MessageTypeEnum messageTypeEnum) {
        super(frame, messageTypeEnum);
    }


    @Override
    public int checkCode() {
        return 0;
    }

    @Override
    public YkcFrame<T> checkCode(int checkCode) {
        return null;
    }

    @Override
    public T data() {

        return null;
    }

    @Override
    public Frame<T> data(T t) {
        return null;
    }

    @Override
    public Hex start() {
        return null;
    }

    @Override
    public int rawDataSize() {
        return 0;
    }

    @Override
    public int sequenceNo() {
        return 0;
    }

    @Override
    public YkcFrame<T> sequenceNo(int seqNo) {
        return null;
    }

    @Override
    public int cryptType() {
        return 0;
    }

    @Override
    public Hex rawMessageType() {
        return null;
    }


    @Override
    protected RawYkcFrame initRawFrame(ChargeConnection connection, String messageType) {
        return RawYkcFrame.new4Sender(connection, messageType);
    }
}
