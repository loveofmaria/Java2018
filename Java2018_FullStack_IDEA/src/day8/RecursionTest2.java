package day8;
// 用递归写出求阶乘(N!)的算法
public class RecursionTest2 {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("10的阶乘为: " + factorial(i));
    }
    public static int factorial(int number){
        if(number == 1){
            return 1;
        } else {
            return number * factorial(number -1);
        }
    }

}
