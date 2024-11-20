package ra.business;

import ra.entity.BookType;

import java.sql.*;
import static ra.util.ConnectionDB.getConnection;
public class BookTypeDAO {
      // Lấy tất cả các loại sách
    public void getAllBookTypes() {
       // String sql = "SELECT * FROM booktype WHERE isDeleted = false";
        String sql = "SELECT * FROM booktype ";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("typeId");
                String typeName = rs.getString("typeName");
                String description = rs.getString("description");
                boolean isDeleted = rs.getBoolean("isDeleted");
                System.out.println("ID: " + id + ", Name: " + typeName + ", Description: " + description + ", IsDeleted: " + isDeleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //lay loai sach theo id
    public BookType getBookTypesById(int typeId) {
        String sql = "SELECT * FROM booktype WHERE typeId = ? AND isDeleted = false";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, typeId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new BookType(
                        rs.getInt("typeId"),
                        rs.getString("typeName"),
                        rs.getString("description"),
                        rs.getBoolean("isDeleted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tạo mới loại sách
    public void addNewBookType(BookType bookType) {
        String sql = "INSERT INTO booktype (typeName, description, isDeleted) VALUES (?, ?, false)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookType.getTypeName());
            pstmt.setString(2, bookType.getDescription());
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Tạo mới loại sách thành công.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin loại sách
    public void updateBookType(BookType bookType) {
        String sql = "UPDATE booktype SET typeName = ?, description = ? WHERE typeId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookType.getTypeName());
            pstmt.setString(2, bookType.getDescription());
            pstmt.setInt(3,bookType.getTypeId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật loại sách thành công.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa loại sách (đánh dấu là đã xóa)
    public static void deleteBookType(int typeId) {
        String sql = "UPDATE booktype SET isDeleted = true WHERE typeId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, typeId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Loại sách đã được đánh dấu là đã xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Thống kê số lượng sách theo mã loại sách
    public static void countBooksByType() {
        String sql = "SELECT typename, COUNT(*) AS bookCount FROM book, booktype WHERE book.isDeleted = false AND book.typeid = booktype.typeid GROUP BY typename";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String typeName = rs.getString("typename");
                int bookCount = rs.getInt("bookCount");
                System.out.println("Mã loại sách: " + typeName + ", Số lượng sách: " + bookCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
