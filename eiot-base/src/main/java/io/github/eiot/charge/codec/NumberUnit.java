package io.github.eiot.charge.codec;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * NumberUnit is a number with unit and numeric offset
 * <p>
 * eg:
 * value = 1500, unit = 100, offset = -500, offsetReverse = false (calc number + offset)
 * actual value = (1500 - 500) / 100 = 10
 * <p>
 * value = 350, unit = 1000, offset = 500, offsetReverse = true (calc offset - number)
 * actual value = (500 - 350) / 1000 = 0.15
 * <p>
 * created by wang007 on 2025/2/27
 */
public class NumberUnit extends Number {

    /**
     * the origin number
     */
    private final long number;

    /**
     * number unit
     */
    private final int unit;

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
     * {@link #NumberUnit(long, int, int, boolean)} but without offset
     *
     * @param number the origin number
     * @param unit   the unit
     */
    NumberUnit(long number, int unit) {
        this(number, unit, 0, false);
    }

    /**
     * {@link #NumberUnit(long, int, int, boolean)} but unit = 0
     *
     * @param number        the origin number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    NumberUnit(long number, int offset, boolean offsetReverse) {
        this(number, 0, offset, offsetReverse);
    }


    /**
     * {@link #NumberUnit(long, int, int, boolean)} but offsetReverse = false
     *
     * @param number the origin number
     * @param unit   the unit
     * @param offset number offset
     */
    NumberUnit(long number, int unit, int offset) {
        this(number, unit, offset, false);
    }

    /**
     * new NumberUnit instance with unit and numeric offset
     *
     * @param number        the origin number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    NumberUnit(long number, int unit, int offset, boolean offsetReverse) {
        this.number = number;
        this.unit = unit;
        this.offset = offset;
        this.offsetReverse = offsetReverse;
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
        long v = number;
        if (offset != 0) {
            v = offsetReverse ? offset - v : v + offset;
        }
        return unit == 0 || unit == 1 ? v : v / (double) unit;
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
        if (offset != 0) {
            v = offsetReverse ? offset - v : v + offset;
        }
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
        long v = unit == 0 || unit == 1 ? (long) actualNumber : (long) actualNumber * unit;
        return new NumberUnit(v, unit);
    }


    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static NumberUnit from(int actualNumber, int offset, boolean offsetReverse) {
        return new NumberUnit(actualNumber, offset, offsetReverse);
    }

    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static NumberUnit from(double actualNumber, int offset, boolean offsetReverse) {
        return new NumberUnit((long) actualNumber, offset, offsetReverse);
    }


    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static NumberUnit from(int actualNumber, int unit, int offset, boolean offsetReverse) {
        long v = unit == 0 || unit == 1 ? (long) actualNumber : (long) actualNumber * unit;
        return new NumberUnit(v, unit, offset, offsetReverse);
    }

    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static NumberUnit from(double actualNumber, int unit, int offset, boolean offsetReverse) {
        long v = unit == 0 || unit == 1 ? (long) actualNumber : (long) actualNumber * unit;
        return new NumberUnit(v, unit, offset, offsetReverse);
    }

}
