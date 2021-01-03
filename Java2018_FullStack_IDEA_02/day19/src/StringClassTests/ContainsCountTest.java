package StringClassTests;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 12:30 PM
 * <p>
 * 获取一个字符串在另一个字符串中出现的次数，比如：获取“ab”在“abkkcadkabkebfkabkskab"中出现的次数
 */
public class ContainsCountTest {
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "abkkcadkabkebfkabkskab";
        System.out.println(countContains(str1, str2));
    }

    public static int countContains(String str1, String str2) {
        int count = 0;
        String tmpStr = "";
        String subStr = "";
        if (str1.length() > str2.length()) {

            tmpStr = str1;
            subStr = str2;
        } else {

            tmpStr = str2;
            subStr = str1;
        }
        for (; ; ) {
            int a = tmpStr.indexOf(subStr);
            if (a == -1) {
                break;
            }
            tmpStr = tmpStr.substring(a + subStr.length());
            count++;
        }
        return count;
    }
}
