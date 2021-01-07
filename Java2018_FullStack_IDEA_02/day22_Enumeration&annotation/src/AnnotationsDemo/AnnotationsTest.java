package AnnotationsDemo;

public class AnnotationsTest {
    public static void main(String[] args) {

    }
}

@MyAnnotationTest(value="Hi")
class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}