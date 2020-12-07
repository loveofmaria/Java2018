#### 接口

* 有时候必须从几个类中派生出一个子类，继承他们所有的属性和方法，但是Java不支持多重继承。但是，有了接口，就可以得到多重继承的效果；
* 有时候必须从几个类中抽取出一些共同特征，而他们之间又没有is-a的关系，仅仅是具有相同的行为特征而已。【鼠标，键盘，打印机。。。。都支持USB连接，但是又不是is-a的关系】
* 接口就是规范，定义的是一组规范，体现了现实世界中的【“如果你是/要。。。则必须能。。。”】的思想。继承是一个【是不是】的关系，而接口是一个【能不能】的关系；
* 接口的本质：契约、标准、规范。制定好后大家都要遵守【法律一样】



#### 接口的定义【创建】

* 使用 interface 来定义

* 接口和类是并列的两个结构

* 定义接口中的成员【组成】

  ```java
  // JDK7 | JDK8 不同
  // JDK7 => 只能定义全局常量和抽象方法[public static final 常量] [public abstract 抽象方法]
  // JDK8 => 还可以定义静态方法和默认方法
  interface Flyable {
      // 全局常量
      public static final int MAX_SPEED = 9000;
      public static final int MIN_SPEED = 1;    
      
      // 抽象方法
      public abstract void fly();
      public abstract void stop();
  }
  
  class InterfaceTest {
      // 类中调用接口的属性
      Systemout.out.println(Flyable.MAX_SPEED);
  }
  ```

* 接口中不能定义构造器，也就是意味着接口无法实例化

* 接口都要通过类的方式实现，关键字【implements】

  1. 如果实现类覆盖【实现】了接口中的所有方法，则此实现类就可以实例化；
  2. 如果实现类没有覆盖【实现】接口中所有的方法，那么这个实现类就是一个抽象类

  ```java
  // 通过类实现接口 Flyable
  // 非抽象类
  class Plane implements Flyable {
      @Override
      public void fly() {
          System.out.println("覆盖了接口的 fly() 方法!")
      }
      
      @Override
      public void stop() {
          System.out.println("覆盖了接口的 stop() 方法!")
      }
  }
  
  // 抽象实现类
  abstract Plane implements Flyable {
      
  }
  // 只要不是全部实现了接口中的方法，都只能是抽象类
  abstract Kite implements Flyable {
      @Override
      public void fly() {
          
      }
  }
  ```

* 解决了类只能单继承的局限性【顺序: 先继承在实现 => class subClass extends parent implements someInterface {} 】

  ```java
  // 同时实现多接口的类
  interface Attckable {  
      public abstrct void kill();
  }
  
  // 继承多个接口的实现类
  class Bullet implements Flyable, Attackable {
      @Override
      public void fly() {
          System.out.println("覆盖了接口的 fly() 方法!")
      }
      
      @Override
      public void stop() {
          System.out.println("覆盖了接口的 stop() 方法!")
      }
      
      @Override
      public void kill () {
          System.out.println("覆盖了接口的Attackable的kill() 方法!")
  	}
  }
  ```

* 接口接口之间可以继承，并且可以多重继承

  ````java
  interface Aa {}
  interface Ba {}
  interface Cc {}
  // 继承
  interface extends Aa,Bb,Cc {}
  ````

* 接口的具体使用，体现了多态性

* 接口实际上可以看做是一种规范



#### 问题：抽象类和接口有哪些区别

![接口和抽象类的现实场景](F:\Projects\Java2018\notes\images\接口和抽象类的现实场景.PNG)



#### 排错题

```java
interface A {
    int x = 0; // 实质上是一个常量 public static final int x = 0;
}
class B {
    int x = 1;
}

class C extends B implements A {  
    public void pX() {
        System.out.println(x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}
// 因为类和接口属于同级结构，所以 x 无法确定是那个结构中的属性[ 这里是 x ]
// 如果是父类的属性 => super.x
// 如果是接口的属性 => A.x 
```

```java
interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public Ball(String name) {
        this.name = name;
    }
    
    @Override
    // 由于接口中的方法名一样，所以实现的时候只要写一个就都算实现了
    public void play() {
        ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}
// ball 已经是接口的一个属性，而且是静态属性，所以无法修改其值 【ball = new Ball("Football") 错误】
```

#### 案例练习

* 定义一个接口来实现两个对象的比较

  -> interface CompareObject {

  ​		public int compareTo(Object o);

  } 返回0则表示相等，若为正数，那么代表当前对象大；负数代表当前对象小

* 定义一个Circle类，声明redius属性，提供getter和setter方法

* 定义一个ComparableCircle类，继承CirCle类，并且实现CompareObject接口。在ComparableCirCle类中给出接口中的方法compareTo的实现体，用来比较两个圆的半径大小；

* 定义一个测试类InterfaceTest, 创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小;

* 参照上述做法，定义矩形类Rectangle和ComparableRectang类，在ComparableRectang类中给出compareTo方法的实现，比较两个矩形面积大小.