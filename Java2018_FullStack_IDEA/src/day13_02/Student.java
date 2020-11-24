package day13_02;

/**
 * @author Administrator
 */
public class Student extends Person {
    protected String school = "pku";

    @Override
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nSchool:" + school;
    }
}
