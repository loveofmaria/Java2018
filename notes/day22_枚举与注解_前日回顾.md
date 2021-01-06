## 昨天回顾：

1.  将字符串"2017-08-16"转换为对应的java.sql.Date类对象

    *   SimpleDateFormat

    *   DateTimeFormatter

        代码说明:

        ```java
        public static java.sql.Date strToSQDate(String dateString) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            	// 当格式化的字符串没有时间的时候，需要调用LocalDate.parse, 而不是 LocalDateTime.parse
        		// 而且还需要调用 atStartOfDay() 指定时间
                LocalDateTime date = LocalDate.parse(dateString, formatter).atStartOfDay();
                long localDateTime = LocalDateTime.from(date).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                return new java.sql.Date(localDateTime);
            }
        ```

        

2.  解释何为编码？解码？何为日期时间的格式化？解析？

3.  自定义Person类如下，如何实现自然排序「按姓名从小到大排序」

    ```java
    class Person {
        private String name;
        private int age;
    }
    ```

4.  提供定制排序涉及到的接口的实现类对象，并按Person类的年龄从大到小排序

5.  JDK8 之前和JDK8 中，日期，时间相关的类分别有哪些？

