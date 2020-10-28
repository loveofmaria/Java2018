package day4;

import java.util.Scanner;

public class Demo19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 求和方法案例
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第一个整数: ");
		int x = sc.nextInt();
		System.out.print("输入第二个整数: ");
		int y = sc.nextInt();
		
		sc.close();
		
		System.out.println("两数之和为: " + sum(x, y));
	}

	public static int sum(int x, int y) {
		return x + y;
	}
}
