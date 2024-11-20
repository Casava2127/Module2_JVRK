package ra.presentation;

import ra.businessImp.Employee;

import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee[] employees = new Employee[0];
        System.out.println("Select an option:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
//              1. Nhập thông tin cho n nhân viên
////            2. Hiển thị thông tin nhân viên
////            3. Tính lương cho các nhân viên
////            4. Tìm kiếm nhân viên theo tên nhân viên
////            5. Cập nhật thông tin nhân viên
////            6. Xóa nhân viên theo mã nhân viên
////            7. Sắp xếp nhân viên theo lương tăng dần
////            8. Thoát
        switch (choice) {
            case 1: {
                System.out.print("Enter the number of employees: ");
                int n = scanner.nextInt();
                employees = new Employee[n]; // 
                scanner.nextLine(); // Consume newline
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter employee details for employee " + (i + 1) + ":");
                    Employee employee = new Employee(); //
                    //cach1
                    // ngay luc nay thi can co contrucotr khong co tham so de khoi tao doi tuong moi
                    // neu khong co constructor thi dung inputDAta1() de nhap du lieu
                    employee.intputData(scanner);
                }
                break;
            }
            case 2: {
                for (Employee employee : employees) {
                    employee.displayData();
                }
                break;
            }
        }
    }
}
