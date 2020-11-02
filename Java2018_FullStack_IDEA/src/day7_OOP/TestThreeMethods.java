package day7_OOP;

public class TestThreeMethods {
    public static void main(String[] args) {
//        methodOne();
//        int area = methodTwo();
//        System.out.println("该矩形的面积为: "+area);
        int area = methodThree(8, 20);
        System.out.println("该矩阵面积为: " + area);
    }

    public static void methodOne(){
        for(int i=1; i<=8; i++){
            for(int j=1; j<=10; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static int methodTwo(){
        methodOne();
        return 10*8;
    }

    public static int methodThree(int m, int n){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        return m * n;
    }
}
