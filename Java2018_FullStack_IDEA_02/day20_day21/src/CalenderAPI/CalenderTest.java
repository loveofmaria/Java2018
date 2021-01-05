package CalenderAPI;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName CalenderAPI
 * @createdTime 2021-01-05 9:33 AM
 */
public class CalenderTest {
    @Test
    public void test1() {
        //Calender 实例化的方法
        // 1. 子类创建实例, GregorianCalender
        // 2. 调用 Calender.getInstance() 获取
        Calendar calendar = Calendar.getInstance();
//        Calendar calendar1 = new GregorianCalendar();
        // 常用方法
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        // 转换成Date
        System.out.println(calendar.getTime());
        // Date 转换成 Calender
        Date date = new Date();
        calendar.setTime(date);
    }
}
