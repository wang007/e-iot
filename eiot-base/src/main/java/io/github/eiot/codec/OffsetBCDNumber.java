package io.github.eiot.codec;

import java.math.BigDecimal;

/**
 * OffsetBCDNumber is a number with unit and numeric offset
 * <p>
 * created by wang007 on 2025/5/22
 */
public class OffsetBCDNumber extends BCDNumber {

    /**
     * number offset
     */
    private final int offset;

    /**
     * offset calculate direction
     * <p>
     * true: offset - number
     * false: number + offset
     */
    private final boolean offsetReverse;

    /**
     * @param bcd           the origin number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    OffsetBCDNumber(BCD bcd, int unit, int offset, boolean offsetReverse) {
        super(bcd, unit);
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    /**
     * new BCDNumber instance with unit and numeric offset
     *
     * @param value  the origin number
     * @param unit   the unit
     * @param length bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    OffsetBCDNumber(long value, int unit, int offset, boolean offsetReverse, int length) {
        super(value, unit, length);
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    @Override
    public double doubleValue() {
        double value = super.doubleValue();
        if (!isValid()) {
            return value;
        }
        if (offset != 0) {
            value = offsetReverse ? offset - value : value + offset;
        }
        return value;
    }

    @Override
    public BigDecimal bigDecimalValue() {
        BigDecimal decimal = super.bigDecimalValue();
        if (!isValid()) {
            return decimal;
        }
        if (offset != 0) {
            BigDecimal of = BigDecimal.valueOf(offset);
            decimal = offsetReverse ? of.subtract(decimal) : of.add(decimal);
        }
        return decimal;
    }


    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static OffsetBCDNumber from(int actualNumber, int offset, boolean offsetReverse, int length) {
        return new OffsetBCDNumber(actualNumber, 0, offset, offsetReverse, length);
    }

    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static OffsetBCDNumber from(double actualNumber, int offset, boolean offsetReverse, int length) {
        return new OffsetBCDNumber((long) actualNumber, 0, offset, offsetReverse, length);
    }


    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static OffsetBCDNumber from(int actualNumber, int unit, int offset, boolean offsetReverse, int length) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new OffsetBCDNumber(v, unit, offset, offsetReverse, length);
    }

    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @param length        bcd length. NOTE: bcd length, Not the length of the underlying bytes
     */
    public static OffsetBCDNumber from(double actualNumber, int unit, int offset, boolean offsetReverse, int length) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new OffsetBCDNumber(v, unit, offset, offsetReverse, length);
    }

}
