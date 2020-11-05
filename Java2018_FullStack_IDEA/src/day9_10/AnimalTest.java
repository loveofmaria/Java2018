package day9_10;

/*
    面向对象的特征一: 封装和隐藏
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.setName("猪八戒");
        a1.setAge(8);
        a1.setLegs(6);
        System.out.println(a1.getAge());
        System.out.println(a1.getName());
        System.out.println(a1.getLegs());
        a1.eat();
    }
}

class Animal {
    private String name;
    private int age;
    // 设置私有属性[隐藏]
    private int legs;

    // 对需要限制的数据进行判断[使用方法]
    public void setLegs(int l) {
        if (l >= 0 && l % 2 == 0) {
            legs = l;
        } else {
            legs = 4;
        }
    }

    public int getLegs() {
        return legs;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        System.out.println("动物进食.....");
    }

}