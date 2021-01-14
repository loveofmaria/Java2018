package extr;

import org.junit.jupiter.api.Test;

public class EmployeesToGenericTest {
    @Test
    public void test1(){
        Order<String> order = new Order<String>("orderOne", 1001,
                "orderDescription");

    }
}

class Order<T> {
    private String orderName;
    private int orderId;
    // 类的内部结构使用类的泛型
    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
