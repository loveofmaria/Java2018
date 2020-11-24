package day13;

/**
 * @author Administrator
 */
public class Cylinder extends Circle {
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private double length;

    Cylinder() {
        super();
        length = 1;
    }

    public double findVolume() {
        return super.findArea() * length;
    }

    @Override
    public double findArea() {
        return 2 * super.findArea() + 2 * Math.PI * getRadius() * length;
    }
}
