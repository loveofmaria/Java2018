# 泛型



## 回顾

1.  Map存储数据的特点是什么？并指明key、value、entry存储数据的特点
2.  描述HashMap的底层实现原理「JDK8」
3.  Map中常用的实现类有那些？各自有什么特点？
4.  如何遍历Map中的键值对，代码实现
5.  Colletion和Collections有什么区别？



>   为什么要有泛型
>
>   在集合中使用泛型
>
>   自定义泛型结构
>
>   泛型在继承上的体现
>
>   通配符的使用
>
>   泛型应用举例



## 为什么要有泛型「Generic」

*   **泛型 --> 标签**

*   **泛型的设计背景：**为了解决容器类声明阶段的类型问题「确定这个容器到底存放的什么类型」

    因为这个时候除了元素的类型不确定，其他的部分都是确定的，因此此时把元素的类型设计成一个参数，这个类型参数叫泛型 Collection<E>, LIst<E>, ArrayList<E>,  这里的<E>就是类型参数，即泛型

*   **泛型的概念：**

    所谓的泛型，就是允许在定义类、接口时通过一个标识标识在类总的某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时「例如，继承或者实现这个接口，用这个类型声明变量，创建对象时」确定「即出入实际的类型参数，也称为类型参数」。

*   ***在指定泛型的时候要注意，泛型不能为基本数据类型。「比如要指定Integer,而不是int」***



## 自定义泛型结构

1.  **泛型类，泛型接口**

    如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类类型为Object类型

    要求：在实例化时应该要指明类的泛型

    继承：子类在定义时，如果指明了父类的泛型，则在子类实例化时，就不再需要指明泛型

    ```java
    public class EmployeesToGenericTest {
        @Test
        public void test1(){
            // 实例化时，应该要指明类的泛型
            Order<String> order = new Order<String>("orderOne", 1001,
                    "orderDescription");
        }
    }
    
    class Order<T> {
        private String orderName;
        private int orderId;
        // 类的内部结构使用类的泛型
        T orderT;
    
        public Order(String orderName, int orderId, T orderT) {
            this.orderName = orderName;
            this.orderId = orderId;
            this.orderT = orderT;
        }
    }
    
    class SubOrder extend Order<Integer> {
        // 子类指明了父类的泛型，所以在实例化时，无需指明泛型
        // SubOrder 不是泛型类
    }
    // 子类指明了父类的泛型，所以在实例化时，无需指明泛型
    SubOrder sub = new SubOrder();
    
    class SubOrder1<T> extend Order<T> {
        // SubOrder1<T> 仍然是泛型类
    }
    ```

    ***一些需要注意的细节问题:***

    *   泛型类可能有多个参数，此时应将多个参数一起放在尖括号内，比如<E1, E2, E3>

    *   泛型类的构造器：public GenericClass(){}

        public GenericClass<E>(){} 则是错误写法

    *   实例化后，操作原来泛型位置的结构必须与指定的泛型类一致

    *   泛型不同的引用不能相互赋值

    *   尽管在编译时ArrayList<String> 和 ArrayList<Integer>是两种类型，但是，运行时只有一个ArrayList被加载到JVM中

    *   泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价与Object。「要用泛型就全部都用，否则一个不用」

    *   如果泛型类是一个接口或者抽象类，则不可创建泛型类的对象

    *   泛型的简化写法：ArrayList<Fruit> flist = new ArrayList<>();

    *   泛型的指定中不能使用基本数据类型，可以使用包装类替换

    *   静态方法中不能使用类的泛型, 因为静态方法在类对象创建之前就要创建，而泛型是在类对象创建时才创建

    *   异常类不能是泛型类

    *   不能使用 new E[]，但是可以这样写：E[] elements = (E[]) new Object[ length ];

    *   父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型

        1.  子类不保留父类的泛型：

            *   类有类型  擦除

                ```java
                class Father<T1, T2> {}
                calss Son1 extends Father {}
                ```

                

            *   具体类型

                ```java
                class Son2 extends Father<Integer, String>{}
                ```

                

        2.  子类保留父类的泛型：泛型子类

            *   全部保留

                ```java
                class Son3<T1, T2> extends Father<T1, T2> {}
                ```

                

            *   部分保留

                ```java
                class Son4<T2> extends Father<Integer, T2> {}
                ```

                

                ***结论：子类除了指定或保留父类的泛型，还可以增加自己的泛型***

2.  **泛型方法**

    *   在方法中出现了泛型结构，「泛型参数与类的泛型参数没有任何关系，和所属类是否为泛型类没有任何关系」；

        ```java
        // 泛型方法的定义
        public <E> List<E> copyFromArrayListToList(E[] arr){ 
        	ArrayList<E> list = new ArrayList<>();
            for(E e : arr) {
                list.add(e);
            }
            return list;
        }
        // 泛型方法调用时，指明泛型参数的类型
        Integer[] arr = new Integer[]{1,2,3,4,5};
        List<Integer> list = copyFromArrayToList(arr);
        ```

    *   泛型方法可以声明为静态，因为泛型参数是在调用方法时确定的，并非在类的实例化时调用

        ```java
        // 泛型方法可以声明为静态
        public static <E> List<E> copyFromArrayListToList(E[] arr){ 
        	ArrayList<E> list = new ArrayList<>();
            for(E e : arr) {
                list.add(e);
            }
            return list;
        }
        // 泛型方法调用时，指明泛型参数的类型
        Integer[] arr = new Integer[]{1,2,3,4,5};
        List<Integer> list = copyFromArrayToList(arr);
        ```

        

## 泛型在继承上的体现

类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系；

A<G> =  B<G> 则可以 ***「无论父类是接口还是类」***

```java
Object[] obj = new Object[5];
String[] str = new String[5];
obj = str; // 可以

List<Object> list1 = null;
List<String> list2 = null;
list1 = list2; // 错误，因为list1, list2 是并列关系

List<String> list1 = null;
ArrayList<String> list2 = null;

list1 = list2; // 可以
```



## 通配符的使用

通配符： ？

类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是 G<?>

```java
// 定义的例子
public void printIterator(List<?> list){
    Iterator<?> iterator = list.iterator();
    while(iterator.hasNext()) {
        Object obj = iterator.next();
        System.out.println(obj);
    }
}
// 调用
List<Object> list = null;
List<String> list1 = null;
List<Integer> list2 = null;
// 不同考虑泛型类型，直接调用即可
printIterator(list);
printIterator(list1);
printIterator(list2);
```

***对于 List<?> 这种类型，不能使用 add 方法添加数据,除非添加 null「即不能写入」***

***对于 List<?> 可以使用 get 方法读取，用 Object 类型变量接收 「即可以读取」***



### 有限制的通配符

*   <?> 允许所有泛型的引用调用

*   通配符指定上限

    上限 extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即 <=

*   通配符指定下限

    下限 super：使用时指定的类型不能小于操作的类，即  >=

*   举例：

    1.  <? extends Number> 「无穷小，Number」

        只允许泛型为Number及Number子类的引用调用

    2.  <? super Number> 「Number， 无穷大」

        只允许泛型为Number以及Number父类的引用调用

    3.  <? extends Comparable>

        只允许泛型为实现Comparable接口的实现类的引用调用

    ```java
    G<? extends A>； // 可以作为G<A>和G<B>的父类，其中B是A的子类
    G<? super A> //   可以作为G<A>和G<B>的父类，其中B是A的父类类
    ```

    

## 泛型应用举例：泛型嵌套

用户在设计类的时候往往会使用类的关联关系，例如：一个人中可以定义一个信息的属性，但是一个人可能有各种各样的信息，所以此信息属性的类型就可以通过泛型进行声明，然后只要设计相应的信息类即可，如图：

![泛型实际案例图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/泛型实际案例图.png)

```java
// 示例代码
class Person<T extends Info> {
    private T info;
    
    public Person(T info) {
        // 通过构造器设置信息属性内容
        this.info = info;
    }
    public void setInfo(T info){
        this.info = info;
    }
    public T getInfo(){
        return info;
    }
    @Override
    public String toString(){
        return "Peron [info=" + info + "]";
    }
}

// 假设已经定义好的接口或者类  Contact, Introduction
public class GenericPerson{
    public static void main(String[] args){
        Person<Contact> per = null;
        per = new Person<Contact>(new Contact("北京市" "01065858258", "102206"));
        
        Person<Introduction> per = null;
        per = new Person<Introduction>(new Introduction("李磊" "男", 24));
    }
}
```



### 练习

1.  定义一个泛型类 DAO<T>, 在其定义一个Map成员变量，Map的键为String类型，值为T类型；

    定义一个User类：

    ​			该类包含 private int id, age,     private String  name

    定义一个测试类：

    ​			创建DAO类的对象，分别调用save，get，update，list，delete方法操作User对象

    创建一下方法：

    *   public void save(String id, T entity) 保存T类型的对象到Map成员变量
    *   public T get(String id) 从map中获取id对应的对象
    *   public void update(String id, T entity) 替换map中key为id的内容，改为entity对象
    *   public List<T> list() 返回map中存放的所有T的对象
    *   public void delete(String id) 删除指定id的对象