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
    ```

    

##### LocalDate, LocalTime, LocalDateTime

##### Instant

##### DateTimeFormatter

##### 其他类



### Java比较器

##### Comparable接口

##### Comparable接口



### System类

### Math类

### BigInteger与BigDecimal