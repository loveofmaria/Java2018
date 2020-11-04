>   面向对象第二天

##### 完成一个项目[或者功能]的思路

*   根据问题需要,选择问题所针对的现实世界中的实体;
*   从实体中寻找解决问题相关的属性和功能,这些属性和功能就形成 了概念世界中的类;
*   把抽象的实体用计算机语言描述,形成计算机世界中的类的定义,把类构造成计算机能够识别和处理的数据结构;
*   将类实列化成计算机世界中的对象.对象是计算机世界中解决问题的最终工具.



#### 匿名对象

*   创建对象没有显示的赋给一个变量名
*   特征: 匿名对象只能调用一次[ 结束后自动丢弃 ]
*   最常使用的场景: 使用其他类来调用[ 下面代码中的PhoneMall 类实列来调用 ]

```java
class TestPhone{
    public static void main(String[] args){
        //使用匿名对象
        // 下面每一次调用内方法,都是一个新的对象
        new Phone().sendEmail();
        new Phone().playGame();
        new Phone().price = 2000; // 设置了一个属性
        new Phone().showPrice(); // 这里不是2000,而是 0.0
        // 通过 PhoneMall 类的实例来使用 Phone的匿名对象
        // 实际作用就是在其他类的对象中调用另一个类实例的功能,但是又不会创建具体实例
        PhoneMall pm = new PhoneMall();
        // 这里的 new Phone() 这个对象已经赋值给了 show(Phone phone) 中的 phone形参,在内存中用 phone 这个形参名来调用
        pm.show(new Phone());
    }
}

class Phone {
    double price; //价格
    
    Phone() {};// 构造函数
    
    public void showPrice(){
        System.out.println(price);
    }
    public void sendMail(){
        System.out.println("发邮件!");
    }
    public void playGam(){
        System.out.println("玩游戏!");
    }
}

// 出现的使用场景
class PhoneMall{
    public void show(Phone phone){
        phone.sendEmail();
        phone.playGame();
    }
}
```



#### 再谈方法

1.  方法的重载

    **概念**: 在同一个类中,允许存在一个以上的同名方法,只要它们的参数个数或者参数类型不同即可;

    **特点**: 与返回值类型无关,只看参数列表,且参数列表必须不同,调用时,根据方法参数列表的不同来区别;

    **判断**: 跟方法的权限修饰符,返回值类型,形参变量名,方法体都没有关系!

    ```java
    // 返回两个整数的和:
    int add(int x, int y){return x + y};
    // 返回三个整数的和
    int add(int x, int y, int z) {return x+y+z};
    // 返回两个小数的和
    double add(double x, double y) {return x + y};
    ```

    练习:

    ```java
    /* 1.
    	三个方法分别接受 int,  [int, int], [String],分别执行
    	平方运算-返回, 相乘运算-返回, 输出字符串信息
    	
    	2.
    	定义三个重载方法max(),第一个方法求两个int值的最大值,第二个方法求两个double值中的最大值,第三个方法求3个double值中的最大值
    */
    ```

    

2.  可变参数的方法

    可变参数方法与同名的方法,不同类型参数之间构成重载

    (String[] numbers) 与 (String ... numbers) 两种方式冲突

    如果参数是混合类型,那么可变参数必须放在最后[数组则没有要求]

    ```java
    // 同一类型,多个参数[数量可变]
    // 这种传参方式包含了只有一个参数和零个参数的情况的情况,
    // public void show(String[] strings){}; 与下面的传参方式是冲突的
    public void show(String ... strings){
        for(int i=0; i<strings.length; i++) {
            // 对每个参数 strings[i] 进行操作
        }
    };
    
    public void show(int ... numbers){};
    
    // 混合参数的位置有要求
    public void show(String string, int ... numbers){}; //必须放在最后
    public void show(int[] numbers; String string){}; // 数组可以在任意位置
    ```

    

3.  **方法参数的值传递机制 [ 重点 ]**

    *   方法: 必须由其所在的类或者对象调用才有意义.若方法有参数,那么参数可分为:

        1.  形参 - 定义方法的时候,使用的参数占位符
        2.  实参 - 方法调用时,实际传入的参数数据

    *   java的实参值的传入方法

        java里方法的参数传递方式只有一种: 值传递,即将实际参数值的副本(复制品)传入方法内,而参数本身不受影响.

        1.  形参是基本数据类型,将实参基本数据类型变量的“数据值”复制 传递给形参
        2.  形参是引用数据类型,将实参引用的数据类型变量的“地址值”复制传递给形参,但同样指向的是堆中的对象

    ```java
    public class ValueTransferTest1 {
        public static void main(String[] args) {
            //方法形参的传递机制
            // 交换变量的数据
            int n = 10;
            int m = 20;
            // 这里的变量m, n虽然名字和方法里面的形参一样,但是不是同一个变量,所以下面方法内带入的仅仅是赋值的数值[即赋值一份的数值],并不是变量m, n本身,所以无法被修改
            swapValue(m, n); // swapValue(m, n)方法执行完成后会弹栈,所以其内部的变量(m, n)都会丢弃
            // 所以这里的m, n 还是main方法中的两个变量[m, n]
            System.out.println("方法体外: " + "m = " + m + ", n = " + n);
        }
    
        public static void swapValue(int m, int n){
            n = n ^ m;
            m = n ^ m;
            n = n ^ m;
            System.out.println("方法体内: "+"m = " + m + ", n = " + n);
        }
    }
    ```

    **如果需要通过方法传参的方式修改数据,那么就应该要传入引用类型的参数**

    ```java
    // 上面列子的修改,改成传入引用数据类型
    public class ValueTransferTest3 {
        public static void main(String[] args) {
            Data data = new Data();
            data.m = 10;
            data.n = 20;
            System.out.println("方法修改数据前: \n" + "m = " + data.m + ", n = " + data.n);
            // 这里的实参是个引用数据类型
            swapValue(data);
            System.out.println("方法修改数据后: \n" + "m = " + data.m + ", n = " + data.n);
        }
    	// 该方法内都是对引用数据类型对应的堆中的对象数据进行直接修改
        public static void swapValue(Data data){
            data.m = data.m ^ data.n;
            data.n = data.m ^ data.n;
            data.m = data.m ^ data.n;
        }
    }
    
    class Data{
        int m;
        int n;
    }
    ```

    练习一:

    ```java
    // 判断下面代码的输出
    public class TransferTest3 {
        public static void main(String[] args){
            TransferTest3 test = new TransferTest3();
            test.first();
        }
        
        public void first(){
            int i=5;
            Value v = new Value();
            v.i = 25;
            second(v, i);
            System.out.println(v.i); // 20
        }
        
        public void second(Value v, int i){
            i=0;
            // 把 first() 中的对象 v.i 改成了20
            v.i=20;
            Value val = new Value();
            v = val;
            System.out.println(v.i + " " + i); // 15 0
        }
    }
    
    class Value {
        int i=15;
    }
    ```

    练习一图示:

    ![传参机制练习内存图](images/%E4%BC%A0%E5%8F%82%E6%9C%BA%E5%88%B6%E7%BB%83%E4%B9%A0%E5%86%85%E5%AD%98%E5%9B%BE.png)

    练习二:

    ```java
    public class Test{
        public static void main(String[] args){
            int a=10;
            int b=10;
            // 需要在method方法被调用之后,仅仅打印出a=100,b=200,写出method代码
            method(a, b);
            System.out.println("a= " + a);
            System.out.println("b= " + b);
        }
         // 代码编写处
    }
    // 思路一: 在方法内输出需要的字符串,方法执行完成后中断程序执行[不执行下面两句]       	System.out.println("a= " + a);
    //    System.out.println("b= " + b);
    //    中断程序执行 System.exit(0);
    
    // 思路二: 重置打印流,即把System.out.println 方法重写
    ```

    练习三:

    ```java
    // 定义一个int型的数组: int[] arr = new int[]{12, 3, 3, 45, 56, 77, 432};
    // 让数组的每个位置上的值去除以首位置的元素,得到结果,作为该位置上的新值,遍历新的数组
    public Test3 {
        public static void main(String[] args){
            int[] arr = new int[]{12, 3, 3, 45, 56, 77, 432};
        }
    }
    ```

    练习四:

    ```java
    // String str = new String{"a", "b", "c"};
    // System.out.println(str) => 输出地址值
    
    // char[] c = new char[]{'a', 'b', 'c'};
    // 问: System.out.println(c) 输出什么?
    // char[] 字符类型的数组在Java中会本当成字符串看待,所以打印输出时会被处理成字符串
    
    System.out.println(c); => "abc";
    ```

    练习五:

    ```java
    // 1 定义一个Circle类,包含一个double型的radius属性,和一个findArea()方法计算面积
    // 2 定义一个PassObject类,有一个方法叫printAreas(),该方法的定义如下:
    public void printAreas(Circle c, int time){
        // 在方法中打印输出1-time之间的每个整数半径值,以及对应的面积.
    }
    // 3 在main方法中调用printAreas(),调用完毕后输出当前半径值,如图:
    ```

    ![练习5[参数传递机制]输出图](images/%E7%BB%83%E4%B9%A05%5B%E5%8F%82%E6%95%B0%E4%BC%A0%E9%80%92%E6%9C%BA%E5%88%B6%5D%E8%BE%93%E5%87%BA%E5%9B%BE.png)

4.  递归方法

    一个方法体内调用它自身[ 实质上是在重复执行方法体内的代码 ]

    递归一定要向已知方向递归,否则这种递归就变成了无穷递归,类似于死循环

    ```java
    // 计算1-100之间的所有自然数的和
    public int sum(int num){
        if(num==1){
            return 1;
        }else {
            return num + sum(num-1);
        }
    }
    ```

    练习一

    ```java
    // 用递归写出求阶乘(N!)的算法
    ```

    练习二

    ```java
    // 已知有一个数列: f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n),其中n是大于0的整数,求f(10)的值
    ```

    练习三

    ```java
    // 已知一个数列: f(20)=1, f(21)=4, f(n+2)=2*f(n+1)+f(n), 其中n是大于0的整数,求f(10)的值
    ```

    练习四

    ```java
    // 输入一个数据n,计算斐波那契数列(Fibonacci)的第n个值,并将整个数列打印出来
    ```

    练习五

    ```java
    // 汉诺塔游戏问题
    ```

    练习六

    ```java
    // 快速排序算法
    ```

    



