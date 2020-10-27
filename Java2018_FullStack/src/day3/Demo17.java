package day3;

import java.util.Scanner;

public class Demo17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 录入x的值，计算出y并输出；

			x >= 3   	 y = 2 * x + 1;
			
			-1 < x < 3   y = 2 * x;
			
			x <= -1      y = 2 * x - 1;
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("输入你的数字: ");
		int i = sc.nextInt();
		
		if (i >= 3) {
			System.out.println("计算结果为: " + (2*i+1));
		} else if (i > -1 && i < 3) {
			System.out.println("计算结果为: " + (2*i));
		} else if(i <= -1) {
			System.out.println("计算结果为: " + (2*i-1));
		} else {
			System.out.println("输入的数字错误!");
		}
		
	}

}
