package day3;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 5;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		y = x ^ y; // y = 10 ^ 5;
		x = x ^ y; // x = 10 ^ 10 ^ 5 = 5;
		y = x ^ y; // y = 5 ^ 10 ^ 5 = 10;
		
		System.out.println("数值交换之后的结果: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
	}

}
