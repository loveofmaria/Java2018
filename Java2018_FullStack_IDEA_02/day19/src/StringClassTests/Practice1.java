package StringClassTests;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 11:34 AM
 */
public class Practice1 {
    // 获取两个字符串中最大相同字串，比如：
    //
    // str1 = "abcwerthelloyuiodef";
    //
    // str2 = "cvhellobnm";
    //
    // 提示：
    //     1，将短的那个子串按照长度递减的方式获取到。
    //     2，将每获取到的子串去长串中判断是否包含，如果包含，已经找到。
    public static void main(String[] args) {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        System.out.println(getMaxSubString(str1, str2));
    }

    public static String getMaxSubString(String str1, String str2) {
        String max, min;
        max = (str1.length() > str2.length()) ? str1 : str2;
        min = (max.equals(str1)) ? str2 : str1;

        for (int i = 0; i < min.length(); i++) {
            for(int a=0, b=min.length()-i; b!=min.length()+1; a++,b++) {
                String sub = min.substring(a, b);
                System.out.println(sub);
                if(max.contains(sub)){
                    return sub;
                }
            }
        }
        return "";
    }
}
