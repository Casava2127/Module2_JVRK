import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào khoảng số
        System.out.print("Nhập số bắt đầu của khoảng: ");
        int start = scanner.nextInt();

        System.out.print("Nhập số kết thúc của khoảng: ");
        int end = scanner.nextInt();

        int tongChan = 0;
        int tongLe = 0;

        // Duyệt qua các số trong khoảng và tính tổng
//        for (int i = start; i <= end; i++) {
//            if (i % 2 == 0) {
//                tongChan += i;
//            } else {
//                tongLe += i;
//            }
//        }
        int soSoHang = (end-start)+1;
        int khoangDu = soSoHang % 10;


        // In kết quả
        System.out.println("Tổng các số chẵn trong khoảng là: " + tongChan);
        System.out.println("Tổng các số lẻ trong khoảng là: " + tongLe);
    }
}


