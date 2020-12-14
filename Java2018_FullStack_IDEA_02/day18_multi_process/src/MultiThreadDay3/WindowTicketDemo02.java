package MultiThreadDay3;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay3
 * @createdTime 2020-12-14 11:41 AM
 */
public class WindowTicketDemo02 {

    public static void main(String[] args) {
        TicketWindow t = new TicketWindow();
        Thread w = new Thread(t);
        w.setName("窗口1");
        w.start();
        Thread w1 = new Thread(t);
        w1.setName("窗口2");
        w1.start();
        Thread w2 = new Thread(t);
        w2.setName("窗口3");
        w2.start();
    }
}

class TicketWindow implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while(true) {
            runWindow();
        }
    }

    private synchronized void runWindow() {
        if(tickets > 0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%s]: %s\n", Thread.currentThread().getName(),tickets);
            tickets--;
        } else {
            return;
        }
    }
}