package StringClassTests;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 12:19 PM
 */
public class ReverseStringTest {

    public static void main(String[] args) {
        String name = "huangzhengluo2011";
        System.out.println(reverseString(name));
    }

    public static String reverseString(String string) {

        char[] tmp = string.toCharArray();
        int end = tmp.length - 1;
        for (int i = 0; i <= end; i++, end--) {
            char temp = ' ';
            temp = tmp[i];
            tmp[i] = tmp[end];
            tmp[end] = temp;
        }
        return new String(tmp);
    }
}
