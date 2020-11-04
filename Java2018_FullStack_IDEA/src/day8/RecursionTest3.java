package day8;

// 已知有一个数列: f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n),其中n是大于0的整数,
// 求f(10)的值
public class RecursionTest3 {
    public static void main(String[] args) {
        System.out.println(functions(10));
    }

    public static int functions(int number){
        if(number == 0){
            return 1;
        } else if(number == 1) {
            return 4;
        } else {
            return 2* functions(number-1) + functions(number -2);
        }
    }
}
