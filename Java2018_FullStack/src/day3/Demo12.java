package day3;

import java.util.Scanner;

public class Demo12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入2个整数，并求和
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第一个数字: ");
		int a = sc.nextInt();
		
		System.out.print("输入第二个数字: ");
		int b = sc.nextInt();
		
		int sum = a + b;
		System.out.println("输入的两数之和：" + sum);
	}

}
