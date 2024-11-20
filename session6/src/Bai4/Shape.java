package Bai4;

public abstract class Shape {
    private String color;

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return 0;
    };
    // Default color for shapes
    public void display() {
            System.out.println("This is a shape have color: " + color);
    };




}
