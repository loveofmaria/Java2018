package day4;

public class Demo16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输出九九乘法表
		/*
		 * 1x1=1
		 * 1x2=2 2x2=4
		 * 1x3=3 2x3=6  3x3=9
		 * 1x4=4 2x4=8  3x4=12 4x4=16
		 * 1x5=5 2x5=10 3x5=15 4x5=20 5x5=25
		 * 1x6=6 2x6=12 3x6=18 4x6=24 5x6=30 6x6=36
		 */
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j + "x" + i + "=" + i*j + '\t');
			}
			System.out.println();
		}
	}

}
