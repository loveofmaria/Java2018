package MultiThreadDay4;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay4
 * @createdTime 2020-12-15 9:54 AM
 */
public class ThreadFirstTestInDay {
    public static void main(String[] args) {
        MyCounter t1 = new MyCounter();
        MyCounter t2 = new MyCounter();
        MyCounter t3 = new MyCounter();
        t1.setName("线程1");
        t1.start();
        t2.setName("线程2");
        t2.start();
        t3.setName("线程3");
        t3.start();

    }
}


class MyCounter extends Thread {
    private static int numbers = 100;
    private static int sum = 0;

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

    private static synchronized void add() {
        sum = sum + numbers;
        numbers--;
        System.out.printf("[%s] - 当前总和: %s\n", Thread.currentThread().getName(), sum);
    }

    public static void getResult() {
        System.out.println("最后结果为: " + sum);
    }
}