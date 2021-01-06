# 枚举类和注解





## 枚举类的使用

>   *   当一个类的对象只有有限个且确定时，该成就是枚举类
>   *   自定义枚举类
>   *   使用关键字 enum 定义枚举类
>   *   Enum 类的主要方法
>   *   实现接口的枚举类

#### 使用枚举类的情况:

1.  类的对象只有**有限个**而且可以**确定**时

    「*如果枚举类只有一个对象，那么就可以作为一种单例模式的实现方式*」

    星期，性别，季节，支付方式，就职状态，订单状态，线程状态......

2.  **当需要定义一组常量时**,强烈推荐使用枚举类

3.  枚举类的属性

    *   枚举类对象的属性不应允许被改动，所以应该使用 private final 修饰
    *   枚举类的使用 private final 修饰的属性应该在构造器中为其赋值
    *   若枚举类显示的定义了带参数的构造器，则在列出枚举值时也必须对应的传入参数



**自定义枚举类步骤代码示例:**

```java
class Seasons {
    //1. 声明Seasons对象属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化构造器
    private Seasons(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //3.提供当前枚举类的多个对象
    public static final Seasons SPRING = new Seasons("春天", "春暖花开");
    public static final Seasons SUMMER = new Seasons("夏天", "夏日炎炎");
    public static final Seasons AUTUMN = new Seasons("秋天", "秋高气爽");
    public static final Seasons WINTER = new Seasons("冬天", "冰天雪地");

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
        return "Season: \n" + "[" + this.seasonName + " - " + this.seasonDesc + "]";
    }
}
```



**enum 关键字定义枚举类示例代码:**

使用enum定义的枚举类，默认继承于 java.lang.Enum

```java
enum Seasons {

    //1.提供当前枚举类的多个对象,多个对象之间使用‘，’隔开
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    //2. 声明Seasons对象属性[ 如果无需对外提供获取属性的方法，这里可以省略 ]
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化构造器
    private Seasons(String seasonName, String seasonDesc) {
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
        return "Season: \n" + "[" + this.seasonName + " - " + this.seasonDesc + "]";
    }
}
```



**Enum 类的主要方法：**

「常用的有 values()  valueOf(String str)  toString()」

<img src="/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/Enum类的主要方法.png" alt="Enum类的主要方法" style="zoom:150%;" />



**关于枚举类对象各自调用同样的方法实现不同功能的技巧**

通过实现接口的方式实现, 代码示例如下:

```java
// 每一个对象都实现了 show() 方法
enum StuffInOffice implements Info {
    MANAGER("章麻子", "经理", 30){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "我怕过谁啊?");
        }
    },
    USER("二傻子", "员工", 29){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "把噶压路，去西藏");
        }
    },
    MODIFY("王二小", "管理员", 32){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "把敌人引入我军的包围圈");
        }
    },
    OTHERS("无名", "闲人", 22){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "闲杂人等，不要闯入");
        }
    };
}

// 定义共同方法的接口
interface Info {
    void show();
}
```





## 注解的使用

>   Annotation 概述
>
>   常见的Annotation示例
>
>   自定义Annotation
>
>   JDK中的元注解
>
>   利用反射获取注解信息「发射章节详解」
>
>   JDK8中注解的新特性



JDK5.0开始，Java增加了对元数据 MetaData 的支持，也就是 Annotation

注解 Annotation 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。通过Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。代码分析工具，开发工具和部署工具可以通过这些补充信息进行验证或者进行部署

Annotation 可以像修饰符一样被使用，可以用于**修饰包，构造器，方法，成员变量，参数，局部变量的声明**，这些信息被保存在Annotation的 "name=value"对中「如同python字典的键值对