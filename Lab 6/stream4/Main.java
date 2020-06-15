import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] arr = Stream.of(input.split(" "))
                          .mapToInt(x -> Integer.parseInt(x))
                          .toArray();

        System.out.println("Variance: " + variance(arr));
    }

    static OptionalDouble variance(int[] arr) {
        double length = IntStream.of(arr).count();
        if (length < 2) {
            return OptionalDouble.empty();
        }

        final double average = IntStream.of(arr).average().getAsDouble();

        double numerator = IntStream.of(arr).mapToDouble(x -> x - average)
                                            .map(x -> x * x)
                                            .sum();
        
        return OptionalDouble.of(numerator / (length - 1));
    }
}