### 前日回顾

1.  画出如下几行代码的内容结构

    「 常量池， 堆空间 」

    String s1 = "hello";

    String s2 = "hello";

    String s3 = new String("hello");

    s1 += "world";

2.  如何理解String类的不可变性

    创建的是 final cha[] , 即不可变的char数组

3.  String类是否可以继承？为什么?

    String s = new String("hello"); 在内存中创建了几个对象？请说明

4.  String, StringBuffer, StringBuilder 三者对比「效率对比以及常用方法-增删改查」

5.  String 的常用方法有那些？（至少7个）

6.  与基本数据类型、包装类之间的转换

7.  与字节byte之间的数据转换, char 之间的转换

8.  String --> StringBuffer, StringBuilder 转换： 调用 StringBuffer, StringBuilder 的构造器即可

9.  JVM 中字符串常量存放位置说明

    jdk1.6 : 字符串常量池存储在方法区「永久区」

    jdk1.7: 字符串常量池存储在堆空间

    jdk1.8: 字符串常量池存储在方法区「元空间」

10.  面试题：

     ***要说明原理***「构造器的源码有写出」

     ```java
         public void testStringBuffer() {
             String str = null;
             StringBuffer sb = new StringBuffer();
             sb.append(str);
     
             System.out.println(sb.length());// ? 输出？
             System.out.println(sb); // 输出?
     
             StringBuffer sb1 = new StringBuffer(str);
             System.out.println(sb1); // 输出？
         }
     // 给出每一条执行语句的输出或者异常
     // 思路：
     // 一个是使用 append() 方法 => 内部有个专门处理 str = null 的方法
     // 一个是构造器，并没有特别处理 str = null 的情况
     ```

     



### JDK8中的新日期时间API

>JDK8新的日期时间API引入了优秀的Joda-time第三方包
>
>新日期时间API出现的背景:
>
>1.  日期和时间应该是不可变的，但是在Date和Calender类型是可变的
>2.  Date中的年份有一个用1900开始的偏移量，而且月份从0开始
>3.  格式化只对Date有用，Calender则不能格式化
>4.  线程不安全，而且也不能处理闰秒

##### SimpleDateFormat类

*   不与语言环境有关的方式来格式化和解析日期的具体类

*   允许进行格式化：日期 -> 文本、解析：-> 日期

*   格式化：

    SimpleDateFormat() 默认的模式和语言环境创建对象

    public SimpleDateFormat(String pattern) 该构造方法可以用参数 pattern 指定的格式创建一个对象[调用下面的format 方法]

    public String format(Date date) 格式化时间对象date

*   解析

    public Date parse(String source) 从给定字符串的开始解析文本，以生成一个日期

    解析时要求字符串必须时符合SimpleDateFormat识别的格式[ 比如通过构造器传入的格式 ]

*   练习一

    ```java
    // 将字符串 "2020-09-08" 转换为java.sql.Date
    // SimpleDateFormat parse 解析成 Date, 然后调用Date的 getTime()转换成时间戳，最后转换成sqlDate
```
    
*   练习二

    ```java
    // 三天打渔，两天晒网 1990-01-01 开始
    // 计算在指定的某天 xxxx-xx-xx 渔夫在打鱼还是在晒网
    // 思路: 计算从1990-01-01 到指定的日期总共过了多少天，然后除以5，看余数「1,2,3 打渔」「0，4 晒网」
    // 毫秒进制 1000； 分 60； 小时 60； 天：24
    // 总天数 = 时间戳差 / (1000 * 60 * 60 * 24) + 1  => +1 是因为除法取整，会舍去不满1天的时间
    ```

    

#### 新日期时间API

>   LocalDate, LocalTime, LocalDateTime 相关方法参考API手册「方法都相同」

*   java.time 包含值对象的基础包
*   java.time.chrono 提供对不同的日历系统的访问
*   java.time.format 格式化和解析时间和日期
*   java.time.temporal 包含底层框架和扩展性
*   java.time.zone 包含时区支持的类

**LocalDate**: 代表IOS格式「yyyy-MM-dd」的日期，可以存储生日、纪念日等日期

**LocalTime**: 表示一个时间，而不是日期

**LocalDateTime**: 是用来表示日期和时间的「最常用的类」



### 瞬时 Instant

*   Instant: 时间线上的一个瞬时点，可能被用来记录应用程序中的事件时间戳

*   年月日时分秒表示时间是面向人类，而面向机器时，是使用大的连续的数字表示[ 这个数从1970年开始，以秒为单位( Unix); 以毫秒为单位( Java ) ]

*   ( 1 ns = 10负9次方 秒 )  1秒 = 1000毫秒 = 10的6次方微秒 = 10的9次方纳秒

*   now() 方法获取一个实例对象, 直接获取的时间是本初子午线的时间，如果要获取当前时区时间，需要使用atOffset(ZoneOffset.ofHours(时区差值))

    ```java
    // 例子，获取北京时间
    Instant instant = Instant.now();
    OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
    ```

*   toEpochMilli( ) 获取自1970年1月0时0分0秒( UTC ) 开始的毫秒数

*   Instant.ofEpochMilli( 1609814263772L ) 创建一个 Instant 对象



### java.time.format.DateTimeFormat 类

**实例化的三种方式如下：**

*   预订义的标准格式

    1.  ISO_LOCAL_DATE_TIME
    2.  ISO_LOCAL_DATE
    3.  ISO_LOCAL_TIME

*   本地化相关的格式，如 ofLocalizedDateTime(FormatStyle.LONG)

    本地时间格式化的风格「常量表示」

     ofLocalizedDateTime( 常量字符 ）

    1.  FormatStyle.LONG
    2.  FormatStyle.MEDIUM
    3.  FormatStyle.SHORT
    4.  FormatStyle.FULL

*   自定义格式，如 ofPattern("yyyy-MM-dd hh:mm:ss E")

    | 方法                       | 描述                                                |
    | :------------------------- | :-------------------------------------------------- |
    | ofPattern(String pattern)  | 静态方法，返回一个指定字符串格式的DateTimeFormatter |
    | format(TemporalAccessor t) | 格式化一个日期、时间、返回字符串                    |
    | parse(CharSequence text)   | 将指定格式的字符序列解析为一个日期、时间            |

    ### **解析**

    ```java
    // 假设自定义的格式化格式 yyyy-MM-ss hh:mm:ss => 2020-01-05 12:32:16
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ss hh:mm:ss")
    TemporalAccessor accessor = formatter.parse("2020-01-05 12:32:16");
    System.out.println(accessor);
    ```



### 与传统日期处理的转换![与传统日期处理的转换](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/与传统日期处理的转换.png)



### Java比较器

>   在实际开发场景中，我们需要对多个对象进行排序，要实现这种需求就会使用到两个接口：
>
>   Comparable | Comparator

##### Comparable接口

需要在排序的类的内部实现CompareTo(Object o) 方法

实现了该接口的CompareTo(Object o)方法后，就可以使用 Arrays.sort() 排序了

![自然排序：java.lang.Comparable](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/自然排序：java.lang.Comparable.png)

##### Comparator接口

临时使用，临时修改[ 在需要排序使用的sort() 方法中创建Comparator 匿名对象，然后重写 compare(o1, o2) 方法  ]

![定制排序: java.util.Comparator](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/定制排序: java.util.Comparator.png)

例子：

```java
String[] arr = new String[]{
    "AA", "CC", "BB", "FF", "GG", "MM", "WW", "NN"
};

// 按需求重写比较规则
Arrays.sort(arr, new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).compareTo((String) o2);
        }
        throw new RuntimeException("输入的数据类型不一致");
    }
});
```



### System类

*[ 一些属性后续流章节中详细讲解 ]*

*   java.lang 包中

*   构造器 private , 所以无法创建类的对象，内部方法属性都是static，可以直接调用

*   成员变量：

    *   System类内部包含in, out, err 三个成员变量，分别代表标准数入流「键盘输入」，标准输出流「显示器」和标准错误输出流「显示器」

*   成员方法

    *   native long currentTimeMillis( )

    *   void exit(int status)

        退出程序，status = 0 的时候表示正常退出，用于手动退出程序

    *   String getProperty(String key)

        获取属性名为key的属性对应的值，系统中常见的属性名及作用如下:

        | 属性名       | 说明               |
        | ------------ | ------------------ |
        | java.version | java运行时环境版本 |
        | java.home    | java的安装目录     |
        | os.name      | 操作系统的名称     |
        | os.version   | 操作系统版本       |
        | user.name    | 用户帐号名称       |
        | user.home    | 用户的主目录       |
        | user.dir     | 用户的当前工作目录 |

        

### Math类

java.lang.Math 提供了一些静态的数学方法，参数和返回值一般为double类型

*   abs 绝对值
*   acos， asin， atan, cos, sin, tan 三角函数
*   sqrt 平方根
*   pow(double a, double b)  a的b次幂
*   log 自然对数
*   exp e为底指数
*   max(double a, double b) 两者取大； min(double a, double b) 两者取小
*   random() 返回0.0 到1.0 的随机数
*   long round(double a) double型数据a转换为long型（四舍五入）
*   toDegrees(double angrad)  弧度 -> 角度
*   toRadians(double angdeg) 角度 -> 弧度

### BigInteger  

### ![BigInteger类](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/BigInteger类.png)

![BigInteger常用方法](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/BigInteger常用方法.png)

### BigDecimal

![BigDecimal](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/BigDecimal.png)