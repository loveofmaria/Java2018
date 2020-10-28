package day4;

public class Demo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// while循环实现输出一个4行5列的星星图
		
		int i = 1;
		int j = 1;

		while (i < 5) {
			while (j < 6) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			// j 一定要初始化，不然内while循环只能执行一次
			j = 1;
		}
		
	}

}
