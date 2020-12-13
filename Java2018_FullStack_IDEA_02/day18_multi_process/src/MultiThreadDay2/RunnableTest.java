package MultiThreadDay2;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay2
 * @createdTime 2020-12-13 10:48 AM
 */
public class RunnableTest {
    public static void main(String[] args) {

    }
}

class RunnableT implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.printf("[线程 %s] %s", Thread.currentThread().getName(), i+1);
        }

    }
}
