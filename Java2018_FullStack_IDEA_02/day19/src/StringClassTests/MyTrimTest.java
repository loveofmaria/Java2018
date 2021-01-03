package StringClassTests;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName StringClassTests
 * @createdTime 2021-01-03 12:03 PM
 *
 * 模拟一个trim方法，去除字符串两端的空格
 */
public class MyTrimTest {

    public static void main(String[] args) {
        String string = "asdfasdf  asd fasdf   ";
        System.out.println(MyTrim(string));
    }

    public static String MyTrim(String string){

        char[] tmp = string.toCharArray();

        int start=0, end=tmp.length-1;
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] != ' '){
                start = i;
                break;
            }
        }

        for (int i = tmp.length-1; i >= 0; i--) {
            if(tmp[i] != ' ') {
                end = i;
                break;
            }
        }

        return string.substring(start, end);
    }
}
