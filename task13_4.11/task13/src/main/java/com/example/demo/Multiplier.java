package com.example.demo;

import org.springframework.stereotype.Component;

@Component("multiplier")
public class Multiplier implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
