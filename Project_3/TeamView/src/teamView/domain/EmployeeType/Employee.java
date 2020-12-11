package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;

public class Employee implements Equipment {
    private int id;
    private String name;
    private int age;
    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    };

    @Override
    public String toString() {
        return "{\nid: " + id + ",\nname: " + name + ",\nage: " + age + ",\nsalary: " + salary + "\n}\n";
    }

    @Override
    public String getDescription() {        
        String display = this.getId() + "\t\t" + this.getName() + "\t\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t";
        return display;
    }
}
