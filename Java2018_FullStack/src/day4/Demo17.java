package day4;

public class Demo17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 控制跳出语句标号
		
		a: for(int i=1; i<10; i++) {
			b: for(int j=1; j<=10; j++) {
				System.out.println(j);
				
				if(j==3) break b;
			}
			System.out.println(i);
			
			if(i==8) break a;
		}
	}

}
