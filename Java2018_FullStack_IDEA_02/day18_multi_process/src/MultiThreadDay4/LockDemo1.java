package MultiThreadDay4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay4
 * @createdTime 2020-12-15 12:30 PM
 */
public class LockDemo1 {
    public static void main(String[] args) {
        WindowLock w = new WindowLock();
        Thread w1 = new Thread(w);
        w1.setName("窗口一");
        Thread w2 = new Thread(w);
        w2.setName("窗口二");
        Thread w3 = new Thread(w);
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}


class WindowLock implements Runnable {
    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            while (true) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("[%s] 售票 - %s \n", Thread.currentThread().getName(), tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        } finally {
            lock.unlock();
        }

    }
}