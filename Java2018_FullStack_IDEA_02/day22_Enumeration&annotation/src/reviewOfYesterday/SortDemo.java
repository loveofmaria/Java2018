package reviewOfYesterday;

import java.util.Arrays;
import java.util.Comparator;

public class SortDemo {

    public static void main(String[] args) {
        Person[] persons = {
                new Person("John", 66),
                new Person("Lucas", 37),
                new Person("Max", 21),
                new Person("Don", 35),
                new Person("Jack", 31),
                new Person("Zhang", 33),
                new Person("Wong", 29),
                new Person("Hellen", 42),
        };
        // 自然排序
//        Arrays.sort(persons);
//        for (Person person : persons) {
//            System.out.println(person);
//        }
        // 定制排序,需要按照需求重写Comparator类中的compare(obj1, obj2)方法
        Arrays.sort(persons, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((o1 instanceof Person) && (o2 instanceof Person)) {
                    if(Integer.compare(((Person) o1).getAge(), ((Person) o2).getAge())==0){
                        return ((Person) o1).getName().compareTo(((Person) o2).getName());
                    }
                    return Integer.compare(((Person) o1).getAge(), ((Person) o2).getAge());
                }
                throw new RuntimeException("传入的类型不匹配!");
            }
        });
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}


// 自定义Person类如下，如何实现自然排序「按姓名从小到大排序」
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

    Person() {
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 自然排序，类的内部实现 CompareTo(Object o)方法
    @Override
    public int compareTo(Object o) {
        int result;
        if (o instanceof Person) {
            result = ((Person) o).getName().compareTo(this.name);
            if (result == 0) {
                return Integer.compare(((Person) o).getAge(), this.age);
            }
            return result;
        }
        throw new RuntimeException("传入的类型不匹配!");
    }

    @Override
    public String toString() {
        return "<" + this.name + " - " + this.age + ">";
    }

}