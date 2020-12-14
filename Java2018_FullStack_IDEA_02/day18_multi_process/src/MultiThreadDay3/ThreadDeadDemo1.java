package MultiThreadDay3;

/**
 *
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay3
 * @createdTime 2020-12-14 12:58 PM *
 *
 */
public class ThreadDeadDemo1 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread () {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s1.append("1");
                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");
                    }
                    System.out.println("s1 " + s1);
                    System.out.println("s2 " + s2);
                }
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized (s2) {
                    s1.append("c");
                    s1.append("3");
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");
                    }
                    System.out.println("s1 " + s1);
                    System.out.println("s2 " + s2);
                }
            }
        }).start();
    }
}
