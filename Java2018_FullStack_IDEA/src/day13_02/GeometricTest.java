package day13_02;

/**
 * @author Administrator
 */
public class GeometricTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "red", 10);
        MyRectangle rectangle = new MyRectangle("black", 10, 20, 30);

        displayGeometricObject(circle);
        displayGeometricObject(rectangle);

        System.out.println("circle 和 rectangle 的面积对比结果为: " + equalsArea(circle, rectangle));

    }

    public static boolean equalsArea(GeometricObject obj1, GeometricObject obj2){
        return obj1.findArea() == obj2.findArea();
    }

    public static void displayGeometricObject(GeometricObject obj){
        System.out.println("面积为: " + obj.findArea());
    }
}
