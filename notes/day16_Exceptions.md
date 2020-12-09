#### 异常概述与异常体系结构

* Java语言中，程序执行的异常情况为“异常”，而不是语法错误
* 执行过程中的异常情况：
  1. **Error**： Java虚拟机无法解决的严重问题。例如JVM内部错误，资源耗尽等严重情况，一般不编写针对性的代码进行处理；
  2. **Exception**：其他因编写错误或者偶然的外在因素导致的一般性为题，可以使用针对性的代码进行处理：
     * 空指针的访问
     * 试图读取不存在的问题
     * 网络连接中断
     * 数组界标越界
* 对于这些错误，处理方式有两种「遇到错误终止运行」「在编写时就考虑到可能的错误，提前处理」
* 捕获错误最理想的是在编译期间，但有的错误只有在运行时才会发生
  * 编译时异常
  * 运行时异常
* ![异常体系结构](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/异常体系结构.png)



#### 体系结构

类：java . lang . Trowable

子类包括：

1. java.lang.Error 一般不编写针对性的代码进行处理；

2. java.lang.Exception 可以进行异常的处理

   * 编译时异常「checked」：

     * IOEException
       * FileNotFoundException
     * ClassNotFoundException

   * 运行时异常「unchecked」

     * NullPointerException

     * ArrayIndexOutOfBoundsException

     * ClassCastException

     * NumberFormatException

     * InputMismatchException

     * ArithmaticException

       

问题：常见的异常有那些？举例说明！