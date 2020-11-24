package day13;

/**
 * @author Administrator
 */
public class Circle {
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;

    public Circle(){
        radius=1;
    }
    public double findArea(){
        return Math.PI*radius*radius;
    }
}
