package day3;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 实现2个整数变量的交换，不适用第三方变量实现
		int x = 10;
		int y = 5;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("交换数值后:");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

}
