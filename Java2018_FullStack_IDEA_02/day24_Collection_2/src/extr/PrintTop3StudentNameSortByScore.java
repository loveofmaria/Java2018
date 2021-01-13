package extr;

import java.util.Iterator;
import java.util.TreeSet;

public class PrintTop3StudentNameSortByScore {
    public static void main(String[] args) {
        Student s1 = new Student("章憨子", 1001, 100);
        Student s2 = new Student("关于", 1002, 92);
        Student s3 = new Student("马超", 1003, 77);
        Student s4 = new Student("刘杰克", 1004, 67);
        Student s5 = new Student("罗伯特马", 1005, 89);
        Student s6 = new Student("罗伯特张", 1006, 89);

        TreeSet treeSet = new TreeSet();
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);
        treeSet.add(s6);

        Iterator iterator = treeSet.iterator();
        int count = 0;
        while (iterator.hasNext()){
            if(count < 3){
                System.out.println(iterator.next());
                count++;
            } else  {
                break;
            }
        }
    }

    static class Student implements Comparable {
        private String name;
        private int id;
        private int score;

        Student(String name, int id, int score) {
                this.name = name;
                this.id = id;
                this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Student) {
                Student student = (Student) o;
                if (student.getScore() == this.getScore()) {
                    return student.getName().compareTo(this.getName());
                } else {
                    return Integer.compare(student.getScore(), this.getScore());
                }
            }
            throw new RuntimeException("传入的类型不匹配!");
        }

        @Override
        public String toString() {
            return "Student{\n" +
                    "姓名: " + this.name + "\n" +
                    "ID: " + this.id + "\n" +
                    "成绩: " + this.score + "\n" +
                    "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            if (score != student.score) return false;
            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + id;
            result = 31 * result + score;
            return result;
        }
    }
}


