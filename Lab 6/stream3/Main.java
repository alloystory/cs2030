import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] arr = Stream.of(input.split(" "))
                          .mapToInt(x -> Integer.parseInt(x))
                          .toArray();

        System.out.println("Number of occurrences: " + countRepeats(arr));
    }

    static long countRepeats(int[] arr) {
        return IntStream.range(0, arr.length - 1)
                        .mapToLong(x -> {
                            if (x == 0 && arr[x] == arr[x + 1])
                                return 1;
                            else if (x != 0 && arr[x - 1] != arr[x] && arr[x] == arr[x + 1])
                                return 1;
                            return 0;
                        })
                        .sum();
    }
}