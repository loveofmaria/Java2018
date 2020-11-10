package day12;

/**
 * @author Administrator
 */
public class Pig extends Animal {

    Pig(int high, int length) {
        super(high, length);
    }

    @Override
    public void singing(){
        System.out.println("哄哄哄哄。。。。");
    }
}
