package com.example.demo;

import org.springframework.stereotype.Component;

@Component("divider")
public class Divider implements Operation {
    @Override
    public double execute(double a, double b) {
        return a / b;
    }
}
