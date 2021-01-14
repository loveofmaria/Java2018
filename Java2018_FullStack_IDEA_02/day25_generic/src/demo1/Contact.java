package demo1;

public class Contact extends Info {
    private String address;
    private String phoneNumber;
    private String zipCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Contact(String address, String phoneNumber, String zipCode) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }
}
