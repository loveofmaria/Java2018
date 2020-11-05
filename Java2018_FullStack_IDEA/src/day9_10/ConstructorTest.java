package day9_10;

// 构造器 Constructor
public class ConstructorTest {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog d2 = new Dog("花花");
        Dog d3 = new Dog("胖胖", "德国牧羊犬");
    }
}

class Dog{
    private String name;
    private String kind;
    // constructor is here
    Dog(){
        System.out.println("我是构造器.....");
    }
    Dog(String n){
        name = n;
        System.out.println("我是另一个构造器,带了参数.....");
    }
    Dog(String n, String k){
        name = n;
        kind = k;
        System.out.println("我是第三个构造器,参数包含了全部属性......");
    }
}