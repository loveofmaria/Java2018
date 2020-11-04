package day8;

import java.io.PrintStream;

public class ValueTransferTest5 {

        public static void main(String[] args){
            int a=10;
            int b=10;
            // 需要在method方法被调用之后,仅仅打印出a=100,b=200,写出method代码
            method(a, b);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
        // 代码编写处
        // 方法一,终止程序运行 System.exit(0);
//        public static void method(int a, int b){
//            a = a * 10;
//            b = b * 20;
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.exit(0);
//        };
        // 方法二 修改标准的System.out.println() 方法
        public static void method(int a, int b){
            PrintStream ps = new PrintStream(System.out){
                @Override
                public void println(String x) {
                    if("a = 10".equals(x)) {
                        x = "a = 100";
                    }else if("b = 10".equals(x)){
                        x = "b = 200";
                    }
                    super.println(x);
                }
            };
            System.setOut(ps);
        }
}
