package day4;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 统计水仙花数的数量，并输出
		
		int h,t,d,count;
		
		count = 0;
		
		for (int i=100; i<1000; i++) {
			d = i % 10;
			t = i / 10 % 10;
			h = i /100 % 10;
			
			if (h*h*h + t*t*t + d*d*d == i) {
				count += 1;
				System.out.println(i);
			}
		}
		
		System.out.println("1000以内的水仙花数为" + count + "个");
	}

}
