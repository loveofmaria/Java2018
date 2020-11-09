package day11;

/**
 * @author Administrator
 */
public class Student extends Person {
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    String major;

    public Student(){}

    public Student(String major){
        this.major =major;
    }

    public void goForLesson(){
        System.out.println("去上课" + this.major);
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.setAge(22);
        st.setName("张飞");
        st.setMajor("计算机软件工程");
        st.sleep();
        st.eat();
        st.goForLesson();
    }

}
