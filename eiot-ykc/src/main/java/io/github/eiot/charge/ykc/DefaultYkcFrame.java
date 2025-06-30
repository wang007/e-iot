package io.github.eiot.charge.ykc;

import io.github.eiot.impl.AbstractFrame;
import io.github.eiot.IotConnection;
import io.github.eiot.CommandDef;
import io.github.eiot.codec.Hex;
import io.github.eiot.charge.ykc.data.YkcBaseData;

/**
 * created by wang007 on 2025/3/16
 */
public class DefaultYkcFrame<T> extends AbstractFrame<T, RawYkcFrame> implements YkcFrame<T> {

    public DefaultYkcFrame(IotConnection connection, CommandDef<T> commandDef) {
        super(connection, commandDef);
    }

    public DefaultYkcFrame(RawYkcFrame frame, CommandDef<T> commandDef) {
        super(frame, commandDef);
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
    public Hex rawCommand() {
        return rawFrame().rawCommand();
    }

    @Override
    protected RawYkcFrame initRawFrame(IotConnection connection, String command) {
        return RawYkcFrame.new4Sender(connection, command);
    }

    @Override
    public <Resp> YkcRequestFrame<T, Resp> asRequest() {
        if (commandDef().responseType() == null) {
            throw new IllegalStateException("not request type frame");
        }
        return new YkcRequestFrame<>(this);
    }

    @Override
    public T newData() {
        T req = data();
        T data = super.newData();
        if (data instanceof YkcBaseData) {
            if (req instanceof YkcBaseData) {
                ((YkcBaseData) data).setTerminalNo(((YkcBaseData) req).getTerminalNo());
            } else {
                String terminalNo = terminalNo();
                if (terminalNo != null && !terminalNo.isEmpty()) {
                    ((YkcBaseData) data).setTerminalNo(terminalNo);
                }
            }
        }
        return data;
    }
}
