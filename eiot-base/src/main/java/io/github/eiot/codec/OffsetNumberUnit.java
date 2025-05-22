package io.github.eiot.codec;

import java.math.BigDecimal;

/**
 * OffsetNumberUnit is a number with unit and numeric offset
 * <p>
 * eg:
 * value = 1500, unit = 100, offset = -500, offsetReverse = false (calc number + offset)
 * actual value = 1500 / 100 + (-500) = -485
 * <p>
 * value = 350, unit = 1000, offset = 500, offsetReverse = true (calc offset - number)
 * actual value = 500 - 350 / 1000 = 499.65
 * <p>
 * created by wang007 on 2025/2/27
 */
public class OffsetNumberUnit extends NumberUnit {

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

    OffsetNumberUnit(long number, int unit, int offset, boolean offsetReverse) {
        super(number, unit);
        this.offset = offset;
        this.offsetReverse = offsetReverse;
    }

    @Override
    public double doubleValue() {
        double value = super.doubleValue();
        if (offset != 0) {
            value = offsetReverse ? offset - value : value + offset;
        }
        return value;
    }

    @Override
    public BigDecimal bigDecimalValue() {
        BigDecimal decimal = super.bigDecimalValue();
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
     */
    public static OffsetNumberUnit from(int actualNumber, int offset, boolean offsetReverse) {
        return new OffsetNumberUnit(actualNumber, 1, offset, offsetReverse);
    }

    /**
     * @param actualNumber  the actual number
     * @param offset        the unit
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static OffsetNumberUnit from(double actualNumber, int offset, boolean offsetReverse) {
        return new OffsetNumberUnit((long) actualNumber, 1, offset, offsetReverse);
    }


    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static OffsetNumberUnit from(int actualNumber, int unit, int offset, boolean offsetReverse) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new OffsetNumberUnit(v, unit, offset, offsetReverse);
    }

    /**
     * @param actualNumber  the actual number
     * @param unit          the unit
     * @param offset        number offset
     * @param offsetReverse Decide how to calculate offset. true: offset - number, false: number + offset
     */
    public static OffsetNumberUnit from(double actualNumber, int unit, int offset, boolean offsetReverse) {
        long v = originNumber(actualNumber, unit, offset, offsetReverse);
        return new OffsetNumberUnit(v, unit, offset, offsetReverse);
    }
}
