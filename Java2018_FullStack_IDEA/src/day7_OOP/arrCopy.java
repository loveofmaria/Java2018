package day7_OOP;

import java.util.Arrays;

public class arrCopy {
    public static void main(String[] args) {
        // 复制数组
        int[] arr = new int[]{34, 5, 22, -98, 6, 76, 0, -3, 102, -222, 1000};
        int[] newArr = copyArrary(arr);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] copyArrary(int[] arr) {
        int[] arr1 = new int[arr.length];
        // java自带的数组拷贝方法,原来的数组修改后，不会受到影响
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        return arr1;
    }
}
