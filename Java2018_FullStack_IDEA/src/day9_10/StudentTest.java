package day9_10;

/*
     Student类： String name; int age; String school; String major;
//    3个构造器：
//    设置(name, age); (name, age, school), (name, age, school, major);
//	  分别调用不同的构造器创建对象，并输出属性值
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("张飞", 22);
        Student s1 = new Student("王麻子", 21, "花城科技学院");
        Student s2 = new Student("李菲儿", 23, "花城科技学院", "核物理");
        s.display();
        s1.display();
        s2.display();
    }
}

class Student {
    String name="匿名";
    int age=20;
    String school="花城科技学院";
    String major="土木工程";

    Student(String n, int a){
        name = n;
        age = a;
    }
    Student(String n, int a, String s){
        name = n;
        age = a;
        school = s;
    }
    Student(String n, int a, String s, String m){
        name = n;
        age = a;
        school = s;
        major = m;
    }

    void display(){
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("学校: " + school);
        System.out.println("专业: " + major);
        System.out.println("------------------");
    }
}
