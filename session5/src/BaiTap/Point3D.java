package BaiTap;

public class Point3D extends Point2D  {// Kế thừa từ l��p Point2D{
  private float z;
  Point3D(float x, float y, float z) {
      super(x, y);
      this.z = z;
  }
  Point3D() {
      this(0, 0, 0);
  }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        this.z = z;
    }
    public float[] getXYZ() {
        return new float[]{getX(), getY() , this.z};// vi x,y khai bao privae nen dung get de lay ra,
       // return new float[]{getX(), getY() , getZ()};
    }
}
