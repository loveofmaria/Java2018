package day8;

public class RecursionTest1 {
    public static void main(String[] args) {
        System.out.println(sumInt(100));
    }

    public static int sumInt(int number){
        if(number == 1){
            return 1;
        }else{
            return number + sumInt(number -1);
        }
    }
}
