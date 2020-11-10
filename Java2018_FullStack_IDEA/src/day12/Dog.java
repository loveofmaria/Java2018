package day12;

/**
 * @author Administrator
 */
public class Dog extends Animal {

    Dog(int high, int length) {
        super(high, length);
    }


    @Override
    public void singing(){
        System.out.println("汪汪汪。。。。");
    }
}
