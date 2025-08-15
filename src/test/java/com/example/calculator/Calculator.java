package com.example.calculator;

public class Calculator {

    /**
     * Performs a mathematical calculation based on two numbers and an operator.
     * @param num1 the first number (double)
     * @param num2 the second number (double)
     * @param operator the operator as a String ("+", "-", "*", "/")
     * @return the result of the calculation (double)
     * @throws IllegalArgumentException if the operator is not one of the valid options.
     */
    public double calculate(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" ->
                // Standard double division handles division by zero by returning Infinity
                    num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}