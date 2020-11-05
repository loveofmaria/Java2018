package day9_10;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person(22, "花花");
        p.getAge();
        p.getName();
        p1.getName();
        p1.getAge();
    }
}

class Person{
    private int age;
    private String name;

    Person(int a){
        age = a;
    }
    Person(int a, String n){
        age = a;
        name = n;
    }
    Person(){
        age = 0;
        name = "unnamed";
    }

    public void getName(){
        System.out.println(name);
    }

    public void getAge(){
        System.out.println(age);
    }
}