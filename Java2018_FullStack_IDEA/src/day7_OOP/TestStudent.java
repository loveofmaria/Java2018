package day7_OOP;

import java.util.Arrays;
import java.util.Random;

public class TestStudent {
    public static void main(String[] args) {
        Random r = new Random();
        StudentReal[] students = new StudentReal[20];
        // 创建一个有随机数组成的student对象数组
        for (int i = 0; i<students.length; i++) {
            StudentReal st = new StudentReal();
            st.number = i + 1;
            st.score = r.nextInt(100);
            st.state = r.nextInt(6) + 1;
            students[i] = st;
        }
        // 打印出 state==3 的学生对象的信息
        for (StudentReal student : students) {
            if (student.state == 3) {
                student.displayInfo();
                System.out.println("-------------------------");
            }
        }
        // 根据成绩排序并且输出信息
        bubbleSort(students);
    }

    public static void bubbleSort(StudentReal[] students){
        StudentReal tmp;
        for(int i=1; i<students.length; i++) {
            for(int j=0; j<students.length-i; j++) {
                if(students[j].score > students[j+1].score) {
                    tmp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = tmp;
                }
            }
        }
        for (StudentReal student : students) {
            student.displayInfo();
        }
    }
}

class StudentReal {
    int number;
    int state;
    int score;

    StudentReal() {
    };

    public void displayInfo(){
        System.out.println("编号: " + number);
        System.out.println("年级: " + state);
        System.out.println("分数: " + score);
        System.out.println("-------------------");
    }
}
