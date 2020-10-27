package day3;

public class Demo2 {

	public static void main(String[] args) {
		// && 「||」 与 & | 的区别
		int i = 10;
		// i > 12 为false，则 i < 22 不再运行
		System.out.println(i>12 && i<22);
		// 如果 i > 9 为true，那么 i<22不再执行
		System.out.println(i>9 || i<22);
	}
	
}
