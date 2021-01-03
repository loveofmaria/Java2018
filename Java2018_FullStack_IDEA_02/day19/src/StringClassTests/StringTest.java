package StringClassTests;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2020-12-29 11:35 AM
 * String 的使用
 */
public class StringTest {
    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        s1.replace('a', 'w');
        System.out.println(s1);
    }
}
