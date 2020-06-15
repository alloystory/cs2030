import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loaders loaders = new Loaders();
        int numOfCruises = scanner.nextInt();

        for (int i = 0; i < numOfCruises; i++) {
            String cruiseCode = scanner.next();
            String cruiseTime = scanner.next();
            char cruiseType = cruiseCode.charAt(0);
            Cruise cruise;

            if (cruiseType == 'B') {
                cruise = new BigCruise(cruiseCode, cruiseTime);
            } else {
                cruise = new Cruise(cruiseCode, cruiseTime);
            }
            loaders.loadCruise(cruise);
        }

        System.out.print(loaders.toString());
    }
}