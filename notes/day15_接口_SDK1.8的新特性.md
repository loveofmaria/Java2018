#### JDK8的接口可以定义默认方法和静态方法【可以有代码体】

**可以给接口添加静态和默认方法，但不意味着推荐这么做，因为这样就违反了接口作为规范的意义**

```java
public interface CompareA {
    // 静态方法+代码体
    public static void method1() {
        // dosomething here
    }
    
    // 静态方法+默认方法
    public default void method2() {
        // dosomething here
    }
}
```

1. 接口中定义的静态方法只能通过接口来调用;

2. 默认方法使用 default 关键字修饰，可以通过**实现类对象**来调用;

3. 默认方法可以被实现类中重写；

4. 如果实现类的父类中存在同名的属性或者方法，如果实现类没有重写，那么默认调用父类的属性和方法【类优先原则】；

5. 如果实现类是同时实现了多个接口【不存在继承父类】，而这些接口中存在同名的参数或者方法名，那么就会报错【接口冲突】, 那么就需要在实现类中重写【必须重写】该重名的方法；

6. 如果想要在实现类中调用接口中的默认方法，可以使用 interfaceName.super.defaultMethod( ) 的方式,

   ```java
   interface Example{
       default void method_1 () {}
   }
   
   class Test implements {
       public void methodInClass(){
           Example.super.method_1();
       }
   }
   ```



#### 练习：解决接口冲突

```java
interface Filial {
    default void help() {
        System.out.println("老妈，我来救你了!");
    }
}

interface Spoony {
    default void help() {
        System.out.println("媳妇，别怕，我来了!");
    }
}

class Man implements Filial, Spoony {
    // 必须要重写
    @Override
    public void help() {
        System.out.println("我该怎么办?");
     //   Filial.super.help();
     //   Spoony.super.help();
    }
}
```



