package org.example;

// Импортируем наши классы из пакета task12_ioc
import org.example.task12_ioc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<MathOperation> operations;

    // Конструктор принимает список операций (Внедрение зависимостей)
    public Main(List<MathOperation> operations) {
        this.operations = operations;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число a");
        double a = scanner.nextDouble();

        System.out.println("Введите число b");
        double b = scanner.nextDouble();

        // Проходим по всем операциям и выводим результат
        for (MathOperation op : operations) {
            double result = op.execute(a, b);
            System.out.printf("Результат %s a и b: %.1f%n", op.getName(), result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Создаем список и добавляем туда все нужные операции
        List<MathOperation> ops = new ArrayList<>();
        ops.add(new Adder());
        ops.add(new Subtractor());
        ops.add(new Multiplier());
        ops.add(new Divider());

        // Передаем список в конструктор (DI)
        Main app = new Main(ops);

        // Запускаем
        app.run();
    }
}