package day3;

import java.util.Scanner;

public class Demo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入2个整数，求最大值
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第一个数字: ");
		int a = sc.nextInt();
		System.out.print("输入第二个数字: ");
		int b = sc.nextInt();
		
		int max = (a > b) ? a : b;
		System.out.println("较大的数字是:" + max);
	}

}
