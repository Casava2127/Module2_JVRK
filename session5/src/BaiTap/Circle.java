package BaiTap;
public class Circle {
    private double radius;
    private String color;

    // Constructor không tham số
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    // Constructor có tham số
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter và Setter cho thuộc tính radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter và Setter cho thuộc tính color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Phương thức tính diện tích hình tròn
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Cài đè phương thức toString
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + ", area=" + getArea() + "]";
    }
}
