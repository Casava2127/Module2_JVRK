package Bai5;

public class main {
    public  double calculateAverageSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary / employees.length;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        FullTimeEmployee employee1 = new FullTimeEmployee(1000, "John Doe");
        FullTimeEmployee employee2 = new FullTimeEmployee(1500, "Jane Doe");

        double totalSalary1 = employee1.calculateSalary();
        double totalSalary2 = employee2.calculateSalary();

        System.out.println("Total salary of employee1: " + totalSalary1);
        System.out.println("Total salary of employee2: " + totalSalary2);

        PartTimeEmployee employee3 = new PartTimeEmployee(500, "Michael Doe", 4);
        double totalSalary3 = employee3.calculateSalary();

        System.out.println("Total salary of employee3: " + totalSalary3);

        Employee[] employees = {employee1, employee2, employee3};

        main program = new main(); // tao doi tuong lop main de goi phuong thuc non-static ben ngoai
        // hoac them static vao cho phuong thuc static de goi ben trong lop main

        double averageSalary = program.calculateAverageSalary(employees);
        System.out.println("Average salary of all employees: " + averageSalary);
    }
}
