package collectionNormalMethods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

    @Test
    public void test() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));

        Iterator iterator = collections.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));

        Iterator iterator = collections.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if("Tom".equals(obj)) {
                iterator.remove();
                break;
            }
        }

        Iterator iterator1 = collections.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}

