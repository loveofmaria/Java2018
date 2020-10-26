##### 隐式转换 [Java中的默认转换规则 ]

当2个数据类型不同的数据进行运算时，如果没有特别操作，那么java默认会转换成int类型，比如：

```java
// byte + int
public class Demo2_1 {
    public static void main(String[] args) {
        int i = 10;
        byte b = 20;
        
        // b = i + b;
        // b 变成了int类型        
    }
}

```



##### 强制转换:

指定转换的格式，语法为：

类型 变量名 = (类型) (数据 运算符 数据 )

```java
public class Demo2_2 {
    public static void main(String[] args) {
        byte b = 100;
        int i = 200;
        
        // 强制转换成 byte 类型
        byte b = (byte) (b + i);
    }
}
```



##### 一个常见的问题：

```java
// 指出这里代码的问题，并说明理由

public class Demo2_3 {
    public static void main(string[] args) {
        byte b1 = 3;
        byte b2 = 4;
        byte b3 = b1 + b2;
    }
}
```

理由说明:

* java 隐式转换类型为 int，所以 b1 + b2 在没有特别指明类型的情况下，是会自动转为 int 类型；
* byte b3 = b1 + b2 相当于把一个int类型的值赋值给一个byte类型的变量，大赋小要报错；



##### long 类型和 float 类型的大小问题:

数据类型从小到大排列 「内存占位」 **byte** < **short** < **char** < **int** < **long** < **float** < **double**

虽然从表面上看，long类型占8个字节而float才占4个字节，但是它们底层的存储结构是不同的。

float类型的范围是：一3.403E38~3.403E38。而long类型的范围是：-2^63~2^63-1（大概是9*10^18）。

long整型数，在内存中占用8个字节共64位，它表示的数值有2的64次方，平分正负，数值范围是负2的63次方到正2的63次方-1。

而float在内存中占4个字节，共32位，但是浮点数在内存中是这样的：

**V=(-1)^s \* M \* 2^E**

![1345633464_1030](/home/gux/Documents/Java2018/notes/images/1345633464_1030.jpg)

浮点数的32位不是简单的直接表示大小，而是按照一定的标准分配的。

其中第1位，符号位，即S。

接下来的8位，指数域，即E。

剩下的23位，小数域，即M，M的取值范围为[1，2）或[0，1）

也就是说，浮点数在内存中的二进制值不是直接转换为十进制数值的，而是按照上述公式计算而来，通过这个公式，虽然只用到了4个字节，但是浮点数却比长整型的最大值要大。

这也就是为什么在数据转换的时候，long类型转换为float类型的根本原因所在！



##### 关于字符和数字的混合运算：

原理是java在计算过程中，会把字母转换成ASCII码的值「一个整数」，然后在与数字计算

```java
// 字母与数字的混合运算
public class Demo2_4 {
    public static void main(String[] args) {
        // 'a' 的ASCII码的值是 97,所以输出结果为 98
        System.out.println('a' + 1);
    }
}
```

也可以通过 char 强制转换为字母，即 char 类型

```java
public class Demo2_4 {
    public static void main(String[] args) {
        // 'a' 的ASCII码的值是 97,所以输出结果为 98
        System.out.println('a' + 1);
       	// 下面输出 'b'
        System.out.println((char)('a' + 1));
    }
}
```

复杂的案例说明:

```java
public class Demo2_5 {
    public static void main(String[] args) {
        // 先运算 hello + a = helloa
        // 在运算 helloa + '1' = helloa1
		System.out.println("hello" + 'a' + 1);
        
        // 先运算 97 + 1 = 98;
        // 再运算 '98' + hello = 98hello;
        System.out.println('a' + 1 + "hello");
    }
}
```

结论：

* 字符串 + 任意 = 直接拼接成字符串
* 字母 + 数字 = 转换成ASCII码后的值的运算



##### 一个关于赋值运算符的问题：

```java
// 指出下面代码的问题，并说明原因
public class Demo2_6 {
    public static void main(String[] args) {
        short s = 1;
        s = s + 1;
        
        short s = 1;
        s += 1;
    }
}
```

原因说明：

* 第一次赋值错误，因为s是short类型，因为没有强制转换，那么 s+1 则会默认转换为 int，所以存在大数据类型赋值给小数据类型的问题;
* 第二次赋值正确，是因为 += 运算符是自增操作，即在原有的数字「类型」基础上增加1，相当于执行了 (short) (s + 1)的操作；



##### 关系运算符：

关系运算符的运行结果必然是 true | false, 即 boolean 类型

== | != | > | >= | < | <= 