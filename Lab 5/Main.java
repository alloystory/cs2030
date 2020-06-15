import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfFaces = 6;
        int numberOfRows = 3;
        int[][][] rubikGrid = new int[numberOfFaces][numberOfRows][numberOfRows];
        
        for (int i = 0; i < numberOfFaces; i++) {
            int[][] faceGrid = new int[numberOfRows][numberOfRows];
            for (int j = 0; j < numberOfRows; j++) {
                int[] row = new int[numberOfRows];
                for (int k = 0; k < numberOfRows; k++) {
                    row[k] = scanner.nextInt();
                }
                faceGrid[j] = row;
            }
            rubikGrid[i] = faceGrid;
        }

        Rubik rubikCube = new Rubik(rubikGrid);
        while (scanner.hasNext()) {
            String move = scanner.next();
            switch (move) {
            case "F":
                rubikCube = rubikCube.frontfaceRight();
                break;
            case "F'":
                rubikCube = rubikCube.frontfaceLeft();
                break;
            case "F2":
                rubikCube = rubikCube.frontfaceHalf();
                break;
            case "R":
                rubikCube = rubikCube.rightfaceRight();
                break;
            case "R'":
                rubikCube = rubikCube.rightfaceLeft();
                break;
            case "R2":
                rubikCube = rubikCube.rightfaceHalf();
                break;
            case "U":
                rubikCube = rubikCube.upfaceRight();
                break;
            case "U'":
                rubikCube = rubikCube.upfaceLeft();
                break;
            case "U2":
                rubikCube = rubikCube.upfaceHalf();
                break;
            case "L":
                rubikCube = rubikCube.leftfaceRight();
                break;
            case "L'":
                rubikCube = rubikCube.leftfaceLeft();
                break;
            case "L2":
                rubikCube = rubikCube.leftfaceHalf();
                break;
            case "B":
                rubikCube = rubikCube.backfaceRight();
                break;
            case "B'":
                rubikCube = rubikCube.backfaceLeft();
                break;
            case "B2":
                rubikCube = rubikCube.backfaceHalf();
                break;
            case "D":
                rubikCube = rubikCube.downfaceRight();
                break;
            case "D'":
                rubikCube = rubikCube.downfaceLeft();
                break;
            case "D2":
                rubikCube = rubikCube.downfaceHalf();
                break;
            }
        }

        System.out.println(rubikCube);
    }
}