package ra.entity;
//shop_management
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop_management";
    private static final String USER = "root"; // Thay đổi theo username của bạn
    private static final String PASSWORD = "123456"; // Thay đổi theo password của bạn

    // Constructor không tham số
    public Categories() {
    }

    // Constructor đầy đủ tham số
    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getter và Setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // Phương thức nhập dữ liệu
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên danh mục: ");
        this.catalogName = scanner.nextLine();

        System.out.println("Nhập mô tả danh mục: ");
        this.descriptions = scanner.nextLine();

        System.out.println("Nhập trạng thái danh mục (true - hoạt động, false - không hoạt động): ");
        this.catalogStatus = scanner.nextBoolean();
        scanner.nextLine(); // Đọc bỏ dòng trống
    }

    // Phương thức hiển thị thông tin danh mục
    public void displayData() {
        System.out.println("ID: " + this.catalogId + " - Tên danh mục: " + this.catalogName
                + " - Mô tả: " + this.descriptions + " - Trạng thái: " + (this.catalogStatus ? "Hoạt động" : "Không hoạt động"));
    }

    // Phương thức lưu danh mục vào CSDL
    public void saveToDatabase() {
        String sql = "INSERT INTO categories (catalogName, descriptions, catalogStatus) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, catalogName);
            pstmt.setString(2, descriptions);
            pstmt.setBoolean(3, catalogStatus);
            pstmt.executeUpdate();
            System.out.println("Danh mục đã được lưu vào CSDL thành công.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức lấy danh mục từ CSDL
    public static void loadFromDatabase() {
        String sql = "SELECT * FROM categories";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("catalogId");
                String name = rs.getString("catalogName");
                String desc = rs.getString("descriptions");
                boolean status = rs.getBoolean("catalogStatus");
                Categories category = new Categories(id, name, desc, status);
                category.displayData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
