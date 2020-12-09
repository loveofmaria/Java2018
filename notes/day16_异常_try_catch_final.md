#### 代码处理异常

```java
public class ExceptionTest {
    
    public void test() {
        String str = "123";
        str = "abc";
        
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("替换掉的异常的信息，保证程序仍然在运行....")
        } catch (NullPointerException e) {
            System.out.println("捕获另一种异常，然后处理")
        } finally {
            System.out.println("无论如何都会执行的语句....")
        }
    }
}

```

当 catch 捕获到异常处理完成后，那么就会跳出 try....catch 结构「如果没有finally的情况下」

通常情况下使用 e.getMessage( ) | e.printStackTrace( ) 输出异常的信息

在 try ... catch 结构中定义的变量，无法在外部调用， 除非在外部声明，内部赋值

```java
public class ExceptionTest {
    
    public void test() {
        String str = "123";
        str = "abc";
        int num = 0; // 外部声明
        try {
            // 内部赋值
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("替换掉的异常的信息，保证程序仍然在运行....")
        } catch (NullPointerException e) {
            System.out.println("捕获另一种异常，然后处理")
        }
        // 然后可以调用 num 变量
        System.out.println(num);
    }
}
```



#### finally 的使用

finally 是可以选的，不是必须出现的语句

finally 中声明的是一定会被执行的代码，即使catch 中又有异常，try 中有 return 语句，catch 中有 return 语句的情况

在方法体中，就算 return 出现在 finally 之前，那么程序也会先执行 finally, 然后在执行 return 

finally 使用的场景：

​		数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动处理回收。需要手动进行资源释放！！

```java
public class ExceptionTest {
    
    public void test() {

        try {
            // 内部赋值
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            // catch 中又可能出现异常
            // 直接跳转到 finally
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("这里写的代码是一定需要执行的内容....")
        }
        
    }
}
```

文件流的处理

```java
finallyHandle() {
        FileInputStream f = null;
        try {
            File file = new File("hello.txt");
            f = new FileInputStream(file);

            int data = f.read();
            while (data != -1) {
                System.out.println((char) data);
                data = f.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        // 处理方式    
        } finally {
            try {
                assert f != null;
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

try-catch-finally 结构可以嵌套