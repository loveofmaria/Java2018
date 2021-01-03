package StringClassTests;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 10:21 AM
 */
public class StringBufferBuilderTest {
    @Test
    public void test(){
        StringBuffer sb1 = new StringBuffer("huangzheng2011");
        sb1.setCharAt(0, 'g');
        System.out.println(sb1);
    }

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer(10);
        s1.append(1);
        s1.append('Q');
        s1.append("euq");
        s1.append("中子备你");
        System.out.println(s1);
    }
}
