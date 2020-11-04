package day8;

public class ValueTransferTest {
    public static void main(String[] args) {
        System.out.println("---------------------基本数据类型-------------------------");
        int m, n;
        m = 10;
        n = m; // 赋值m的值,然后赋值给n
        System.out.println("m = " + m + ", n = " + n);
        n = 20;
        System.out.println("m = " + m + ", n = " + n);
        System.out.println("-----------------------引用数据类型------------------------------------");
        Order o1 = new Order();
        o1.orderID = 1001;
        Order o2 = o1;
        System.out.println("o1.orderID: " + o1.orderID);
        o2.orderID = 1002;
        System.out.println("赋值给o2,o2修改了orderID!!!!!!");
        System.out.println("o1.orderID: " + o1.orderID);

    }
}

class Order{
    int orderID;
}