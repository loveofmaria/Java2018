package day8;

// 1 定义一个Circle类,包含一个double型的radius属性,和一个findArea()方法计算面积
// 2 定义一个PassObject类,有一个方法叫printAreas(),该方法的定义如下:
// public void printAreas(Circle c, int time){
        // 在方法中打印输出1-time之间的每个整数半径值,以及对应的面积.
//        }
// 3 在main方法中调用printAreas(),调用完毕后输出当前半径值

public class PriacticeFive {
    public static void main(String[] args) {
    Circle cObject = new Circle();
    PassObject pObject = new PassObject();
    pObject.printAreas(cObject, 6);
    System.out.println("\nnow Circle radius is : " + cObject.radius);
    System.out.println("now Circle area is : " + cObject.findArea());
    }
}

class Circle {
    double radius;

    public double findArea(){
        return Math.PI * radius * radius;
    }
}

class PassObject{
    public  void printAreas(Circle c, int time){
        System.out.println("Radius\t\t\t\t\tArea");
        for(int i=1; i<=time; i++){
            c.radius = i*1.0;
            if(i==6) continue;
            double area = c.findArea();
            System.out.println(c.radius + "\t\t\t\t\t\t" + area);
        }
    }
}