package day7_OOP;

public class reverseArr {
    public static void main(String[] args) {
        // 反转数组
        int[] arr = new int[]{34, 5, 22, -98, 6, 76, 0, -3, 102, -222, 1000};

        reverseArray(arr);

        for (int value : arr) {
            System.out.print(value + ",");
        }

    }

    public static void reverseArray(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }
}
