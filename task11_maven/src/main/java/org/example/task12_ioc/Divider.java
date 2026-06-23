package org.example.task12_ioc;

public class Divider implements MathOperation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }

    @Override
    public String getName() {
        return "деления";
    }
}