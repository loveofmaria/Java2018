package day3;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 20;
		int b = 5;
		
		// 一个数对位异或另一个数2次，结果不变
		// 20 ^ 5 ^ 5 = 20
		System.out.println(i ^ b ^ b);
		// 5 ^ 20 ^ 5 = 20
		System.out.println(b ^ i ^ b);
		// 5 ^ 5 ^ 20 = 20;
		System.out.println(b ^ b ^ i);
	}

}