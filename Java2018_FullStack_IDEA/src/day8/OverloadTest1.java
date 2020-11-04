package day8;

public class OverloadTest1 {
    // 方法重载
    // 参数个数,类型不同的相同名字的方法
    public static void main(String[] args) {
        getSum(1, "好好啊好!");
        getSum(2, 222);
        getSum(3, 4, 5);
        getSum('a', "好好啊好!");
        getSum(1.2, 2.2);

        OverloadTest1 test = new OverloadTest1();
        test.getSum(1, 3);
    }

    public static void getSum(int a, int b){
        System.out.println(a + b);
    }
    public static void getSum(int a, int b, int c){
        System.out.println(a + b + c);
    }
    public static void getSum(double a, double b){
        System.out.println(a + b);
    }

    public static void getSum(int a, String b){
        System.out.println(a + b);
    }

    public static void getSum(char a, String b){
        System.out.println(a + b);
    }
}
