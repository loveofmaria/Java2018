package day7_OOP;

public class BubbleSort {

    public static void main(String[] args) {
        // 要求：手写冒泡排序算法
    /*
    思路：
     */

        int[] arr = new int[]{34, 5, 22, -98, 6, 76, 0, -3};
        sortArr(arr);

        for (int value : arr) {
            System.out.print(value + ",");
        }

    }

    public static void sortArr(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
