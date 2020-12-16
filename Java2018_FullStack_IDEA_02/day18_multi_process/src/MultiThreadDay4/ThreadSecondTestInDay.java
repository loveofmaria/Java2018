package MultiThreadDay4;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay4
 * @createdTime 2020-12-15 10:24 AM
 */

public class ThreadSecondTestInDay {
    public static void main(String[] args) {
        MyCount mc = new MyCount();
        Thread t1 = new Thread(mc);
        Thread t2 = new Thread(mc);
        Thread t3 = new Thread(mc);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t3.start();
        t2.start();
    }

}


class MyCount implements Runnable {
    private int numbers = 100;
    private int sum = 0;

    @Override
    public void run() {
        while (numbers > 0) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add();
        }

    }

    private synchronized void add() {
        sum = sum + numbers;
        numbers--;
        System.out.printf("[%s] - 当前结果: %s\n", Thread.currentThread().getName(), sum);
    }
}