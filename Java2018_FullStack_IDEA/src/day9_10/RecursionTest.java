package day9_10;

// 测试递归调用的次数
// 递归 [ 一个百度面试的双重递归题 ]

public class RecursionTest {
    private static int count = 0;

    public static void main(String[] args) {
        // 测试结果
        int k = 10;
        binomial(k);
        System.out.println(count);
    }

    public static int recursion(int k) {
        count++;
//        System.out.println("count1: " + count + "   k: " + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k - 1) + recursion(k - 2);
        // return recursion(k-1); 11
        // return recursion(k-1) + recursion(k-1); // 2047
    }

    public static void binomial(int k) {
        recursion(k);
    }
}



