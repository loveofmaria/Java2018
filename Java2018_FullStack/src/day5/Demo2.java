package day5;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 遍历数组
		String[] userStrings = {"毛十八", "张麻子", "牛头怪", "meimei", "alex"};
		
		System.out.println("用户数量为: " + userStrings.length);
		// 遍历
		for(int i=0; i<=userStrings.length-1; i++) {
			System.out.println("[" + (i+1) + "]" + userStrings[i]);
		}
	}

}
