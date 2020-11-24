package day13_02;

/**
 * @author Administrator
 * 定义方法method(Person e);
 *
 * 1.根据e的类型调用相应类型的getInfo()
 * 2.根据e的类型执行：
 *      如果e为Person类对象，输出：‘a person'
 *      Student 对象，输出 ' a student a person'
 *      Graduate 对象，输出 ‘a graduate a student a person'
 */
public class InstanceTest {
    public static void main(String[] args) {
        Person p = new Person();
        Person s = new Student();
        Person g = new Graduate();
        System.out.println("----------Person----------");
        System.out.println(p.getInfo());
        method(p);
        System.out.println("----------Student----------");
        System.out.println(s.getInfo());
        method(s);
        System.out.println("----------Graduate----------");
        System.out.println(g.getInfo());
        method(g);
    }

    public static void method(Person e){
        if(e instanceof Graduate){
            System.out.println("a graduate \na student \na person");
        } else if(e instanceof Student){
            System.out.println("a student \na person");
        } else {
            System.out.println("a person");
        }
    }
}
