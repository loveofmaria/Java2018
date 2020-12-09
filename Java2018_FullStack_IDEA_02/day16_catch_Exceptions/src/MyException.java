public class MyException extends RuntimeException {
    static final long serialVersionUID = -2393432942394239432L;

    public MyException() {}
    public MyException(String msg){
        super(msg);
    }

    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("马子", -20);
            System.out.println(person);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Person {
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

    public Person(String name, int age) {
        if (age < 0 ) {
            throw new MyException("你他妈是妖精吗!?");
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person[" + this.name + " " + this.age + " ]";
    }
}
