### 判断下面代码的输出结果

```java
public class ReturnExceptionDemo {
    // 方法A
    static void methodA {
        try {
            System.out.println("进入方法A");
            trhow new RuntimeException("制造异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }
    
    // 方法B
    static void methodB() {
        try {
            System.out.println("进入方法B");
            return ;
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
    // main 方法
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();
    }
}

/*
	1 进入方法A
	2 用A方法的finally
	3 进入方法B
	4 调用B方法的finally
*/
```



编写应用程序EcmDef.java, 接受命令行的两个参数，要求不能输入负数，计算两数相除；

1.  对数据类型不一致（NumberFormatException），缺少命令行参数（ArrayIndexOutBoundsException）除0（ArithmeticException）及输入负数（EcDef 自定义的异常）进行异常处理；

2.  提示

    -   [ ] 在主类（EcmDef）中定义异常方法（ecm）完成两数相除功能

    -   [ ] 在面main() 方法中使用异常处理语句进行异常处理

    -   [ ] 在程序中，自定义对应输入负数的异常类(EcDef)

    -   [ ] 运行时接受参数 java EcmDef 20 10 => args[0] = "20" args[1]="10"

    -   [ ] Interger 类的static 方法 parseInt(String s) 将s转换成对应的int值

        如：int a = Integer.parseInt("314");

```java
public class EcmDef {

    public static void main(String[] args) {
        try {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            System.out.println(ecm(x, y));
        } catch (NumberFormatException | ArithmeticException | MyExceptionTest | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double ecm(double x, double y) throws  MyExceptionTest {
        if(x < 0 || y < 0) {
            throw new MyException("参数不能输入负数");
        }
        return x / y;
    }
}

// 自定义异常类
class MyException extends Exception {
    static final long serialVersionUID = 23430434039L;
    
    public MyException() {}
    public MyException(String msg) {
        super(msg);
    }
}
```

