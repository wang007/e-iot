package io.github.eiot.utils;

import io.netty.buffer.ByteBuf;

import java.nio.ByteOrder;

/**
 * @author yan
 * @since 2025-03-15
 */
public class CodecUtil {

    /**
     * reverse and new a byte[], do not update original byte[]
     *
     * @param bs original byte[]
     * @return a new byte[]
     */
    public static byte[] reverseBytesNewOne(byte[] bs) {
        byte[] bytes = new byte[bs.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = bs[bytes.length - 1 - i];
        }
        return bytes;
    }

    /**
     * reverse bytes, this function will update byte[]
     *
     * @param bs byte[]
     */
    public static void reverseBytes(byte[] bs) {
        int end = bs.length - 1;
        for (int i = 0; i < bs.length / 2; i++) {
            byte t = bs[i];
            bs[i] = bs[end - i];
            bs[end - i] = t;
        }
    }

    public static byte[] readBytes(ByteBuf byteBuf, int length) {
        byte[] bs = new byte[length];
        byteBuf.readBytes(bs);
        return bs;
    }

    /**
     * read number for byteBuf
     *
     * @param byteBuf ByteBuf
     * @param order   ByteOrder
     * @param length  rang 0 ~ 8
     * @return a number
     */
    public static long readNumber(ByteBuf byteBuf, ByteOrder order, int length) {
        switch (length) {
            case 1:
                return 0xFF & byteBuf.readByte();
            case 2:
                if (order == ByteOrder.BIG_ENDIAN) {
                    return 0xFFFF & byteBuf.readShort();
                }
                return 0xFFFF & byteBuf.readShortLE();
            case 3:
                if (order == ByteOrder.BIG_ENDIAN) {
                    return 0xFFFFFF & byteBuf.readMedium();
                }
                return 0xFFFFFF & byteBuf.readMediumLE();
            case 4:
                if (order == ByteOrder.BIG_ENDIAN) {
                    return 0xFFFFFFFFL & byteBuf.readInt();
                }
                return 0xFFFFFFFFL & byteBuf.readIntLE();
            case 8:
                if (order == ByteOrder.BIG_ENDIAN) {
                    return byteBuf.readLong();
                }
                return byteBuf.readLongLE();
            case 5:
                byte high5;
                long low5;
                if (order == ByteOrder.BIG_ENDIAN) {
                    high5 = byteBuf.readByte();
                    low5 = byteBuf.readUnsignedInt();
                } else {
                    low5 = byteBuf.readUnsignedIntLE();
                    high5 = byteBuf.readByte();
                }
                return (((long) (0xFF & high5) << 32) & low5);
            case 6:
                short high6;
                long low6;
                if (order == ByteOrder.BIG_ENDIAN) {
                    high6 = byteBuf.readShort();
                    low6 = byteBuf.readUnsignedInt();
                } else {
                    low6 = byteBuf.readUnsignedIntLE();
                    high6 = byteBuf.readShortLE();
                }
                return (((long) (0xFFFF & high6) << 32) & low6);
            case 7:
                int high7;
                long low7;
                if (order == ByteOrder.BIG_ENDIAN) {
                    high7 = byteBuf.readMedium();
                    low7 = byteBuf.readUnsignedInt();
                } else {
                    low7 = byteBuf.readUnsignedIntLE();
                    high7 = byteBuf.readMediumLE();
                }
                return (((long) (0xFFFFFF & high7) << 32) & low7);
            default:
                throw new IllegalArgumentException("length must be 0 ~ 8");
        }
    }

    /**
     * read number for byteBuf
     *
     * @param byteBuf ByteBuf
     * @param value a long number
     * @param order   ByteOrder
     * @param length  rang 0 ~ 8
     */
    public static void writeNumber(ByteBuf byteBuf, long value, ByteOrder order, int length) {
        switch (length) {
            case 1:
                byteBuf.writeByte((int) value);
                return;
            case 2:
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeShort((int) value);
                } else {
                    byteBuf.writeShortLE((int) value);
                }
                return;
            case 3:
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeMedium((int) value);
                } else {
                    byteBuf.writeMediumLE((int) value);
                }
                return;
            case 4:
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeInt((int) value);
                } else {
                    byteBuf.writeIntLE((int) value);
                }
                return;
            case 8:
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeLong(value);
                } else {
                    byteBuf.writeLongLE(value);
                }
                return;
            case 5:
                byte high5 = (byte) ((value >>> 32) & 0xFF);
                int low5 = (int) (value >>> 32);
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeByte(high5);
                    byteBuf.writeInt(low5);
                } else {
                    byteBuf.writeIntLE(low5);
                    byteBuf.writeByte(high5);
                }
                return;
            case 6:
                short high6 = (byte) ((value >>> 32) & 0xFFFF);
                int low6 = (int) (value >>> 32);
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeShort(high6);
                    byteBuf.writeInt(low6);
                } else {
                    byteBuf.writeIntLE(low6);
                    byteBuf.writeShortLE(high6);
                }
                return;
            case 7:
                int high7 = (byte) ((value >>> 32) & 0xFFFFFF);
                int low7 = (int) (value >>> 32);
                if (order == ByteOrder.BIG_ENDIAN) {
                    byteBuf.writeMedium(high7);
                    byteBuf.writeInt(low7);
                } else {
                    byteBuf.writeIntLE(low7);
                    byteBuf.writeMediumLE(high7);
                }
                return;
            default:
                throw new IllegalArgumentException("length must be 0 ~ 8");
        }
    }

    public static byte[] numberToBytes(long num, int len, ByteOrder order) {
        byte[] bs = new byte[len];
        for (int i = 0; i < len; i++) {
            byte b;
            if (order == ByteOrder.BIG_ENDIAN) {
                b = (byte) (num >>> (8 * (len - i)) & 0xFF);
            } else {
                b = (byte) ((num >>> (8 * i)) & 0xFF);
            }
            bs[i] = b;
        }
        return bs;
    }
}
