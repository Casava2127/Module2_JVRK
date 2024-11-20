package ra.business;

import ra.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ra.util.ConnectionDB.getConnection;

public class BookDAO {

    public void getAllBook(){
        String sql = "SELECT * FROM BOOK WHERE ISDELETED = FALSE";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

                while (rs.next()) {
                    int id = rs.getInt("bookId");
                    String name = rs.getString("bookName");
                    String title = rs.getString("title");
                    String author= rs.getString("author");
                    int totalPages = rs.getInt("totalPages");
                    String content= rs.getString("content");
                    String publisher = rs.getString("publisher");
                    float price = rs.getInt("price");
                    int typeId = rs.getInt("typeId");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    System.out.println("ID: " + id + ", Name: " + name + ", Title: " + title + ", Author: " + author + ", Total Pages: " + totalPages + ", Content: " + content + ", Publisher: " + publisher + ", Price: " + price + ", Type ID: " + typeId + ", Is Deleted: " + isDeleted);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //addBook
    public void addNewBook(Book book)  {
        String sql = "INSERT INTO book(bookName, title, author, totalPages, content, publisher, price, typeId, isDeleted) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getTotalPages());
            pstmt.setString(5, book.getContent());
            pstmt.setString(6, book.getPublisher());
            pstmt.setFloat(7, book.getPrice());
            pstmt.setInt(8, book.getTypeId());
            pstmt.setBoolean(9, book.isDeleted());

            pstmt.executeUpdate();
            System.out.println("New book added successfully");
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    //get book by id
    public Book getBookById(int i){
        String sql = "SELECT * FROM BOOK WHERE ISDELETED = FALSE AND BOOKID =i ";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
// thong tin hien thi
//            while (rs.next()) {
//                int id = rs.getInt("bookId");
//                String name = rs.getString("bookName");
//                String title = rs.getString("title");
//                String author= rs.getString("author");
//                int totalPages = rs.getInt("totalPages");
//                String content= rs.getString("content");
//                String publisher = rs.getString("publisher");
//                float price = rs.getInt("price");
//                int typeId = rs.getInt("typeId");
//                boolean isDeleted = rs.getBoolean("isDeleted");
//                System.out.println("ID: " + id + ", Name: " + name + ", Title: " + title + ", Author: " + author + ", Total Pages: " + totalPages + ", Content: " + content + ", Publisher: " + publisher + ", Price: " + price + ", Type ID: " + typeId + ", Is Deleted: " + isDeleted);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBook(Book book) {
        String sql = "UPDATE book SET bookName = ?, title = ?, author = ?, totalPages = ?, content = ?, publisher = ?, price = ?, typeId = ? WHERE bookId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật sách thành công.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete
    public static void deleteBook(int bookId) {
        String sql = "UPDATE book SET isDeleted = true WHERE bookId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Loại sách đã được đánh dấu là đã xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //: Sắp xếp và hiển thị danh sách các cuốn sách theo giá giảm dần
    public static void sortAndDisplayBooksByPrice(){
        String sql = "SELECT * FROM book WHERE isDeleted = FALSE ORDER BY price DESC";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("bookId");
                String name = rs.getString("bookName");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                System.out.println("ID: " + id + ", Name: " + name + ", Author: " + author + " price " + price);
            }
        }catch(SQLException e){
                e.printStackTrace();
            }
        }

    public static void searchBookByNameOrContent(String keyword) {
        String sql = "SELECT * FROM book WHERE (bookName LIKE ? OR content LIKE ?) AND isDeleted = false";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Thiết lập các tham số tìm kiếm bằng keyword
            pstmt.setString(1, "%" + keyword + "%"); // Tìm trong tên sách
            pstmt.setString(2, "%" + keyword + "%"); // Tìm trong nội dung sách

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean hasResults = false; // Để kiểm tra xem có kết quả nào không
                while (rs.next()) {
                    hasResults = true;
                    int bookId = rs.getInt("bookId");
                    String bookName = rs.getString("bookName");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    int totalPages = rs.getInt("totalPages");
                    String content = rs.getString("content");
                    String publisher = rs.getString("publisher");
                    Float price = rs.getFloat("price");
                    int typeId = rs.getInt("typeId");
                    boolean isDeleted = rs.getBoolean("isDeleted");

                    // Hiển thị thông tin sách
                    System.out.println("ID: " + bookId + ", Name: " + bookName + ", Title: " + title +
                            ", Author: " + author + ", Total Pages: " + totalPages +
                            ", Content: " + content + ", Publisher: " + publisher +
                            ", Price: " + price + ", Type ID: " + typeId +
                            ", IsDeleted: " + isDeleted);
                }
                // Nếu không có kết quả, hiển thị thông báo
                if (!hasResults) {
                    System.out.println("Không tìm thấy sách phù hợp.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void categorizeBooksByPageCount() {
        String sql = "SELECT * FROM book WHERE isDeleted = false";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Tạo danh sách cho từng nhóm
            List<String> group1 = new ArrayList<>(); // Số trang < 50
            List<String> group2 = new ArrayList<>(); // Số trang từ 50 đến dưới 300
            List<String> group3 = new ArrayList<>(); // Số trang từ 300 trở lên

            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                int totalPages = rs.getInt("totalPages");

                // Phân loại sách vào các nhóm dựa trên số trang
                if (totalPages < 50) {
                    group1.add("ID: " + bookId + ", Name: " + bookName + ", Pages: " + totalPages);
                } else if (totalPages >= 50 && totalPages < 300) {
                    group2.add("ID: " + bookId + ", Name: " + bookName + ", Pages: " + totalPages);
                } else {
                    group3.add("ID: " + bookId + ", Name: " + bookName + ", Pages: " + totalPages);
                }
            }

            // Hiển thị kết quả
            System.out.println("Nhóm 1 (Số trang < 50):");
            if (group1.isEmpty()) {
                System.out.println("Không có sách trong nhóm này.");
            } else {
                group1.forEach(System.out::println);
            }

            System.out.println("\nNhóm 2 (Số trang từ 50 đến dưới 300):");
            if (group2.isEmpty()) {
                System.out.println("Không có sách trong nhóm này.");
            } else {
                group2.forEach(System.out::println);
            }

            System.out.println("\nNhóm 3 (Số trang từ 300 trở lên):");
            if (group3.isEmpty()) {
                System.out.println("Không có sách trong nhóm này.");
            } else {
                group3.forEach(System.out::println);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}





