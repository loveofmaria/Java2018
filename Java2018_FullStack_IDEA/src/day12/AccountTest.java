package day12;

/**
 * @author Administrator
 */
public class AccountTest {
    public static void main(String[] args) {
//        Account account = new Account(1122, 200000, 45);
//
//        account.withDraw(30000);
//        account.withDraw(2500);
//        account.deposit(3000);
//        System.out.println("月利率: " + account.getMonthlyRate() + "%");
//        account.withDraw(200000000);
        CheckAccount checkAccount = new CheckAccount(1122, 20000, 45, 5000);
//        checkAccount.withDraw(5000);
//        checkAccount.withDraw(18000);
//        checkAccount.withDraw(3000);
        checkAccount.withDraw(200000);
    }
}
