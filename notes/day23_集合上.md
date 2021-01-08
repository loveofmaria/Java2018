# 回顾

1.  什么是枚举类？枚举类的对象声明修饰符有那些？

    **枚举类：**类中的对象个数是确定的，是有限的

    **特殊情况**：对象只有一个，那么就是单例模式

    **修饰符**：public static final 「不能使用 private 」

2.  什么是元注解？Retention和Target元注解的作用

    **元注解**：对现有的注解进行解释说明的注解

    **Retention**：指名所修饰的注解的生命周期「SOURCE, CLASS, RUNTIME」

    **Target：**指定被修饰的注解可以修饰那些元素「类，对象，数据类型等等」

3.  集合框架接口都有那些，存储数据的特点是什么

    **Collection 接口** 「单列集合，用来存储一个一个的对象」

    *   **List 接口**「存储有序的，可重复的数据」
        *   ArrayList，LinkedList， Vector
    *   **Set接口**「存储无序，不可重复的数据」
        *   HashSet，LinkedHashSet，TreeSet

    **Map 接口**「双列集合，用来存储一对（key-value）」

    *   HashMap，LinkedHashMap，TreeMap，Hashtable，Properties

4.  比较throw和throws的区别

    **throw：**生成一个异常，并抛出。使用在方法内部 <->自动抛出异常对象

    **throws**：相当于一种处理异常的方式，使用在方法声明处的末尾 <-> try-catch-finally 

    "上游排污「throw」"，"下游治污「throws」"

5.  同步代码块中同步监视器和共享数据的理解以及各自要求是什么？

    **同步监视器：**俗称锁。

    1.  任何一个类的对象都可以充当锁；
    2.  多个线程共用一把锁

    **共享数据**：多个线程共同操作的数据，即为共享数据「需要使用同步机制将要操作共享数据的代码包裹」

    

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

![Collection接口继承树](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/Collection接口继承树.png)



### Collection 常用方法

***结论：向Collection接口的实现类的对象中添加数据obj时，要求obj所在的类要重写equals()***

1.  add(Object obj) 往容器中添加一个对象

2.  contains(Object obj)  判断一个对象是否存在与容器当中, 

3.  containsAll(Collection collection)  判断多个对象是否都存在与容器当中

4.  remove(Object obj) 移除容器内的一个对象, 返回 true | false

5.  remove(Collection collection) 移除多个对象, 返回 true | false

6.  retainAll(Collection collection)  求两个集合的交集「会直接把原集合修改为交集」

    ```java
    Collection coll = Arrays.asList(123, 234, 345, 456);
    Collection coll_1 = Arrays.asList(234, 345);
    
    // 求交集，然后重新把交集作为结果赋值给 coll
    coll.retainAll(coll_1);
    System.out.println(coll); // => [234, 345]
    ```

7.  equals(Object obj) 判断当前集合和另一个集合是否一致「只有当两个集合的元素都相同时才会返回true」

8.  hashCode(Collection coll) 获取hash值

9.  toArray()  把集合转换成数组

    ```java
    Object[] arr = coll.toArray();
    ```

    把数组转换成集合

    ```java
    int[] arr = {1, 2, 3, 4,5};
    // 注意：这种写法会把整个 arr 当成一个元素，即 coll.size() => 1
    Collection coll = Arrays.asList(arr);
    // 正确的写法
    collection coll = Arrays.asList(new Integer[] {1, 2, 3, 4,5});
    ```

    

### Iterator迭代器接口

*   Iterator 对象称为迭代器「设计模式的一种」，主要用于遍历Collection集合中的元素
*   GOF给迭代器模式的定义为：提供一种方法访问一个容器「container」对象中各元素，而又不需暴露该对象内部的细节。迭代器模式，就是为迭代器而生，类似与“公交车上的售票员”，“空姐”，“火车售票员”
*   Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所有实现了Collection接口的集合类都有一个iterator() 方法，用以返回一个实现了Iterator接口的对象
*   Iterator 仅用于遍历集合，Iterator本身并不提供承装对象的能力，如果需要创建Iterator对象，则必须有一个被迭代的集合
*   集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素

**Iterator 接口的方法：**

***如果 hasNext() 返回false还继续调用 next() 则报错：NoSuchElementException***

*   forEachRemaining(Consumer<? super E> action)

*   hasNext()

*   next()

*   remove()  删除集合中的一个元素 iterator.remove();

    **注意**：

    *   Iterator 可以删除集合的元素，但是遍历过程中通过迭代器对象的 remove 方法，不是集合对象的 remove 方法
    *   如果还没调用 next() 或在上一次调用的 next 方法之后已经调用了 remove 方法，在调用 remove 方法都会报 IllegalStateException 错误



**关于遍历集合元素的写法问题:**

```java
// 开发中的推荐写法, 而不是用 for 循环「习惯问题」
Iterator iterator = collections.iterator();
while(iterator.hasNext()){
    System.out.println(iterator.next());
}
```

![迭代器执行原理](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/迭代器执行原理.png)

**遍历集合的两种错误方式：**

1.  next() 在没有元素的时候会报错：NoSuchElementException， 而不是值为 null

    ```java
    // 错误
    while(iterator.next() != null) {
        iterator.next();
    }
    ```

2.  集合在调用 iterator() 方法时，每调用一次则会创建一个新的 Iterator 对象, 所以必须要用一个变量接收保存

    ```java
    // 死循环
    while(collection.iterator().hasNext()) {
        collection.iterator().next();
    }
    ```

    

