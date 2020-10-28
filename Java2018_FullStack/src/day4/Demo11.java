package day4;

public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// while 循环实现1-100偶数或者奇数之和
		
		int sum = 0;
		int i = 1;
		
		while (i <= 100) {
			// 偶数
			if (i%2==0) {
				sum += i;				
			}
			i++;
		}
		
		System.out.println(sum);
	}

}
