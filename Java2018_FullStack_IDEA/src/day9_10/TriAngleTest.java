package day9_10;

/*
    定义 TriAngle TriAngleTest 两个类,
    其中 TriAngle 类中声明私有的底边长 base 和 高height,
    同时声明公共方法访问私有属性.此外,提供类必要的构造器.
    另一个类中使用这些公共方法计算三角形的面积
 */
public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle tri = new TriAngle();
        TriAngle tri_1 = new TriAngle(20, 15);
        TriAngle tri_2 = new TriAngle(0, 0);
        System.out.println("tri_1: " + tri_1.getBaseline() + "  " + tri_1.getHeight());
        System.out.println("tri_1 Area: " + tri_1.getArea());
        System.out.println("tri_2: " + tri_2.getBaseline() + "  " + tri_2.getHeight());
        System.out.println("tri_2 Area: " + tri_2.getArea());
        System.out.println("tri: " + tri.getBaseline() + "  " + tri.getHeight());
        System.out.println("tri Area: " + tri.getArea());
        tri.setBaseline(11);
        tri.setHeight(8);
        System.out.println("tri: " + tri.getBaseline() + "  " + tri.getHeight());
        System.out.println("tri Area: " + tri.getArea());

    }
}

class TriAngle {
    private int baseline;
    private int height;

    TriAngle() {
        baseline = 1;
        height = 1;
    }

    TriAngle(int bl, int hg) {
        baseline = bl;
        height = hg;
        if (bl <= 0) {
            baseline = 1;
        }
        if (hg <= 0) {
            height = 1;
        }
    }

    public void setBaseline(int bl) {
        baseline = bl;
    }

    public void setHeight(int hg) {
        height = hg;
    }

    public int getBaseline() {
        return baseline;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return baseline * height / 2;
    }
}