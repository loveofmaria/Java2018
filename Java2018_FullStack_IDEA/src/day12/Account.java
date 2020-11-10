package day12;

/**
 * @author Administrator
 */
public class Account {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(int annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    private int id;
    private int balance;
    private int annualInterestRate;

    public Account(int id, int balance, int annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void withDraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("余额不足....");
        }
        System.out.println("余额: " + balance);
    }

    public int getMonthlyRate() {
        return annualInterestRate / 12;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("余额: " + balance);
    }
}
