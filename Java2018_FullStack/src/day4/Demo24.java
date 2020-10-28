package day4;

public class Demo24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 方法重载比较2个数值是否相等;
		// double, int 两种类型的方法
		char r = isEqual(10, 20) ? '是' : '否';
		char r1 = isEqual(10.2, 10.2) ? '是' : '否';
		
		System.out.println(r + "----" + r1);
	}
	
	public static boolean isEqual(int a, int b) {
		return (a == b) ? true : false;
	}
	
	public static boolean isEqual(double a, double b) {
		return (a == b) ? true : false;
	}	
	
}
