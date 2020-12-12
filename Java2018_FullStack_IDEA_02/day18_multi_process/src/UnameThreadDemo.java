/**
 * @author huangzheng2011
 * @作者 瓜哥
 * @项目名 Java2018_FullStack_IDEA_02
 * @包名称 PACKAGE_NAME
 * @创建时间 2020-12-12 2:14 PM
 */
public class UnameThreadDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("当前进程号: " + currentThread().getName());
                        System.out.println(i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println("当前进程号: " + currentThread().getName());
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }
}
