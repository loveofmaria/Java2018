package day7_OOP;

public class TestPerson {
    public static void main(String[] args) {
        // 实例化一个 Person 对象
        Person xm = new Person();
        xm.name = "小明";
        xm.age = 28;
        xm.isMarried = true;
        xm.displayInfo();
//        Person xm = new Person("小明", 29, true);
//        xm.displayInfo();
        Person xh = new Person();
        xh.displayInfo();
        xm.displayInfo();
    }
}

class Person {
    // 属性
    String name;
    int age;
    boolean isMarried;

    // 构造器
    public Person() {

    }
//    public Person(String n, int a, boolean im){
//        name = n;
//        age = a;
//        isMarried=im;
//    }

    // 方法
    public void setName(String name) {
        this.name = name;
    }

    public void setMarried(boolean status) {
        this.isMarried = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        String r = (isMarried) ? "是" : "否";
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("婚否: " + r);
    }
}