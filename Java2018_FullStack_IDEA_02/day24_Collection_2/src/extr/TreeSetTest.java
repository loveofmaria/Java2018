package extr;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Tom", 29, new MyDate(1980, 12, 16));
        Employee employee2 = new Employee("Mike", 33, new MyDate(1991, 10, 26));
        Employee employee3 = new Employee("Jack", 30, new MyDate(1979, 8, 1));
        Employee employee4 = new Employee("Susan", 42, new MyDate(1983, 6, 26));
        Employee employee5 = new Employee("Jhon", 32, new MyDate(1985, 3, 23));

        Collection employees = new TreeSet();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test() {
        Employee employee1 = new Employee("eTom", 29, new MyDate(1980, 12, 16));
        Employee employee2 = new Employee("dMike", 33, new MyDate(1991, 10, 26));
        Employee employee3 = new Employee("bJack", 30, new MyDate(1979, 8, 1));
        Employee employee4 = new Employee("cSusan", 42, new MyDate(1983, 6, 26));
        Employee employee5 = new Employee("aJhon", 32, new MyDate(1985, 3, 23));

        Collection employees = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
                }
                throw new RuntimeException("传入类型不匹配!");
            }
        });
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
