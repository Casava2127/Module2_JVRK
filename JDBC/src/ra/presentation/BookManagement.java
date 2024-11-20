package ra.presentation;

import ra.business.BookDAO;
import ra.business.BookTypeDAO;


import ra.entity.Book;
import ra.entity.BookType;

import java.util.Scanner;
// Nhập tất cả các lớp từ package java.sql để sử dụng cho thao tác với cơ sở dữ liệu.

import static ra.business.BookDAO.*;
import static ra.business.BookTypeDAO.countBooksByType;
import static ra.business.BookTypeDAO.deleteBookType;

public class BookManagement {
    private static final BookTypeDAO bookTypeDAO = new BookTypeDAO();
    private static final BookDAO bookDAO = new BookDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("*********************BOOK-MANAGEMENT******************");
            System.out.println("1. Quan ly loai sach");
            System.out.println("2. Quan ly sach");
            System.out.println("3. Thoat");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTypeMenu();
                    break;
                case 2:
                    bookMenu();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 3);
    }

    public static void bookTypeMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("*********************BOOKTYPE-MENU******************");
            System.out.println("1. Danh sach loai sach");
            System.out.println("2. Tao moi loai sach");
            System.out.println("3. Cap nhap thong tin loai sach");
            System.out.println("4. Xoa loai sach");
            System.out.println("5. Thong ke loai sach");
            System.out.println("6. Quay lai");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTypeDAO.getAllBookTypes();
                    break;
                case 2:
                    BookType newBookType2 = new BookType();
                    newBookType2.inputData(scanner);
                    bookTypeDAO.addNewBookType(newBookType2);

                    break;
                case 3:
                    System.out.println("Nhap ma loai sach can cap nhat: ");
                    int bookTypeIdNeedUpdate = scanner.nextInt();
                    BookType bookTypeToUpdate = bookTypeDAO.getBookTypesById(bookTypeIdNeedUpdate);
                    if (bookTypeToUpdate == null) {
                        System.out.println("Không tìm thấy loại sách với mã này.");
                        break;
                    }

                    // Hiển thị thông tin hiện tại
                    System.out.println("Thông tin loại sách hiện tại:");
                    System.out.println("Tên: " + bookTypeToUpdate.getTypeName());
                    System.out.println("Mô tả: " + bookTypeToUpdate.getDescription());

                    // Cho phép người dùng chọn thông tin cần sửa
                    System.out.println("Chọn thông tin cần sửa:");
                    System.out.println("1. Tên loại sách");
                    System.out.println("2. Mô tả loại sách");
                    System.out.print("Lựa chọn của bạn: ");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (updateChoice == 1) {
                        System.out.print("Nhập tên mới: ");
                        bookTypeToUpdate.setTypeName(scanner.nextLine());
                    } else if (updateChoice == 2) {
                        System.out.print("Nhập mô tả mới: ");
                        bookTypeToUpdate.setDescription(scanner.nextLine());
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                    }
                    // Cập nhật thông tin vào cơ sở dữ liệu
                    bookTypeDAO.updateBookType(bookTypeToUpdate);
                    break;

                case 4:
                    System.out.println("Nhap ma loai sach can xoa: ");
                    deleteBookType(scanner.nextInt());
                    break;
                case 5:
                    countBooksByType();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);

    }

    public static void bookMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("*********************BOOK-MENU******************");
            System.out.println("1. Danh sach  sach");
            System.out.println("2. Tao moi  sach");
            System.out.println("3. Cap nhap thong tin  sach");
            System.out.println("4. Xoa l sach");
            System.out.println("5. Thong ke sach theo gia giam dan");
            System.out.println("6. Tim kiem thong tin theo ten hoac noi dung");
            System.out.println("7. Thong ke so luogn sach theo nhom");
            System.out.println("8. Quay lai");

            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookDAO.getAllBook();
                    break;
                case 2:
                    Book newBook = new Book();
                    newBook.inputData(scanner);
                    bookDAO.addNewBook(newBook);

                    break;
                case 3:
                    //  Cho phép người dùng nhập mã sách cần cập nhật thông tin .Thông
                    //báo lỗi nếu mã sách không tồn tại. Nếu nhập đúng mã sách thì hiển thị thông
                    //tin cũ của sách ra và cho người dùng chọn thông tin cần cập nhật. Sau khi cập
                    //nhật thông tin, tiến hành lưu lại và hiển thị thông báo cập nhật thành công.
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    int bookId = scanner.nextInt();
                    Book bookToUpdate = bookDAO.getBookById(bookId);

                    if (bookToUpdate == null) {
                        System.out.println("Không tìm thấy sách với mã này.");
                        break;
                    }

                    System.out.println("Thông tin sách hiện tại:");
                    System.out.println("ID: " + bookToUpdate.getBookId());
                    System.out.println("Tên sách: " + bookToUpdate.getBookName());
                    System.out.println("Tiêu đề: " + bookToUpdate.getTitle());
                    System.out.println("Tác giả: " + bookToUpdate.getAuthor());
                    System.out.println("Số trang: " + bookToUpdate.getTotalPages());
                    System.out.println("Nội dung: " + bookToUpdate.getContent());
                    System.out.println("Nhà xuất bản: " + bookToUpdate.getPublisher());
                    System.out.println("Giá: " + bookToUpdate.getPrice());
                    System.out.println("Loại sách: " + bookToUpdate.getTypeId());
                    System.out.println("Đã xóa: " + bookToUpdate.isDeleted());


                    do {
                        int choice1;
                        System.out.println("Chọn thông tin cần cập nhật:");
                        System.out.println("1. Ten Sach");
                        System.out.println("2. Tiêu đ��");
                        System.out.println("3. Tac gia");
                        System.out.println("4. So trang");
                        System.out.println("5. Noi dung");
                        System.out.println("6. Nha xuat ban");
                        System.out.println("7. Gia");
                        System.out.println("8. Loai sach");
                        System.out.println("9. Tinh trang xoa");
                        System.out.println("10. Thoát");

                        System.out.println("Lua chon:");
                        choice1 = scanner.nextInt();

                        switch (choice1) {
                            case 1:
                                bookToUpdate.setBookName(scanner.nextLine());
                                break;
                            case 2:
                                bookToUpdate.setTitle(scanner.nextLine());
                                break;
                            case 3:
                                bookToUpdate.setAuthor(scanner.nextLine());
                                break;
                            case 4:
                                bookToUpdate.setTotalPages(scanner.nextInt());
                                break;
                            case 5:
                                bookToUpdate.setContent(scanner.nextLine());
                                break;
                            case 6:
                                bookToUpdate.setPublisher(scanner.nextLine());
                                break;
                            case 7:
                                bookToUpdate.setPrice(scanner.nextFloat());
                                break;
                            case 8:
                                bookToUpdate.setTypeId(scanner.nextInt());
                                break;
                            case 9:
                                bookToUpdate.setDeleted(scanner.nextBoolean());
                                break;
                            case 10:
                                System.out.println("Quay lai.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }
                    } while (choice != 10);
                    bookDAO.updateBook(bookToUpdate);
                    break;
                case 4:
                    System.out.println("Nhap ma sach can xoa: ");
                    deleteBookType(scanner.nextInt());

                    break;
                case 5:
//                    : Sắp xếp và hiển thị danh sách các cuốn sách theo giá giảm dần
                    System.out.println(" Sap xep theo gia giam dan ");
                    sortAndDisplayBooksByPrice();

                    break;
                case 6:
                    System.out.println("Nhap ten sach hoac noi dung ");
                    searchBookByNameOrContent(scanner.nextLine());

                    break;
                case 7:
                    System.out.println("Thong ke so luong sach theo nso trang ban ");
                    categorizeBooksByPageCount();

                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }

}
