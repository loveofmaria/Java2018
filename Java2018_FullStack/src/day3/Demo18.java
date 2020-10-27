package day3;

import java.util.Scanner;

public class Demo18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// switch 语句
		// 练习：给定一个数字，输出对应的星期几
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入一个数字: ");
		int num = sc.nextInt();
		
		switch(num % 7) {
		case 0:
			System.out.println("星期天");
			break;
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		default:
			System.out.println("输入的数字有误!");
		}
		
	}

}
