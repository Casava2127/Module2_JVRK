package raExample.util; // Định nghĩa package chứa lớp này.

public class Main { // Khai báo lớp Main, lớp chính của chương trình.
    public static void main(String[] args) { // Phương thức main, điểm khởi đầu của chương trình.
        ProductDAO productDAO = new ProductDAO(); // Tạo một đối tượng ProductDAO để truy cập các phương thức quản lý sản phẩm.

        // Thêm sản phẩm mới
        // Gọi phương thức addProduct với 3 tham số
        productDAO.addProduct("Sản phẩm cua RUM", 199.99, "RUM THEM"); // Thêm một sản phẩm mới với tên, giá và mô tả cụ thể.

        // Lấy danh sách tất cả sản phẩm
        productDAO.getAllProducts(); // Lấy và hiển thị danh sách tất cả sản phẩm hiện có trong cơ sở dữ liệu.

        // Cập nhật thông tin sản phẩm
        // Cập nhật sản phẩm với id
        productDAO.updateProduct(9, "Sản phẩm 9 đã cập nhật", 299.99, "RUM CAP NHAT"); // Cập nhật sản phẩm với ID 13, thay đổi tên, giá và mô tả.

        // Xóa sản phẩm
        // productDAO.deleteProduct(9); // Xóa sản phẩm có ID 9 (đã được chú thích).

        // Kiểm tra danh sách sản phẩm sau khi xóa
         productDAO.getAllProducts(); // Hiển thị lại danh sách sản phẩm để xác nhận sản phẩm đã bị xóa (đã được chú thích).
    }
}
