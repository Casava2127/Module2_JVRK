package ra;
import java.util.ArrayList;
import java.util.Comparator;

class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;

    public Book(String bookId, String bookName, float importPrice, float exportPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void displayBookData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Import Price: " + importPrice);
        System.out.println("Export Price: " + exportPrice);
    }
}

public class BookSortExample {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        // Thêm các sách vào danh sách
        books.add(new Book("B001", "Book One", 100, 150));
        books.add(new Book("B002", "Book Two", 200, 250));
        books.add(new Book("B003", "Book Three", 150, 180));

        System.out.println("Danh sách sách trước khi sắp xếp:");
        displayBooks();

        // Sắp xếp sách theo giá bán tăng dần
        sortBooksByExportPrice();

        System.out.println("\nDanh sách sách sau khi sắp xếp theo giá bán tăng dần:");
        displayBooks();
    }

    private static void sortBooksByExportPrice() {
        books.sort(Comparator.comparing(Book::getExportPrice));

        System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
    }

    private static void displayBooks() {
        for (Book book : books) {
            book.displayBookData();
            System.out.println("-----------------------------");
        }
    }
}
