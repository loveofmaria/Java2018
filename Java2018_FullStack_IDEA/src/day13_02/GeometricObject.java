package day13_02;

/**
 * @author Administrator
 */
public class GeometricObject {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private String color;
    private double weight;

    GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public double findArea(){
        return weight * weight;
    }

}
