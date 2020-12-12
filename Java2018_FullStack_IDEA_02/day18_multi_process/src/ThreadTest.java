/**
 * @作者 瓜哥
 * @项目名 Java2018_FullStack_IDEA_02
 * @包名称 PACKAGE_NAME
 * @创建时间 2020-12-12 1:09 PM
 */

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.start();
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i + "-" + Thread.currentThread().getName() + "----------main---------");
            }
        }
        myThread1.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}