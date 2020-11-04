package day8;

public class ValueTransferTest1 {
    public static void main(String[] args) {
        //方法形参的传递机制
        // 交换变量的数据
        int n = 10;
        int m = 20;
        swapValue(m, n);
        System.out.println("方法体外: " + "m = " + m + ", n = " + n);
    }

    public static void swapValue(int m, int n){
        n = n ^ m;
        m = n ^ m;
        n = n ^ m;
        System.out.println("方法体内: "+"m = " + m + ", n = " + n);
    }
}
