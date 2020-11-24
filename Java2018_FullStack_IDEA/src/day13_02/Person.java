package day13_02;

/**
 * @author Administrator
 */
public class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name:" + name + "\n" + "age:" + age;
    }
}
