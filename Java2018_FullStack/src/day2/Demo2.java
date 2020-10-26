package day2;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 强制转换，指定要转换的类型
		byte b = 10;
		int i = 20;
		
		byte b1 = (byte) (b + i);
		
		// 输出为 class java.lang.Byte
		System.out.println(getType(b1));
	}

	// 获取对象类型的私有方法
	private static String getType(Object a) {
		return a.getClass().toString();
	}

}
