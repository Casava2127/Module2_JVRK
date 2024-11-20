package ra.entity;

import java.util.Scanner;

public class Book implements IBookManagement{
    private int bookId;
    private String bookName;
    private String title;
    private String author;
    private int totalPages;
    private String content;
    private String publisher;
    private float price;
    private int typeId;
    private boolean isDeleted;

    //Constructor


    public Book(int bookId, String bookName, String title, String author, int totalPages, String content, String publisher, float price, int typeId, boolean isDeleted) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.content = content;
        this.publisher = publisher;
        this.price = price;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }

    public Book() {
    }
    //get-set


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
//        System.out.print("Enter book ID: ");
//        bookId = scanner.nextInt();
//        scanner.nextLine();

        System.out.print("Enter book name: ");
        bookName = scanner.nextLine();

        System.out.print("Enter title: ");
        title = scanner.nextLine();

        System.out.print("Enter author: ");
        author = scanner.nextLine();

        System.out.print("Enter total pages: ");
        totalPages = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter content: ");
        content = scanner.nextLine();

        System.out.print("Enter publisher: ");
        publisher = scanner.nextLine();

        System.out.print("Enter price: ");
        price = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Enter type ID: ");
        typeId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter isDeleted: ");
        isDeleted = scanner.nextBoolean();
        scanner.next();
    }

    @Override
    public void displayData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Content: " + content);
        System.out.println("Publisher: " + publisher);
        System.out.println("Price: " + price);
        System.out.println("Type ID: " + typeId);
        System.out.println("Is Deleted: " + isDeleted);
        System.out.println("------------------------");
    }
}
