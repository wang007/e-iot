package io.github.eiot.charge.codec;



import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * CP56time2a contains 7 bytes
 * <p>
 * 7    6    5    4    3    2    1   0
 * +----+----+----+----+----+----+----+----+
 * |      Milliseconds (D7 ~ D0)           |
 * +---------------------------------------+
 * |     Milliseconds (D15 ~ D8)           |
 * +---------------------------------------+
 * | IV |RES1|       Minutes(D5 ~ D0)      |
 * +---------------------------------------+
 * | SU |  RES2   |       Hours(D4 ~ D0)   |
 * +---------------------------------------+
 * | Weeks(D7~D5) |       Days(D4 ~ D0)    |
 * +---------------------------------------+
 * |   RES3 (D7 ~ D4)  |      Months(D3~D0)|
 * +---------------------------------------+
 * |RES1|        Years(D6 ~ D0)            |
 * +---------------------------------------+
 * <p>
 * created by wang007 on 2025/2/26
 */
public class CP56time2a implements Comparable<CP56time2a> {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final byte[] bytes;

    /**
     * @param bytes bytes length must be equals 7
     */
    CP56time2a(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * internal method. For test
     *
     * @return raw bytes
     */
    byte[] getBytes() {
        return this.bytes;
    }

    /**
     * @return to localDateTime
     */
    public LocalDateTime toLocalDateTime() {
        try {
            int millSec = (bytes[0] & 0xFF | (bytes[1] << 8) & 0xFF00);
            int minutes = bytes[2] & 0x3F;
            int hours = bytes[3] & 0x1F;
            int days = bytes[4] & 0x1F;
            int months = bytes[5] & 0x0F;
            int years = bytes[6] & 0x7F;
            return LocalDateTime.of(2000 + years, months, days,
                    hours, minutes, millSec / 1000,
                    (int) TimeUnit.MILLISECONDS.toNanos(millSec % 1000));
        } catch (DateTimeException e) {
            return LocalDateTime.of(1970, 1, 1, 8, 0, 0);
        }
    }

    /**
     * @return to Date
     */
    public Date toDate() {
        return Date.from(toLocalDateTime().atZone(ZoneOffset.systemDefault()).toInstant());
    }

    @Override
    public int compareTo(CP56time2a o) {
        return toLocalDateTime().compareTo(o.toLocalDateTime());
    }

    @Override
    public String toString() {
        return toLocalDateTime().format(formatter);
    }

    /**
     * CP56time2a is created at now
     *
     * @return now
     */
    public static CP56time2a now() {
        return from(LocalDateTime.now());
    }

    /**
     * CP56time2a is created at the specified time
     *
     * @param date the specified time
     * @return the new CP56time2a instance
     */
    public static CP56time2a from(Date date) {
        Instant instant = date.toInstant();
        return from(instant.atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * CP56time2a is created at the specified time
     *
     * @param dateTime The time
     * @return the new CP56time2a instance
     */
    public static CP56time2a from(LocalDateTime dateTime) {
        byte[] bytes = new byte[7];
        int millSec = (int) ((dateTime.getSecond() * 1000) + TimeUnit.NANOSECONDS.toMillis(dateTime.getNano()));
        //int week = dateTime.getDayOfWeek().getValue();
        int day = dateTime.getDayOfMonth();
        bytes[0] = (byte) millSec;
        bytes[1] = (byte) (millSec >>> 8);
        bytes[2] = (byte) (dateTime.getMinute() & 0x3F);
        bytes[3] = (byte) (dateTime.getHour() & 0x1F);
        //bytes[4] = (byte) ((week << 5) | (day & 0x1F));
        bytes[4] = (byte) (day & 0x1F);
        bytes[5] = (byte) (dateTime.getMonthValue() & 0x0F);
        bytes[6] = (byte) (((dateTime.getYear() - 2000) & 0x7F));
        return new CP56time2a(bytes);
    }
}
