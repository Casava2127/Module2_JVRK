package src;

import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeGen;
    private double employeeRate;
    private double employeeSalary;

    // Getter và Setter
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeGen() {
        return employeeGen;
    }

    public void setEmployeeGen(String employeeGen) {
        this.employeeGen = employeeGen;
    }

    public double getEmployeeRate() {
        return employeeRate;
    }

    public void setEmployeeRate(double employeeRate) {
        this.employeeRate = employeeRate;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    // Constructor không tham số
    public Employee() {

    }

    // Constructor có tham số
    public Employee(int employeeId, String employeeName, int employeeAge, String employeeGen, double employeeRate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeGen = employeeGen;
        this.employeeRate = employeeRate;
        this.employeeSalary = employeeSalary();  // Tính lương sau khi gán hệ số
    }

    // Phương thức tính lương
    public double employeeSalary() {
        return employeeRate * 1300000;
    }

    // Phương thức nhập thông tin nhân viên
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên:");
        System.out.print("ID: ");
        setEmployeeId(scanner.nextInt());
        scanner.nextLine(); // Đọc bỏ ký tự thừa
        System.out.print("Tên: ");
        setEmployeeName(scanner.nextLine());
        System.out.print("Tuổi: ");
        setEmployeeAge(scanner.nextInt());
        scanner.nextLine(); // Đọc bỏ ký tự thừa
        System.out.print("Giới tính: ");
        setEmployeeGen(scanner.nextLine());
        System.out.print("Hệ số: ");
        setEmployeeRate(scanner.nextDouble());

        // Tính lương sau khi nhập hệ số
        employeeSalary = employeeSalary();
    }

    // Phương thức hiển thị thông tin nhân viên
    public void displayData() {
        System.out.println("Thông tin nhân viên:");
        System.out.println("ID: " + getEmployeeId());
        System.out.println("Tên: " + getEmployeeName());
        System.out.println("Tuổi: " + getEmployeeAge());
        System.out.println("Giới tính: " + getEmployeeGen());
        System.out.println("Hệ số: " + getEmployeeRate());
        System.out.println("Lương: " + getEmployeeSalary());  // Lương đã tính toán
    }
}
