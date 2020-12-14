package MultiThreadDay3;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay3
 * @createdTime 2020-12-14 12:25 PM
 */
public class SynchronizedBankDemo01 {
}


class Bank {
    private Bank() {
    }

    private static Bank instance = null;
//      public static synchronized Bank getInstance() {
//        if (instance == null) {
//            /*
//             *
//             *    多个线程同时进入的时候，
//             *    如果同时判断 instance == null,
//             *    那么就会创建多个
//             *    Bank 对象,就会出现安全问题
//             *
//             */
//            instance = new Bank();
//        }
//        return instance;
//    }
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }
}