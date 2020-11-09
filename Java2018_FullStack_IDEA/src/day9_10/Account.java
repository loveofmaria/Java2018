package day9_10;

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

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    private int id;
    private int balance;
    private double annualInterestRate;

    public Account(int id, int balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void withDraw(int amount){
        if(balance < amount){
            System.out.println("余额不足。。。。。");
        } else {
            this.setBalance(this.balance - amount);
            System.out.println("成功取款: " + amount + " 元");
            System.out.println("余额: " + this.balance + " 元");
        }
    }
    public void deposit(int amount){
        this.setBalance(this.balance + amount);
        System.out.println("存款成功，当前余额为: " + this.balance + " 元");
    }
    public void displayAccount(){
        System.out.println("账户: " + this.id);
        System.out.println("余额: " + this.balance);
        System.out.println("利率: " + this.annualInterestRate);

    }
}
