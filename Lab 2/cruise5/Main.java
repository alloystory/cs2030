import java.util.*;

public class Main {
    private static int _numOfNormalCruises = 0;
    private static int _numOfBigCruises = 0;

    private static void print(Loaders loaders) {
        System.out.printf("+==================================+\n");
        System.out.printf("| Cruise Statistics                |\n");
        System.out.printf("+----------------------------------+\n");
        System.out.printf("| Number of normal cruises   = %3d |\n", _numOfNormalCruises);
        System.out.printf("| Number of big cruises      = %3d |\n", _numOfBigCruises);
        System.out.printf("+==================================+\n");
        System.out.printf("| Equipment statistics             |\n");
        System.out.printf("+----------------------------------+\n");
        System.out.printf("| Number of loaders          = %3d |\n", loaders.getNumOfNormalLoaders());
        System.out.printf("| Number of recycled loaders = %3d |\n", loaders.getNumOfRecycledLoaders());
        System.out.printf("+==================================+\n");
        System.out.print(loaders.toString());
    }

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
                _numOfBigCruises++;
                cruise = new BigCruise(cruiseCode, cruiseTime);
            } else {
                _numOfNormalCruises++;
                cruise = new Cruise(cruiseCode, cruiseTime);
            }
            loaders.loadCruise(cruise);
        }

        print(loaders);
    }
}