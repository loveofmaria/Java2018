# 常用类



### 字符串相关

*   String 类：代表字符串，Java程序中的所有字符串字面值都作为此类的实例实现；

*   String 是一个final类，代表不可变的字符序列;

    不可变性体现在:

    			1. 当堆字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
    			2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value赋值
    			3. 当调用String 的 replace（）方法修改指定字符串或者字符时，也需要重新指定内存区域中新的value值

*   字符串是常量，用双引号引起来表示，它们的值在创建之后不能更改;

*   String对象的字符串内容是存储在一个字符数组final char[] value中的;

*   String 实现了Serializable接口：表示字符串是支持序列化的,

    ​			实现了Comparable接口: 表示String可以比较大小;

*   如果拼接的结果调用intern()方法，返回值就在常量池中;

*   内部定义了 final char[] value 用于存储字符串数据

*   常量池中的字符串值「内容」是不能存在相同的内容「值」的，（使用equals() 比较）

##### String类及常用方法

String 对象的创建

String str = "hello";

// 本质上 this.value = new char[0];

String s1 = new String();

![String和new String()的区别](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/String和new String()的区别.png)

// this.value = original.value;

String s2 = new String(String original);

// this.value = Arrays.copyOf(value, value.length);

String s3 = new String(char[] a);

String s4 = new String(char[] a,  int startIndex, int count);

1.  StringBuffer

2.  StringBuilder

    

#### 字符串的常用方法

|                             方法                             |                             说明                             |                       例子                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------: |
|                         int length()                         |                       返回字符串的长度                       |               return value.length                |
|                    char charAt(int index)                    |                      返回某索引处的字符                      |               return value[index]                |
|                      boolean isEmpty()                       |                      判断是否是空字符串                      |             return value.length == 0             |
|                     String toLowerCase()                     |       使用默认语言环境，将String中的所有字符转换为小写       |                                                  |
|                     String toUpperCase()                     |       使用默认语言环境，将String中的所有字符转换为大写       |                                                  |
|                        String trim()                         |           返回字符串的副本，忽略前导空白和尾部空白           |                                                  |
|                  boolean equals(Object obj)                  |                   比较字符串的内容是否相等                   |                                                  |
|        boolean equalsIgnoreCase(String anotherString)        |                 与equals方法类似，忽略大小写                 |                                                  |
|                  String concat(String str)                   |         将指定字符串连接到此字符串的结尾，等价于“+”          |                                                  |
|             int compareTo(String anotherString)              |                     比较两个字符串的大小                     |                                                  |
|               String substring(int beginIndex)               | 返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个字符串 |                                                  |
|        String substring(int beginIndex, int endIndex)        | 返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex「不包含」的一个子字符串 |                                                  |
|               boolean endsWith(String suffix)                |               测试此字符串是否以指定的后缀结束               |                                                  |
|              boolean startsWith(String prefix)               |               测试此字符串是否以指定的前缀开始               |                                                  |
|        boolean startsWith(String prefix, int toffset)        |    测试此字符串从指定索引开始的子字符串是否以指定前缀开始    |                                                  |
|               boolean contains(CharSequence s)               |       当且仅当此字符串包含指定的char值序列时，返回true       |                                                  |
|                   int indexOf(String str)                    |          返回指定字符串在此字符串中第一次出现的索引          |                                                  |
|            int indexOf(String str, int fromIndex)            | 返回指定字符串仔此字符串中第一次出现处的索引，从指定索引开始 |                                                  |
|                 int lastIndexOf(String str)                  |         返回指定字符串在此字符串中最右边出现处的索引         |                                                  |
|          int lastIndexOf(String str, int fromIndex)          | 返回指定子字符串仔此字符串中最后一次出现处的索引，从指定的索引开始反向搜索 | 注：indexOf和lastIndexOf方法如果未找到都是返回-1 |
|          String replace(char oldChar, char newChar)          | 返回一个新的字符串，它通过用newChar替换此字符串中出现的所有oldChar得到的 |                                                  |
| String replace(CharSequence target, CharSequence replacement) | 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串 |                                                  |
|     String replaceAll(String regex, String replacement)      | 使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串 |                                                  |
|    String replaceFirst(String regex, String replacement)     | 使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串 |                                                  |
|                boolean matches(String regex)                 |             告知此字符串是否匹配给定的正则表达式             |                                                  |
|                 String[] split(String regex)                 |              根据给定正则表达式匹配拆分此字符串              |                                                  |
|           String[] split(String regex, int limit)            | 根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中 |                                                  |

### 常见算法题目[ 字符串 ]

*   获取两个字符串中最大相同字串，比如：

    str1 = "abcwerthelloyuiodef";

    str2 = "cvhellobnm";

    提示：

    1.  将短的那个子串按照长度递减的方式获取到
    2.  将每获取到的字串去长串中判断是否包含，如果包含，就已经找到「 string.contains(str) 方法判断」

*   对字符串中字符进行自然顺序排序

    提示:

    1.  字符串变成字符数组;
    2.  对数组排序，选择，冒泡，Arrays.sort();
    3.  将排序后的数组变成字符串.

*   模拟一个trim方法，去除字符串两端的空格

    思路：记住前后的连续空格最后一个的位置，然后通过 subString(start， end) 截取

*   将一个字符串进行反转，将字符串中指定的部分进行反转，比如：将”abcdefg"反转为"abfedcg"

*   获取一个字符串在另一个字符串中出现的次数，比如：获取“ab”在“abkkcadkabkebfkabkskab"中出现的次数

*   String, StringBuffer, StringBuilder三者的异同

    String: 不可变的字符序列，底层使用char[] 进行存储

    StringBuffer: 可变字符序列; 线程安全「效率低」, 底层使用char[] 进行存储

    StringBuilder: 可变字符序列； 线程不安全「效率高」, 底层使用char[] 进行存储

    执行效率 String < StringBuffer < StringBuilder

    ***实际开发中，尽量使用StringBuffer(指定长度) 的方式来创建字符串***

    **StringBuffer [ StringBuilder ]类的常用方法:**

    | 方法名「insert，append操作可扩容」「支持方法链操作」 | 作用                         |
    | ---------------------------------------------------- | ---------------------------- |
    | StringBuffer append(xxxx)                            | 提供了众多的append()拼接方法 |
    | StringBuffer delete(int start, int end)              | 删除指定位置的内容           |
    | StringBuffer replace(int start, int end, String str) | 把[start, end] 位置替换为str |
    | StringBuffer insert(Int offset, xxx)                 | 在指定位置插入xxx            |
    | StringBuffer reverse()                               | 把当前字符序列反转           |
    | public int indexOf(String str)                       | 获取某个字符的下标           |
    | public String substring(int start, int end)          | 获取指定范围的子字符序列     |
    | public int length()                                  | 获取字符长度                 |
    | public char charAt(int n)                            | 获取指定下标的字符           |
    | public void setCharAt(int n, char ch)                | 设置指定下标位置的字符       |

    

### JDK8之前的日期时间API

##### System静态方法

java.lang.System类

System类提供的public static long currentTimeMills() 用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差,通常称为时间戳

计算世界时间的主要标准有：

*   UTC [ Coordinated Universal Time ]
*   GMT [ Greenwich Mean Time ]
*   CST [ Central Standard Time ]

##### Date类

java.util.Date类「java.sql.Date 对应数据库中的日期类型的变量」

***Date 类型强转为 java.sql.Date 类型编辑器不报错，但是编译报错***

相互转换需要通过共同的方法getTime() 来实现 =＞　java.sql.Date dateSQL = new java.sql.Date(date.getTime())

*   构造器
    1.  Date(): 使用无参数构造器创建的对象可以获取本地当前时间
    2.  Date(long date)
*   常用方法
    1.  getTime(): 返回自1970年1月1日00:00:00 GMT 以来此 Date 对象表示的毫秒数
    2.  toString(): 把此 Date 对象转换为以下形式的 String: dow mon dd hh:mm:ss zzz yyyy 其中: dow 是一周中的某一天，zzz 是时间标准

##### Calendar类

*   Calender 类是一个抽象类，主要用于完成日期字段之间互相操作的功能
*   获取Calender实例的方法
    1.  Calender.getInstance()
    2.  子类构造器 GregorianCalender
*   一个Calender的实例是系统时间的抽象表示，通过get(int field) 方法来取得想要的时间信息，比如: YEAR, MONTH, DAY_OF_WEEK, HOUR_OF_DAY, MINUTE, SECOND
    1.  public void set(int field, int value)
    2.  public void add(int field, int amount)
    3.  public final Date getTime()
    4.  public final void setTime(Date date)
*   注意：
    1.  获取月份时，是从0开始表示月份，即1月是数字0
    2.  获取星期时，从周日开始，数字从1开始





 





