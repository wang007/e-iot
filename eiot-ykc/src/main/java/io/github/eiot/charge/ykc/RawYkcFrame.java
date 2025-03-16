package io.github.eiot.charge.ykc;

import io.github.eiot.charge.AbstractRawFrame;
import io.github.eiot.charge.ChargeConnection;
import io.github.eiot.charge.Side;
import io.github.eiot.charge.codec.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * body 部分未解析的 frame
 * <p>
 * created by wang007 on 2025/3/15
 */
public class RawYkcFrame extends AbstractRawFrame<ByteBuf> implements YkcFrame<ByteBuf> {

    private static final ComposeCodec YKC_CODEC;

    static {
        HexCodec start = new HexCodec(1);
        BIN4ContextCodec len = new BIN4ContextCodec(2, ByteOrder.LITTLE_ENDIAN);
        BIN4Codec seqNo = new BIN4Codec(2, ByteOrder.LITTLE_ENDIAN);
        BIN4Codec cryptType = new BIN4Codec(1, ByteOrder.LITTLE_ENDIAN);
        HexCodec messageType = new HexCodec(1, ByteOrder.LITTLE_ENDIAN);
        ByteBufCodec data = new ByteBufCodec(-1, ByteOrder.LITTLE_ENDIAN);
        BIN4Codec checkCode = new BIN4Codec(2, ByteOrder.LITTLE_ENDIAN);
        YKC_CODEC = new ComposeCodec(Arrays.asList(start, len, seqNo, cryptType, messageType, data, checkCode));
    }

    public static RawYkcFrame new4Receiver(ChargeConnection connection, ByteBuf byteBuf) {
        List<Object> fields = YKC_CODEC.decode(byteBuf.slice(), new DefaultCodecContext());
        Hex messageType = (Hex) fields.get(4);
        return new RawYkcFrame(connection, messageType.toString(), fields, byteBuf);
    }

    public static RawYkcFrame new4Sender(ChargeConnection connection, String messageType) {
        return new RawYkcFrame(connection, messageType);
    }

    private final List<Object> fields;

    private ByteBuf bytebuf;

    /**
     * 用于 {@link Side#RECEIVER} 接收场景
     */
    RawYkcFrame(ChargeConnection connection, String messageType, List<Object> fields, ByteBuf byteBuf) {
        super(connection, Side.SENDER, messageType);
        this.fields = fields;
        this.bytebuf = byteBuf;
    }

    /**
     * 用于 {@link Side#SENDER} 发送出去的 frame
     */
    RawYkcFrame(ChargeConnection connection, String messageType) {
        super(connection, Side.SENDER, messageType);
        List<Object> fields = new ArrayList<>(7);
        this.fields = fields;
    }


    @Override
    protected ByteBuf decodeData() {

        return null;
    }

    @Override
    protected void encodeData(ByteBuf byteBuf) {

    }

    @Override
    public String terminalNo() {
        return chargeConnection().get(ChargeConnection.TERMINAL_NO_KEY, "");
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
    public YkcFrame<ByteBuf> sequenceNo(int seqNo) {
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
    public int checkCode() {
        return 0;
    }

    @Override
    public YkcFrame<ByteBuf> checkCode(int checkCode) {
        return null;
    }

    @Override
    public boolean checkCodeResult() {
        return false;
    }

    @Override
    protected ByteBuf genByteBuf() {
        if (isReceiver()) {
            return bytebuf;
        }
        ByteBuf buffer = Unpooled.buffer();
        YKC_CODEC.encode(buffer, fields);
        return buffer;
    }

    @Override
    public ByteBuf newDate() {
        return Unpooled.buffer();
    }


}
