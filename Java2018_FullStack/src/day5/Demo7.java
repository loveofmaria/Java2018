package day5;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 二维数组的遍历
		
		int[][] arr = {
				{1, 22, 4},
				{-1, 21, 100, 4},
				{33, 99, -101, 44},
				{120, 111, -11, 55}
		};
		
		// 输出arr的每一个元素
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + ",");
			}
		}
	}

}
