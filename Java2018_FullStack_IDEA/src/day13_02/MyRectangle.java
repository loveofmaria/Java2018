package day13_02;

/**
 * @author Administrator
 */
public class MyRectangle extends GeometricObject {
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    MyRectangle(String color, double weight, double height, double width){
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    @Override
    public double findArea(){
      return height * width;
    }
}
