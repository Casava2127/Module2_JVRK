
public class MemoryExample {
    public static void main(String[] args) {
        // Biến giá trị thực
        int a = 10; // Stack: a -> 10
        int b = a; // Stack: b -> 10 (sao chép giá trị)
        b = 20; // Stack: b -> 20, a vẫn là 10

        // Biến tham chiếu
        StringBuilder sb1 = new StringBuilder("Hello"); // Stack: sb1 -> địa chỉ; Heap: đối tượng StringBuilder
        StringBuilder sb2 = sb1; // Stack: sb2 -> cùng địa chỉ
        sb2.append(" World"); // Heap: đối tượng thay đổi thành "Hello World"
        System.out.println(sb1); // In: Hello World (cả sb1 và sb2 trỏ cùng đối tượng)
    }
}