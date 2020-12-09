#### throws 方式处理异常

throws 在方法体外部声明了一个异常类型的对象，并且抛出「异常代码的后续代码就不再执行」

throws 只是抛出异常给上层调用者，而没有真正处理异常;

子类重写父类中的方法时，抛出的异常类型不能大于父类抛出的异常类型;

如果子类重写父类的方法没有抛出异常，那么子类的重写方法就不能使用 throws 方式;

如果执行的方法 `method`中，先后又调用了另外的几个方法，这几个方法是层级递进关系执行，那么建议使用 throws方式处理异常, 而执行的方法 `method` 考虑使用 try-catch-final 处理;

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) {
        ThrowsTest.ExceptionsHandlerTest();
    }

    // 这里调用某个方法，那么就要处理该方法抛出的异常「也可以继续往上层调用抛出，直到JVM」	
    // 抛出的每一类异常都要进行处理
    static void ExceptionsHandlerTest() {
        try {
            FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException) {
            e.printStackTrace();
        }
    }
	
    // trhows EIOxception 把异常抛给上一级的调用者处理
    static void FileHandler() throws IOException, NullPoionterException {
        File file = new File("hello.txt");
        FileInputStream f = new FileInputStream(file);

        int data = f.read();
        while (data != -1) {
            System.out.println((char) data);
            data = f.read();
        }
        f.close();
    }
}
```

