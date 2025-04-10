package io.github.eiot.codec;

import java.time.*;
import java.util.Date;

/**
 * BCDTime contains 6 bytes and declare the time in bcd format.
 * format: yyMMddHHmmss
 * <p>
 * created by wang007 on 2025/2/26
 */
public class BCDTime {

    private final BCD bcd;

    BCDTime(BCD bcd){
        this.bcd = bcd;
    }

    BCDTime(byte[] bytes) {
        this.bcd = new BCD(bytes);
        if (bytes.length != 12) {
            throw new IllegalArgumentException("bcd length must be = 12");
        }
    }

    public BCD getBcd(){
        return this.bcd;
    }

    public byte[] getBytes(){
        return bcd.getBytes();
    }

    /**
     * @return the date
     */
    public Date toDate() {
        return Date.from(toLocalDateTime().atZone(ZoneOffset.systemDefault()).toInstant());
    }

    /**
     * @return to localDateTime
     */
    public LocalDateTime toLocalDateTime() {
        try {
            byte[] bs = bcd.getBytes();
            return LocalDateTime.of(2000 + bs[0] * 10 + bs[1],
                    bs[2] * 10 + bs[3],
                    bs[4] * 10 + bs[5],
                    bs[6] * 10 + bs[7],
                    bs[8] * 10 + bs[9],
                    bs[10] * 10 + bs[11]);
        } catch (DateTimeException e) {
            return LocalDateTime.of(1970, 1, 1, 8, 0, 0);
        }
    }

    /**
     * BCDTime is created at now
     *
     * @return the new BCDTime instance
     */
    public static BCDTime now() {
        return from(LocalDateTime.now());
    }

    /**
     * BCDTime is created at the specified time
     *
     * @param date The time
     * @return the new BCDTime instance
     */
    public static BCDTime from(Date date) {
        Instant instant = date.toInstant();
        return from(instant.atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * BCDTime is created at the specified time
     *
     * @param dateTime The time
     * @return the new BCDTime instance
     */
    public static BCDTime from(LocalDateTime dateTime) {
        return new BCDTime(localDateTimeToBCD(dateTime));
    }


    private static byte[] localDateTimeToBCD(LocalDateTime localDateTime) {
        byte[] bcd = new byte[12];
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        bcd[0] = (byte) getDecade(year);
        bcd[1] = (byte) getDigit(year);

        bcd[2] = (byte) getDecade(month);
        bcd[3] = (byte) getDigit(month);

        bcd[4] = (byte) getDecade(day);
        bcd[5] = (byte) getDigit(day);

        bcd[6] = (byte) getDecade(hour);
        bcd[7] = (byte) getDigit(hour);

        bcd[8] = (byte) getDecade(minute);
        bcd[9] = (byte) getDigit(minute);

        int second = localDateTime.getSecond();

        bcd[10] = (byte) getDecade(second);
        bcd[11] = (byte) getDigit(second);

        return bcd;
    }


    private static int getDecade(int value) {
        return value % 100 / 10;
    }

    private static int getDigit(int value) {
        return value % 10;
    }

}
