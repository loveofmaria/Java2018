#### 抽象类与抽象方法的使用

1. **抽象类**

   随着继承层次中的一个个新子类的定义，类变得**越来越具体**，而父类则更一般，更通用。

   类的设计应该保证父类和子类能够共享特征。

   有时将一个父类设计得**非常抽象**，以至于它**没有具体的实例**，这样的类叫抽象类。

   【不在创建实例对象；使用 abstract 关键字修饰】

   【abstract 还可以修饰方法，叫抽象方法】

   【抽象类虽然不能手动创建对象，但是构造器还是应该要存在，因为可以通过子类来调用】

2. **抽象方法**

   【abstract 不能修饰私有、静态 方法、final 方法】

   只有方法声明，而没有方法体【具体代码】

   抽象方法不能被调用

   包含抽象方法的类，一定是一个抽象类【应为不能被调用的前提是没有对象来调用该方法】

   若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类【所有抽象方法包括间接继承的父类中的方法】【若子类没有重写完父类的方法，那么该子类也是一个抽象类】

3. **应用场景**

![抽象类抽象方法使用场景](F:\Projects\Java2018\notes\images\抽象类抽象方法使用场景.PNG)

 4. 创建匿名子类的对象

    ```java
    // Person为抽象类，其中有一个eat() 抽象方法
    // 下面的 new Person() 实质上并不是抽象方法 Person,因为重写了内部抽象方法 eat(),所以应该是一个匿名的子类
    Person p = new Person(){
        @Override
        public void eat(){}
    }
    ```





#### 多态的应用：模板方法设计模式【TemplateMethod】

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

解决问题：

* 当功能内部一部分实现是确定的，一部分实现是不确定的，这时可以把不确定的部分暴露出去，让子类去实现；
* 在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变的部分可以抽象出来，供不同的子类实现，这就是一种模板模式。

```java
// 固定通用流程的抽象父类 Template
abstract class Template{
    public void doSomethingHere(){
        // 流程
        System.out.println("第一步");
        this.secondStep();
        System.out.println("第三步");
    }
    // 开放出去的不能确定的部分
    public abstract void secondStep();
}

// 子类-实现具体的需求【secondStep()】
class Subtemplate extends Template{
    @Override
    public void secondStep(){
        System.out.println("第二步");
    }
}

// 实现
Subtemplate subTemplate = new Subtempalte();
subTemplate.doSomethingHere(); => 父类的doSomething()方法中的this.secondStep()这里调用子类重写后的方法
```



#### 练习

编写工资系统，实现不同类型员工[多态]的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元

1. Employee 类，属性=> private[ String-name, int-number, MyDate-birthday],abstract 方法 earning(), 重写 toString,输出 name, number, birthday;
2. MyDate 类, 属性=> private[ String year, String month, String day ], toDateString() 方法返回对应的字符串-xxxx年xx月xx日；
3. SalariedEmployee类，继承Employee，实现按月计算工资处理，属性private [ int-monthlySalary ],实现earning() 方法，返回monthlySalary值， toString()输出员工类型信息以及员工的name，number，birthday;
4. HourlyEmployee类，实现按小时计算工资，属性 private [int-wage, int-hour],方法earing()返回[wage * hour],toString()不变;
5. PayrollSystem类，创建Employee变量数组，并初始化，该数组存放各类雇员对象的引用，利用循环遍历数组元素，输出各个对象的类型，name,number,birthday. 当键盘输入本月月份值时，如果是某个员工对象的生日，还要输出增加工资的信息.













​	