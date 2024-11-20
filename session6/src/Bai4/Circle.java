package Bai4;

public class Circle extends Shape {
    private double radius;
    private String color;
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public void display() {
        System.out.println("Circle: Area = " + getArea() + ", Color = " + this.color);
    }

}
