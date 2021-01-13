package extr;

import java.util.*;

public class NumberFromKeyBoradSorted {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List list  = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            System.out.print("输入 " + (i+1) + " 个整数： ");
            int number = SCANNER.nextInt();
            list.add(number);
        }
        SCANNER.close();
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
