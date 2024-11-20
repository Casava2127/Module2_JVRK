package BaiTap;

public class Point2D {
    private float x;
    private float y;

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    Point2D() {
        this.x = 0;
        this.y = 0;
    };

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float []getXY(){
        return new float[]{getX(), y};
    }
    @Override
    public String toString(){
        return System.out.printf("Point2D (%.2f, %.2f)%n", x, y).toString();
    }

}
