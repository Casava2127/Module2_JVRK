package ra.entity;

import java.util.Scanner;

public class Product {
//    • productid – String: mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là
//    một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh
//            tố, A: các đồ ăn nhanh), không được trùng lặp
//• productName – String: tên sản phẩm đồ uống, có từ 10-50 ký tự,
//    không được trùng lặp
//• price – float: giá sản phẩm có giá trị lớn hơn 0
//            • description – String: mô tả sản phẩm
//• created – date: ngày nhập sản phẩm có định dạng dd/mm/yyyy
//• catalogId – int: Mã danh mục mà sản phẩm thuộc về
//• productStatus – int: trạng thái sản phẩm, chỉ nhận 1 trong các trạng
//    thái sau (0: Đang bán – 1: Hết hàng – 2: Không bán)

    private String productId;
    private String productName;
    private float price;
    private String description;
    private String created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, String created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;

    }

    // Getters and Setters


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputDataDrink(Scanner scanner, Product[] arrProducts, int index, Categories arrCategories) {


        do {
            System.out.print("Enter product ID (4 characters, must be unique): ");
            productId = scanner.nextLine();
        } while (!isDuplicateProductId(productId, arrProducts) && !isValidProductId(productId));
        setProductId(productId);
        scanner.nextLine();

        do {
            System.out.print("Enter product name (10-50 characters): ");
            productName = scanner.nextLine();
        } while (isDuplicateProductName(productName, arrProducts) && isValidProductName(productName));
        setProductName(productName);
        scanner.nextLine();

        do {
            System.out.print("Enter price (more than 0): ");
            price = scanner.nextFloat();
        } while (!isDuplicatePrice(price));
        setPrice(price);
        scanner.nextLine();

        do {
            System.out.print("Enter description (maximum 1000 characters): ");
            description = scanner.nextLine();
        }while (!isDuplicateDescription(description));
        setDescription(description);
        scanner.nextLine();

        do {
            System.out.print("Enter created date (dd/mm/yyyy): ");
            created = scanner.nextLine();
        } while (!isDuplicateCreatedDate(created));
        setCreated(created);
        scanner.nextLine();

        do {
            arrCategories.displayData();
            System.out.print("Enter catalog ID : ");
            catalogId = scanner.nextInt();
        } while (!isDuplicateCatalogId(catalogId, new Categories[]{arrCategories}));
        setCatalogId(catalogId);
        scanner.nextLine();

        do {
            System.out.print("Enter product status (0: Selling, 1: Out of stock, 2: Unsellable): ");
            productStatus = scanner.nextInt();
        } while (!isDuplicateProductStatus(productStatus));
        setProductStatus(productStatus);
        scanner.nextLine();

    }
    public void displayDataDrink() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        System.out.println("Created Date: " + created);
        System.out.println("Catalog ID: " + catalogId);
        System.out.println("Product Status: " + productStatus);
    }


    private boolean isDuplicateProductId(String productId, Product[] arrProducts) {
//mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là
//một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh
//tố, A: các đồ ăn nhanh), không được trùng lặp
        // bieu thuc chinh quy
        for(Product product : arrProducts){
            if(product != null && product.getProductId().equals(productId) ){
                return true;
            }
        }
        return false;
    }
    private boolean isValidProductId(String productId){
        // bieu thuc chinh quy
        //return productId.length() == 4 && (productId.charAt(0) == 'C' || productId.charAt(0) == 'S' || productId.charAt(0) == 'A');
        return productId.matches("[CSA][0-9]{3}");
    }
    private boolean isDuplicateProductName(String productName, Product[] arrProducts) {
//        String: tên sản phẩm đồ uống, có từ 10-50 ký tự,
//        không được trùng lặp
        for(Product product : arrProducts){
            if(product!= null && (product.getProductName().equals(productName))){
                return false;
            }
        }
        return true;
    }
    private boolean isValidProductName(String productName){
        return (productName.length() >= 10 && productName.length() <=50);
    }

    private boolean isDuplicatePrice(float price) {
        return (price >= 0);
    }
    private boolean isDuplicateDescription(String description) {
        return (description.length() <= 1000);
    }
    private boolean isDuplicateCreatedDate(String created) {
        //dd/mm/yyyy
        return (created.matches("\\d{2}/\\d{2}/\\d{4}"));
    }
    private boolean isDuplicateProductStatus(int productStatus){
        return (productStatus>=0 && productStatus<=2);
    }
    private boolean isDuplicateCatalogId(int catalogId, Categories[] arrCategories) {
        // mã danh mục mà sản phẩm thuộc về
        for(Categories category : arrCategories) {
            if(category != null && category.getCatalogId() == catalogId) {
                // Nếu tìm thấy mã trùng, trả về true (mã đã tồn tại)
                return true;
            }
        }
        // Nếu không tìm thấy mã trùng, trả về false (mã không trùng)
        return false;
    }


}
