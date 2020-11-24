package day13;

/**
 * @author Administrator
 */
public class Woman extends Person{

    Woman(String name, int age) {
        super(name, age);
    }

    @Override
    public void showClassName() {
        System.out.println("This is Class Woman!");
    }

}