package Bai5;

public class PartTimeEmployee extends Employee {
    private int workingHours;

    public PartTimeEmployee(int paymentPerHouse, String name, int workingHours) {
        super(paymentPerHouse, name);
        this.workingHours = workingHours;

    }
    @Override
    public int calculateSalary() {
        return paymentPerHouse * workingHours;
    }

}
