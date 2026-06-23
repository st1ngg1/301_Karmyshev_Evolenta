package org.example.task12_ioc;

public class Adder implements MathOperation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }

    @Override
    public String getName() {
        return "сложения";
    }
}