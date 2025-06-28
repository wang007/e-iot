package io.github.eiot.charge.ykc;

import io.github.eiot.*;
import io.github.eiot.codec.*;
import io.github.eiot.impl.AbstractRawFrame;
import io.github.eiot.utils.CodecUtil;
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
public class RawYkcFrame extends AbstractRawFrame implements YkcFrame<ByteBuf> {

    private static final ComposeCodec YKC_CODEC;

    private static final Hex START_VALUE = Hex.from("68");

    private static final ByteBufRef EMPTY_DATA = ByteBufRef.from(Unpooled.EMPTY_BUFFER);

    static {
        HexCodec start = new HexCodec(1);
        BIN4OffsetCodec len = new BIN4OffsetCodec(1, ByteOrder.LITTLE_ENDIAN, "len", -4);
        BIN4Codec seqNo = new BIN4Codec(2);
        BIN4Codec cryptType = new BIN4Codec(1);
        HexCodec command = new HexCodec(1);
        ByteBufRefCodec data = new ByteBufRefCodec(-1, ByteOrder.LITTLE_ENDIAN, "len");
        BIN4Codec checkCode = new BIN4Codec(2);
        YKC_CODEC = new ComposeCodec(Arrays.asList(start, len, seqNo, cryptType, command, data, checkCode));
    }

    public static RawYkcFrame new4Receiver(IotConnection connection, ByteBuf byteBuf) {
        List<Object> fields = YKC_CODEC.decode(byteBuf.slice(), new DefaultCodecContext());
        Hex command = (Hex) fields.get(4);
        return new RawYkcFrame(connection, command.toString(), fields, byteBuf);
    }

    public static RawYkcFrame new4Sender(IotConnection connection, String command) {
        return new RawYkcFrame(connection, command);
    }

    private final int sumCheckCode;

    private final List<Object> fields;

    private ByteBuf bytebuf;

    /**
     * 用于 {@link Side#RECEIVER} 接收场景
     */
    RawYkcFrame(IotConnection connection, String command, List<Object> fields, ByteBuf byteBuf) {
        super(connection, Side.RECEIVER, command);
        this.fields = fields;
        this.bytebuf = byteBuf;

        int sumCheckCode;
        if (isReceiver()) {
            try {
                sumCheckCode = calcCheckCode();
            } catch (Throwable e) {
                // gg, -2 作为计算出异常的标记
                sumCheckCode = -2;
            }
        } else {
            // 发送端不需要立即计算
            sumCheckCode = -1;
        }
        this.sumCheckCode = sumCheckCode;
    }

    /**
     * 用于 {@link Side#SENDER} 发送出去的 frame
     */
    RawYkcFrame(IotConnection connection, String command) {
        super(connection, Side.SENDER, command);
        List<Object> fields = new ArrayList<>(7);
        initFields(fields, command);
        this.fields = fields;
        sumCheckCode = -1;
    }

    private void initFields(List<Object> fields, String command) {
        fields.add(START_VALUE); // start 0x68
        fields.add(0);  // len
        fields.add(0); // first set seq no = 0
        fields.add(0); // cryptType always 0
        fields.add(Hex.from(command)); // command
        fields.add(EMPTY_DATA); // first set empty
        fields.add(-1);     // first set -1 checkCode
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
        fields.set(1, len + 4);
        fields.set(5, bufRef);
    }

    @Override
    public String terminalNo() {
        return iotConnection().get(IotConnection.TERMINAL_NO_KEY, "");
    }

    @Override
    public Hex start() {
        return (Hex) fields.get(0);
    }

    @Override
    public int rawDataSize() {
        return (int) fields.get(1);
    }

    @Override
    public int sequenceNo() {
        return (int) fields.get(2);
    }

    @Override
    public YkcFrame<ByteBuf> sequenceNo(int seqNo) {
        ensureWriteable(true);
        fields.set(2, seqNo);
        return this;
    }

    @Override
    public int cryptType() {
        return 0;
    }

    @Override
    public Hex rawCommand() {
        return (Hex) fields.get(4);
    }

    @Override
    public int checkCode() {
        return (int) fields.get(6);
    }

    @Override
    public YkcFrame<ByteBuf> checkCode(int checkCode) {
        ensureWriteable(true);
        fields.set(6, checkCode);
        return this;
    }

    @Override
    public <Resp> YkcRequestFrame<ByteBuf, Resp> asRequest() {
        throw new IllegalStateException("raw frame not support");
    }

    @Override
    public boolean checkCodeResult() {
        if (isReceiver()) {
            return sumCheckCode == checkCode();
        }
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
    public ByteBuf newData() {
        return Unpooled.buffer();
    }


    /**
     * WORD ModbusCRC(BYTE * pData, BYTE len)
     * {
     * BYTE byCRCHi = 0xff;
     * BYTE byCRCLo = 0xff;
     * BYTE byIdx;
     * WORD crc;
     * while(len--) {
     * byIdx = byCRCHi ^* pData++;
     * byCRCHi = byCRCLo ^ gabyCRCHi[byIdx];
     * byCRCLo = gabyCRCLo[byIdx];
     * }
     * crc = byCRCHi;
     * crc <<= 8;
     * crc += byCRCLo;
     * return crc;
     * }
     */
    public int calcCheckCode() {
        BYCRC crc = new BYCRC();
        calcCheckCode(CodecUtil.numberToBytes(sequenceNo(), 2, ByteOrder.LITTLE_ENDIAN), crc);
        calcCheckCode(new byte[]{(byte) cryptType()}, crc);
        calcCheckCode(rawCommand().getBytes(), crc);
        calcCheckCode(data(), crc);
        int crc0;
        crc0 = ((crc.hi & 0x00ff) << 8) | (crc.lo & 0x00ff) & 0xffff;
        return crc0;
    }

    private static class BYCRC {
        public int hi = 0xff;
        public int lo = 0xff;
    }

    private void calcCheckCode(byte[] bytes, BYCRC crc) {
        int byIdx;
        for (byte b : bytes) {
            byIdx = (crc.lo ^ b) & 0xff;
            crc.lo = crc.hi ^ gabyCRCHi[byIdx];
            crc.hi = gabyCRCLo[byIdx];
        }
    }

    private void calcCheckCode(ByteBuf byteBuf, BYCRC crc) {
        int byIdx;
        int start = byteBuf.readerIndex();
        int len = start + byteBuf.readableBytes();
        for (int i = start; i < len; i++) {
            byIdx = (crc.lo ^ byteBuf.getByte(i)) & 0xff;
            crc.lo = crc.hi ^ gabyCRCHi[byIdx];
            crc.hi = gabyCRCLo[byIdx];
        }
    }

    // CRC 码表高字节
    final static byte[] gabyCRCHi =
            {
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                    (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40
            };
    // CRC 码表低字节
    final static byte[] gabyCRCLo =
            {
                    (byte) 0x00, (byte) 0xC0, (byte) 0xC1, (byte) 0x01, (byte) 0xC3, (byte) 0x03, (byte) 0x02, (byte) 0xC2, (byte) 0xC6, (byte) 0x06, (byte) 0x07, (byte) 0xC7, (byte) 0x05, (byte) 0xC5, (byte) 0xC4, (byte) 0x04,
                    (byte) 0xCC, (byte) 0x0C, (byte) 0x0D, (byte) 0xCD, (byte) 0x0F, (byte) 0xCF, (byte) 0xCE, (byte) 0x0E, (byte) 0x0A, (byte) 0xCA, (byte) 0xCB, (byte) 0x0B, (byte) 0xC9, (byte) 0x09, (byte) 0x08, (byte) 0xC8,
                    (byte) 0xD8, (byte) 0x18, (byte) 0x19, (byte) 0xD9, (byte) 0x1B, (byte) 0xDB, (byte) 0xDA, (byte) 0x1A, (byte) 0x1E, (byte) 0xDE, (byte) 0xDF, (byte) 0x1F, (byte) 0xDD, (byte) 0x1D, (byte) 0x1C, (byte) 0xDC,
                    (byte) 0x14, (byte) 0xD4, (byte) 0xD5, (byte) 0x15, (byte) 0xD7, (byte) 0x17, (byte) 0x16, (byte) 0xD6, (byte) 0xD2, (byte) 0x12, (byte) 0x13, (byte) 0xD3, (byte) 0x11, (byte) 0xD1, (byte) 0xD0, (byte) 0x10,
                    (byte) 0xF0, (byte) 0x30, (byte) 0x31, (byte) 0xF1, (byte) 0x33, (byte) 0xF3, (byte) 0xF2, (byte) 0x32, (byte) 0x36, (byte) 0xF6, (byte) 0xF7, (byte) 0x37, (byte) 0xF5, (byte) 0x35, (byte) 0x34, (byte) 0xF4,
                    (byte) 0x3C, (byte) 0xFC, (byte) 0xFD, (byte) 0x3D, (byte) 0xFF, (byte) 0x3F, (byte) 0x3E, (byte) 0xFE, (byte) 0xFA, (byte) 0x3A, (byte) 0x3B, (byte) 0xFB, (byte) 0x39, (byte) 0xF9, (byte) 0xF8, (byte) 0x38,
                    (byte) 0x28, (byte) 0xE8, (byte) 0xE9, (byte) 0x29, (byte) 0xEB, (byte) 0x2B, (byte) 0x2A, (byte) 0xEA, (byte) 0xEE, (byte) 0x2E, (byte) 0x2F, (byte) 0xEF, (byte) 0x2D, (byte) 0xED, (byte) 0xEC, (byte) 0x2C,
                    (byte) 0xE4, (byte) 0x24, (byte) 0x25, (byte) 0xE5, (byte) 0x27, (byte) 0xE7, (byte) 0xE6, (byte) 0x26, (byte) 0x22, (byte) 0xE2, (byte) 0xE3, (byte) 0x23, (byte) 0xE1, (byte) 0x21, (byte) 0x20, (byte) 0xE0,
                    (byte) 0xA0, (byte) 0x60, (byte) 0x61, (byte) 0xA1, (byte) 0x63, (byte) 0xA3, (byte) 0xA2, (byte) 0x62, (byte) 0x66, (byte) 0xA6, (byte) 0xA7, (byte) 0x67, (byte) 0xA5, (byte) 0x65, (byte) 0x64, (byte) 0xA4,
                    (byte) 0x6C, (byte) 0xAC, (byte) 0xAD, (byte) 0x6D, (byte) 0xAF, (byte) 0x6F, (byte) 0x6E, (byte) 0xAE, (byte) 0xAA, (byte) 0x6A, (byte) 0x6B, (byte) 0xAB, (byte) 0x69, (byte) 0xA9, (byte) 0xA8, (byte) 0x68,
                    (byte) 0x78, (byte) 0xB8, (byte) 0xB9, (byte) 0x79, (byte) 0xBB, (byte) 0x7B, (byte) 0x7A, (byte) 0xBA, (byte) 0xBE, (byte) 0x7E, (byte) 0x7F, (byte) 0xBF, (byte) 0x7D, (byte) 0xBD, (byte) 0xBC, (byte) 0x7C,
                    (byte) 0xB4, (byte) 0x74, (byte) 0x75, (byte) 0xB5, (byte) 0x77, (byte) 0xB7, (byte) 0xB6, (byte) 0x76, (byte) 0x72, (byte) 0xB2, (byte) 0xB3, (byte) 0x73, (byte) 0xB1, (byte) 0x71, (byte) 0x70, (byte) 0xB0,
                    (byte) 0x50, (byte) 0x90, (byte) 0x91, (byte) 0x51, (byte) 0x93, (byte) 0x53, (byte) 0x52, (byte) 0x92, (byte) 0x96, (byte) 0x56, (byte) 0x57, (byte) 0x97, (byte) 0x55, (byte) 0x95, (byte) 0x94, (byte) 0x54,
                    (byte) 0x9C, (byte) 0x5C, (byte) 0x5D, (byte) 0x9D, (byte) 0x5F, (byte) 0x9F, (byte) 0x9E, (byte) 0x5E, (byte) 0x5A, (byte) 0x9A, (byte) 0x9B, (byte) 0x5B, (byte) 0x99, (byte) 0x59, (byte) 0x58, (byte) 0x98,
                    (byte) 0x88, (byte) 0x48, (byte) 0x49, (byte) 0x89, (byte) 0x4B, (byte) 0x8B, (byte) 0x8A, (byte) 0x4A, (byte) 0x4E, (byte) 0x8E, (byte) 0x8F, (byte) 0x4F, (byte) 0x8D, (byte) 0x4D, (byte) 0x4C, (byte) 0x8C,
                    (byte) 0x44, (byte) 0x84, (byte) 0x85, (byte) 0x45, (byte) 0x87, (byte) 0x47, (byte) 0x46, (byte) 0x86, (byte) 0x82, (byte) 0x42, (byte) 0x43, (byte) 0x83, (byte) 0x41, (byte) 0x81, (byte) 0x80, (byte) 0x40
            };

}
