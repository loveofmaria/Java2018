#### 关键字 **final**

1. final 关键字可以修饰类、变量、方法
2. 用 final 修饰的类不能被继承,比如 String类，System类，StringBuffer类.....
3. final 修饰的方法不能被重写,比如Object中的getClass( )方法
4. final 修饰的变量成为常量，即不可变，可以考虑的赋值位置有：显示初始化、代码块中初始化、构造器中初始化
5. static final 用来修饰的属性叫 **全局常量**



#### 练习一

```java
// 排错
public class Something {
    public int addOne(final int x){
        return ++x;
        // return x+1 => 可行
    }
}
// 局部变量 int x 使用 final 修饰后，就不能在方法内更改值了
```

#### 练习二

```java
// 排错
public class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }
    public void addOne(final Other o){
        o.i++;
    }
}

class Other{
    public int i;
}
// 可以编译通过运行，不报错
```

