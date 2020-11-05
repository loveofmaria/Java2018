package day9_10;

public class ValueTransferTest {
    public static void main(String[] args) {
        String s1 = "hello";
        changeString(s1);
        System.out.println(s1);
    }

    public static void changeString(String s) {

        s = "Say Hello!";
    }
}
