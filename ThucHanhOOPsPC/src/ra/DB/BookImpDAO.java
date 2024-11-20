package ra.DB;
 // Định nghĩa package chứa lớp này.

import java.sql.*; // Nhập tất cả các lớp từ package java.sql để sử dụng cho thao tác với cơ sở dữ liệu.
import static ra.DB.ConnectionDBBookImp.getConnection; // Nhập phương thức getConnection từ lớp ConnectionDB để lấy kết nối CSDL.

public class BookImpDAO { // Khai báo lớp ProductDAO để quản lý các thao tác liên quan đến sản phẩm trong CSDL.

    // Thêm sản phẩm mới vào CSDL
    public void addProduct(String bookId,String productName, float importPrice, float exportPrice, String author, int year) { // Phương thức thêm sản phẩm mới với các tham số đầu vào.
        String sql = "INSERT INTO books(bookId, bookName, importPrice, exportPrice, author, year) VALUES (?, ?, ?, ?, ?, ?)"; // Câu lệnh SQL để thêm sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Chuẩn bị câu lệnh SQL với tham số., day la tao 1 obj PreparedStatement cho các truy vấn SQL có tham số, giúp bảo vệ chống SQL Injection.
            pstmt.setString(1, bookId); // Gán giá trị bookId cho tham số đầu tiên.
            pstmt.setString(2, productName); // Gán giá trị productName cho tham số đầu tiên.
            pstmt.setFloat(3, importPrice); // Gán giá trị price cho tham số thứ hai.
            pstmt.setFloat(4, exportPrice); // Gán giá trị price cho tham số thứ hai.
            pstmt.setString(5, author); // Gán giá trị description cho tham số thứ ba.
            pstmt.setInt(6, year); // Gán giá trị description cho tham số thứ ba.
            pstmt.executeUpdate(); // Thực thi câu lệnh SQL để thêm sản phẩm.
            System.out.println("Thêm sản phẩm thành công!"); // Thông báo thành công.
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra trong quá trình kết nối hoặc thực thi.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(String bookId,String productName, float importPrice, float exportPrice, String author, int year) { // Phương thức cập nhật thông tin sản phẩm dựa trên ID.
        String sql = "UPDATE Product SET bookName=?, importPrice=?, exportPrice=?, author=?, year=? WHERE id = ?"; // Câu lệnh SQL để cập nhật sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Chuẩn bị câu lệnh SQL với tham số.
            pstmt.setString(1, productName); // Gán giá trị productName cho tham số đầu tiên.
            pstmt.setFloat(2, importPrice); // Gán giá trị price cho tham số thứ hai.
            pstmt.setFloat(3, exportPrice); // Gán giá trị price cho tham số thứ hai.
            pstmt.setString(4, author); // Gán giá trị description cho tham số thứ ba.
            pstmt.setInt(5, year); // Gán giá trị description cho tham số thứ ba.
            pstmt.executeUpdate(); // Thực thi câu lệnh SQL để cập nhật sản phẩm.
            System.out.println("Cập nhật sản phẩm thành công!"); // Thông báo thành công.
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }

    // Xóa sản phẩm theo ID
    public void deleteProduct(int id) { // Phương thức xóa sản phẩm dựa trên ID.
        String sql = "DELETE FROM books WHERE id = ?"; // Câu lệnh SQL để xóa sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Chuẩn bị câu lệnh SQL với tham số.
            pstmt.setInt(1, id); // Gán giá trị id cho tham số.
            pstmt.executeUpdate(); // Thực thi câu lệnh SQL để xóa sản phẩm.
            System.out.println("Xóa sản phẩm thành công!"); // Thông báo thành công.
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }

    // Lấy tất cả sản phẩm
    public void getAllBooks() { // Phương thức lấy danh sách tất cả sản phẩm.
        String sql = "SELECT * FROM books"; // Câu lệnh SQL để chọn tất cả sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             Statement stmt = conn.createStatement(); // Tạo đối tượng Statement để thực thi câu lệnh SQL.
             ResultSet rs = stmt.executeQuery(sql)) { // Thực thi câu lệnh SQL và lưu kết quả vào ResultSet.
            while (rs.next()) { // Lặp qua các bản ghi trong ResultSet.
                String id = rs.getString("bookId"); // Lấy giá trị id từ bản ghi hiện tại.
                String productName = rs.getString("bookName"); // Lấy giá trị product_name từ bản ghi hiện tại.
                float exportPrice = rs.getFloat("exportPrice"); // Lấy giá trị price từ bản ghi hiện tại.
                String author = rs.getString("author"); // Lấy giá trị description từ bản ghi hiện tại.
                // In ra thông tin sản phẩm.
                System.out.println("ID: " + id + ", Name: " + productName + ", Price: " + exportPrice + ", Author: " + author);


            }
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }
}
