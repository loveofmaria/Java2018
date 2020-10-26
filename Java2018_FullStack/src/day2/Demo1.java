package day2;

import java.lang.reflect.Field;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 隐式转换，java默认转换成int类型
		byte i = 10;
		byte b = 20;
		
		// 输出为 class java.lang.Integer
		System.out.println(getType(i+b));
	}
	
	// 获取对象类型的私有方法
	private static String getType(Object a) {
		return a.getClass().toString();
	}

}
