package day4;

public class Demo12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输出1000以内的水仙花数，并统计数量
		// while循环实现
		
		int count,i,h,t,d;
		
		count = 0;
		i = 100;
		
		while (i < 1000) {
			h = i / 100 % 10;
			t = i / 10 % 10;
			d = i % 10;
			
			if (h*h*h + t*t*t + d*d*d == i) {
				System.out.println(i);
				count++;
			}
			
			i++;
		}
		
		System.out.println("1000以内的水仙花数量为" + count + "个");
	}

}
