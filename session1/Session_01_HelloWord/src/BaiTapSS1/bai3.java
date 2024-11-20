package BaiTapSS1;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        System.out.print("Nhập độ dài cạnh: ");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.println("Chu vi: "+x*4+" Diện tích: "+x*x);
    }
}
