public class MyIntegerTest {
    public static void main(String[] args) {
        // 1. Create MyInteger objects
        MyInteger num1 = new MyInteger(10);
        MyInteger num2 = new MyInteger(20);
        MyInteger num3 = new MyInteger(10);

        // 2. Test comparison methods
        System.out.println("num1 > num2: " + num1.greaterThan(num2)); // false
        System.out.println("num1 < num2: " + num1.lessThan(num2));   // true
        System.out.println("num1 == num3: " + num1.equals(num3));     // true

        // 3. Test increment method with chaining
        System.out.println("Before increment: " + num1); // MyInteger{value=10}
        num1.increment().increment(); // Increment twice
        System.out.println("After increment: " + num1);  // MyInteger{value=12}

        // 4. Using MyInteger in an array
        MyInteger[] numbers = {new MyInteger(5), new MyInteger(15), new MyInteger(8)};
        System.out.println("Array of MyInteger:");
        for (MyInteger num : numbers) {
            System.out.println(num); // Print each object
        }

        // 5. Find the largest MyInteger in the array
        MyInteger max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i].greaterThan(max)) {
                max = numbers[i];
            }
        }
        System.out.println("Largest value in array: " + max); // MyInteger{value=15}

        // 6. Test null handling
        try {
            num1.greaterThan(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Error: Cannot compare with null
        }
    }
}