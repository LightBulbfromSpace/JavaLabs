package com.example.universal_calculator;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> integerCalculator = new Calculator<>(10, 3);
        printResults("Integer calculator (10, 3)", integerCalculator);

        Calculator<Double> doubleCalculator = new Calculator<>(5.5, 2.0);
        printResults("Double calculator (5.5, 2.0)", doubleCalculator);

        Calculator<Integer> negativeCalculator = new Calculator<>(-8, 2);
        printResults("Negative values (-8, 2)", negativeCalculator);

        Calculator<Integer> zeroDivisorCalculator = new Calculator<>(5, 0);
        try {
            System.out.println("5 / 0 = " + zeroDivisorCalculator.divide());
        } catch (ArithmeticException exception) {
            System.out.println("Division by zero handled: " + exception.getMessage());
        }

        System.out.println("Square of 4 = " + Calculator.square(4));
        System.out.println("Square of 2.5 = " + Calculator.square(2.5));
    }

    private static void printResults(String label, Calculator<? extends Number> calculator) {
        System.out.println(label);
        System.out.println("  Addition: " + calculator.add());
        System.out.println("  Subtraction: " + calculator.subtract());
        System.out.println("  Multiplication: " + calculator.multiply());
        System.out.println("  Division: " + calculator.divide());
        System.out.println("  Average: " + calculator.average());
    }
}