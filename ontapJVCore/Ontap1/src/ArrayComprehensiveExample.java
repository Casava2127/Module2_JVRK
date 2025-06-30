public class ArrayComprehensiveExample {
    public static void main(String[] args) {
        // 1. Khai báo và khởi tạo mảng một chiều (1D)
        // Cách 1: Khởi tạo với giá trị mặc định
        int[] numbers = new int[5]; // Mảng 5 phần tử, giá trị mặc định là 0
        numbers[0] = 10; // Gán giá trị cho phần tử đầu tiên
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Cách 2: Khởi tạo trực tiếp với giá trị
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        // 2. Truy cập và in mảng một chiều
        System.out.println("Mảng số nguyên (numbers):");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " "); // In: 10 20 30 40 50
        }
        System.out.println();

        System.out.println("Mảng chuỗi (names):");
        for (String name : names) { // Sử dụng for-each
            System.out.print(name + " "); // In: Alice Bob Charlie David
        }
        System.out.println();

        // 3. Mảng hai chiều (2D)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Mảng hai chiều (matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
        // Kết quả:
        // 1 2 3
        // 4 5 6
        // 7 8 9

        // 4. Thao tác với mảng: Tính tổng các phần tử
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Tổng các phần tử trong mảng numbers: " + sum); // In: 150

        // 5. Tìm phần tử lớn nhất trong mảng
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng numbers: " + max); // In: 50

        // 6. Xử lý ngoại lệ ArrayIndexOutOfBoundsException
        try {
            System.out.println(numbers[10]); // Truy cập chỉ số không hợp lệ
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lỗi: Truy cập chỉ số ngoài phạm vi mảng!");
        }

        // 7. Mảng tham chiếu và bản chất trong bộ nhớ
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1; // arr2 trỏ cùng đối tượng trong heap
        arr2[0] = 99; // Thay đổi arr2 ảnh hưởng arr1
        System.out.println("arr1[0] sau khi thay đổi arr2: " + arr1[0]); // In: 99

        // 8. Mảng với kiểu tham chiếu (đối tượng)
        class Student {
            String name;
            int age;

            Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student{name='" + name + "', age=" + age + "}";
            }
        }

        Student[] students = new Student[2];
        students[0] = new Student("John", 20);
        students[1] = new Student("Mary", 22);

        System.out.println("Mảng đối tượng Student:");
        for (Student student : students) {
            System.out.println(student); // In thông tin từng học sinh
        }
    }
}
/// chi dung mang voii kich thuot co dinh
