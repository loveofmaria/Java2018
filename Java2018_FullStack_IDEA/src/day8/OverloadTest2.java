package day8;

public class OverloadTest2 {
    public static void main(String[] args) {
        // 练习1
        System.out.println(showResult(3));
        System.out.println(showResult(10, 20));
        showResult("毛哥是个大英雄,不错不错哦!");
        System.out.println("-----------------------------------");
        //练习2
        System.out.println("20, 33的最大值: " + getMaxNumber(20, 33));
        System.out.println("10.22, 0.33的最大值: " + getMaxNumber(10.22, 0.33));
        System.out.println("11.2, 5.3, 4.48的最大值: " + getMaxNumber(11.2, 5.3, 4.48));
    }

    public static int showResult(int a) {
        return a * a;
    }
    public static int showResult(int a, int b){
        return a * b;
    }
    public static void showResult(String str){
        System.out.println(str);
    }

    public static int getMaxNumber(int a, int b){
        return Math.max(a, b);
    }
    public static double getMaxNumber(double a, double b){
        return Math.max(a, b);
    }
    public static double getMaxNumber(double a, double c, double b){
        return Math.max(Math.max(a, b), c);
    }

}
