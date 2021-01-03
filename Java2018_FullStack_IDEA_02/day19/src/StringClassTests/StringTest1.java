package StringClassTests;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 9:31 AM
 */
public class StringTest1 {
    /*
        1. String 基本数据类型，包装类转换
     */
    @Test
    public void test1() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        String s = String.valueOf(i);
        String str3 = i + " " + s;
        System.out.println(str3);
    }

    @Test
    public void test2() {
        /*
            字符串与数组和字符数组的转换
         */
        String str = "abc123huangzhengluo";
        char[] c = str.toCharArray();
        for (char value : c) {
            System.out.print(value + " ");
        }
        char[] arr = new char[]{'h', 'u', 'z', 'h', 'e', 'n', 'g', '1', '2', '3'};
        String s = new String(arr);
        System.out.println(s);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        /*
            String 与byte[] 之间的转换
         */
        String str1 = "abc123高手";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = str1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));
        System.out.println("**********************");
        String str2 = new String(bytes);
        System.out.println(str2);
        String str3 = new String(bytes1, "gbk");
        System.out.println(str3);
    }

    @Test
    public void test4() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);// false
        final String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5); // true
    }
}
