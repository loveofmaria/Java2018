package practicesString;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName practicesString
 * @createdTime 2021-01-04 10:43 AM
 * <p>
 * 计算一个字符串在另一个字符串中出现的次数
 */
public class StringDemo2 {

    public static int counter(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int total = 0;
        int index = 0;
        if (mainLength >= subLength) {
            // 方式一，效率低，每次都需要重新创建一个新的字符串
//            while((index = mainStr.indexOf(subStr)) != -1) {
//                mainStr = mainStr.substring(index + subStr.length());
//                total ++;
//            }
            // 方式二
            while((index=mainStr.indexOf(subStr, index)) != -1){
                total ++;
                index += subStr.length();
            }
            return total;
        } else {
            return 0;
        }
    }

    @Test
    public void test1() {
        String mainStr = "abkkabcadkabkebfkaabkskab";
        String subStr = "ab";

        System.out.println(counter(mainStr, subStr));
    }
}
