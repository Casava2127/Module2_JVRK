Để tạo một bảng quản lý sản phẩm trong cơ sở dữ liệu `ExampleJDBC` mà bạn đã tạo trước đó, hãy làm theo các bước sau trong IntelliJ IDEA:

### Bước 1: Mở SQL Console

1. **Mở Cửa sổ Database**:
    - Nếu bạn chưa mở, vào `View` > `Tool Windows` > `Database` hoặc nhấn `Alt + 1`.

2. **Chọn Cơ sở Dữ liệu**:
    - Tìm cơ sở dữ liệu `ExampleJDBC` trong danh sách.
    - Nhấp chuột phải vào nó và chọn `New` > `SQL Console`.

### Bước 2: Tạo Bảng Sản Phẩm

1. **Nhập Câu lệnh Tạo Bảng**:
   Trong cửa sổ SQL Console, bạn có thể nhập câu lệnh SQL sau để tạo bảng sản phẩm:

   ```sql
   CREATE TABLE Product (
       id INT AUTO_INCREMENT PRIMARY KEY,  -- Cột ID tự động tăng và là khóa chính
       product_name VARCHAR(100) NOT NULL, -- Tên sản phẩm, không được để trống
       price DECIMAL(10, 2) NOT NULL,       -- Giá sản phẩm, không được để trống
       description TEXT                      -- Mô tả sản phẩm
   );
   ```

2. **Chạy Câu lệnh**:
    - Nhấn `Ctrl + Enter` để chạy câu lệnh. Nếu thành công, bạn sẽ thấy thông báo về việc tạo bảng thành công.

### Bước 3: Kiểm Tra Bảng Đã Tạo

1. **Làm Mới Danh Sách Bảng**:
    - Nhấp chuột phải vào `Tables` dưới `ExampleJDBC` trong cửa sổ Database.
    - Chọn `Refresh` để làm mới danh sách bảng.

2. **Kiểm Tra Bảng**:
    - Bạn nên thấy bảng `Product` trong danh sách. Nhấp đúp vào bảng để xem cấu trúc và dữ liệu (nếu có).

### Bước 4: Thêm Dữ Liệu Vào Bảng

1. **Mở lại SQL Console**:
    - Nếu bạn đã đóng SQL Console, mở lại bằng cách nhấp chuột phải vào `ExampleJDBC` và chọn `New` > `SQL Console`.

2. **Nhập Câu lệnh Thêm Dữ liệu**:
   Bạn có thể thêm dữ liệu vào bảng `Product` bằng cách sử dụng câu lệnh SQL như sau:

   ```sql
   INSERT INTO Product (product_name, price, description) VALUES
   ('Sản phẩm 1', 99.99, 'Mô tả sản phẩm 1'),
   ('Sản phẩm 2', 199.99, 'Mô tả sản phẩm 2'),
   ('Sản phẩm 3', 299.99, 'Mô tả sản phẩm 3');
   ```

3. **Chạy Câu lệnh**:
    - Nhấn `Ctrl + Enter` để chạy câu lệnh. Nếu thành công, bạn sẽ thấy thông báo về việc thêm dữ liệu thành công.

### Bước 5: Kiểm Tra Dữ Liệu

1. **Mở lại SQL Console** (nếu cần).

2. **Nhập Câu lệnh Truy Vấn Dữ Liệu**:
   Để kiểm tra dữ liệu đã thêm, bạn có thể sử dụng câu lệnh sau:

   ```sql
   SELECT * FROM Product;
   ```

3. **Chạy Câu lệnh**:
    - Nhấn `Ctrl + Enter` để chạy câu lệnh. Bạn sẽ thấy danh sách các sản phẩm đã thêm trong bảng `Product`.

### Kết luận

Bây giờ bạn đã tạo thành công một bảng quản lý sản phẩm trong cơ sở dữ liệu `ExampleJDBC`, và đã thêm một số sản phẩm vào bảng. Nếu bạn cần thực hiện thêm các thao tác khác hoặc có câu hỏi nào khác, hãy cho tôi biết!