package day3;

public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取三个整数中最大值[三元运算」
		int x,y,z;
		x = 10;
		y = 22;
		z = 90;
		
		int max = (x > y) ? x : y;
		max = (max > z) ? max : z;
		
		System.out.println("最大值为: " + max);
	}

}
