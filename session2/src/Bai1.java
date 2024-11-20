import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = scr.nextInt();
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("Yes, the number divisible by 3 and 5");
        } else {
            System.out.println("No, the number not divisible by 3 and 5");
        }
    }
}
