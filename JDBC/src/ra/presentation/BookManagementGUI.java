package ra.presentation;


import ra.business.BookDAO;
import ra.business.BookTypeDAO;
import ra.entity.Book;
import ra.entity.BookType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManagementGUI extends JFrame {
    private static final BookTypeDAO bookTypeDAO = new BookTypeDAO();
    private static final BookDAO bookDAO = new BookDAO();

    public BookManagementGUI() {
        // Thiết lập JFrame
        setTitle("Quản lý sách");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Thêm các nút chức năng
        JButton btnManageBookTypes = new JButton("Quản lý loại sách");
        JButton btnManageBooks = new JButton("Quản lý sách");
        JButton btnExit = new JButton("Thoát");

        add(btnManageBookTypes);
        add(btnManageBooks);
        add(btnExit);

        // Xử lý sự kiện cho các nút
        btnManageBookTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBookTypeMenu();
            }
        });

        btnManageBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBookMenu();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void showBookTypeMenu() {
        JFrame bookTypeFrame = new JFrame("Quản lý loại sách");
        bookTypeFrame.setSize(400, 300);
        bookTypeFrame.setLocationRelativeTo(null);
        bookTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bookTypeFrame.setLayout(new GridLayout(6, 1));

        JButton btnListBookTypes = new JButton("Danh sách loại sách");
        JButton btnAddBookType = new JButton("Tạo mới loại sách");
        JButton btnUpdateBookType = new JButton("Cập nhật thông tin loại sách");
        JButton btnDeleteBookType = new JButton("Xóa loại sách");
        JButton btnStatisticBookType = new JButton("Thống kê loại sách");
        JButton btnBack = new JButton("Quay lại");

        bookTypeFrame.add(btnListBookTypes);
        bookTypeFrame.add(btnAddBookType);
        bookTypeFrame.add(btnUpdateBookType);
        bookTypeFrame.add(btnDeleteBookType);
        bookTypeFrame.add(btnStatisticBookType);
        bookTypeFrame.add(btnBack);

        // Xử lý sự kiện cho các nút trong menu loại sách
        btnListBookTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeDAO.getAllBookTypes();
            }
        });

        btnAddBookType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeName = JOptionPane.showInputDialog("Nhập tên loại sách:");
                String description = JOptionPane.showInputDialog("Nhập mô tả:");

                BookType newBookType = new BookType();
                bookTypeDAO.addNewBookType(newBookType);
            }
        });

        btnUpdateBookType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeIdStr = JOptionPane.showInputDialog("Nhập mã loại sách cần cập nhật:");
                int typeId = Integer.parseInt(typeIdStr);
                BookType bookType = bookTypeDAO.getBookTypesById(typeId);

                if (bookType == null) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy loại sách.");
                    return;
                }

                String newName = JOptionPane.showInputDialog("Nhập tên mới:", bookType.getTypeName());
                String newDescription = JOptionPane.showInputDialog("Nhập mô tả mới:", bookType.getDescription());

                bookType.setTypeName(newName);
                bookType.setDescription(newDescription);
                bookTypeDAO.updateBookType(bookType);
            }
        });

        btnDeleteBookType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeIdStr = JOptionPane.showInputDialog("Nhập mã loại sách cần xóa:");
                int typeId = Integer.parseInt(typeIdStr);
                bookTypeDAO.deleteBookType(typeId);
            }
        });

        btnStatisticBookType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeDAO.countBooksByType();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeFrame.dispose();
            }
        });

        bookTypeFrame.setVisible(true);
    }

    private void showBookMenu() {
        JFrame bookFrame = new JFrame("Quản lý sách");
        bookFrame.setSize(400, 400);
        bookFrame.setLocationRelativeTo(null);
        bookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bookFrame.setLayout(new GridLayout(8, 1));

        JButton btnListBooks = new JButton("Danh sách sách");
        JButton btnAddBook = new JButton("Tạo mới sách");
        JButton btnUpdateBook = new JButton("Cập nhật thông tin sách");
        JButton btnDeleteBook = new JButton("Xóa sách");
        JButton btnSortBooksByPrice = new JButton("Thống kê sách theo giá giảm dần");
        JButton btnSearchBook = new JButton("Tìm kiếm theo tên hoặc nội dung");
        JButton btnBack = new JButton("Quay lại");

        bookFrame.add(btnListBooks);
        bookFrame.add(btnAddBook);
        bookFrame.add(btnUpdateBook);
        bookFrame.add(btnDeleteBook);
        bookFrame.add(btnSortBooksByPrice);
        bookFrame.add(btnSearchBook);
        bookFrame.add(btnBack);

        btnListBooks.addActionListener(e -> bookDAO.getAllBook());

        btnAddBook.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên sách:");
            String author = JOptionPane.showInputDialog("Nhập tác giả:");
            float price = Float.parseFloat(JOptionPane.showInputDialog("Nhập giá:"));
            Book newBook = new Book();
            bookDAO.addNewBook(newBook);
        });

        btnUpdateBook.addActionListener(e -> {
            int bookId = Integer.parseInt(JOptionPane.showInputDialog("Nhập mã sách cần cập nhật:"));
            Book bookToUpdate = bookDAO.getBookById(bookId);
            if (bookToUpdate != null) {
                bookToUpdate.setBookName(JOptionPane.showInputDialog("Tên sách:", bookToUpdate.getBookName()));
                bookDAO.updateBook(bookToUpdate);
            }
        });

        btnDeleteBook.addActionListener(e -> {
            int bookId = Integer.parseInt(JOptionPane.showInputDialog("Nhập mã sách cần xóa:"));
            bookDAO.deleteBook(bookId);
        });

        btnBack.addActionListener(e -> bookFrame.dispose());

        bookFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookManagementGUI app = new BookManagementGUI();
            app.setVisible(true);
        });
    }
}
