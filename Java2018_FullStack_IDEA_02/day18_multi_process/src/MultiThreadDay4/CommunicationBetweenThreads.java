package MultiThreadDay4;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay4
 * @createdTime 2020-12-15 3:01 PM
 */
public class CommunicationBetweenThreads {
    public static void main(String[] args) {

        NumberToShare number = new NumberToShare();
        Thread printer1 = new Thread(number);
        printer1.setName("打印机1: ");
        Thread printer2 = new Thread(number);
        printer2.setName("打印机2: ");

        printer1.start();
        printer2.start();
    }

}

class NumberToShare implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (number < 100) {
                    try {
                        // sleep 设置阻塞，但是不会释放锁
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;


                    try {
                        // wait()方法进入阻塞状态,并且释放锁
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}