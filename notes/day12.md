#### Eclipse 的 DBUG方式

略过【后面使用IDEA】



#### 方法的重写【override/overwrite】

**在子类中**根据需要对从**父类中继承来**的方法进行改造，在执行程序的时候，**子类方法会覆盖父类的方法**

1. 子类方法必须和父类方法一致【相同的方法名，参数列表】

   **如果仅仅是方法名相同，参数列表不同，那么就是方法重载而不是重写了**

2. 子类方法重写后的返回值类型不能大于父类被重写方法的返回值类型【子类：int， 父类：short => 不行】

3. 子类重写的方法使用的访问权限不能小于父类被重写的方法访问权限【子类private，父类public => 不行】

   子类不能重写父类中声明为private权限的方法

4. 子类方法抛出的异常不能大于父类被重写方法的异常

   **总结：名+参 相同**

   ​			**异常+返回 不能大于父类[父类为void, 子类不能重写]**

   ​			**权限不能小于父类[private 不能重写，因为权限最小了]**

   ​			**static是静态方法，随着类的加载而加载，这类方法不能重写**

   重写的习题：

   ```java
   // 1 如果现在在父类的一个方法定义成private访问权限，在子类中将此方法声明为default访问权限，那么这样还叫重写吗？
   ```

   

#### 四种访问权限的修饰符【回顾protected】

主要是在父类，子类的情况下使用 protected 修饰符的回顾



#### super 关键字

子类重写父类的方法后，还需要用到父类该方法的场景

1. super 可以理解为“父类的”

2. super 可以用来调用父类的：属性、方法、构造器

3. 需要显示的使用super调用父类的属性和方法，通常是因为子类中重写了同名的属性和方法

   ```java
   public class Person{
   	int id=1000;
       
       public void showID(){
           System.out.println("父类的ID：" + id);
       }
   }
   
   public class Child extends Person{
       // 重写属性
       int id=1001;
       // 重写方法，在方法中通过super调用父类的id属性
       @Override
       public void showID(){
           System.out.println("父类的ID: " + super.id);
           System.out.println("子类的ID: " + this.id);
       }
   }
   ```

4. 在构造器首行，如果没有显式的声明“this(形参列表)"或者"super(形参列表)"，则默认调用父类中的空参构造方法super() [ 如果子类中有多个构造器，至少有一个无参构造器使用了父类的super() ]



#### 子类对象实例化过程

![子类对象实例化过程](F:\Projects\Java2018\notes\images\子类对象实例化过程.PNG)

**创建子类对象时，虽然调用了父类的构造器，但是自始自终在内存中就只创建过一个对象，即new 的对象**



实验练习：

```java
/*
	1. 创建一个Account的类模拟账户：
		属性：
		账号id；余额balance；年利率annuInterestRate
		方法：
		get/set； 取款：withdraw（），存款：deposit（）；返回月利率：getMonthlyInterest();
		
		测试：
		创建账号：1122；余额为：200000；年利率：4.5%；
		提款：30000；打印余额；提款2500；存款3000；打印余额
		
		提示:
		在提款方法中，需要判断用户余额是否能满足提款数额的要求，如果不能，给出提示
		
	2.	创建一个CheckAccount子类，代表可以透支的账户，该账户中定义一个属性overdraft代表可以透支限额。在
		该类中重写withDraw方法，其算法如下：
		A. 如果（取款金额<账户余额),可以直接取款
		B. 如果(取款金额>账户余额),计算需要透支的额度，判断可透支overdraft是否足够支付本次透支需要，如果			可以，将账户余额修改为0，冲减可透支金额，如果不可以，提示用户超过可透支额的限额
		
		测试：
		创建CheckAccount对象1122，余额为20000，年利率为4.5%，可透支限额为5000
		使用withDraw方法提款5000，并打印账户余额和可透支额
		使用withDraw方法提款18000，并打印账户余额和可透支额
		使用withDraw方法提款3000，并打印账户余额和可透支额
*/
```



#### 多态性

1. 多态性是面向对象中最重要的概念

   对象的多态：父类的引用指向子类的对象【可以直接应用在抽象类和接口上】

2. Java引用变量有两个类型：编译时类型和运行时类型。编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。简称：**编译时，看左边；运行时，看右边**。

   * 若编译时类型和运行时类型不一致，就出现了对象的多态性【Polymorphism】

   * 多态情况下，”看左边“：看的是父类的引用(父类中不具备子类特有的方法)

     ​						”看右边“：看的是子类的对象(实际运行的是子类重写父类的方法)

```java
class A {
    int id = 1000;
    public dosomething(){
        System.out.println("method in A");
    }
}

class B extends A {
    int id = 1001;
    @Override
    public dosomething(){
        System.out.println("method in B");
    }
}

class C extends A {
    int id = 1002;
    @Override
    public dosomething(){
        System.out.println("method in C");
    }
}

// 父类引用指向子类对象
// 编译期是 A类型；执行期是 子类类型
A a = new B();
A a1 = new C();
// 执行 dosomething() 方法
a.dosomething() => 输出：method in B
a1.dosomething() =>输出: method in C
// 多态性不适用于属性    
a.id => 1000;
a1.id => 1000;
```

**对象的多态性只适用于方法，不适用于属性！**



#### 虚拟方法调用【多态性】

![虚拟方法调用图](F:\Projects\Java2018\notes\images\虚拟方法调用图.PNG)

**总结【重载和多态的区别】：**

【重载】：允许在多个同名方法，而这些方法的参数不同。编译器根据方法不同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了不同的方法。**他们调用的地址在编译期就绑定了**。Java的重载是可以包括父类和子类的，即子类可以重载父类的同名不同参数的方法。

所以：对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这成为”**早绑定**“或”**静态绑定**“；

【多态】：只有等到方法调用的那一刻，编译器才会确定索要调用的具体方法，这成为”晚绑定“或者”动态绑定“

> "不要犯傻，如果它不是晚绑定，它就不是多态。" —— Bruce Eckel



