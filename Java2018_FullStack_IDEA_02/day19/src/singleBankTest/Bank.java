package singleBankTest;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName singleBankTest
 * @createdTime 2020-12-29 10:56 AM
 */
public class Bank {

    private Bank() {}

    private static Bank instance = null;

    public static Bank getInstance() {
        if(instance == null) {
            synchronized(Bank.class) {
                if(instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
