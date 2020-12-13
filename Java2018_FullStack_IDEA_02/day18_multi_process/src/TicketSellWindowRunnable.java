/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName PACKAGE_NAME
 * @createdTime 2020-12-13 9:54 AM
 */
public class TicketSellWindowRunnable {

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        Thread t1 = new Thread(ticketWindow);
        t1.setName("线程1");

        Thread t2 = new Thread(ticketWindow);
        t2.setName("线程2");
        Thread t3 = new Thread(ticketWindow);
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketWindow implements Runnable {
    // 共享数据
    private int tickets = 100;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            // 同步代码
            synchronized (obj) {
                if (tickets <= 0) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("线程[%s]: 卖出票号: %s\n", Thread.currentThread().getName(), tickets--);
            }

        }
    }
}