public class Main {
    public static void main(String[] args) {
        int v = 4;
        v = v++ + ++v;  // Tính toán v
        System.out.println("Giá trị của v là: " + v);
    }
}
