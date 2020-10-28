package day4;

public class Demo18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在控制台只输出第2，7，13次 「我爱Java编程」
		
		String s = "我爱Java编程";
		
		
		for (int i=1; i<=15; i++) {
			if (i == 2) {
				System.out.println(i + ": " + s);
				continue;
			} else if (i == 7) {
				System.out.println(i + ": " + s);
				continue;
			} else if (i == 13) {
				System.out.println(i + ": " + s);
			} 
		}
	}

}
