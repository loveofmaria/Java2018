package day9_10;

/**
 * @author Administrator
 */
public class Bank {
    private final Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10];
    }


    public void addCustomer(String firstName, String lastName) {
        //添加客户
        Customer customer = new Customer(firstName, lastName);
        customers[numberOfCustomers++] = customer;
    }

    public int getNumberOfCustomers() {
        // 获取客户个数
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        // 获取指定位置的客户
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }
        return null;
    }
}
