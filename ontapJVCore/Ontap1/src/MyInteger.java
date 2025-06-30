public class MyInteger {
    private int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter
    public int getValue() {
        return value;
    }

    // Setter
    public void setValue(int value) {
        this.value = value;
    }

    // Comparison methods
    public boolean greaterThan(MyInteger other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare with null");
        }
        return this.value > other.getValue();
    }

    public boolean lessThan(MyInteger other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare with null");
        }
        return other.greaterThan(this);
    }

    // Increment method
    public MyInteger increment() {
        value++;
        return this;
    }

    // Equals method
    public boolean equals(MyInteger other) {
        if (other == null) {
            return false;
        }
        return this.value == other.getValue();
    }

    // toString method for readable output
    @Override
    public String toString() {
        return "MyInteger{value=" + value + "}";
    }
}