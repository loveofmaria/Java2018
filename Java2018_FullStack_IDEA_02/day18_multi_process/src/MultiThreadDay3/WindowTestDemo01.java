package MultiThreadDay3;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay3
 * @createdTime 2020-12-14 10:11 AM
 * <p>
 */

public class WindowTestDemo01 {

    public static void main(String[] args) {
        Window t1 = new Window();
        t1.setName("窗口一");
        Window t2 = new Window();
        t2.setName("窗口二");
        Window t3 = new Window();
        t3.setName("窗口三");
        Window t4 = new Window();
        t4.setName("窗口四");

        t4.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            runWindow();
        }
    }

    private static synchronized void runWindow() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%s]: 出票号为 %s 的票\n", Thread.currentThread().getName(), tickets);
            tickets--;
        }
    }
}



