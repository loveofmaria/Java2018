package teamVIew.view;

import java.util.Scanner;

public class TSUtility {
    private static final Scanner scanner = new Scanner(System.in);

    // 键盘读取通用方法[获取所有键盘输入]
    // 通过重载设置了参数的默认值 boolean = false
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn)
                    return line;
                else
                    continue;
            }
            if (line.length() > limit) {
                System.out.println("输入长度「不能大于" + limit + "」,请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

    private static String readKeyBoard(int limit) {
        boolean blankReturn = false;
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn)
                    return line;
                else
                    continue;
            }
            if (line.length() > limit) {
                System.out.print("输入长度「不能大于" + limit + "」,请重新输入: ");
                continue;
            }
            break;
        }
        return line;
    }

    // 处理[yes｜no 的输入]
    public static char readConfirmSelection() {
        char choice;
        for(;;) {
            String str = readKeyBoard(1).toUpperCase();
            choice = str.charAt(0);
            if (choice == 'Y' || choice == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入: ");
            }
        }
        return choice;
    }

    // 获取键盘输入的长度不超过2的整数，并返回
    // 这里输入的是员工ID的范围
    public static int readInt() {
        int n  = 0;
        for(; ;) {
            System.out.print("输入要添加的员工 ID: ");
            String  str = readKeyBoard(2);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入:");
            }
        }
        return n;
    }

    // 获取键盘输入的菜单选择数字「1-4」然后返回
    public static char readMenuSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c!='2' && c!='3' && c!='4') {
                System.out.print("选择错误，请重新输入: ");
            } else break;
        }
        return c;
    }
}
