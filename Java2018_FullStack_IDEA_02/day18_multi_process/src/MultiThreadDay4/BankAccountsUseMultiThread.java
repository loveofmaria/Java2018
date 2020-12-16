package MultiThreadDay4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzheng2011
 */
public class BankAccountsUseMultiThread {
    public static void main(String[] args) {
        Account account = new Account();
        Customers c1 = new Customers(account);
        c1.setName("张飞");
        Customers c2 = new Customers(account);
        c2.setName("马超");
        Customers c3 = new Customers(account);
        c3.setName("刘备");

        c1.start();
        c2.start();
        c3.start();
    }
}

class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void saveMoney(int money) {
        balance += money;
    }
}

class Customers extends Thread {
    private Account account;
    private final ReentrantLock LOCK = new ReentrantLock();

    @Override
    public void run() {
        LOCK.lock();
        try {
            for (int i = 0; i < 3; i++) {
                account.saveMoney(1000);

                System.out.printf("[%s] 存储1000成功\n当前余额： %s\n",
                        Thread.currentThread().getName(), account.getBalance());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            LOCK.unlock();
        }
    }

    Customers(Account account) {
        this.account = account;
    }
}