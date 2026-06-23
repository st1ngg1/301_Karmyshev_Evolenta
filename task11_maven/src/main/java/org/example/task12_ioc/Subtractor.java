package org.example.task12_ioc;

public class Subtractor implements MathOperation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }

    @Override
    public String getName() {
        return "вычитания";
    }
}