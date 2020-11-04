package day8;

import java.util.Arrays;

public class ArraysSortTest {
    public static void main(String[] args) {
        int[] l = {1,22, 1, -22, 100, -111};
        arrSort(l);

        System.out.println(Arrays.toString(l));
    }

    public static void arrSort(int[] arr){
        // 冒泡排序
        for(int i= 0; i<arr.length; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

//    public static int[] swap(int a, int b){
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//
//        return new int[] {a, b};
//    }
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

