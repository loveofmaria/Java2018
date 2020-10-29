package day5;

public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 二维数组的求和
		int[][] arr = {
				{1,2,3},
				{4,5},
				{6,7,8,9},
				{10},
				{20,30,40,50}
		};
		
		System.out.println(sumofArray(arr));
	}

	public static int sumofArray(int[][] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
}
