package conllection_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class CollectionDemo1 {

    @Test
    public void test1(){
        ArrayList coll1 = new ArrayList();
        ArrayList coll = new ArrayList();
        coll.add("AA");
        coll.add(123);
        coll.add(new Date());
        coll.add("BB");
        coll.add("BC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll.isEmpty());
        coll.clear();
        System.out.println(coll);
    }
}
