import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        
        StringBuilder output = new StringBuilder();
        primeFactors(num).forEach(x -> output.append(x + " "));
        output.deleteCharAt(output.length() - 1);
        System.out.println(String.format("Prime factors of %d are: %s", num, output.toString()));
    }

    static IntStream factors(int x) {
        return IntStream.rangeClosed(1, x)
                        .filter(y -> x % y == 0);
    }

    static IntStream primeFactors(int x) {
        return factors(x).filter(y -> {
                            if (y < 2)
                                return false;
                            return IntStream.range(2, y)
                                            .noneMatch(z -> y % z == 0);
                        });
    }
}