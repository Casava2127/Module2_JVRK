import java.util.Arrays;
import java.util.Scanner;

public class BaiNguyenTo {

    // Hàm kiểm tra số nguyên tố
    private static boolean kiemTraSoNguyenTo(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Hàm liệt kê n số nguyên tố đầu tiên
    private static void lietKeNSoNguyenToDauTien(int n) {
        int dem = 0;
        int i = 2;
        while (dem < n) {
            if (kiemTraSoNguyenTo(i)) {
                System.out.print(i + " ");
                dem++;
            }
            i++;
        }
        System.out.println(); // Xuống dòng sau khi in xong
    }

    // Hàm liệt kê các số nguyên tố nhỏ hơn max sử dụng Sàng Eratosthenes
    private static void eratosthenes(int max) {
        // Tạo mảng Boolean để đánh dấu số nguyên tố
        boolean[] isPrime = new boolean[max + 1];
        // tạo mang đánh giá ất cả các số trogn mảng là true ( nghĩa là số nguyên tố )
        Arrays.fill(isPrime, true); // Giả định tất cả các số là nguyên tố

        // Sàng Eratosthenes
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false; // Đánh dấu các bội số của i không phải nguyên tố
                }
            }
        }

        // In các số nguyên tố
        System.out.println("Các số nguyên tố nhỏ hơn " + max + " là:");
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Xuống dòng sau khi in xong
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        // Liệt kê n số nguyên tố đầu tiên
        System.out.println("Nhập số lượng n để liệt kê n số nguyên tố đầu tiên: ");
        int n = scanner.nextInt();
        lietKeNSoNguyenToDauTien(n);

        // Liệt kê các số nguyên tố trong một khoảng sử dụng Sàng Eratosthenes
        System.out.println("Nhập khoảng tối đa để liệt kê các số nguyên tố: ");
        int max = scanner.nextInt();
        eratosthenes(max);
    }
}
