package foreachDemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForeachTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(234);
        coll.add(345);
        coll.add(222);
        coll.add("abb");
        coll.add('a');

        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 54, 6, 7, 22, 101};

        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        String[] arr = {"MM", "MM", "MM", "MM"};

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }
        for(String s:arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
