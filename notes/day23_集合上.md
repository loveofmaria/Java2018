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

    

# 集合「上」

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

    

### 使用 foreach 循环遍历集合

*   从JDK5.0开始引入 foreach 循环迭代访问 Collection 和数组

*   foreach 无需获取 Collection和数组长度，无需使用索引访问元素

*   遍历集合的底层调用 Iterator 完成操作

    ```java
    //   元素类型 自定义的元素名 Collection|数组名
    for (Person person: persons) {
        System.out.println(person.getName());
    }
    ```

    

### Collection子接口之一：List接口

***[ list 集合的元素都是包装类对象 ]***

*   概述：由于Java中数组用来存储数据的局限性，我们通常使用List替代数组。List集合类中元素有序，且可重复，集合中的每个元素都有其对应的顺序索引。List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素。

*   常用实现类：ArrayList, LinkedList, Vector

*   **ArrayList, LinkedList, Vector 的异同：**

    ***「需要阅读源码」***

    相同点：

    1.  都实现了List接口。
    2.  存储数据的特点相同：存储有序，可重复数据

    不同点：

    1.  ArrayList: 作为List接口的主要实现类，线程不安全，执行效率高; 底层使用Object[] 存储, 实际开发中建议使用带参数的构造器「直接指定容量」 ArrayList list = new ArrayList( 容量整数 );

    2.  LinkedList: 底层使用的是双向链表存储；如果需要频繁的插入、删除操作，该类操作效率要比ArrayList高，图示如下：

        ![LinkedList图示](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/LinkedList图示.png)

    3.  Vector 作为List接口的老旧的实现类；线程安全，执行效率低；底层使用Object[] 存储;***实际开发中并不使用***

     

*   ***List 接口类的常用方法***

    ***「增删改查」***

    *   void add(int index, Object ele) =>在index位置插入ele元素
    *   boolean addAll(int index, Collection eles) => 从index位置开始，将ele中所有的元素添加进来
    *   Object get(int index) => 获取指定index位置的元素
    *   int indexOf(Object obj) =>返回obj在集合中**首次**出现的位置
    *   int lastIndexOf(Object obj) => 返回obj在集合中**最后**出现的位置
    *   Object remove(int index) => 移除指定位置index的元素，并返回该元素
    *   Object set(int index, Object ele) => 设置指定index位置的元素为 ele
    *   List subList(int fromIndex, int toIndex) => 返回指定范围内的子集合**[ 包含开始，但不包含结束的元素 ]**
    *   int size() => 获取List的长度

    遍历方式：for循环；foreach循环；iterator方式

    ```java
    // 方式一
    for(int=0; i<list.size(); i++);
    // 方式二
    for(Object obj : list);
    // 方式三
    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
        iterator.next();
    }
    ```

*   List接口的面试题

    ```java
    // 输出语句的结果是什么
    
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    
    private static void updateList(List list) {
        list.remove(2);
        // 如果需要删除数据 2,而不是使用索引
        // list.remove(new Integer(2))
    }
    ```



### Collection接口之二：Set接口

***「Set添加元素的过程，以HashSet为例：要添加元素a，首先调用元素a所在的类的hashCode() 方法，计算元素a的哈希值，此哈希值接着通过某种算法计算出在HashSet底层数组中存放的位置( 索引位置 )，判断数组此位置上是否已经有元素:***

​		***如果此位置没有元素，则a添加成功；***

​		***如果此位置上有其他元素b(或者已经存在以链表形式的多个元素),则比较元素a与元素b的hash值：***

​				***如果hash值不相同，则元素a添加成功；***

​				***如果hash值相同，进而需要调用元素a所在类的equals()方法:***

​						***equals() 返回true,元素a添加失败***

​						***equals()返回false，则元素a添加成功***

​		***对于添加成功的情况，元素a与已经存在指定位置上的数据以链表的形式存储」***

***「无序性不代表是随机性，无序是值在底层数组中并非按照数组索引添加，而是按照哈希值添加」***

***「为了保证元素不可重复性，在重写的equals()方法中，如果相等需要返回false」***

![HashSet存储图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/HashSet存储图.png)

*   概述：Set接口是Collection的子接口，没有提供额外的方法「都是使用的Collection中的方法」。Set集合不允许重复的元素，Set判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法；

    *   **实现类之一：HashSet**:

    1.  HashSet是Set接口的典型实现，大多数时候使用Set集合都是使用这个实现类

    2.  HashSet按Hash算法存储集合中的元素，因此具有很好的存取、查找、删除性能

    3.  HashSet的特点：

        *   不能保证元素的顺序排序``
        *   不是线程安全的
        *   集合元素可以是 null

    4.  HashSet集合判断两个元素相等的标准：两个对象通过hashCode()方法比较相等，并且两个对象的 equals() 方法返回值也相等；

    5.  对于存放在Set容易中的对象，***对应的类一定要重写 equals() 和 hashCode(Object obj) 方法，以实现对象相等规则，即“相等的对象必须具有相同的散列值”***

        重写hashCode(Objcet obj) 方法的基本原则:

        *   在程序运行时，同一个对象多次调用hashCode() 方法应该返回相同的值
        *   当两个对象的 equals() 方法比较返回 true 时，这两个对象的hashCode()方法返回值也应该相等
        *   对象中用作 equals() 方法比较的 Field, 都应该计算hashCode 值

    *   ***LinkedHashSet***：**

        *   **LinkedHashSet是HashSet的子类**

        *   根据元素的hashCode值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，这使得元素看起来是**以插入顺序**保存的

        *   LinkedHashSet插入性能略低于HashSet，但是在迭代访问Set里的全部元素时有很好的性能

        *   LinkedHashSet不允许元素重复

        *   图示：

            ![LinkedHashSet结构图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/LinkedHashSet结构图.png)

    *   **实现类之三：TreeSet**

        *   图示:

            ![TreeSet结构图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/TreeSet结构图.png)

        *   TreeSet 是 SortedSet 接口的实现类，TreeSet可以确保集合元素处于排序状态

        *   不能添加不同类的对象 

        *   TreeSet底层使用红黑树接口存储数据

        *   TreeSet比较不是按照equals()方法，而是按照实现的Comparable 或者 Comparator 接口方法中的定义比较[ compareTo() 方法是否返回0来判断是否相等 ]

        *   新增方法：

            Comparator comparator()

            Object first()

            Object last()

            Object lower(Object e)

            Object higher(Object e)

            SortedSet subSet(fromElement, toElement)

            SortedSet headSet(toElement)

            SortedSet tailSet(fromElement)

        *   TreeSet 两种排序方法：自然排序和定制排序。默认情况下，TreeSet

            定制排序代码示例:

            ```java
            // 假设有一个Person类，属性「String name, int age」
            // 自定义的排序是 age 属性
            Comparator comparator = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if(o1 instanceof Person && o2 instanceof Person) {
                        Person p1 = (Person) o1;
                        Person p2 = (Person) o2;
                        return Integer.compare(p1.getAge(), p2.getAge());
                    } else {
                        throw new RuntimeException("传入类型不匹配....");
                    }
                }
            };
            // 创建 TreeSet 对象[ 参数为实现的comparator 方法 ]
            TreeSet treeSet = new TreeSet(comparator);
            set.add(new Person("TOM", 28));
            set.add(new Person("TOM", 31));
            set.add(new Person("Ma", 32));
            set.add(new Person("John", 32));
            set.add(new Person("Jack", 29));
            set.add(new Person("Zhang", 32));
            set.add(new Person("TOM", 33));
            
            // 如果age值相同，那么就会被认为是相同的元素，无法添加到 treeSet中
            Person {name: TOM, age: 28 }
            Person {name: Jack, age: 29 }
            Person {name: TOM, age: 31 }
            Person {name: Ma, age: 32 }
            Person {name: TOM, age: 33 }
            ```

            

        

    **关于IDE中自动生成的hashCode() 的说明:**

    ![](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/hashCode方法自动生成说明.png)

    

