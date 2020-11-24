> 对于是否可以使用继承关系的简单判断：A is B = true 则可以使用继承关系



#### instanceof 操作符

x instanceof A: 检验X是否为类A的对象，返回值为boolean类型

1. 要求X所属的类与类A必须是子类和父类的关系，否则编译错误
2. 如果X属于类A的子类B，X instanceof A值也为true

**使用场景**：

​	为了避免在向下转型时出现ClassCastException异常，我们在向下转型之前，先进行instanceof判断，一旦返回true,就进行向下转型，如果返回false，不进行向下转型。

```java
class Person{}
class Man extens Person{}
class Woman extens Person{}

// 问题一：编译时通过，运行时不通过
Person person = new Woman();
// 强转[ 向下转型 ]
// 报错 ClassCastException
Man personMAN = (Man)person;

// 问题二：编译通过，运行时也通过
// 都只是类型转换，方法调用时任然是 Woman 类的方法
Object obj = new Woman();
Person p = (Person)obj;
```



#### 向下转型的使用

1. 有了对象的多态性后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用；

2. 解决方法【向下转型】：![向下转型](F:\Projects\Java2018\notes\images\向下转型.PNG)

3. 向下转型前要使用 instanceof 进行类型的判断;

   如果 p instanceof Man 成立，那么 p instance of Person 也成立，其中 Person 是 Man 的父类.

   ```java
   class Person { String atr }
   class Man extens Person { boolean isSomking atr 1}
   
   Person p = new Man();
   // 转换后调用子类 Man 的方法和属性
   // 先使用 instanceof 判断 当前实例是否属于需要转型的类
   if(p instanceof Man){
       Man p1 = (Man)p;
   	p1.siSomking = true;
   }
   ```

   

#### 多态的练习

```java
// 父类
public class Base {
    int count = 10;
    public void display(){
        System.out.println(this.count);
    }
}
// 子类
public class Sub extends Base {
    int count = 20;
    @Override
    public void display(){
        System.out.println(this.count);
    }
}
// 测试
public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);
        s.display();
       // 下面的输出是什么
        Base b = s; // 多态性
        // 这里的 == 是比较引用数据类型变量地址值
        System.out.println(b == s); // true
        System.out.println(b.count); // 10
        b.display(); // 20      
    }
}
/*
	结论：
		子类属性是根据就近原则查找，因为当前类中有count属性，那么就直接调用声明类的属性,否则去父类查找调用；所以子类 s.count 为20；
		多态不看属性，而是直接调用声明类的属性，比如上面的列子中，b 声明的是 Base 类型，所以调用 count 是 Base 的count属性, b.count 为 10；
		但是因为多态的关系，在调用 display()方法时，调用的就是 Sub 的display方法了
		
		!!实际开发中不要定义相同的属性名!!
*/
```

