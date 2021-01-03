#### 用户自定义异常类

自定义的类应该要继承现有的异常类

1.  RuntimeException 「运行时异常」| Exception 「 编译时异常类」
2.  提供 全局常量: serialVersionUID 「一个long类型的整数」
3.  提供重载的构造器
4.  调用

```java
public class TeamException extends Exception {
    public static long Serializable = 203492384203480L;

    public TeamException(String msg){
        super(msg);
    }
}
```















































