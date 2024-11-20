package BaiTapSS1;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhập vào giá trị USD: ");
        double usd = sc.nextDouble();
        System.out.println(" Giá trị VNĐ: "+ usd*23000 + "VNĐ");
    }
}
