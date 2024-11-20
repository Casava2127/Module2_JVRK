package ra.businessImp;

import ra.business.IEmployee;
import java.util.Scanner;

public class Employee implements IEmployee {
    private String name;
    private String Id;
    private int Year;
    private float Rate;
    private float Commission;
    private  float Salary;
    private  Boolean Status;

    public Employee() {
    }

    public Employee(String name, String id, int year, float rate, float commission,  Boolean status) {
        this.name = name;
        this.Id = id;
        this.Year = year;
        this.Rate = rate;
        this.Commission = commission;
        this.Status = status;
        this.Salary = calculateSalary();
    }



    float calculateSalary(){
        return Rate*BASIC_SALARY+Commission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 6 && name.length() <= 50) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Tên nhân viên phải từ 6 đến 50 ký tự.");
        }
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        if(year<2002){
            Year = year;
        } else {
            throw new IllegalArgumentException("Năm sinh phải truoc 2002.");
        }
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        if(rate>0 ) {
            Rate = rate;
        }else {
            throw new IllegalArgumentException("He so luong phai lon hơn 0.");
        }
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        if(status){
            System.out.println("Status : Dang Lam Viec");
        }else {
            System.out.println("Status : Nghi Viec");
        }
    }

    @Override
    public void intputData(Scanner scanner) {
        System.out.print("Enter Name : ");
        setName(scanner.nextLine());
        System.out.print("Enter ID : ");
        setId(scanner.nextLine());
        System.out.print("Enter Year : ");
        setYear(scanner.nextInt());
        System.out.print("Enter Rate : ");
        setRate(scanner.nextFloat());
        System.out.print("Enter Commission : ");
        setCommission(scanner.nextFloat());
        System.out.print("Enter Status (true/false) : ");
        setStatus(scanner.nextBoolean());
        Salary = calculateSalary();
        scanner.nextLine();  // consume newline left-over from the previous input
    }
    @Override
    public void displayData() {
        System.out.println("Name : " + getName());
        System.out.println("ID : " + getId());
        System.out.println("Year : " + getYear());
        System.out.println("Rate : " + getRate());
        System.out.println("Commission : " + getCommission());
        System.out.println("Salary : " + getSalary());
        System.out.println("Status : " + getStatus());
    }




    public void intputData1(Scanner scanner) {
        this.name = scanner.nextLine();


    }
}
