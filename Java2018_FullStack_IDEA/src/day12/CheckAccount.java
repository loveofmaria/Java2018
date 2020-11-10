package day12;

/**
 * @author Administrator
 */
public class CheckAccount extends Account{
    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    private int overdraft;

    public CheckAccount(int id, int balance, int annualInterestRate, int overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withDraw(int amount) {
        System.out.println("当前余额: " + this.getBalance());
        System.out.println("该账户可透支额度: " + this.getOverdraft());

        if(this.getBalance() >= amount){
            int balance = this.getBalance() - amount;
            this.setBalance(balance);
            System.out.println("取款 " + amount);
            System.out.println("余额: " + this.getBalance());
        } else {
            int balanceDraft = this.getOverdraft() + this.getBalance();
            if(balanceDraft >= amount){
                this.setBalance(0);
                System.out.println("透支消费完成，余额: 0");
            } else {
                System.out.println("透支额度不足以完成本次取款！");
            }
        }
        System.out.println("-----------------------------------------------------");
    }
}
