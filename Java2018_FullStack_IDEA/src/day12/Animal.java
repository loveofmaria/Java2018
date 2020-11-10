package day12;

/**
 * @author Administrator
 */
public class Animal {
    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int high;
    private int length;

    Animal(int high, int length){
        this.length = length;
        this.high = high;
    }

    public void run(){
        System.out.println("Running....");
    }
    public void loud(){
        System.out.println("lauding.......");
    }
    public void singing(){
        System.out.println("父类singing方法......");
    }
}
