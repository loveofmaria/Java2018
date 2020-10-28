package day4;

public class Demo25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 分别求2个，3个，4个整数之和
		System.out.println(sum(1,2,3,4));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));		
	}

	public static int sum(int x, int y) {
		return x + y;
	}
	
	public static int sum(int x, int y, int z) {
		return x + y + z;
	}

	public static int sum(int x, int y, int z, int h) {
		return x + y + z + h;
	}
}
