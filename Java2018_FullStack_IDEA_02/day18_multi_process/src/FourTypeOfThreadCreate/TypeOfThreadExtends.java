package FourTypeOfThreadCreate;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName FourTypeOfThreadCreate
 * @createdTime 2020-12-16 11:58 AM
 */
public class TypeOfThreadExtends {
    public static void main(String[] args) {
        ThreadNumber t1 = new ThreadNumber();
        t1.setName("张飞");
        ThreadNumber t2 = new ThreadNumber();
        t2.setName("刘备");
        ThreadNumber t3 = new ThreadNumber();
        t3.setName("关羽");
        ThreadNumber t4 = new ThreadNumber();
        t4.setName("马超");
        ThreadNumber t5 = new ThreadNumber();
        t5.setName("关羽");
        ThreadNumber t6 = new ThreadNumber();
        t6.setName("赵云");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class ThreadNumber extends Thread {
    private static int total = 100;
    private int getTotal = 0;

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            threadsRunHere();
            this.getTotal++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void threadsRunHere() {
        if (total > 0) {
            System.out.printf(
                    "[%s] - 取走1个 - 还剩 - %s个\n",
                    Thread.currentThread().getName(), (total - 1)
            );
            total--;
        }
    }

    public static int getTotal() {
        return total;
    }

    public int getGetTotal() {
        return getTotal;
    }
}