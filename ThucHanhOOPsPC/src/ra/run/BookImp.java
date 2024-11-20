package ra.run;

import ra.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ra.DB.ConnectionDBBookImp;
import ra.DB.BookImpDAO;


public class BookImp {
    private static ArrayList<Book> books = new ArrayList<>();

    //lay tat ca csdl -> chuyen vao arraylist

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputBooks(scanner);
                    break;
                case 2:
                    calculateProfit();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortBooksByExportPrice();
                    break;
                case 5:
                    sortBooksByProfit();
                    break;
                case 6:
                    searchBookByName(scanner);
                    break;
                case 7:
                    statisticsByYear();
                    break;
                case 8:
                    statisticsByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 9);
    }

    private static void inputBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputBookInfo();
            books.add(book);
        }
    }

    private static void calculateProfit() {
        double interestSum = 0.0;
        for (Book book : books) {
            interestSum += (double)book.calculateInterest();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả các sách: "+interestSum);
    }

    private static void displayBooks() {
//        for (Book book : books) {
//            book.displayBookInfo();
//            System.out.println("-----------------------------");
//        }
       BookImpDAO bookImpDAO = new BookImpDAO();
       bookImpDAO.getAllBooks();
    }

    private static void sortBooksByExportPrice() {
        books.sort(Comparator.comparing(Book::getExportPrice));
        System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
    }

    private static void sortBooksByProfit() {
        books.sort(Comparator.comparing(Book::getInterest).reversed());
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
    }

    private static void searchBookByName(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        scanner.nextLine(); // clear buffer
        String name = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                book.displayBookInfo();
                found = true;
                System.out.println("-----------------------------");
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên \"" + name + "\".");
        }
    }

//    private static void statisticsByYear() {
//        Map<Integer, Integer> yearCount = new HashMap<>();
//        for (Book book : books) {
//            yearCount.put(book.getYear(), yearCount.getOrDefault(book.getYear(), 0) + 1);
//        }
//
//        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
//        for (Map.Entry<Integer, Integer> entry : yearCount.entrySet()) {
//            System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " cuốn");
//        }
//    }
private static void statisticsByYear() {
    int[] yearCount = new int[100]; // Giả sử không có sách nào xuất bản trước năm 2000 và sau năm 2099

    // Đếm số lượng sách theo năm
    for (Book book : books) {
        int year = book.getYear();
        if (year >= 2000 && year < 2100) {
            yearCount[year - 2000]++; // Tăng số lượng sách cho năm tương ứng
        }
    }

    // Hiển thị kết quả
    System.out.println("Thống kê số lượng sách theo năm xuất bản:");
    for (int year = 2000; year < 2100; year++) {
        if (yearCount[year - 2000] > 0) {
            System.out.println("Năm " + year + ": " + yearCount[year - 2000] + " cuốn");
        }
    }
}


//    private static void statisticsByAuthor() {
//        Map<String, Integer> authorCount = new HashMap<>();
//        for (Book book : books) {
//            authorCount.put(book.getAuthor(), authorCount.getOrDefault(book.getAuthor(), 0) + 1);
//        }
//
//        System.out.println("Thống kê số lượng sách theo tác giả:");
//        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
//            System.out.println("Tác giả " + entry.getKey() + ": " + entry.getValue() + " cuốn");
//        }
//    }
private static void statisticsByAuthor() {
    String[] authors = new String[100]; // Giả sử có tối đa 100 tác giả
    int[] authorCount = new int[100]; // Mảng để đếm số lượng sách cho từng tác giả
    int authorIndex = 0;

    // Đếm số lượng sách theo tác giả
    for (Book book : books) {
        String author = book.getAuthor();

        // Kiểm tra xem tác giả đã được thêm vào mảng chưa
        int index = -1;
        for (int i = 0; i < authorIndex; i++) {
            if (authors[i].equals(author)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // Nếu tác giả chưa tồn tại, thêm vào mảng
            authors[authorIndex] = author;
            authorCount[authorIndex] = 1; // Đếm sách cho tác giả mới
            authorIndex++;
        } else {
            // Nếu tác giả đã tồn tại, tăng số lượng sách
            authorCount[index]++;
        }
    }

    // Hiển thị kết quả
    System.out.println("Thống kê số lượng sách theo tác giả:");
    for (int i = 0; i < authorIndex; i++) {
        System.out.println("Tác giả " + authors[i] + ": " + authorCount[i] + " cuốn");
    }
}
}
