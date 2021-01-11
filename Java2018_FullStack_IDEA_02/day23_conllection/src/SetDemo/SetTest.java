package SetDemo;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SetTest {
    @Test
    public void test() {
        Set set = new HashSet();
        set.add(4556);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(129);
        set.add(new Person("Tom", 12));
        set.add(new Person("Tom", 12));
        System.out.println(set);
    }

    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(4556);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(129);
        set.add(new Person("Tom", 12));
        set.add(new Person("Tom", 12));
        System.out.println(set);
    }


    @Test
    public void test3() {
        Set set = new TreeSet();
        set.add(4556);
        set.add(123);
        set.add(23);
        set.add(8);
        set.add(10);
        set.add(1089);
        set.add(890);
        System.out.println(set);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        Set set = new TreeSet();
        set.add(new Person("TOM", 28));
        set.add(new Person("TOM", 31));
        set.add(new Person("Ma", 32));
        set.add(new Person("John", 32));
        set.add(new Person("Jack", 29));
        set.add(new Person("Zhang", 32));
        set.add(new Person("TOM", 33));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test5(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("传入类型不匹配....");
                }
            }
        };
        Set set = new TreeSet(comparator);
        set.add(new Person("TOM", 28));
        set.add(new Person("TOM", 31));
        set.add(new Person("Ma", 32));
        set.add(new Person("John", 32));
        set.add(new Person("Jack", 29));
        set.add(new Person("Zhang", 32));
        set.add(new Person("TOM", 33));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}


class Person implements Comparable {
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
        return "Person {" + "name: " + name + ", age: " + age + " }";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        int result;
        if(o instanceof Person) {
            Person person = (Person) o;
            result = this.name.compareTo(person.name);
            if(result == 0) {
                result =  Integer.compare(this.age, person.age);
            }
            return result;
        } else {
            throw new RuntimeException("传入的类型不一致!");
        }

    }
}
