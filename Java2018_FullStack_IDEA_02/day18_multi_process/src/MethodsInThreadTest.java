/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName PACKAGE_NAME
 * @createdTime 2020-12-12 2:38 PM
 */
public class MethodsInThreadTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("子线程");
        /* helloThread.setName("子线程一号"); */
        helloThread.setPriority(Thread.MAX_PRIORITY);
        helloThread.start();
        // 主线程
        Thread.currentThread().setName("主线程....");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int j = 0; j < 100; j++) {
            if (j % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "-" + j);
            }

            if (j == 20){
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(helloThread.isAlive());
    }
}

class HelloThread extends Thread {
    HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String threadName = this.getName();
        System.out.println(this.isAlive());
        for (int j = 0; j < 100; j++) {

            if (j % 2 == 0) {
                System.out.println(threadName + "-" + j);
            }
           if (j == 20) {
               System.out.println("子线程让位......");
                Thread.yield();
               try {
                   sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        }
    }
}