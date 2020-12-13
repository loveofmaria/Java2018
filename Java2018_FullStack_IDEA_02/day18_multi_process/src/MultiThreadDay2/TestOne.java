package MultiThreadDay2;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay2
 * @createdTime 2020-12-13 10:41 AM
 */
public class TestOne {
    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();

        testThread1.start();
        testThread2.start();
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("[线程 %s] %s\n", Thread.currentThread().getName(), (i+1));
        }
    }
}
