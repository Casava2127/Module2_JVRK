public class Bai3 {
    public static void main(String[] args) {
        int n = 0;
        while(n<100){
            if(n%3 == 0 && n%5 == 0){
                System.out.println(n);
            }
            n+=15;
        }
    }
}
