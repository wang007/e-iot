package io.github.eiot.charge.codec;

/**
 * bcd must be a byte of 0 to 9.
 * If this is exceeded, bcdNumber is invalid and the actual value obtained is returned -1
 * <p>
 * created by wang007 on 2025/2/27
 */
public class BCDNumber extends NumberUnit {

    private final BCD bcd;

    private final boolean valid;

    BCDNumber(BCD bcd, int unit) {
        this(bcd, unit, 0);
    }

    BCDNumber(BCD bcd, int offset, boolean offsetReverse) {
        this(bcd, 0, offset, offsetReverse);
    }

    BCDNumber(BCD bcd, int unit, int offset) {
        this(bcd, unit, offset, false);
    }

    BCDNumber(BCD bcd, int unit, int offset, boolean offsetReverse) {
        super(bcdToLong(bcd.getBytes()), unit, offset, offsetReverse);
        this.bcd = bcd;
        this.valid = validBCDNumber(bcd.getBytes());
    }

    /**
     * new BCDNumber instance with unit and numeric offset
     *
     * @param value         the origin number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    BCDNumber(long value, int unit, int offset, boolean offsetReverse, int length) {
        super(value, unit, offset, offsetReverse);
        this.bcd = new BCD(longToBcd(value, length));
        this.valid = true;
    }


    public BCD getBcd() {
        return bcd;
    }

    /**
     * @return Whether bcdNumber is valid
     */
    public boolean isValid() {
        return valid;
    }

    @Override
    public double doubleValue() {
        return valid ? super.doubleValue() : -1;
    }

    @Override
    public float floatValue() {
        return valid ? super.floatValue() : -1;
    }

    @Override
    public int intValue() {
        return valid ? super.intValue() : -1;
    }

    @Override
    public long longValue() {
        return valid ? super.longValue() : -1;
    }

    /**
     * bcd to long
     *
     * @param bcd the bcd
     * @return long value
     */
    private static long bcdToLong(byte[] bcd) {
        int length = bcd.length;
        long v = 0;
        long unit = 1;
        for (int i = length - 1; i >= 0; i--) {
            v += unit * bcd[i];
            unit = unit * 10;
        }
        return v;
    }

    /**
     * long to bcd
     *
     * @param v
     * @param len bcd length
     * @return
     */
    private static byte[] longToBcd(long v, int len) {
        byte[] bcd = new byte[len];
        long unit = 10;
        for (int i = len - 1; i >= 0; i--) {
            bcd[i] = (byte) ((v % unit) / (unit / 10));
            unit = unit * 10;
        }
        return bcd;
    }

    /**
     * Check whether bcd is valid, bcd
     *
     * @param bcd bcd
     * @return true: valid false: invalid
     */
    private static boolean validBCDNumber(byte[] bcd) {
        for (byte b : bcd) {
            if (b < 0 || b > 9) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param actualNumber the actual number
     * @param unit         the unit
     * @param length       bcd length. NOTE: bcd length, Not the length of the underlying bytes
     * @return new BCDNumber instance
     */
    public static BCDNumber from(int actualNumber, int unit, int length) {
        long v = unit == 0 || unit == 1 ? actualNumber : (long) actualNumber * unit;
        return new BCDNumber(v, unit, 0, false, length);
    }

    /**
     * @param actualNumber the actual number
     * @param unit         the unit
     * @param length       bcd length. NOTE: bcd length, Not the length of the underlying bytes
     * @return new BCDNumber instance
     */
    public static BCDNumber from(double actualNumber, int unit, int length) {
        long v = unit == 0 || unit == 1 ? (long) actualNumber : (long) (actualNumber * unit);
        return new BCDNumber(v, unit, 0, false, length);
    }

    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static BCDNumber from(int actualNumber, int offset, boolean offsetReverse, int length) {
        return new BCDNumber(actualNumber, 0, offset, offsetReverse, length);
    }

    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static BCDNumber from(double actualNumber, int offset, boolean offsetReverse, int length) {
        return new BCDNumber((long) actualNumber, 0, offset, offsetReverse, length);
    }


    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static BCDNumber from(int actualNumber, int unit, int offset, boolean offsetReverse, int length) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new BCDNumber(v, unit, offset, offsetReverse, length);
    }

    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static BCDNumber from(double actualNumber, int unit, int offset, boolean offsetReverse, int length) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new BCDNumber(v, unit, offset, offsetReverse, length);
    }

}
