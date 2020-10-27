package day3;

import java.util.Scanner;

public class Demo13 {

	public static void main(String[] args) {
		// 比较录入的2个整数是否相等
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第一个数字: ");
		int a = sc.nextInt();
		System.out.print("输入第二个数字: ");
		int b = sc.nextInt();
		
		boolean r = (a == b) ? true : false;
		if(r) {
			System.out.println("两个数字相等!");
		} else {
			System.out.println("两个数字不相等!");
		}
	}
	
}
