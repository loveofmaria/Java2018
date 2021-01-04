package practicesString;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName practicesString
 * @createdTime 2021-01-04 11:50 AM
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());
        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
