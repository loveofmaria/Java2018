package day13;

public class Sub extends Base {
    int count = 20;

    @Override
    public void display(){
        System.out.println("子类属性count: "+ this.count);
    }
}
