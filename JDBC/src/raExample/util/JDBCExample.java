package raExample.util;

import java.sql.Connection; // Nhập lớp Connection từ package java.sql để làm việc với kết nối đến CSDL.
import java.sql.DriverManager; // Nhập lớp DriverManager để quản lý các kết nối tới CSDL.
import java.sql.ResultSet; // Nhập lớp ResultSet để lưu trữ và xử lý kết quả truy vấn.
import java.sql.SQLException; // Nhập lớp SQLException để xử lý các lỗi liên quan đến CSDL.
import java.sql.Statement; // Nhập lớp Statement để thực thi các câu lệnh SQL.

public class JDBCExample {
    public static void main(String[] args) {
        // Định nghĩa các thông số kết nối
        String url = "jdbc:mysql://localhost:3306/quanlythuvien"; // Địa chỉ URL của CSDL MySQL.
        String user = "root"; // Tên người dùng đăng nhập vào CSDL.
        String password = "123456"; // Mật khẩu của người dùng; cần thay đổi theo mật khẩu thực tế.

        try {
            // Tải Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Tải driver JDBC cho MySQL vào bộ nhớ.

            // Thiết lập Kết Nối
            Connection connection = DriverManager.getConnection(url, user, password); // Tạo kết nối đến CSDL bằng thông tin đã cung cấp.
            // tao 1 doi tuong Connection

            // Tạo doi tuong Statement
            Statement statement = connection.createStatement(); // Tạo đối tượng Statement để thực thi câu lệnh SQL.
            // tao doi tuong nay thong qua doi tuong connection

//cach1
            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book"); // Thực hiện truy vấn SQL để lấy tất cả sản phẩm từ bảng product
            System.out.println(resultSet);// địa chỉ đối tượng của ResultSet

            //phan biet ro excuteQuery, excuteUpdate, excute


            // Xử lý kết quả
            while (resultSet.next()) { // Duyệt qua từng bản ghi trong ResultSet.
                System.out.println("ID: " + resultSet.getInt("BookId") + " Name: "+ resultSet.getString(2)); // In ra ID sản phẩm.
            }// getXXX(yyy)  thi y co the la tren truong hoac chi so thu tu cua truong trong bang

            // Đóng kết nối
            resultSet.close(); // Đóng ResultSet sau khi xử lý xong.
            statement.close(); // Đóng Statement sau khi thực hiện xong.
            connection.close(); // Đóng kết nối đến CSDL.

        } catch (ClassNotFoundException e) { // Bắt lỗi nếu driver không tìm thấy.
            e.printStackTrace(); // In ra thông tin lỗi.
        } catch (SQLException e) { // Bắt lỗi liên quan đến CSDL.
            e.printStackTrace(); // In ra thông tin lỗi.
        }
    }
}
