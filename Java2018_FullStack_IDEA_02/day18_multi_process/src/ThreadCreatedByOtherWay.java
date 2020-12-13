/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName PACKAGE_NAME
 * @createdTime 2020-12-13 9:28 AM
 * <p>
 * 1.  创建一个实现了Runnable接口的类
 * 2.  实现类去实现Runnable中的抽象方法：run()
 * 3.  创建实现类的实例对象
 * 4.  将此对象作为参数传递给Thread类的构造器中，创建Thread对象
 * 5.  通过Thread类的对象调用start( )
 */
public class ThreadCreatedByOtherWay {
    public static void main(String[] args) {
        MyThreadTest mt = new MyThreadTest();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}

class MyThreadTest implements Runnable {
    private static int threadNumber = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.printf("[线程: %s] - 偶数: %s%n", Thread.currentThread().getName(), i);
            }
        }
    }
}
