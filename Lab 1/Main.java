import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxCount = scanner.nextInt();
        Point[] points = new Point[maxCount];
        for (int i = 0; i < maxCount; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            points[i] = new Point(x, y);
        }

        int maxDiscCoverage = 0;
        for (int i = 0; i < maxCount - 1; i++) {
            for (int j = i + 1; j < maxCount; j++) {
                Point a = points[i];
                Point b = points[j];
                Point centre = a.findCentre(b);

                if (centre != null) {
                    int tempMaxDC = 0;
                    for (Point pt : points) {
                        if (pt.distTo(centre) <= 1) {
                            tempMaxDC++;
                        }
                    }
                    
                    if (tempMaxDC > maxDiscCoverage) {
                        maxDiscCoverage = tempMaxDC;
                    }
                }
            }
        }

        System.out.printf("Maximum Disc Coverage: %d\n", maxDiscCoverage);
    }
}
