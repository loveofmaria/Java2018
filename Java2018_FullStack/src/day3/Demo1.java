package day3;

public class Demo1 {

	public static void main(String[] args) {		
		// &、|、^、!
		// 逻辑运算
		int i = 10;
		
		System.out.println(i>5 & i<11);
		System.out.println(i>5 | i<11);
		// ^ 两边不同则为 true
		System.out.println(i<5 ^ i<11);
		System.out.println(i != 12);
	}

}
