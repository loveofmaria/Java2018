package day3;

import java.util.Scanner;

public class Demo16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 录入一个成绩，判断并输出该成绩的等级；

			90-100	优
			
			80-89	  良
			
			70-79	  中
			
			60-69	  及
			
			0-59	  差
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("输入成绩: ");
		int score = sc.nextInt();
		
		if (score >= 90 && score <= 100) {
			System.out.println("优");
		} else if (score >= 80 && score <= 89) {
			System.out.println("良");
		} else if (score >= 70 && score <= 79) {
			System.out.println("中");
		} else if (score >= 60 && score <= 69) {
			System.out.println("及格");
		} else if (score >= 0 && score <= 59) {
			System.out.println("差");
		} else {
			System.out.println("你录入的成绩有误!");
		}
		
		
	}

}
