import java.util.stream.IntStream;

public class ArithmeticProgression {

    public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b)
                .asLongStream()
                .sum();              // Суммируем
    }

    public static void main(String[] args) {

        // Задание
        int a = 10_000_000;
        int b = 1_000_000_000;

        long result = getArithmeticProgressionSum(a, b);
        System.out.println("Сумма от " + a + " до " + b + ": " + result);
    }
}