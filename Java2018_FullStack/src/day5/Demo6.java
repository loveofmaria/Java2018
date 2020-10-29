package day5;

import java.util.Scanner;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据给出的元素去查找在数组中第一次出现的位置-索引值
		/*
		 * 通常比较两个字符串是否相同的表达式是“==” ，
		 * 但在 Java 中不能这么写。在 Java 中，
		 * 如果要比较 a 字符串是否等于 b 字符串，需要这么写： 
		 * if(a.equals(b)){ } 返回 true 或 false
		 */
		String[] arr = {"黄毛瓜", "绿豆芽", "大白菜", "马骡子", "茄子", "毛十八"};
		Scanner sc = new Scanner(System.in);		
		
		System.out.print("输入你要查找的同学名字: ");
		String str = sc.nextLine();
		sc.close();				
		
		int result = getIndex(arr, str);
		if(result != -1) {
			System.out.println("你要找的同学排在第 " + (result + 1) + "位");
		} else {
			System.out.println("没有找到该同学!");
		}
		
	}

	public static int getIndex(String[] arr, String str) {		
		for(int i=0; i<arr.length; i++) {
			// 判断字符串是否相等：str.equals(str1) return: true | false
			if(str.equals(arr[i])) {
				return i;
			}
		}		
		return -1;
	} 
}
