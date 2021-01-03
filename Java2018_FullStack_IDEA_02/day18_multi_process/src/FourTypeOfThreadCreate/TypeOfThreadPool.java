package FourTypeOfThreadCreate;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName FourTypeOfThreadCreate
 * @createdTime 2020-12-16 1:26 PM
 */
public class TypeOfThreadPool {
    public static void main(String[] args) {
        ExecutorService service = newFixedThreadPool(4);
        ThreadPoolNumber w = new ThreadPoolNumber();
        service.execute(w);
        service.execute(w);
        service.execute(w);
        service.execute(w);
        service.execute(w);

        service.shutdown();
    }
}


class ThreadPoolNumber implements Runnable {
    private int total = 50;

    @Override
    public void run() {
        while (total > 1) {
            synchronized (this) {

                    System.out.printf("[%s]-取走1，total-%s\n",
                            Thread.currentThread().getName(), total - 1);
                    total--;

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
