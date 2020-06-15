import java.util.stream.IntStream;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPerfect(n));
    }

    static boolean isPerfect(int n) {
        int sum = IntStream.rangeClosed(1, n / 2)
                           .filter(x -> n % x == 0)
                           .sum();
        return sum == n;
    }
}
