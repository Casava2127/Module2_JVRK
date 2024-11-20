package BaiTapSS1;

import java.util.Scanner;

public class CircleCalculation {

    public static void main(String[] args) {
        // Khởi tạo Scanner để nhận dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập bán kính hình tròn từ người dùng
        System.out.print("Nhập bán kính hình tròn: ");
        double radius = scanner.nextDouble();

        // Đảm bảo bán kính phải là số dương
        if (radius <= 0) {
            System.out.println("Bán kính phải là số dương.");
        } else {
            // Tính chu vi hình tròn
            double circumference = 2 * Math.PI * radius;

            // Tính diện tích hình tròn
            double area = Math.PI * Math.pow(radius, 2);

            // In kết quả ra màn hình
            System.out.printf("Chu vi của hình tròn là: %.2f%n", circumference);
            System.out.printf("Diện tích của hình tròn là: %.2f%n", area);
        }

        // Đóng đối tượng Scanner
        scanner.close();
    }
}