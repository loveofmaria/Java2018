package StringClassTests;

import java.util.Arrays;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 11:59 AM
 * 对字符串中字符进行自然顺序排序
 * <p>
 * 提示:
 * <p>
 * 1.  字符串变成字符数组;
 * 2.  对数组排序，选择，冒泡，Arrays.sort();
 * 3.  将排序后的数组变成字符串.
 */
public class Practice2 {

    public static void main(String[] args) {
        System.out.println(sortString("234234b32snakdljkl"));
    }

    public static String sortString(String string) {
        char[] stringToChar = string.toCharArray();
        Arrays.sort(stringToChar);
        return new String(stringToChar);
    }
}
