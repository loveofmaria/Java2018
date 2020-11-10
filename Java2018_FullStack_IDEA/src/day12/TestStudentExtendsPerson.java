package day12;

/**
 * @author Administrator
 */
public class TestStudentExtendsPerson {
    public static void main(String[] args) {
        Student s1 = new Student("计算机科学与技术");
        Person p1 = new Person();
        p1.setAge(200);
        s1.walk(200);
        s1.setName("子类");
        s1.setAge(33);
        s1.eat();
        s1.study();
        p1.eat();
        s1.displayName();
        s1.showID();
    }
}
