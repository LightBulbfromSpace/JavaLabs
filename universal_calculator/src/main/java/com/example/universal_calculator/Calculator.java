package com.example.universal_calculator;

public class Calculator<T extends Number> {
    private final T first;
    private final T second;

    public Calculator(T first, T second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Operands must not be null");
        }
        this.first = first;
        this.second = second;
    }

    public double add() {
        return first.doubleValue() + second.doubleValue();
    }

    public double subtract() {
        return first.doubleValue() - second.doubleValue();
    }

    public double multiply() {
        return first.doubleValue() * second.doubleValue();
    }

    public double divide() {
        double divisor = second.doubleValue();
        if (divisor == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return first.doubleValue() / divisor;
    }

    public double average() {
        return (first.doubleValue() + second.doubleValue()) / 2.0;
    }

    public static <N extends Number> double square(N value) {
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        double number = value.doubleValue();
        return number * number;
    }
}
