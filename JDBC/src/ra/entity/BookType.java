package ra.entity;

import java.util.Scanner;

public class BookType implements IBookManagement {
    private int typeId;
    private String typeName;
    private String description;
    private boolean isDeleted;

    //construct
    public BookType(int typeId, String typeName, String description, boolean isDeleted) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public BookType() {}
    //get-set

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

// them data
    @Override
    public void inputData(Scanner scanner) {
//        System.out.print("Nhập mã loại sách: ");
//        typeId = scanner.nextInt();

        System.out.print("Nhập tên loại sách: ");
        scanner.nextLine();
        typeName = scanner.nextLine();

        System.out.print("Nhập mô tả: ");
        description = scanner.nextLine();

        System.out.print("Nhập trạng thái (true/false): ");
        isDeleted = scanner.nextBoolean();
        scanner.nextLine();
    }
// hien thi
    @Override
    public void displayData() {
        System.out.println("Mã loại sách: " + typeId);
        System.out.println("Tên loại sách: " + typeName);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (isDeleted? "Đã xóa" : "Chưa xóa"));
        System.out.println("-----------------------------");
    }
}
