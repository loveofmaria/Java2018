package day13_02;

/**
 * @author Administrator
 */
public class Graduate extends Student {
    public String major = "IT";

    @Override
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nSchool:" + school
                + "\nmajor:" + major;
    }
}
