package day12;

/**
 * @author Administrator
 */
public class TestOrder {
    public static void main(String[] args) {
        Order od = new Order();

        od.orderDefault = 1;
        od.orderProtected = 2;
        od.orderPublic = 3;

        od.methodDefault();
        od.methodProtected();
        od.methodPublic();

        // od.orderPrivate = 4;
        // od.methodPrivate();
    }
}
