package day5;

public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*		案例
			A:二维数组遍历
			B:公司年销售额求和
				某公司按照季度和月份统计的数据如下：单位(万元)
				第一季度：22,66,44
				第二季度：77,33,88
				第三季度：25,45,65
				第四季度：11,66,99
		 */
		int[][] arr = {
				{22, 66, 44},
				{77, 33, 88},
				{25, 45, 65},
				{11, 66, 99}
		};	
		
		printSalary(arr);
		System.out.println("----------------------");
		System.out.println("全年销售总额为: " + sumSalary(arr) + "万元");
		
	}
	// 遍历需求
	public static void printSalary(int[][] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.print("第" + (i+1) + "个季度: ");
				for(int j=0; j<arr[i].length; j++) {
					if(j==2) {
						System.out.print(arr[i][j]);
					} else {
						System.out.print(arr[i][j] + ", ");
					};				
			}
				System.out.println();
		}
	}
	// 业绩求和需求
	public static int sumSalary(int[][] arr) {
		int totalSalary = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				totalSalary += arr[i][j];
			}
		}
		return totalSalary;
	}
}
