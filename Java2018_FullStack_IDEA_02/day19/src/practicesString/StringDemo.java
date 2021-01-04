package practicesString;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName practicesString
 * @createdTime 2021-01-04 10:00 AM
 * <p>
 * 算法题： 将字符串中指定的部分进行反转
 */
public class StringDemo {
    public static void main(String[] args) {

    }

    // 方式一： 转换成 char[] 数组
    public static String reverseString(String str, int start, int end) {
        if (str != null && str.length() != 0) {
            if ((end > start) && (end - start) > str.length()) {
                char[] tempList = str.toCharArray();
                for (int x = start, y = end; x < y; x++, y--) {
                    char temp = tempList[x];
                    tempList[x] = tempList[y];
                    tempList[y] = temp;
                }

                return new String(tempList);
            } else {
                return "";
            }
        } else {
            return str;
        }
    }

    // 方式二: 使用String的拼接
    public static String reverseString2(String str, int start, int end) {
        StringBuilder reverseStr = new StringBuilder(str.substring(0, start));
        for (int i = end; i>=start; i--) {
            reverseStr.append(str.charAt(i));
        }

        return new String(reverseStr.append(str.substring(end + 1)));
    }

    public static String reverseString3(String str, int start, int end){
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0, start));
        for(int i=end; i>=start; i--){
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(end+1));
        return new String(builder);
    }

    @Test
    public void reverseStringTest() {
        String str = "abcdefg";
        int start = 2;
        int end = 5;
        System.out.println(reverseString(str, start, end));
    }

    @Test
    public void reverseStringTest1(){
        String str = "abcdefg";
        int start = 2;
        int end = 5;
        System.out.println(reverseString2(str, start, end));
    }

    @Test
    public void reverseStringTest3(){
        String str = "abcdefg";
        int start = 2;
        int end = 5;
        System.out.println(reverseString3(str, start, end));
    }
}
