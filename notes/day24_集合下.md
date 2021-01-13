# 集合「下」



## 回顾

1.  集合Collecton中存储的如果是自定义类的对象，需要自定义类重写那些个方法？为什么？
2.  ArrayList、LinkedList、Vector三者的相同和不同点有那些「源码分析」？
3.  List接口的常用方法有那些？「增 删 改 查 插 长度 遍历」,存储数据的特点
4.  如何使用Iterator和增强for循环遍历List，举例说明？
5.  Set存储数据的特点是什么？常见的实现类有那些「并没有自定义额外的方法，全部继承于Collection」？说明一下彼此的特点。
6.  Collection接口的常用方法
7.  Collection集合与数组之间的转换
8.  使用Collection集合存储对象，要求对象所属类的满足条件
9.  Collection的两种遍历方式「foreach[或者增强for循环] ,  Iterator」
10.  关于Iterator对象「迭代器，设计模式的一种」
11.  增强for循环的写法
12.  本章的要求：
     *   层次一：选择合适的集合类去实现数据的保存，调用其内部的相关方法；
     *   层次二：不同的集合类底层的数据结构为何？如何实现数据的操作的：增删改查等等。

对List对象去重的示例代码：

```java
// 去除List对象中的重复内容
// 核心代码部分「定义一个方法」
public static List duplicateList(List list){
    HashSet set = new HashSet();
    set.addAll(list); // 利用set的特性去重
    return new ArrayList(set); // 再把结果Set转换成List
}
```



## Map接口

>   Map：双列数据，存储 key-value对数据
>
>   实现类:
>
>   ​			HashMap : Map 的主要实现类,线程不安全，效率高;能存储 null的key和value
>
>   ​					LinkedHashMap: 保证遍历map时，元素可以按照添加的顺序排列,对于频繁的遍历操作，效率更高
>
>   ​			TreeMap : 可以保证添加的key-value实现排序遍历「默认根据key来排序」; 底层使用红黑树数据结构
>
>   ​			Hashtable : 老旧的实现类;线程安全，效率低；不能存储 null的key和value
>
>   ​					Properties ： 常用来处理配置文件；key-value都是String类型
>
>   HashMap 的底层： 数组+链表「JDK7.0」
>
>   ​									数组+链表+红黑树「JDK8.0」

### 继承树结构:

![Map接口继承树](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/Map接口继承树.png)

面试题：

1.  HashMap的底层实现原理
2.  HashMap和Hashtable的异同
3.  CurrentHashMap与Hashtable的异同



### Map结构的理解

[key无序且不能重复-set的特性, 要求key所在的set重写equals和hashCode方法]

[value无序可以重复-Collection特性]

![Map结构的理解图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/Map结构的理解图.png)



### Map接口的常用方法

*   添加、删除、修改操作

    1）Object put(Object key, Object value) 添加

    2）void putAll(Map m) 将另一个map对象的所有key-value对放到map中

    3）Object remove(Object key) 移除指定key的key-value对，返回value

    4）void clear() 清空map中的所有数据

*   元素查询操作

    1）Object get(Object key) 获取指定key的value

    2）boolean containsKey(Object key)  是否包含指定的key

    3）boolean containsValue(Object value) 是否包含指定的value

    4）int size() 返回key-value对的个数

    5）boolean isEmpty() 判断是否为空

    6）boolean equals(Object obj) 判断当前map和参数对象obj是否相等

*   元视图操作的方法

    1）Set keySet() 返回所有key构成的Set集合 

    2）Collection values() 返回所有value构成的Collection集合

    3）Set entrySet() 返回所有key-value对构成的Set集合



### HashMap底层实现原理[ JDK8.0为例 ]

### ![HashMap原理视图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/HashMap原理视图.png)

HashMap实际是一种“数组+链表”数据结构。在put操作中，通过内部定义算法寻止找到数组下标，将数据直接放入此数组元素中，若通过算法得到的该数组元素已经有了元素（俗称hash冲突，链表结构出现的实际意义也就是为了解决hash冲突的问题）。将会把这个数组元素上的链表进行遍历，将新的数据放到链表末尾。

通过哈希算法从寻止上能够高效的找到对应的下标，但是随着数据的增长，哈希冲突碰撞过多。在寻找数据上，找到该来链表，会通过遍历在寻找对应数据，如此将会使得get数据效率越来越低。在jdk1.8中，链表元素数量大于等于8将会重组该链表结构形成为“红黑树结构”，这种结构使得在hash冲突碰撞过多情况下，get效率比链表的效率高很多。

***put 的底层实现：***

​		1、首选判断table是否为空，数组长度为空，将会进行第一次初始化。（在实例化HashMap是，并不会进行初始化数组）

​		2、进行第一次resize()扩容之后。开始通过hash算法寻址找到数组下标。若数组元素为空，则创建新的数组元素。若数组元素不为空，同时hash相等，key不相等，同时不是TreeNode数据对象，将遍历该数组元素下的链表元素。若找到对应的元素，则覆盖，如果没有找到，就新建元素，放入上一个链表元素的next中，在放入元素之后，如果条件满足"链表元素长度>8"，则将该链表结构转为"红黑树结构"。

​		3、找到对应的数组元素或者链表元素，同时创建新的数据元素或者覆盖元素之后。如果条件满足元素大小size>允许的最大元素数量threshold，则再一次进行扩容操作。每次扩容操作，新的数组大小将是原始的数组长度的两倍。

​		4、put操作完成。

#### ***HashMap扩容resize()***

java是静态方法，在数组进行初始化时，必须给一个数组长度。HashMap定义默认的数组长度为16。条件满足元素size>允许的最大元素数量threshold。则进行扩容。一般来说，在put操作中，HashMap至少进行了一次扩容（第一次为初始化）。

***简单来说就是：***

***首先有一个每个元素都是链表（可能表述不准确）的数组，当添加一个元素（key-value）时，就首先计算元素key的hash值，以此确定插入数组中的位置，但是可能存在同一hash值的元素已经被放在数组同一位置了，这时就添加到同一hash值的元素的后面，他们在数组的同一位置，但是形成了链表，同一各链表上的Hash值是相同的，所以说数组存放的是链表。而当链表长度太长时，链表就转换为红黑树，这样大大提高了查找的效率。***

   ***当链表数组的容量超过初始容量的0.75时，再散列将链表数组扩大2倍，把原链表数组的搬移到新的数组中***![hashmapEntry数组图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/hashmapEntry数组图.png)

***HashMap的存储结构***

![HashMap存储结构](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/HashMap存储结构.png)



### HashMap源码中的重要常量说明

![HashMap源码中常量说明](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/HashMap源码中常量说明.png)



### LInkedHashMap底层原理

因为是继承于HashMap，所以大部分原理是相同的，核心逻辑代码如下:

```java
static class Entry<K, V> extends HashMap.Node<K, V> {
    Entry<K, V> before after; // 能够记录添加的元素的先后顺序
    Entry<int hash, K key, V value, Node<K, V> next) {
        super(hash, key, value, next);
    }
}
```

***HashSet 创建时，底层就是调用的HashMap。添加的值被当成了HashMap的key，value都设置成了 一个常量： 这个常量的值为 new Object()***



### HashMap的常用操作总结：

添加：put(Object key, Object value)

删除：remove(Obejct key)

修改：put(Object key, Object value)

查询：get(Object key)

长度：size()

遍历： keySet() / values() / entrySet()



### TreeMap :  可以保证添加的key-value实现排序遍历「默认根据key来排序」; 底层使用红黑树数据结构

*   向TreeMap中添加key-value，要求key必须是由同一个类创建的对象

*   因为要按照key排序：「自然排序、定制排序」

    

### Map实现类之五：Properties

*   Properties类是Hashtable的子类，该对象用于处理属性文件

*   由于属性文件里的key, value都是字符串类型，所以Properties里的key和value都是字符串类型

*   存取数据时，建议使用setProperty(String key, String value) 方法和getProperty(String key) 方法

    ```java
    Properties pros = new Properties();
    pros.load(new FileInputStream("jdbc.properties")); // 加载文件
    String user = pros.getProperty("user"); // 获取值
    System.out.println(user);
    ```

    

### Collections工具类

操作数组的工具类：**Arrays**

问题：Collection 和 Collections 的区别?

*   Collections是一个操作Set，List，Map等集合的工具类

*   Collections中提供了一系列的静态方法对集合元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制的方法；

*   排序操作：「均为static方法」

    1.  reverse(List) 反转List 中元素的顺序
    2.  shuffle(List) 对List集合元素进行随机排序
    3.  sort(List)根据元素的自然顺序对指定List集合元素按升序排序
    4.  sort(List, Comparator) 根据指定的Comparator产生的顺序排序
    5.  swap(List list, int i, int j) 将指定list集合中的i处元素和j处元素进行交换

*   同步控制方法[方法返回的对象即为线程安全的]：

    1.  synchronizedColletion(Collection<T> c)
    2.  synchronizedList(List<T> list)
    3.  synchronizedMap(Map<K, V> m)
    4.  synchronizedSet(Set<T> s)
    5.  synchronizedSortedMap(SortedMap<K, V> m)
    6.  synchronizedSortedSet(SortedSet<T> s)

*   一般常用方法：

    查找，替换

    1.  Object max(Collection) 返回给定元素中最大值

    2.  Object max(Collection, Comparator) 根据指定的排序方式，返回最大值

    3.  Object min(Collection) 返回最小值

    4.  Object min(Collection Comparator) 根据指定的排序方式，返回最小值

    5.  void copy(List dest, List src) 将src中的内容复制到dest中

    6.  boolean replaceAll(List list, Object odlVal, Object newVal) 使用新值替换List对象的所有旧值

    7.  int frequency(Collection c, Object c) 指定元素在集合中出现的次数

    8.  void copy(List dest, List src) 将src中的内容复制到dest中

        ***copy的错误示范:***

        ```java
        public void test() {
            List list = new ArrayList();
            list.add(22);
            list.add(123);
            list.add(123);
            list.add(234);
            list.add(78);
            list.add(78);
            list.add(78);
            list.add(101);
        
            // 初始化另一个 list
            List dest = new ArrayList();
            // 使用 Collections.copy 方法复制内容
            Collections.copy(dest, list);
            // 报错：java.lang.IndexOutOfBoundsException: Source does not fit in dest
        }
        ```

        ***copy的正确方式***

        ```java
        public void test() {
            List list = new ArrayList();
            list.add(22);
            list.add(123);
            list.add(123);
            list.add(234);
            list.add(78);
            list.add(78);
            list.add(78);
            list.add(101);
        
            // 初始化另一个 list
            List dest = Arrays.asList(new Object[list.size()])
            // 使用 Collections.copy 方法复制内容
            Collections.copy(dest, list);
        }
        ```

        

### 练习：

1.  从键盘随机输入10个整数保存到List，并按倒序，从大到小顺序显示；

2.  把学生名与考试分数录入到集合，并按分数显示前三名成绩学生的名字；

    TreeSet(Student(name, socre, id))

3.  姓氏统计：一个文本文件中存储着北京所有高校在校生的姓名，格式如下：

    每一个名字 姓与名以空格分开： 张  飞

    现在要统计所有姓氏在文件中出现的次数

4.  对一个java源文件中的关键字进行统计

    java源文件中的每一个单词，需要确定该单词是否是一个关键字，为了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains方法来测试

    ```java
    File file = new File("Test.java");
    Scanner scanner = new Scanner(file);
    while(scanner.hasNext()){
        String word = scanner.next();
        System.out.println(word);
    }
    ```

    

