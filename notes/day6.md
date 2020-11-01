> 从面向对象开始，视频改成尚硅谷教程，并且编辑器改成 idea

#### 面向对象内容的三条主线

1. Java类及类的成员「属性、方法、构造器、代码块、内部类」
2. 面向对象的三大特征「封装性、继承性、多态性、 (抽象类)」
3. 其他关键字 「this，super，static，final，abstract，interface，package，import...」



#### 面向对象「OOP」和面向过程「POP」的对比

1. 面向过程强调功能和行为，以函数为最小单位，考虑的是怎么做；
2. 面向对象则将功能封装在对象内，强调具备了功能的对象，以类/对象为最小单位，考虑的是谁来做；
3. 面向对象更加强调运用人类在日常的思维逻辑中采用的思想方法与原则；



#### 类和实例

1. 类：是对一类食物的描述，是抽象，概念上的定义；

   面向对象程序设计的重点就是对类的设计

   Java中用类class来描述，常见的成员有「属性、行为」

   ```java
   public class Person {
       // 属性
       String name;
       int age;
       boolean isMarried;
       //构造器
       // 一 无参数
       public Person(){};
       // 二 有参数
       public Person(String n, int a, boolean im){
           name=n;
           age=a;
           isMarried=im;
       }
       // 方法
       public void setName(String name){
           this.name = name;
       }
       
       public void setAge(int age){
           this.age = age;
       }
       
       public void setMarried(boolean im){
           this.isMarried = im;
       }
       
       public void displayInfo(){
           String r = (this.isMarried)? "是" : "否";
           System.out.println("姓名: " + this.name);
           System.out.println("年龄: " + this.age);
           System.out.println("婚否: " + r);
       }
   }
   ```

   

2. 对象：是实际存在的该类食物的每个个体，因此也称为「instance」;

   ```java
   // 创建实例
   public class PersonTest{
       public static void main(String[] args){
           // 使用无参数构造器创建
           Person xm = new Person();
           xm.name = "小明";
           xm.age = 28;
           xm.isMarried = true;
           xm.displayInfo();
           // 使用有参数构造器创建
           Person xm = new Person("小明", 29, true);
           xm.displayInfo();
       }
   }
   // 如果新创建的对象没有给定参数，那么默认值为:
   // String -> null
   // int -> 0
   // boolean -> false
   ```

   

#### 对象的创建和使用：内存解析

* 堆[Heap]：存放实例对象，所有实例对象以及数组都要在堆上分配；
* 栈[Stack]：存储局部变量「各种基本数据类型，对象引用。方法执行完毕，自动释放」
* 方法区[Method Area]: 用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据；

![对象创建内存图](/home/gux/Documents/Java2018/notes/images/对象创建内存图.png)