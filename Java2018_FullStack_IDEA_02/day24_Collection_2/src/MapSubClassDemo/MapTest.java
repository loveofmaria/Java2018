package MapSubClassDemo;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test() {
        Map map = new HashMap();
//        map.put(null, null);
        map.put("Name", "高盛");
        map.put("Age", 20);
        map.put("Josh", 21);
        map.put("Jordan", 320);
        map.put("Mike", 204);
        map.put("Jack", 2065);
        map.put("Mack", 2022);

//        System.out.println(map);
//        System.out.println(map.get("Name"));
//        System.out.println(map.containsKey("Age"));
//        System.out.println(map.containsValue(20));
        Collection collection = map.values();
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    @Test
    public void test1() {
        Map map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(643, "BB");
        map.put(251, "CC");
        map.put(333, "EE");
        map.put(222, "DD");
        map.put(234, "AA");

        System.out.println(map);
    }

    @Test
    public void test2() {
        Map map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(643, "BB");
        map.put(251, "CC");
        map.put(333, "EE");
        map.put(222, "DD");
        map.put(234, "AA");

//        Set keySet = map.keySet();
//        for(Object k :keySet){
//            System.out.println(k + " - " + map.get(k));
//        }
//
//        Collection values = map.values();
//        for(Object v :values){
//            System.out.println(v);
//        }
//        Set entrySet = map.entrySet();
//        for(Object e : entrySet){
//            System.out.println(e);
//        }
        Set entrySet = map.entrySet();
        for (Object e : entrySet) {
            Map.Entry entry = (Map.Entry) e;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }

    @Test
    public void test3() {

        class Person implements Comparable {
            String name;
            int id;

            Person() {
            }

            Person(String name, int id) {
                this.id = id;
                this.name = name;
            }

            @Override
            public String toString() {
                return "Person<" + this.id + " " + this.name + ">";
            }

            @Override
            public int compareTo(Object o) {
                if (o instanceof Person) {
                    if (this.name.compareTo(((Person) o).name) == 0) {
                        return Integer.compare(this.id, ((Person) o).id);
                    }
                    return this.name.compareTo(((Person) o).name);
                }
                throw new RuntimeException("传入的类型不匹配!");
            }
        }

        TreeMap treeMap = new TreeMap();
        Person p1 = new Person("Tom", 122);
        Person p2 = new Person("Jack", 242);
        Person p3 = new Person("Mike", 22);
        Person p4 = new Person("Jason", 232);
        Person p5 = new Person("Wong", 22);
        treeMap.put(p1, 1001);
        treeMap.put(p2, 1002);
        treeMap.put(p3, 1003);
        treeMap.put(p4, 1004);
        treeMap.put(p5, 1005);

        Set entrySet = treeMap.entrySet();
        for(Object e : entrySet){
            Map.Entry entry = (Map.Entry) e;
            System.out.println(((Map.Entry<?, ?>) e).getKey() + "---->" + ((Map.Entry<?, ?>) e).getValue());
        }

    }
}
