package day8;


public class numbersMethodArgs {
    // [方法数量可变参数]
    public static void main(String[] args) {
        show(1,2,3,4,5);
//        show("猫猫", "毛个");
        show(22);
        show();
    }

//    public static void show(String... strings) {
//        System.out.println("show strings args!");
//    }

    public static void show(int... numbers) {
        System.out.println("show numbers args!");
    }
    public static void show(int[] numbers, String string){

    }

//    public static void show(int a){
//        System.out.println("show int single number!");
//    }
}
