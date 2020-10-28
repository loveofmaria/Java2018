package day4;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 求 1-100之间的偶数或者奇数之和
		
		int sum = 0;
		
		for (int i=1; i<101; i++) {
			// 偶数
			if (i%2==0) {
				sum += i;
			}
			// 奇数 
//			if (i%2==1) {
//				sum += 1;
//			}
		}
		
		System.out.println(sum);
	}

}
