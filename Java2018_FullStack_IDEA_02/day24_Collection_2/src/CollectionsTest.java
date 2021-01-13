import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(22);
        list.add(123);
        list.add(123);
        list.add(234);
        list.add(78);
        list.add(78);
        list.add(78);
        list.add(101);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);

//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//        Collections.reverse(list);
//        System.out.println(list);
//        Collections.swap(list, 0, list.toArray().length -1);
//        System.out.println(list);
//        Collections.shuffle(list);
//        System.out.println(list);
//
//        System.out.println(Collections.max(list));
//        Collections.min(list);
        System.out.println(Collections.frequency(list, 'a'));
        System.out.println(dest);

        System.out.println(Collections.synchronizedCollection(list));
    }
}
