package BaiTap;


public class Cylinder extends Circle {
    private double height;

    // Constructor không tham số
    public Cylinder() {
        super(); // Gọi constructor không tham số của lớp Circle
        this.height = 1.0;
    }

    // Constructor có tham số
    public Cylinder(double radius, String color, double height) {
        super(radius, color); // Gọi constructor có tham số của lớp Circle
        this.height = height;
    }

    // Getter và Setter cho thuộc tính height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Phương thức tính thể tích hình trụ
    public double getVolume() {
        return getArea() * height;
    }

    // Cài đè phương thức toString
    @Override
    public String toString() {
        return "Cylinder[radius=" + getRadius() + ", color=" + getColor() + ", height=" + height + ", volume=" + getVolume() + "]";
    }
}
