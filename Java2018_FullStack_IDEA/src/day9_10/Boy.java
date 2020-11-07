package day9_10;

public class Boy {

    private String name;
    private int age;

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

    public void marryGirl(Girl girl) {
        System.out.println(this.name + "娶了" + girl.getName() + "为妻子!");
    }

    public void shout() {
        if (this.age < 24) {
            System.out.println(this.getName() + "你还没有达到法定结婚年龄。。。。。");
        } else {
            System.out.println(this.getName() + "年龄合法，可以去结婚登记了!");
        }
    }
}
