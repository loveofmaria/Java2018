package FourTypeOfThreadCreate;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName FourTypeOfThreadCreate
 * @createdTime 2020-12-16 12:33 PM
 */
public class TypeOfImplementsCallable {
    public static void main(String[] args) {
        ThreadNumberCallable w = new ThreadNumberCallable();
        FutureTask futureTask = new FutureTask(w);
        Thread t1 = new Thread(futureTask);
        t1.setName("张飞");
        Thread t2 = new Thread(futureTask);
        t2.setName("马超");
        Thread t3 = new Thread(futureTask);
        t3.setName("黄忠");
        Thread t4 = new Thread(futureTask);
        t4.setName("赵云");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class ThreadNumberCallable implements Callable {
    private int total = 50;
    Lock lock = new ReentrantLock();

    @Override
    public Object call() throws Exception {
        lock.lock();
        try {
            while (true) {
                if (total > 0) {
                    System.out.printf("[%s] - 取走1 total-%s\n",
                            Thread.currentThread().getName(), total - 1);
                    total--;
                } else {
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}


