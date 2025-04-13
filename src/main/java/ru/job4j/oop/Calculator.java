package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public double divide(int y) {
        return (double) x / y;
    }

    public int sumAllOperation(int y) {
        int sumResult = sum(y);
        int minusResult = minus(y);
        double divideResult = divide(y);
        int multiplyResult = x * y;
        return sumResult + minusResult + (int) divideResult + multiplyResult;
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println("Result of sum: " + resultSum);

        int resultMinus = Calculator.minus(10);
        System.out.println("Result of minus: " + resultMinus);

        Calculator calculator = new Calculator();
        double resultDivide = calculator.divide(10);
        System.out.println("Result of divide: " + resultDivide);

        int resultAllOperations = calculator.sumAllOperation(10);
        System.out.println("Result of sumAllOperation: " + resultAllOperations);
    }
}
