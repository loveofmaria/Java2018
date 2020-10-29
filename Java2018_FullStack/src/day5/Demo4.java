package day5;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 数组反转
		/*
		 * 思路：
		 * arr[0] <--> arr[ arr.length - 1 - 0 ] 交换

			arr[1] <--> arr[ arr.length - 1 - 1 ] 交换
			
			arr[2] <--> arr[ arr.length - 1 - 2 ] 交换
			
			arr[3] <--> arr[ arr.length - 1 - 3 ] 交换
			
			.....
			
			arr[i] <--> arr[ arr.length - 1 - i ] 交换
			
			实际操作的次数 = arr.length / 2
		 */
		int[] arr = {22, 1, 0, -91, 102, 111, 31, 79};
		reverseArr(arr);
		// {79,31,111,102,-91,0,1,22}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	public static void reverseArr(int[] arr) {
		int tmp;
		for(int i=0; i<arr.length/2; i++) {
			tmp = arr[i];
			arr[i]= arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		}
	}
}
