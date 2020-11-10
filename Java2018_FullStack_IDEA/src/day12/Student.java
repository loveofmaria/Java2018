package day12;

/**
 * @author Administrator
 */
public class Student extends Person {
    public Student(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String major;
    private int id;

    public void study() {
        System.out.println("学习的专业是: " + this.major);
    }

    // 父类的eat方法重写
    @Override
    public void eat() {
        System.out.println("这里是学生类重写了父类的eat方法!");
        super.eat();
    }

    public void displayName(){
        super.setAge(222);
        System.out.println("姓名: " + this.getName() +"\n年龄: " + this.getAge() + "\n父类中的age: " +
                super.getAge());
    }
    public void showID(){
        System.out.println("父类的ID: " + super.id);
        System.out.println("子类的ID：" + this.id);
    }
}
