package day12;

/**
 * @author Administrator
 */
public class AnimalTest {
    public static void main(String[] args) {

        // 多态性，父类引用子类对象
        func(new Dog(20,20));
        func(new Pig(20,20));

    }
    public static void func(Animal animal){
        animal.singing();
    }
}
