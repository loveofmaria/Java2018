package day11;

/**
 * @author Administrator
 */
public class Creature {

}

class TestCreature{
    public static void main(String[] args) {
        Creature c = new Creature();
        Creature c1 = new Creature();
        System.out.println(c.toString());
        System.out.println(c.getClass());
        System.out.println(c.equals(c1));
    }

}