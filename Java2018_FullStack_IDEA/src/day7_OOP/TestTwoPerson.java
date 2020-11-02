package day7_OOP;
/*
    创建一个Person类,定义如下

        调用 study() 输出 “studying”

        调用 showAge() 显示 age 的值

        调用 addAge() 给对象的 age 值 +2

        创建 2个 对象测试[ person1,  person2 ]

        属性 String name, int age, int sex
*       方法 study():void,  showAge():void,  addAge(int i):int
 */
public class TestTwoPerson {
    public static void main(String[] args) {
        // 第一个对象测试
        PersonReal p1 = new PersonReal();
        p1.name = "毛瓜";
        p1.age = 20;
        p1.sex = 0;
        p1.study();
        p1.showAge();
        int a = p1.addAge();
        System.out.println("年龄修改后为: " + a);

        // 第一个对象测试
        PersonReal p2 = new PersonReal();
        p2.name = "张麻子";
        p2.age = 66;
        p2.sex = 1;
        p2.study();
        p2.showAge();
        a = p2.addAge();
        System.out.println("年龄修改后为: " + a);
    }
}

class PersonReal{
    String name;
    int age;
    int sex;

    PersonReal(){};

    public void study(){
        System.out.println(name + " is studying.....");
    }

    public void showAge(){
        System.out.println("你的年龄为: " + age);
    }

    public int addAge() {
        age += 2;
        return age;
    }
}