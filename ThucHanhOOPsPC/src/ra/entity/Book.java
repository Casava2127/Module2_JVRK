package ra.entity;

import java.util.Scanner;

public class Book {
    // bookId – String: Mã sách, không được trùng lặp (Duy nhất)
    //▪ bookName – String: Tên sách, không được trùng lặp, gồm 4
    //ký tự, bắt đầu là ký tự B
    //▪ importPrice – float: Giá nhập của sách có giá trị lớn hơn 0
    //▪ exportPrice – float: Giá xuất của sách, có giá trị lớn hơn ít
    //nhất 30% so với giá nhập
    //▪ author – String: Tác giả, có từ 6-50 ký tự
    //▪ interest – float : Lợi nhuận sách tính theo công thức
    //interest = exportPrice – importPrice
    //▪ year – int: Năm xuất bản, ít nhất xuất bản sau năm 2000
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    // Constructor
    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        setBookName(bookName);
        setImportPrice(importPrice);
        setExportPrice(exportPrice);
        setAuthor(author);
        setYear(year);
        calculateInterest();
    }
    public Book(){};

    // Getter and Setter


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        // khong trung lap, 4 ky tu, bat dau B
//        if(bookName.length() == 4 && bookName.charAt(0) == 'B' ){
//            this.bookName = bookName;
//        }
        if(bookName.matches("B\\{3}")){
            this.bookName = bookName;
        } else {
            System.out.println("Tên sách phải có 4 ký tự, bắt đầu là ký tự B");
        }
    }
    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        if(importPrice > 0){
            this.importPrice = importPrice;
        }else {
            System.out.println("Giá nhập phải lon hơn 0");
        }
    }


    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if(exportPrice > 1.3*importPrice){
            this.exportPrice = exportPrice;
            calculateInterest();
        }else{
            System.out.println("Giá xuất phải lon hon 30% so với giá nhập");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.length() >= 6 && author.length() < 50){
            this.author = author;
        }else{
            System.out.println("Tác giả phải co 6-50 ký tự");
        }
    }

    public float getInterest() {
        return interest;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >= 2000){
            this.year = year;
        };
    }

    // Phuong thuc in thong tin sach
    public void displayBookInfo(){
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Import Price: " + importPrice);
        System.out.println("Export Price: " + exportPrice);
        System.out.println("Author: " + author);
        System.out.println("Interest: " + interest);
        System.out.println("Year: " + year);
    }
    // Phuong thuc nhap thogn tin sach
    public  void inputBookInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        setBookId(scanner.nextLine());

        System.out.print("Nhập tên sách: ");
        setBookName(scanner.nextLine());

        System.out.print("Nhập giá nhập: ");
        setImportPrice(scanner.nextFloat());

        System.out.print("Nhập giá xuất: ");
        setExportPrice(scanner.nextFloat());

        scanner.nextLine(); // clear the buffer
        System.out.print("Nhập tên tác giả: ");
        setAuthor(scanner.nextLine());

        System.out.print("Nhập năm xuất bản: ");
        setYear(scanner.nextInt());

        calculateInterest();

    }

    // Tính lợi nhuận sách
    public float calculateInterest() {
       return  this.interest = exportPrice - importPrice;
    }
}
