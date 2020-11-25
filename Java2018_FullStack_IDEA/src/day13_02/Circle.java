package day13_02;

/**
 * @author Administrator
 */
public class Circle extends GeometricObject {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    Circle(double radius, String color, double weight){
        super(color, weight);
        this.radius = radius;
    }

    @Override
    public double findArea(){
        return Math.PI * (radius * radius);
    }
}
