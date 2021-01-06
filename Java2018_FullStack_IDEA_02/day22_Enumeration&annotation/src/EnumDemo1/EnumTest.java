package EnumDemo1;

import org.junit.Test;

public class EnumTest {
    @Test
    public void testSeasons() {
        Seasons spring = Seasons.SPRING;
        Seasons summer = Seasons.SUMMER;
        Seasons autumn = Seasons.AUTUMN;
        Seasons winter = Seasons.WINTER;
        System.out.println(spring);
        System.out.println(summer);
        System.out.println(autumn);
        System.out.println(winter);
        // Enum 类的 values 方法获取所有枚举类的对象，并以数组的形式返回
        StuffInOffice[] instances = StuffInOffice.values();
        for (StuffInOffice instance : instances) {
            System.out.println(instance);
            instance.show();
        }
        System.out.println(StuffInOffice.valueOf("MANAGER"));
    }
}

enum Seasons {

    //1.提供当前枚举类的多个对象,多个对象之间使用‘，’隔开
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    //2. 声明Seasons对象属性
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化构造器
    Seasons(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //4.其他需求，比如获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //5.提供toString方法
    @Override
    public String toString() {
        return "Season: \n" + "[" + this.getSeasonName() + " - " + this.getSeasonDesc() + "]";
    }
}


