import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCruises = scanner.nextInt();

        for (int i = 0; i < numOfCruises; i++) {
            String cruiseCode = scanner.next();
            String cruiseTime = scanner.next();
            Cruise cruise = new Cruise(cruiseCode, cruiseTime);
            System.out.println(cruise.toString());
        }
    }
}