package ListDemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(457);
        list.add(list.size(), "黄瓜");
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 56, 7);
        list.addAll(list.size(), list1);
        System.out.println(list);

        System.out.println(list.get(4));

        System.out.println(list.indexOf("黄花"));
        System.out.println(list.indexOf("黄瓜"));

        list.add("黄瓜");
        System.out.println(list.lastIndexOf("黄瓜"));
//        System.out.println(list.remove(20));
//        System.out.println(list);
//        System.out.println(list.remove(list.indexOf("黄瓜")));
//        System.out.println(list);
        System.out.println(list.subList(2, 4));
        int index = list.lastIndexOf("黄瓜");
        list.set(index, "冬瓜");
        System.out.println(list);
    }

    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2);
    }
}
