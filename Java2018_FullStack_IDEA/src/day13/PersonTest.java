package day13;

/**
 * @author Administrator
 */

public class PersonTest {

    public static void main(String[] args) {
//        Person person = new Woman("美丽", 22);
//        Man personMan = (Man) person;
        Object obj = new Woman("玛美里", 30);
        Person p = (Person)obj;
        p.showClassName();
    }
}
