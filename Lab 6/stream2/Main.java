import java.util.stream.IntStream;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isSquare(n));
    }

    static boolean isSquare(int n) {
        boolean output = IntStream.rangeClosed(1, n / 2 + 1)
                                  .anyMatch(x -> x * x == n);
        return output;
    }
}
