package day13;

/**
 * @author Administrator
 */
public class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void showClassName(){
        System.out.println("This class is Person!");
    }
}
