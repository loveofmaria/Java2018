package day3;

import java.util.Scanner;

public class Demo15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入3个整数，获取最大值
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第一个数字: ");
		int a = sc.nextInt();
		System.out.print("输入第二个数字: ");
		int b = sc.nextInt();
		System.out.print("输入第三个数字: ");
		int c = sc.nextInt();
		
		int max = (a > b) ? a : b;
		max = (max > c )? max : c;
		
		System.out.println("最大的数字是：" + max);
		
	}

}
