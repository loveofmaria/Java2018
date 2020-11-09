package day9_10;

/**
 * @author Administrator
 */
class TestAccountAndCustomer {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("John", "Harden");
        bank.getCustomer(0).setAccount(new Account(1001, 20000, 0.07));
        bank.getCustomer(0).getAccount().withDraw(2000);
        bank.getCustomer(0).getAccount().deposit(10000);
        bank.getCustomer(0).displayCustomerInfo();
        System.out.println("---------------------------------------------------------------------");
        bank.addCustomer("麻子", "张");
        bank.getCustomer(1).setAccount(new Account(1002, 2000, 0.07));
        bank.getCustomer(1).getAccount().withDraw(2000);
        bank.getCustomer(1).getAccount().deposit(1000);
        bank.getCustomer(1).displayCustomerInfo();

    }
}
