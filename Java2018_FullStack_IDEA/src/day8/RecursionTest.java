package day8;

// 输入一个数据n,计算斐波那契数列(Fibonacci)的第n个值,并将整个数列打印出来
public class RecursionTest {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibNumbers(n));
    }

    public static int fibNumbers(int number){
        if(number == 0){
            return 0;
        }else if(number==1){
            return 1;
        } else {
            return fibNumbers(number - 1) + fibNumbers(number - 2);
        }
    }
}
