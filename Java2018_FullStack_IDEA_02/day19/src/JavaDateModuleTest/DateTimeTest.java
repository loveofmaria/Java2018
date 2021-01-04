package JavaDateModuleTest;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName JavaDateModuleTest
 * @createdTime 2021-01-03 3:40 PM
 */

public class DateTimeTest {
    /* 1. System&#x7C7B;&#x4E2D;&#x7684;currentTimeMillis() */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2() {
        Date now = new Date();
        System.out.println(now.toString());
        Date declaredTime = new Date(234234234234234234L);
        System.out.println(declaredTime);
        java.sql.Date sqlDate = new java.sql.Date(102034393439L);
        System.out.println(sqlDate);
        System.out.println(now.getTime());
        System.out.println(sqlDate.getTime());
    }
}
