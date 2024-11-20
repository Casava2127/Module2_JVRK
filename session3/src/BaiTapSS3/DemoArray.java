package BaiTapSS3;

import java.util.Arrays;
import java.util.Scanner;

public class DemoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Khai báo và khởi tạo mảng trong cùng một câu lệnh
        int[] numbers1 = {1, 2, 3, 4, 5};

        // 2. Khai báo mảng trước, sau đó khởi tạo mảng
        int[] numbers2;
        numbers2 = new int[5]; // Khởi tạo mảng với kích thước 5
        // khai báo một biến tham chiếu mảng có tên là numbers2 kiểu dữ liệu MẢNG INT
        // dòng tiếp khởi tạo 1 mảng có 5 phần tử và gán cho biến tham chiếu mảng
        //ew int[5]`**: Từ khóa `new` yêu cầu Java cấp phát bộ nhớ cho một mảng có **5 phần tử** kiểu `int
        //Array trong java là một đối tượng, việc tạo biến tham chiếu mảng chỉ là gán địa chỉ để ĐIỀU KHIỂN TỪ Xa
        // các phần tử trong đối tuognjw mảng




        // 3. Khai báo mảng và khởi tạo với các giá trị
        int[] numbers3 = new int[]{6, 7, 8, 9, 10};

        // 4. Khai báo mảng với kiểu dữ liệu tham chiếu (như String)
        String[] names = {"Alice", "Bob", "Charlie"};

        // 5. Khai báo và khởi tạo mảng đa chiều
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};

        // 6. Nhập giá trị cho mảng numbers2
        System.out.println("Nhập 5 số nguyên cho mảng numbers2:");
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + ": ");
            numbers2[i] = scanner.nextInt();
        }

        // In mảng numbers1 sử dụng vòng lặp for
        System.out.println("Mảng numbers1:");
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i] + " ");
        }
        System.out.println(); // Xuống dòng

        // In mảng numbers2 sử dụng vòng lặp foreach
        System.out.println("Mảng numbers2:");
        for (int number : numbers2) {
            System.out.print(number + " ");
        }
        System.out.println(); // Xuống dòng

        // In mảng numbers3 sử dụng Arrays.toString()
        System.out.println("Mảng numbers3:");
        System.out.println(Arrays.toString(numbers3));

        // In mảng names sử dụng Arrays.toString()
        System.out.println("Mảng names:");
        System.out.println(Arrays.toString(names));

        // In mảng đa chiều matrix
        System.out.println("Mảng matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        scanner.close();
    }
}

