package day7_OOP;

public class TestCustomer {
    public static void main(String[] args) {
        Customer c = new Customer("张麻子", 4112, "草莓冰淇淋");
        c.eat();
        c.display();
    }
}

class Customer {
    String name;
    int cusID;
    String favFood;

    Customer(String n, int i, String f) {
        name = n;
        cusID = i;
        favFood = f;
    }

    public void eat() {
        System.out.println("顾客" + name + "在吃" + favFood);
    }

    public void display() {
        System.out.println("姓名: " + name);
        System.out.println("I D: " + cusID);
        System.out.println("食物: " + favFood);
    }
}