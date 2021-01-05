package SystemOperationTest;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName SystemOperationTest
 * @createdTime 2021-01-05 12:54 PM
 */
public class SystemOperationTest {

    @Test
    public void test() {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
}
