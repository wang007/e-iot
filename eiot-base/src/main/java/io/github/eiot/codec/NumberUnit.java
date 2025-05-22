package io.github.eiot.codec;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * NumberUnit is a number with unit
 * <p>
 * eg:
 * value = 1500, unit = 100
 * actual value = 1500 / 100 = 150
 * <p>
 * created by wang007 on 2025/2/27
 */
public class NumberUnit extends Number {

    /**
     * the origin number
     */
    protected final long number;

    /**
     * number unit
     */
    protected final int unit;

    /**
     *
     *
     * @param number the origin number
     * @param unit   the unit
     */
    NumberUnit(long number, int unit) {
        this.number = number;
        this.unit = unit;
        if (unit != 1 && unit % 10 != 0) {
            throw new IllegalArgumentException("unit must be the multiple of 10");
        }
        if (unit < 0) {
            throw new IllegalArgumentException("unit must be >= 0");
        }
    }

    /**
     * The actual value after calculation
     *
     * @return The actual double value
     */
    @Override
    public double doubleValue() {
        return unit == 0 || unit == 1 ? number : number / (double) unit;
    }

    /**
     * The actual value after calculation
     *
     * @return The actual float value
     */
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    /**
     * The actual value after calculation
     *
     * @return The actual int value
     */
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    /**
     * The actual value after calculation
     *
     * @return The actual long value
     */
    @Override
    public long longValue() {
        return (long) doubleValue();
    }


    /**
     * The actual value after calculation
     *
     * @return The actual bigDecimal value
     */
    public BigDecimal bigDecimalValue() {
        long v = number;
        if (unit == 0 || unit == 1) {
            return new BigDecimal(v);
        }
        int scale = 1;
        for (int i = 10; i < this.unit; i = i * 10) {
            scale++;
        }
        return new BigDecimal(v)
                .divide(BigDecimal.valueOf(this.unit), scale, RoundingMode.DOWN);
    }

    /**
     * @return the origin number
     */
    public long originNumber() {
        return number;
    }

    /**
     * @param actualNumber the actual number
     * @param unit         the unit
     * @return new NumberUnit instance
     */
    public static NumberUnit from(int actualNumber, int unit) {
        long v = unit == 0 || unit == 1 ? actualNumber : (long) actualNumber * unit;
        return new NumberUnit(v, unit);
    }

    /**
     * @param actualNumber the actual number
     * @param unit         the unit
     * @return new NumberUnit instance
     */
    public static NumberUnit from(double actualNumber, int unit) {
        long v = (unit == 0 || unit == 1) ? (long) actualNumber : (long) (actualNumber * unit);
        return new NumberUnit(v, unit);
    }

    /**
     * get originNumber by actualNumber
     *
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @return originNumber
     */
    protected static long originNumber(int actualNumber, int unit, int offset, boolean offsetReverse) {
        int v = actualNumber;
        if (offset != 0) {
            v = offsetReverse ? offset - v : v - offset;
        }
        long n = unit == 0 || unit == 1 ? (long) v : (long) v * unit;
        return n;
    }

    /**
     * get originNumber by actualNumber
     *
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     * @return originNumber
     */
    protected static long originNumber(double actualNumber, int unit, int offset, boolean offsetReverse) {
        BigDecimal v = BigDecimal.valueOf(actualNumber);
        if (offset != 0) {
            BigDecimal of = BigDecimal.valueOf(offset);
            v = offsetReverse ? of.subtract(v) : v.subtract(of);
        }
        long n = unit == 0 || unit == 1 ? v.longValue() : v.multiply(BigDecimal.valueOf(unit)).longValue();
        return n;
    }
}
