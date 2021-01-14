package demo1;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GenericTest {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(100);
        list.add(99);
        list.add(92);
        list.add(56);
        list.add(97);
        Arrays.sort(new ArrayList[]{list});

//        list.add("Tom");

        for (Object score : list) {
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(100);
        list.add(99);
        list.add(92);
        list.add(56);
        list.add(97);
//        list.add("Tom");
        for (Object score : list) {
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Alice", 30);
        map.put("Jack", 32);
        map.put("Lucas", 29);
        map.put("Mari", 26);
        map.put("Age", 33);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            Integer value = e.getValue();
            String key = e.getKey();
        }
    }

    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;
    }
    class Person{}
    class Student extends Person{}
}
