package Bai5;

abstract class Employee implements IEmployee {
    protected int paymentPerHouse;
    protected String name;
    public Employee(int paymentPerHouse, String name) {
        this.paymentPerHouse = paymentPerHouse;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setPaymentPerHouse(int paymentPerHouse) {
        this.paymentPerHouse = paymentPerHouse;
    }
    public int getPaymentPerHouse() {
        return paymentPerHouse;
    }

}
