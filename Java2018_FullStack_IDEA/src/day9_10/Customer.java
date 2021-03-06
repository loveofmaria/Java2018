package day9_10;

/**
 * @author Administrator
 */
public class Customer {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {this.account=account;}

    public void displayCustomerInfo(){
        System.out.println("姓名: " + this.lastName + "." + this.firstName);
        account.displayAccount();
    }

    private final String firstName;
    private final String lastName;
    private Account account;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
