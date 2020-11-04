package day8;

public class RecursionTest4 {
    // 已知一个数列: f(20)=1, f(21)=4, f(n+2)=2*f(n+1)+f(n),
    // 其中n是大于0的整数,求f(10)的值
    public static void main(String[] args) {
        System.out.println(functions(10));
    }

    public static int functions(int num){
        if(num==20){
            return 1;
        } else if(num==21){
            return 4;
        } else {
            return functions(num + 2) - 2* functions(num+1);
        }
    }

}
