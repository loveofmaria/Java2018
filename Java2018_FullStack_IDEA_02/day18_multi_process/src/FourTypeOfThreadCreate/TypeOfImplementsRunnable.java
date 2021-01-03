package FourTypeOfThreadCreate;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName FourTypeOfThreadCreate
 * @createdTime 2020-12-16 12:21 PM
 */
public class TypeOfImplementsRunnable {
    public static void main(String[] args) {
        ThreadRunnableNumber ex = new ThreadRunnableNumber();
        Thread t1 = new Thread(ex);
        t1.setName("张飞");
        Thread t2 = new Thread(ex);
        t2.setName("关羽");
        Thread t3 = new Thread(ex);
        t3.setName("马超");
        Thread t4 = new Thread(ex);
        t4.setName("黄忠");
        Thread t5 = new Thread(ex);
        t5.setName("赵云");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


class ThreadRunnableNumber implements Runnable {
    private int total = 50;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total > 0) {

                    System.out.printf(
                            "[%s] - 取走1个 total - %s\n",
                            Thread.currentThread().getName(),
                            total - 1
                    );
                    total--;
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}