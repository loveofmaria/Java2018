package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName ThreadPoolDemo
 * @createdTime 2020-12-16 11:23 AM
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        ExecutorService service = newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        service.shutdown();
//        service.submit()
    }
}


class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.printf("[%s] - %s\n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.printf("[%s] - %s\n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}