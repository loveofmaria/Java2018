/**
 * @作者 瓜哥
 * @项目名 Java2018_FullStack_IDEA_02
 * @包名称 PACKAGE_NAME
 * @创建时间 2020-12-12 1:53 PM
 *
 * 练习：
 * 创建两个线程，分别遍历100内的偶数和奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        threadDemo2.start();
        threadDemo1.start();
    }
}

class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

class ThreadDemo2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}