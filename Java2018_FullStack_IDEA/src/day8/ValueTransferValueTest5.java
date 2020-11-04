package day8;
import java.util.Arrays;
// 定义一个int型的数组: int[] arr = new int[]{12, 3, 3, 45, 56, 77, 432};
// 让数组的每个位置上的值去除以首位置的元素,得到结果,作为该位置上的新值,遍历新的数组
public class ValueTransferValueTest5 {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 3, 45, 56, 77, 432};
        char[] c = new char[]{'a', 'b', 'c'};
        String[] s = new String[5];
        // 每一个元素除以首位的值,如果从第一位开始,那么第一位的数据就会被修改,后面所得的值都是错误的
        changeArr(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(c);
        System.out.println(s);
    }

    // 方法一
//    public static void changeArr(int[] arr){
//        for(int i=arr.length-1; i>-1; i--){
//            arr[i] = arr[i] / arr[0];
//        }
//    }
    // 方法二
    public static void changeArr(int[] arr){
        int tmp = arr[0];
        for(int i=0; i< arr.length; i++){
            arr[i] = arr[i] /tmp;
        }
    }
}
