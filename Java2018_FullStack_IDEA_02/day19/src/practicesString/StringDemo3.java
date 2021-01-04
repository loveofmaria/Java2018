package practicesString;

import org.junit.jupiter.api.Test;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName practicesString
 * @createdTime 2021-01-04 11:18 AM
 */
public class StringDemo3 {

    public String returnSameString(String str1, String str2) {
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        String subStr;

        for(int i=0; i<length; i++){
            for(int x=0, y=length-i; y<=length; x++, y++) {
                subStr = minStr.substring(x, y);
                if(maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }

    @Test
    public void test(){
        String str1 = "abcwerthehelloa3234am";
        String str2 = "cvhellonm";
        System.out.println(returnSameString(str1, str2));
    }
}
