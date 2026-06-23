package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

@Component
@Profile("cli")
public class Calculator implements CommandLineRunner {
    private final Map<String, Operation> operations;

    public Calculator(Map<String, Operation> operations) {
        this.operations = operations;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число a");
        double a = scanner.nextDouble();

        System.out.println("Введите число b");
        double b = scanner.nextDouble();

        System.out.println("Введите тип операции: [adder, divider, multiplier, subtractor]");
        String type = scanner.next();

        double result = operations.get(type).execute(a, b);
        System.out.println(result);

        scanner.close();
    }
}
