package JDK8newDateAPI;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName JDK8newDateAPI
 * @createdTime 2021-01-05 10:02 AM
 */
public class JDK8DateTimeTest {

    @Test
    public void test() {
        // LocalDate, LocalTime, LocalDateTime
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);
        System.out.println(localTime);
        System.out.println(localDate);

        // 设置时间
        localDateTime = LocalDateTime.of(2020, 8, 6, 13, 23);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfWeek());
    }

    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        LocalDateTime localDateTime1 = localDateTime.plusYears(1);
        System.out.println(localDateTime1.getYear());
    }

    @Test
    public void test3() {
        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(1609814263772L);
        System.out.println(instant);
        System.out.println(instant1);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void test4() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(formatter1.format(LocalDateTime.now()));
        TemporalAccessor accessor = formatter.parse("2018-03-22 12:32:22");
        System.out.println(accessor);
    }
}
