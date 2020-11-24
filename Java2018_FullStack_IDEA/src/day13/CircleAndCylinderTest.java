package day13;

/**
 * @author Administrator
 */
public class CircleAndCylinderTest {
    public static void main(String[] args) {
        int radius = 20;
        Circle circle = new Circle();
        circle.setRadius(radius);
        System.out.println("半径为20的圆的面积为: " + circle.findArea());
        System.out.println("------------------------------------------");
        int length = 10;
        Cylinder cylinder = new Cylinder();
        cylinder.setLength(length);
        cylinder.setRadius(radius);
        System.out.println("半径为20的圆柱体体积为: " + cylinder.findVolume());
        System.out.println("半径为20的圆柱体表面积为: " + cylinder.findArea());
        System.out.println("---------------------------------------------");
        System.out.println(cylinder instanceof Circle);
        System.out.println(circle instanceof Circle);
        System.out.println(circle instanceof Cylinder);

    }
}
