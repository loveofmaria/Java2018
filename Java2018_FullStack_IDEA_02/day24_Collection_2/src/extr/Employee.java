package extr;

public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "姓名: " + this.name + "\n" +
                "年龄: " + this.age + "\n" +
                "生日: " + this.getBirthday() + "\n" +
                "}";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return -this.birthday.compareTo(employee.birthday);
        }
        throw new RuntimeException("传入的类型不匹配!");
    }
}

class MyDate implements Comparable {
    private int year = 2020;
    private int month = 1;
    private int day = 12;

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) return false;
        if (month != myDate.month) return false;
        return day == myDate.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            int result = this.getYear() - ((MyDate) o).getYear();
            if(result != 0){
                return result;
            }
            result = this.getMonth() - ((MyDate) o).getMonth();
            if(result != 0){
                return result;
            }
            return this.getDay() - ((MyDate) o).getDay();
        }
        throw new RuntimeException("传入的类型不匹配!");
    }

    @Override
    public String toString(){
        return year + "-" + month + "-" + day;
    }
}
