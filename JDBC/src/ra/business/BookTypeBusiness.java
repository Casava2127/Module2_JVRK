package ra.business;

import ra.entity.BookType;

import java.sql.*; // Nhập tất cả các lớp từ package java.sql để sử dụng cho thao tác với cơ sở dữ liệu.
import static ra.util.ConnectionDB.getConnection; // Nhập phương thức getConnection từ lớp ConnectionDB để lấy kết nối CSDL.

public class BookTypeBusiness { // Khai báo lớp ProductDAO để quản lý các thao tác liên quan đến sản phẩm trong CSDL.

    // Thêm sản phẩm mới vào CSDL
    public void addProduct(String productName, double price, String description) { // Phương thức thêm sản phẩm mới với các tham số đầu vào.
        String sql = "INSERT INTO Product (product_name, price, description) VALUES (?, ?, ?)"; // Câu lệnh SQL để thêm sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Chuẩn bị câu lệnh SQL với tham số., day la tao 1 obj PreparedStatement cho các truy vấn SQL có tham số, giúp bảo vệ chống SQL Injection.
            pstmt.setString(1, productName); // Gán giá trị productName cho tham số đầu tiên.
            pstmt.setDouble(2, price); // Gán giá trị price cho tham số thứ hai.
            pstmt.setString(3, description); // Gán giá trị description cho tham số thứ ba.
            pstmt.executeUpdate(); // Thực thi câu lệnh SQL để thêm sản phẩm.
            System.out.println("Thêm sản phẩm thành công!"); // Thông báo thành công.
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra trong quá trình kết nối hoặc thực thi.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }
    // Cập nhật thông tin sản phẩm
    public void updateProduct(BookType bookType) { // Phương thức cập nhật thông tin sản phẩm dựa trên ID.
        String sql = "UPDATE Product SET bookType.typeName = ?, price = ?, description = ? WHERE id = ?"; // Câu lệnh SQL để cập nhật sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Chuẩn bị câu lệnh SQL với tham số.
//            pstmt.setString(1, productName); // Gán giá trị productName cho tham số đầu tiên.
//            pstmt.setDouble(2, price); // Gán giá trị price cho tham số thứ hai.
//            pstmt.setString(3, description); // Gán giá trị description cho tham số thứ ba.
//            pstmt.setInt(4, id); // Gán giá trị id cho tham số thứ tư.
//            pstmt.executeUpdate(); // Thực thi câu lệnh SQL để cập nhật sản phẩm.
//            System.out.println("Cập nhật sản phẩm thành công!"); // Thông báo thành công.
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }

    // Xóa sản phẩm theo ID
    public void deleteProduct(int id) { // Phương thức xóa sản phẩm dựa trên ID.
        String sql = "DELETE FROM Product WHERE id = ?"; // Câu lệnh SQL để xóa sản phẩm.
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
    public void getAllBookType() { // Phương thức lấy danh sách tất cả sản phẩm.
        String sql = "SELECT * FROM booktype WHERE booktype.IsDeleted = false"; // Câu lệnh SQL để chọn tất cả sản phẩm.
        try (Connection conn = getConnection(); // Lấy kết nối tới CSDL và tự động đóng sau khi hoàn thành.
             Statement stmt = conn.createStatement(); // Tạo đối tượng Statement để thực thi câu lệnh SQL.
             ResultSet rs = stmt.executeQuery(sql)) { // Thực thi câu lệnh SQL và lưu kết quả vào ResultSet.
            while (rs.next()) { // Lặp qua các bản ghi trong ResultSet.
                int id = rs.getInt("typeId"); // Lấy giá trị id từ bản ghi hiện tại.
                String productName = rs.getString("typeName"); // Lấy giá trị product_name từ bản ghi hiện tại.
                String description = rs.getString("description"); // Lấy giá trị price từ bản ghi hiện tại.
                boolean isDeleted  = rs.getBoolean("isDeleted"); // Lấy giá trị description từ bản ghi hiện tại.
                // In ra thông tin sản phẩm.
                System.out.println("ID: " + id + ", Name: " + productName + ", Description: " + description + ", IsDeleted: " + isDeleted);

            }
        } catch (SQLException e) { // Xử lý ngoại lệ có thể xảy ra.
            e.printStackTrace(); // In ra chi tiết lỗi nếu có ngoại lệ.
        }
    }
}

