package io.github.eiot.codec;

import java.math.BigDecimal;

/**
 * bcd must be a byte of 0 to 9.
 * If this is exceeded, bcdNumber is invalid and the actual value obtained is returned -1
 * <p>
 * created by wang007 on 2025/2/27
 */
public class BCDNumber extends NumberUnit {

    private static final BigDecimal INVALID_VALUE = BigDecimal.valueOf(-1L);

    private final BCD bcd;

    private final boolean valid;

    BCDNumber(BCD bcd, int unit) {
        super(bcdToLong(bcd.getBytes()), unit);
        this.bcd = bcd;
        this.valid = validBCDNumber(bcd.getBytes());
    }

    /**
     * new BCDNumber instance with unit and numeric offset
     *
     * @param value  the origin number
     * @param unit   the unit
     * @param length bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    BCDNumber(long value, int unit, int length) {
        super(value, unit);
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
    public BigDecimal bigDecimalValue() {
        return valid ? super.bigDecimalValue() : INVALID_VALUE;
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
     * @param v   the origin value
     * @param len bcd length
     * @return byte[]
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
        return new BCDNumber(v, unit, length);
    }

    /**
     * @param actualNumber the actual number
     * @param unit         the unit
     * @param length       bcd length. NOTE: bcd length, Not the length of the underlying bytes
     * @return new BCDNumber instance
     */
    public static BCDNumber from(double actualNumber, int unit, int length) {
        long v = unit == 0 || unit == 1 ? (long) actualNumber : (long) (actualNumber * unit);
        return new BCDNumber(v, unit, length);
    }

}
