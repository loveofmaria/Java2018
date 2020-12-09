public class ThrowsHandleTest {
    public static void main(String[] args) {
        Student student = new Student(20, 1001);
        try {
            student.register(-1010);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


class Student {
    private int age;
    private int id;

    public Student(int age, int id) {
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception("你输入的数据非法!");
        }
    }
}