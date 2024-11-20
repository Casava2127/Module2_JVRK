package BaiTap;


public class main {
    public static void main(String[] args) {
//bai1
        // Tạo đối tượng Circle
        Circle circle = new Circle(5.0, "blue");
        System.out.println(circle.toString());
        // Tạo đối tượng Cylinder
        Cylinder cylinder = new Cylinder(5.0, "green", 10.0);
        System.out.println(cylinder.toString());

// bai
        Point2D point2D = new Point2D(3, 4);
        System.out.println(point2D.toString());
        Point3D point3D = new Point3D(3, 4, 5);
        System.out.println(point3D.toString());

        Point2D point2D2 = new Point3D(6, 8,9); // upcasting
        System.out.println(point2D2.toString()); // s�� in ra "Point3D [x=6.0, y=8.0, z=9.0]"
        System.out.println(point2D2.getY()); // lấy giá tri x va y thi duoc nhung z thi khong duoc lấy, luc nay no dang
        // kieu cua lop 2D -DA Hinh, hay noi cach khac luc nay no dang tham chieu toi lop 3d va no chi co the lay ra cac
        // bien nay kieu 2d va no chi co the goi cac phuong thuc no co trong lop 3d. tuy nhien vi getZ khong the co trong 2d nen khogn goi dc
        // phuong thuc cua 3D
        System.out.println(((Point3D) point2D2).getZ()); // lấy giá tri z duoc lấy duoc - ep ev kieu point3d
        Point3D point3D2 = (Point3D) point2D2; // downcasting
        System.out.println(point3D2.toString()); // s�� in ra "Point3D [x=6.0, y=8.0, z=9.0]"
        System.out.println(point3D2.getY()); // lấy giá tri x va y thi duoc
        System.out.println(point3D2.getZ()); // lấy giá tri z duoc lấy duoc





    }
}
