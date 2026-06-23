package com.example.demo;

import org.springframework.stereotype.Component;

@Component("subtractor")
public class Subtractor implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
