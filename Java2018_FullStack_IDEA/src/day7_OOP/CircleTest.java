package day7_OOP;

// 利用面向对象的编程方法,设计类Circle计算圆面积

import java.text.DecimalFormat;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(12.0);
        c1.circleArea();
    }
}

class Circle {
    double radius;

    Circle(double r) {
        radius = r;
    }

    private String areaToString(double d) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        return fmt.format(d);
    }

    public void circleArea() {
        double r = radius * radius * Math.PI;
        System.out.println("半径为" + radius + "的面积为: " + areaToString(r));
    }
}