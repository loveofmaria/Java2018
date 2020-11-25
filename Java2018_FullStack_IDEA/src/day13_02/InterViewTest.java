package day13_02;
import java.util.Random;
/**
 * @author Administrator
 * //面试题：多态是编译时行为还是运行时行为？
 * //证明如下：
 */
class Animal  {

    protected void eat() {
        System.out.println("animal eat food");
    }
}

class Cat  extends Animal  {

    @Override
    protected void eat() {
        System.out.println("cat eat fish");
    }
}

class Dog  extends Animal  {

    @Override
    public void eat() {
        System.out.println("Dog eat bone");

    }

}

class Sheep  extends Animal  {

    @Override
    public void eat() {
        System.out.println("Sheep eat grass");

    }

}

class InterviewTest {

    public static Animal  getInstance(int key) {
        switch (key) {
            case 0:
                return new Cat ();
            case 1:
                return new Dog ();
            default:
                return new Sheep ();
        }

    }

    public static void main(String[] args) {
        int key = new Random().nextInt(3);

        System.out.println(key);

        Animal  animal = getInstance(key);

        animal.eat();

    }

}