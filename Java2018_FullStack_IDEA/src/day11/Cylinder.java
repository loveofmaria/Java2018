package day11;

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

    public Cylinder(){
        this.length = 1;
    }

    public double findVolume(){
        return this.findArea()*length;
    }
}
