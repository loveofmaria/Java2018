package day4;

import java.util.Scanner;

public class Demo23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据键盘输入的整数，打印相应的乘法表
		Scanner sc = new Scanner(System.in);
		System.out.print("输入你要打印的乘法表的数字: ");
		int number = sc.nextInt();
		sc.close();
		
		multiTable(number);
	}
	
	public static void multiTable(int number) {
		if(number < 1) {
			System.out.println("你的输入有误,数字应该大于等于1!");
			return;
		}
		
		for(int i=1; i<=number; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j + "x" + i + "=" + j*i + '\t');
			}
			System.out.println();
		}
	}
}
