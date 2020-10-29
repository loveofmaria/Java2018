package day5;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 参数传递问题 - 数组
		int[] arr = {1,2,3,4,5};
		
		changeValueArr(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +",");
		}
	}

	public static void changeValueArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i==1) {
				arr[i] = arr[i] * 2;
				break;
			}
		}
	}
}
