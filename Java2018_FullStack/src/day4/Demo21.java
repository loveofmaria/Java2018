package day4;

import java.util.Scanner;

public class Demo21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 判断2个数是否相等
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入第1个整数: ");
		int x = sc.nextInt();
		System.out.print("输入第2个整数: ");
		int y = sc.nextInt();
		
		sc.close();
		
		char r = isEqual(x, y) ? '是' : '否';
		
		System.out.println("两数相等吗: " + r);
	}
	
	public static boolean isEqual(int x, int y) {
		return (x == y) ? true : false;
	}

}
