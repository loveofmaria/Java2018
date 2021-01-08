package collectionNormalMethods;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));
        Collection collection1 = Arrays.asList(123, 456);

        System.out.println(collections.contains(456));
        System.out.println(collections.contains("ABC"));
        System.out.println(collections.contains("Tom"));
        System.out.println(collections.contains(new Person("Jerry", 20)));
        System.out.println(collections.contains(collection1));
    }

    @Test
    public void test1() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));
        Collection collection1 = Arrays.asList(123, 456);

        System.out.println(collections.remove(123));
        System.out.println(collections.contains(123));

        System.out.println(collections.removeAll(Arrays.asList(456, "Tom")));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(234);
        coll.add(345);
        coll.add(222);
        Collection coll_1 = Arrays.asList(234, 345);
        coll.retainAll(coll_1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));

        Object[] coll = collections.toArray();
        System.out.println(coll);
        int[] arr = {1, 2, 3, 4, 5};
        List arr2 = Arrays.asList(new Integer[] {1, 2, 3, 4, 5});
    }

    @Test
    public void test4() {
        Collection collections = new ArrayList();
        collections.add(123);
        collections.add(456);
        collections.add(new String("Tom"));
        collections.add(new Person("Jerry", 20));
        Collection collection1 = Arrays.asList(123, 456);

        System.out.println(collections.hashCode());
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "<" + this.name + "-" + this.age + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}