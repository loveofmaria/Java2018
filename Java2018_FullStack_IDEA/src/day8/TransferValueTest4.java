package day8;

public class TransferValueTest4 {
    public static void main(String[] args){
        TransferValueTest4 test = new TransferValueTest4();
        test.first();
    }

    public void first(){
        int i=5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i); // 25
    }

    public void second(Value v, int i){
        i=0;
        v.i=20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i); // 15
    }
}

class Value {
    int i=15;
}