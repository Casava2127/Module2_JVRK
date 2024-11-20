package BaiTapSS1;
import java.util.*;
public class HelloWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = Integer.parseInt(sc.nextLine());
        // hoặc
        // int age1 = sc.nextInt();
        // vì khi nhấn enter thì coi như đã nhập cho aaau lệnh dưới nên cần 2 cách dưới
        //c1:
        //sc.nextLine();

        // c2: lấy string -> convert sang kiểu khac
        // int: Interger.parseInt("String") ...

        System.out.println("Enter your name:");
        String str = sc.nextLine();
        System.out.println("If of you: "+str+" "+age);
        sc.close();
    }
}
