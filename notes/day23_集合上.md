# 集合

>   1.  Java 集合框架的概述
>   2.  Collection接口方法
>   3.  Iterator迭代器接口
>   4.  Collection子接口一： List
>   5.  Collection子接口二：Set
>   6.  Map接口
>   7.  Collections工具类



## Java集合框架概述



*   为了方便多个对象的操作
*   解决Array存储对象方面的一些弊端
    *   数组长度无法动态更改
    *   数组类型无法动态更改
    *   数组提供的属性和方法少，不便进行添加，删除，插入等操作，且效率不高
    *   数组存储数据有序且可以重复 
*   Java集合类可以用于存储数量不等的多个对象，且还可以用于保存具有映射关系的关系数组

**Java 集合可以分成 Collection 和map两种体系：**

*   Collection接口：单列数据，定义了存取一组对象的方法的集合
    1.  List：元素有序，可重复的集合
        *   ArrayList, LinkedList, Vector
    2.  Set：元素无序，不可重复的集合
        *   HashSet, LinkedHashSet, TreeSet
*   Map 接口： 双列数据，保存具有映射关系” key-value“对的集合「python中的字典」
    1.  HashMap
    2.  LinkedHashMap
    3.  TreeMap
    4.  Hashtable
    5.  Properties



## Collection 接口

