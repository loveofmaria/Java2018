package day4;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输出所有水仙花数
		// 水仙花数：三位，各位数字的立方之和等于该数字
		// 153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
		
		int b,s,g;
		
		for (int i=100; i<=999; i++) {
			
			b = i / 100 % 10;
			s = i / 10 % 10;
			g = i % 10;			
			
			if ((b*b*b + s*s*s + g*g*g) == i) {
				System.out.println(i);
			}			
		}
	}

}
