package day13;

/**
 * @author Administrator
 */
public class Man extends Person{

    Man(String name, int age) {
        super(name, age);
    }

    @Override
    public void showClassName() {
        System.out.println("This is Class Man!");
    }

}
