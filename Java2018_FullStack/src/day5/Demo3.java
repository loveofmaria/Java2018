package day5;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取数组的最大「最小值」
		// 思路：遍历所有元素，使用临时变量来存储比较后较大的值
		
		int[] arr = {2, 10, 33, -1, 0, 99, 34, 6};
		System.out.println("该数组最大值为: " + getMax(arr));
		
	}
	
	public static int getMax(int[] arr) {
		int max = 0;		
		for(int i=0; i<=arr.length-1; i++) {
			max = (max > arr[i]) ? max : arr[i]; 
		}		
		return max;
	}

}
