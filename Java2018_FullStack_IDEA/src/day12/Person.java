package day12;

/**
 * @author Administrator
 */
public class Person {
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
    private int age=20;
    int id = 1001;

    public void eat(){
        System.out.println("这里是Person类中的eat方法!");
    }
    public void walk(int distance){
        System.out.println("走了" + distance +"里山路!");
    }
}
