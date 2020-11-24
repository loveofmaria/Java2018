package day13;

/**
 * @author Administrator
 */
public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println("子类s属性值count:" + s.count);
        s.display();
        System.out.println("=================================");
        Base b = s;
        System.out.println(b == s);
        System.out.println(b.count);
        b.display();
        b.className = "父类";
    }
}
