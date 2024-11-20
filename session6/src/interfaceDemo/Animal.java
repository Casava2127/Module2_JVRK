package interfaceDemo;
// tu java 8 tro di thi co the chau phoung thuc default

public interface Animal {
    void sound();  // Phương thức trừu tượng

    default void sleep() {
        System.out.println("Sleeping...");
    }

    static void run() {
        System.out.println("Running...");
    }
}
