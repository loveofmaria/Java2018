package day4;

import java.util.Scanner;

public class Demo22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 更具输入的行数和列数，打印星星图像
		Scanner sc = new Scanner(System.in);
		
		System.out.print("行数「不低于3」: ");
		int x = sc.nextInt();
		System.out.print("列数「不低于3」: ");
		int y = sc.nextInt();
		
		sc.close();
		
		starsArr(x, y);			
	}
	
	public static void starsArr(int x, int y) {
		if (x < 3 | y < 3) {
			System.out.println("输入的「行数」或者「列数」错误!");
			return;
		}
		
		for(int i=1; i<=x; i++) {
			for(int j=1; j<=y; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}