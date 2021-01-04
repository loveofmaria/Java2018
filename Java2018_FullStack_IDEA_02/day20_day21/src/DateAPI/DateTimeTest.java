package DateAPI;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName DateAPI
 * @createdTime 2021-01-04 12:21 PM
 */
public class DateTimeTest {

    @Test
    public void testSimpleDateFormat() throws ParseException {
        Date now = new Date();
        String pattern = "yyyy-MM-dd HH:MM:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String timeString = "2020-01-04 12:39:22";

        System.out.println(sdf.format(now));
        System.out.println(sdf.parse(timeString));
    }

    @Test
    public void testSimpleDateFormat1() throws ParseException {
        String birthday = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeParsed = sdf.parse(birthday);
        java.sql.Date sqlDate = new java.sql.Date(timeParsed.getTime());
        System.out.println(sqlDate);
    }
}

