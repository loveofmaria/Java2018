package day5;

import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] weekStrings = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Scanner sc = new Scanner(System.in);
		System.out.print("输入你要指定的星期数: ");
		int num = sc.nextInt() % 7;
		
		System.out.println(getWeek(weekStrings, num));
	}

	public static String getWeek(String[] arr, int number) {
		return arr[number];
	}
}
