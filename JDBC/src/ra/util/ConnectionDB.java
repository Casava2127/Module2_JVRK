package ra.util; // Định nghĩa package chứa lớp này.

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection; // Nhập lớp Connection từ package java.sql để TẠO KET NOI tới CSDL.
import java.sql.DriverManager; // Nhập lớp DriverManager từ package java.sql để QUẢN LÝ các kết nối.
import java.sql.SQLException; // Nhập lớp SQLException để XU LY CAC LOI liên quan đến kết nối CSDL.

public class ConnectionDB { // Khai báo lớp ConnectionDB.

    // URL của CSDL cần kết nối đến
    private static final String URL = "jdbc:mysql://localhost:3306/quanlythuvien"; // Địa chỉ URL của cơ sở dữ liệu MySQL.

    // Driver của MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Tên driver JDBC cho MySQL.

    // Tên người dùng và mật khẩu của CSDL
    private static final String USER_NAME = "root"; // Tên người dùng để đăng nhập vào CSDL.
    private static final String PASSWORD = "123456"; // Mật khẩu của người dùng; thay đổi theo mật khẩu thực tế của bạn.

    // Phương thức lấy kết nối
    public static Connection getConnection() { // Khai báo phương thức static để lấy kết nối.
        Connection conn = null; // Khởi tạo biến conn để lưu trữ kết nối.
        try {
            // Đăng ký driver
            Class.forName(DRIVER); // Tải driver MySQL vào bộ nhớ, cho phép sử dụng.
            // Kết nối tới CSDL
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); // Thiết lập kết nối đến CSDL sử dụng thông tin đã cung cấp.
            // phuong thuc getConnection này tạo ra 1 obj Connection
            System.out.println("Kết nối thành công!"); // Thông báo nếu kết nối thành công.
        } catch (ClassNotFoundException | SQLException e) { // Xử lý các ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
            System.out.println("Kết nối thất bại!"); // Thông báo nếu kết nối thất bại.
        }
        return conn; // Trả về kết nối (có thể là null nếu không thành công).
    }

    // Phương thức đóng kết nối
    public void closeConnection(Connection conn, CallableStatement callSt) {
        try {
            if (callSt != null && !callSt.isClosed()) {
                callSt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Đóng kết nối thành công!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
        }
    }
}
