package BaiTapSS3;

// xoa phan tu khoi mang -  gia tri xoa ban dau

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BaiTapArray {

    //BAI1
    private static int[] xoaPhanTu(int[] mang, int giaTriXoa) {
        // về bản chất thì mảng cố định trong java, nên khi thay đổi số lượng phần tử trong mảng thì
        // cần tạo ra 1 mảng để lưu ket quả, muốn làm việc trên chính no thì chuyển qua araylist
        int soPhanTuConLai = 0; // so phan tu con lai cua mang - loai tru cac gia tri can xoa
        for (int k : mang) { //for cai tien
            if (k != giaTriXoa) {
                soPhanTuConLai++;
            }
        }
        int[] mangMoi = new int[soPhanTuConLai];
        for (int i = 0, j = 0; i < mang.length; i++) {
            if (mang[i] != giaTriXoa) {
                mangMoi[j++] = mang[i];
            }
        }
        return mangMoi;
    }

    //    Bai 2
    // chèn thêm phần tử vào mảng\
    // cách  1
    private static int[] themPhanTu(int[] mang, int giaTriThem, int viTriThem) {
        int[] mangSauKhiThem = new int[mang.length];
        for (int i = 0, j = 0; i < mang.length - 1; ) {
            if (j == viTriThem) {
                mangSauKhiThem[j++] = giaTriThem;
            } else {
                mangSauKhiThem[j++] = mang[i];
                i++;
            }
        }
        return mangSauKhiThem;
    }

    //cách 2
    // Hàm để chèn phần tử vào một vị trí cụ thể trong mảng
    public static int[] insertElement(int[] originalArray, int newElement, int position) {
        // Tạo một mảng mới có kích thước lớn hơn
        int[] newArray = new int[originalArray.length];

        // Sao chép phần tử và chèn phần tử mới tại vị trí mong muốn
        for (int i = 0; i < originalArray.length; i++) {
            if (i < position) {
                newArray[i] = originalArray[i];  // Sao chép các phần tử trước vị trí chèn
            } else if (i == position) {
                newArray[i] = newElement;  // Chèn phần tử mới
            } else {
                newArray[i] = originalArray[i - 1];  // Sao chép phần tử sau vị trí chèn
            }
        }
        return newArray;  // Trả về mảng mới sau khi chèn
    }

    //cach 3
    private static int[] InsertElementWithArrayCopy(int[] originalArray, int newElement, int position) {
        int[] newArray = new int[originalArray.length];
        System.arraycopy(originalArray, 0, newArray, 0, position);
        newArray[position] = newElement;
        System.arraycopy(originalArray, position, newArray, position + 1, originalArray.length - position - 1);
        return newArray;
    }

    // cach4
    private static int[] InsertElementWithStream(int[] originalArray, int newElement, int position) {
        return IntStream.concat(// nối chúng lại
                IntStream.concat( // nối chúng lại
                        Arrays.stream(originalArray, 0, position), // tạo 1 stream
                        IntStream.of(newElement) // tạo 1 stream chứa duy nhất 1 phần tử
                ),
                Arrays.stream(originalArray, position, originalArray.length - 1) // tạo 1 stream để chứa đống còn lại
        ).toArray(); // chuyển thành mảng số nguyên
    }

    // Bai 3
    private static int[] MergeArraysUsingStream(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
    }

    private static <ArraysList> int[] MergeArraysUsingArrayList(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : arr1) {
            list.add(a);
        }
        ;
        for (int a : arr2) {
            list.add(a);
        }
        ;
        return list.stream().mapToInt(i -> i).toArray(); // chuyen list thanh mang
    }

    private static <ArraysList> int[] MergeArraysUsingArrayCopy(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }

    // Bai 4 - tim phan tu lon nhat mang  2 chieu
    public static int findMax(int[][] array) {
//         Dùng Stream để xử lý mảng hai chiều và tìm phần tử lớn nhất
//        return Arrays.stream(array)
//                .flatMapToInt(Arrays::stream) // Chuyển đổi mảng hai chiều thành một stream của các giá trị nguyên
//                .max()                      // Tìm giá trị lớn nhất
//                .orElseThrow();             // Trả về giá trị lớn nhất, hoặc ném ngoại lệ nếu mảng rỗng

        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
//    Bai 5
    private static int MinElementIn2DArrayUsingFlatten(int[][] array) {
        int[] flattenedArray = Arrays.stream(array)// tao stream tu mang 2 chieu- moi phan tu la mang 1 chieu -> giam chieu
                .flatMapToInt(Arrays::stream)  //Tạo một Stream của các giá trị nguyên từ cac mang 1 chieu thanh 1 stream duy nhat
                .toArray();//chuyen thanh mang
        return Arrays.stream(flattenedArray)// tao stream tu mang 1 chieu
                .min()
                .orElseThrow(); // nem ngoai le neu khong co gia tri
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner sc = new Scanner(System.in);

    // BAI1 - xoa phan tu mang
//        System.out.println(" the value you want delete: ");
//        int n = sc.nextInt();
        System.out.println("Array after delete values :" + Arrays.toString(xoaPhanTu(arr, 7)));
    // Bai 2: Chen Phan Tu Mang

        System.out.println(" the value you want add at index 2  Method1 : " + Arrays.toString(themPhanTu(arr, 99, 2)));
        System.out.println(" the value you want add at index 1- Method2 : " + Arrays.toString(insertElement(arr, 100, 1)));
        System.out.println(" the value you want add at index 3- Method3 : " + Arrays.toString(InsertElementWithArrayCopy(arr, 555, 3)));
        System.out.println(" the value you want add at index 7- Method4 : " + Arrays.toString(InsertElementWithStream(arr, 444, 7)));

        // Bai 3 : Gop Mang
        int[] arr1 = new int[]{11, 12, 13, 14, 15, 19, 20, 30, 40, 51};
        System.out.println("Array after merged arr and arr1 - Using ArrayCopy : " + Arrays.toString(MergeArraysUsingArrayCopy(arr, arr1)));
        System.out.println("Array after merged arr and arr1 - Using ArrayList : " + Arrays.toString(MergeArraysUsingArrayList(arr, arr1)));
        System.out.println("Array after merged arr and arr1 - Using Stream : " + Arrays.toString(MergeArraysUsingStream(arr, arr1)));

    // Bai4
        int[][] array = {
                {1, 5, 9},
                {7, 2, 3},
                {4, 8, 6}
        };
        System.out.println("Find Max -  Method 1: "+findMax(array));
    // Bai 5
        System.out.println("Find Min -  Method 2 - using stream: "+MinElementIn2DArrayUsingFlatten(array));

    //Bai 6
//        cach1
        String str1 = "Hello";
        String str2 = "World";

        // Nối hai chuỗi bằng phương thức concat()
        String result = str1.concat(" ").concat(str2);

        System.out.println("Nối chuỗi bằng concat(): " + result);
//        cach 2
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2);

        String result1 = sb.toString();
        System.out.println("Nối chuỗi bằng StringBuilder: " + result1);

//  Bai 7
        String mainString = "Hello World";
        String subString = "World";

        // Kiểm tra xem mainString có chứa subString không
        boolean contains = mainString.contains(subString);

        System.out.println("Chuỗi chứa chuỗi con: " + contains);
//  Bai 8
        String originalString = "   Hello World   ";

        // Loại bỏ khoảng trắng ở đầu và cuối chuỗi
        String trimmedString = originalString.trim();

        System.out.println("Chuỗi gốc: '" + originalString + "'");
        System.out.println("Chuỗi đã loại bỏ khoảng trắng: '" + trimmedString + "'");
//  Bai 9

    }
}
