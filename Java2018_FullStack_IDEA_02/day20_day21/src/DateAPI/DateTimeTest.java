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

    @Test
    public void testSimpleDateFormat2() throws ParseException {
        // 三天打渔，两天晒网 1990-01-01 开始
        // 计算在指定的某天 xxxx-xx-xx 渔夫在打鱼还是在晒网,比如 2012-12-22在干什么
        Date beginDay = new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
        Date endDay = new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-22");
        int timeOfDay = (int)((endDay.getTime() - beginDay.getTime()) / (1000*3600*24) +1);
        int result = timeOfDay % 5;
        switch (result) {
            case 1:
            case 2:
            case 3:
                System.out.println("在打渔");
                break;
            case 0:
            case 4:
                System.out.println("在晒网");
                break;
            default:
                break;
        }
    }
}

