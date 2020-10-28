package day4;

import java.util.Scanner;

public class Demo20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 判断2个数的大小
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第1个整数: ");
		int x = sc.nextInt();
		System.out.print("输入第2个整数: ");
		int y = sc.nextInt();
		
		sc.close();
		
		System.out.println("较大的数是: " + max(x, y));
	}
	
	public static int max(int x, int y) {
		return (x > y) ? x : y;
	}

}
