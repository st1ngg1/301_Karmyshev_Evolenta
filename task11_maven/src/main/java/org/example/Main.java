package org.example;


import org.example.task12_ioc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<MathOperation> operations;


    public Main(List<MathOperation> operations) {
        this.operations = operations;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Java from Maven!");
        System.out.println("---------------------------------------");


        System.out.println("Введите число a");
        double a = scanner.nextDouble();

        System.out.println("Введите число b");
        double b = scanner.nextDouble();


        for (MathOperation op : operations) {
            double result = op.execute(a, b);
            System.out.printf("Результат %s a и b: %.1f%n", op.getName(), result);
        }
        scanner.close();
    }

    public static void main(String[] args) {

        List<MathOperation> ops = new ArrayList<>();
        ops.add(new Adder());
        ops.add(new Subtractor());
        ops.add(new Multiplier());
        ops.add(new Divider());


        Main app = new Main(ops);


        app.run();
    }
}