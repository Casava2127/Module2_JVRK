package src;

import java.util.Scanner;

public class Circle {
    // Thuộc tính
    private double radius;
    private String color;

    // Constructor không tham số
    public Circle() {
        this.radius = 0.0;
        this.color = "Undefined";
    }

    // Constructor có tham số
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter và Setter cho bán kính
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter và Setter cho màu sắc
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Phương thức tính chu vi
    public double chuVi() {
        return 2 * Math.PI * radius;
    }

    // Phương thức tính diện tích
    public double dienTich() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Phương thức nhập dữ liệu
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính: ");
        setRadius(scanner.nextDouble());
        scanner.nextLine(); // Đọc dòng ký tự thừa
        System.out.print("Nhập màu sắc: ");
        this.color = scanner.nextLine();
    }

    // Phương thức hiển thị dữ liệu
    public void displayData() {
        System.out.println("Bán kính: " + this.radius);
        System.out.println("Màu sắc: " + getColor());
        System.out.println("Chu vi: " + chuVi());
        System.out.println("Diện tích: " + dienTich());
    }


}
