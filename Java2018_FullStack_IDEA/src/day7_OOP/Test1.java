package day7_OOP;
/*
编写教师和学生类,并通过测试类创建对象进行测试

*   Student

    属性: String name, int age, String major, String interests,

    方法: say() 返回个人信息

*   Teacher

    属性: String name, int age, int teachAge, Strong course

    方法: say() 输出个人信息
 */
public class Test1 {
    public static void main(String[] args) {
        // 测试Student类
        Student st = new Student();
        st.name = "小明";
        st.age = 20;
        st.major = "法语";
        st.interests = "篮球,音乐,旅游";
        st.say();

        System.out.println("\n" + "-------------分割线------------" + "\n");

        // 测试Teacher类
        Teacher tc = new Teacher("张老师", 38, 8, "西方哲学史");
        tc.say();
    }
}

class Student {
    String name;
    int age;
    String major;
    String interests;

    Student (){}

    public void say(){
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("课程: " + major);
        System.out.println("爱好: " + interests);
    }
}

class Teacher{
    String name;
    int age;
    int teachAge;
    String course;

    Teacher(String n, int a, int ta, String c) {
        name=n;
        age=a;
        teachAge=ta;
        course=c;
    }

    public void say(){
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("教龄: " + teachAge);
        System.out.println("课程: " + course);
    }
}