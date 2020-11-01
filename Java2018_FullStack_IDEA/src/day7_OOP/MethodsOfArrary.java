package day7_OOP;

import java.util.Arrays;

public class MethodsOfArrary {
    public static void main(String[] args) {
        // 数组常用的5种类方法
        // 判断数组是否相等
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {2, 3, 4, 5, 6};
        boolean r = Arrays.equals(arr, arr1);
        // 输出数组的字符窜形式
        System.out.println(Arrays.toString(arr) + r);
        // 添加一个数据到数组
        Arrays.fill(arr, 10);
        System.out.println(Arrays.toString(arr));
        // 对数组排序
        int[] arr2 = {22, 303, -111, 20, 1, 0, 99, 10100, 224, 55, 90};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        // 对排序后的数组进行二分法检索指定的值
        int result = Arrays.binarySearch(arr2, 8000);
        System.out.println(result);
    }
}
