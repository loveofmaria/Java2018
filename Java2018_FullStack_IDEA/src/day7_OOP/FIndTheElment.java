package day7_OOP;

import java.util.Scanner;

public class FIndTheElment {
    public static void main(String[] args) {
        // 从数组中查找某个元素并返回索引值，否则返回-1；
        int[] arr = new int[]{34, 5, 22, -98, 6, 76, 0, -3, 102, -222, 1000};
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要查找的数字: ");
        int num = sc.nextInt();
        int result = findElm(arr, num);
        if(result != -1) {
            System.out.println("你要查找的数字位置在第" + (result + 1));
        } else {
            System.out.println("对不起，你输入的数字不存在!");
        }

    }

    public static int findElm(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
