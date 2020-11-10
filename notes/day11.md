#### 接下来的要点：

1. OOP的特征二 【继承性】
2. 方法的重写【override】
3. 四种访问权限修饰符
4. 关键字【super】
5. 子类对象实例化过程
6. OOP特征三【多态性】
7. Object类的使用
8. 包装类的使用



#### 继承性

语法：class A extends B {}

A: 子类、派生类、subclass

B:父类、超类、基类、superclass

**一旦子类A继承了父类B以后，子类A就获取了父类B中声明的结构、属性【包括私有】、方法**

```java
// 父类 Person
class Person{
    String name;
    int age;
    // 对于私有属性，子类不能直接读取调用，必须现在父类中创建get/set方法,然后在由子类继承
    private int heigh;
    
    sleep(){
        System.out.println("睡觉!!");
    }
    eat(){
        System.out.println("吃饭!")
    }
    
    public int getHeigh(){
        return height;
    }
}

// 子类 Student
class Student extens Person{
    String major;    
    // name， age 属性来自继承
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
   
    public static void main(String[] args){
         // 无法直接调用父类的私有属性 heigh
        // 需要使用父类的 set/get方法使用私有属性
        heigh = getHight();
    }
}
```

Java只支持单继承和多层继承，不允许多重继承：

* 一个子类只能有一个父类-【直接父类】，但是【间接父类】可以有多个【多层次继承】
* 子类继承父类后，就获取了**直接父类以及所有间接父类中的声明的属性和方法**
* 一个父类可以派生出多个子类
* 父类中声明为private属性或方法，子类继承父类以后，仍然认为获取了父类当中的私有的结构，只是因为封装性的影响，使得子类不能直接调用父类的结构而已。



#### Object类的理解

如果我们没有显示的声明一个类的父类，那么该类继承于`java.lang.Object`类

所有Java类【除了java.lang.Object】都直接或者间接的继承于`java.lang.Object`类

这意味着所有的java类具有java.lang.Object类声明的功能:

1. public final native Class<?> getClass()
2. public native int hashCode()
3. public boolean equals(Object obj)
4. protected native Object clone() throws CloneNotSupportedException
5. public String toString()
6. public final native void notify()
7. public final native void notifyAll()
8. public final native void wait(long timeout) throws InterruptedException
9. public final void wait(long timeout, int nanos) throws InterruptedException 
10. public final void wait() throws InterruptedException
11. protected void finalize() throws Throwable { }



#### 练习

```java
// 1 在CylinderTest类中创建Cylinder类的对象，设置圆柱的地面半径和高，并输出圆柱的体积
/*
Circle:
-radius: double
Circle(): 构造器，将 radius 初始化为1
+setRadius(): double
+getRadius(): double
+findArea(): double 计算圆的面积

Cylinder
-length: double
Cylinder(): 构造器将length属性初始化为1
+setLength(double length): void
+getLength(): double
+findVolume(): double 计算圆柱体积
*/
```

