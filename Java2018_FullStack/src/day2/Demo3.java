package day2;

//指出这里代码的问题，并说明理由

public class Demo3 {
 public static void main(String[] args) {
     byte b1 = 3;
     byte b2 = 4;
     
     // 错误 ：byte b3 = b1 + b2;
     // 正确方法：
     byte b3 = (byte) (b1 + b2);
 }
}
