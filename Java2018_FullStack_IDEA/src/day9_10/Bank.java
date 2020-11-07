package day9_10;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank(){
        customers = new Customer[10];
    }

    //添加客户
    public void addCustomer(String firstName, String lastName){
        Customer cust = new Customer(firstName, lastName);
        customers[numberOfCustomers++] = cust;
    }
    // 获取客户个数
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }
    // 获取指定位置的客户
    public Customer getCustomer(int index){
        if(index >= 0 && index < numberOfCustomers){
            return customers[index];
        }
        return null;
    }
}
