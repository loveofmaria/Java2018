package day8;

public class ValueTransferTest3 {
    public static void main(String[] args) {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("方法修改数据前: \n" + "m = " + data.m + ", n = " + data.n);
        swapValue(data);
        System.out.println("方法修改数据后: \n" + "m = " + data.m + ", n = " + data.n);
    }

    public static void swapValue(Data data){
        data.m = data.m ^ data.n;
        data.n = data.m ^ data.n;
        data.m = data.m ^ data.n;
    }
}

class Data{
    int m;
    int n;
}