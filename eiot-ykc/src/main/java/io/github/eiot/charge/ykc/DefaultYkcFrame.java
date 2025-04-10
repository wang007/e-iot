package io.github.eiot.charge.ykc;

import io.github.eiot.charge.*;
import io.github.eiot.charge.codec.Hex;
import io.github.eiot.charge.ykc.data.YkcBaseData;

/**
 * created by wang007 on 2025/3/16
 */
public class DefaultYkcFrame<T> extends AbstractFrame<T, RawYkcFrame> implements YkcFrame<T> {

    public DefaultYkcFrame(ChargeConnection connection, MessageType<T> messageTypeEnum) {
        super(connection, messageTypeEnum);
    }

    public DefaultYkcFrame(RawYkcFrame frame, MessageType<T> messageTypeEnum) {
        super(frame, messageTypeEnum);
    }

    @Override
    public int checkCode() {
        return rawFrame().checkCode();
    }

    @Override
    public YkcFrame<T> checkCode(int checkCode) {
        rawFrame().checkCode(checkCode);
        return this;
    }

    @Override
    public Hex start() {
        return rawFrame().start();
    }

    @Override
    public int rawDataSize() {
        return rawFrame().rawDataSize();
    }

    @Override
    public int sequenceNo() {
        return rawFrame().sequenceNo();
    }

    @Override
    public YkcFrame<T> sequenceNo(int seqNo) {
        rawFrame().sequenceNo(seqNo);
        return this;
    }

    @Override
    public int cryptType() {
        return 0;
    }

    @Override
    public Hex rawMessageType() {
        return rawFrame().rawMessageType();
    }

    @Override
    protected RawYkcFrame initRawFrame(ChargeConnection connection, String messageType) {
        return RawYkcFrame.new4Sender(connection, messageType);
    }

    @Override
    public <Resp> RequestFrame<T, YkcFrame<Resp>> asRequest() {
        if (messageTypeEnum().responseType() == null) {
            throw new IllegalStateException("not request type frame");
        }
        return new YkcRequestFrame<>(this);
    }

    @Override
    public T newDate() {
        T req = data();
        T data = super.newDate();
        if (data instanceof YkcBaseData) {
            if (req instanceof YkcBaseData) {
                ((YkcBaseData) data).setTerminalNo(((YkcBaseData) req).getTerminalNo());
            } else {
                String terminalNo = terminalNo();
                if (terminalNo != null && !terminalNo.isEmpty()) {
                    ((YkcBaseData) data).setTerminalNoString(terminalNo);
                }
            }
        }
        return data;
    }
}
