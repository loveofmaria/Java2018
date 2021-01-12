package extr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CollectionTest1 {

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        System.out.println(list);

        System.out.println(duplicateList(list));
    }

    @Test
    public void test1() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1001, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        System.out.println(set);
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}

class Person {
    String name;
    int id;

    Person() {
    }

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person<" + this.id + " " + this.name + ">";
    }
}

