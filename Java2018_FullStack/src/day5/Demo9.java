package day5;

public class Demo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 关于java参数传递的说明
		int a = 10;
		int b = 20;
		System.out.println("main方法中的a: " + a + "main方法中的b: " + b);
		changeValue(a, b);
		System.out.println("调用changeValue方法后  " + "main方法中的a: "+a + "main方法中的b: " + b);
		
	}

	// 该方法调用完成后会弹栈，局部变量a，b随之丢弃
	public static void changeValue(int a, int b) {
		System.out.println("方法内部a: " + a + "方法内部b: " + b);
		a = b;
		b = a + b;
		System.out.println("交换后-" + "  " + "方法内部a: " + a + "方法内部b: " + b);
	}
}
