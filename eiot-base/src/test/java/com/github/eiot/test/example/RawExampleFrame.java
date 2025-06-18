package com.github.eiot.test.example;

import io.github.eiot.*;
import io.github.eiot.codec.*;
import io.github.eiot.impl.AbstractRawFrame;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * byteOrder: LITTLE_ENDIAN
 * format:
 * 2 byte type: Hex, header: AAF5
 * 6 byte type: BCD, terminalNo
 * 1 byte command
 * 2 byte seqNo
 * 2 byte len
 * N byte data.
 * <p>
 * created by wang007 on 2025/4/12
 */
public class RawExampleFrame extends AbstractRawFrame implements ExampleFrame<ByteBuf> {

    private static final ComposeCodec CODEC;

    private static final Hex HEADER_VALUE = Hex.from("AAF5");

    static {
        HexCodec header = new HexCodec(2);
        BCDCodec terminalNo = new BCDCodec(6);
        HexCodec command = new HexCodec(1);
        BIN4Codec seqNo = new BIN4Codec(2);
        BIN4Codec len = new BIN4Codec(2, ByteOrder.LITTLE_ENDIAN, "len");
        ByteBufRefCodec data = new ByteBufRefCodec(-1, ByteOrder.LITTLE_ENDIAN, "len");

        CODEC = new ComposeCodec(Arrays.asList(header, terminalNo, command, seqNo, len, data));
    }

    private final List<Object> fields;
    private ByteBuf bytebuf;

    public static RawExampleFrame new4Receiver(IotConnection connection, ByteBuf byteBuf) {
        List<Object> fields = CODEC.decode(byteBuf.slice(), new DefaultCodecContext());
        Hex command = (Hex) fields.get(2);
        return new RawExampleFrame(connection, command.toString(), fields, byteBuf);
    }

    public static RawExampleFrame new4Sender(IotConnection connection, String command) {
        return new RawExampleFrame(connection, command);
    }


    /**
     * use for receiver
     */
    RawExampleFrame(IotConnection connection, String command, List<Object> fields, ByteBuf byteBuf) {
        super(connection, Side.RECEIVER, command);
        this.fields = fields;
        this.bytebuf = byteBuf;
    }

    /**
     * 用于 {@link Side#SENDER} 发送出去的 frame
     */
    RawExampleFrame(IotConnection connection, String command) {
        this(connection, command, connection.get(IotConnection.TERMINAL_NO_KEY));
    }

    /**
     * 用于 {@link Side#SENDER} 发送出去的 frame
     */
    RawExampleFrame(IotConnection connection, String command, String terminalNo) {
        super(connection, Side.SENDER, command);
        List<Object> fields = new ArrayList<>(6);
        initFields(fields, command, terminalNo);
        this.fields = fields;
    }

    private void initFields(List<Object> fields, String command, String terminalNo) {
        if (terminalNo.length() != 12) {
            throw new IllegalArgumentException("terminalNo must be 12");
        }
        fields.add(HEADER_VALUE); // header AAF5
        fields.add(BCD.from(terminalNo));  // terminalNo
        fields.add(Hex.from(command)); // command
        fields.add(0); // seqNo
        fields.add(0); // len
        fields.add(ByteBufRef.EMPTY); //  data
    }

    @Override
    public Hex header() {
        return (Hex) fields.get(0);
    }

    @Override
    public BCD terminalNo0() {
        return (BCD) fields.get(1);
    }

    @Override
    public ExampleFrame<ByteBuf> sequenceNo(int seqNo) {
        fields.set(3, seqNo);
        return this;
    }

    @Override
    public int sequenceNo() {
        return (int) fields.get(3);
    }

    @Override
    protected ByteBuf decodeData() {
        ByteBufRef ref = (ByteBufRef) fields.get(5);
        return ref.byteBuf();
    }

    @Override
    protected void encodeData(ByteBuf byteBuf) {
        int len = byteBuf.readableBytes();
        ByteBufRef bufRef = ByteBufRef.from(byteBuf);
        fields.set(4, len);
        fields.set(5, bufRef);
    }

    @Override
    protected ByteBuf genByteBuf() {
        if (isReceiver()) {
            return bytebuf;
        }
        ByteBuf buffer = Unpooled.buffer();
        CODEC.encode(buffer, fields);
        return buffer;
    }

    @Override
    public String terminalNo() {
        return terminalNo0().toString();
    }

    @Override
    public int rawDataSize() {
        return (int) fields.get(4);
    }

    @Override
    public boolean checkCodeResult() {
        return true;
    }

    @Override
    public ByteBuf newData() {
        return Unpooled.buffer();
    }

    @Override
    public <Resp> RequestFrame<ByteBuf, ExampleFrame<Resp>> asRequest() throws IllegalStateException {
        throw new IllegalStateException("raw frame not support");
    }

}
