package interfaceDemo;
//  interface là một dạng cấu trúc cho phép định nghĩa các phương thức mà các lớp triển khai (implement) phải tuân theo,
//  nhưng không có phần thực thi cụ thể trong chính interface.
//  nterface giống như một hợp đồng mà các lớp phải thực hiện đầy đủ nếu muốn triển khai (implement).

public interface demo1 {
    //1 .gom cac hang so mac dinh la public static final
    public static final int MAX_VALUE = 100;
    //2 .gom cac phuong thuc la public abstract - truoc java8
    public abstract void show1();
}
