package Bai5;

 class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int paymentPerHouse, String name) {
        super(paymentPerHouse, name);
    }
    @Override
    public int calculateSalary() {
        return 8 * paymentPerHouse;
    }
}
