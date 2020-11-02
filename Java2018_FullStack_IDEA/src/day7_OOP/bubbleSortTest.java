package day7_OOP;

import java.util.Arrays;

public class bubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {22, 0, -1, 33, 1, 4, 55, 101, -200};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        int tmp;
        for(int j=1; j<arr.length; j++){
            for(int i=0; i<arr.length-j; i++){
                if(arr[i] > arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
