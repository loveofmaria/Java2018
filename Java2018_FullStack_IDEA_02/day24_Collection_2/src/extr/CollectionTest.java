package extr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {

    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(222);
        collection.add("AB");
        collection.add("CC");

        collection.forEach(System.out::println);
    }


}
