package AlgorithmsFundamentals.Exam04April2016Nakov;

import java.util.Arrays;
import java.util.Scanner;

/* да се свържат без да се пресичат, така че да има максимален брой мостове
2 5 3 3 3 1 8 2 6 7 6 22
1 2 5 3 4 1 7 8 2 5 6
 */
public class Bridges {
    public static  int[][] maxBridges;
    public static int[] north;
    public static int[] south;
    public static int NotCalculated = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        north = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        south = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        maxBridges = new int[north.length][south.length];

        for (int i = 0; i < north.length; i++) {
            for (int j = 0; j < south.length; j++) {
                maxBridges[i][j] = NotCalculated;
            }
        }

        calcMaxBridges(north.length - 1, south.length - 1);

        System.out.print(maxBridges[north.length - 1][south.length - 1]);
    }

    private static int calcMaxBridges(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (maxBridges[x][y] != NotCalculated) {
            return maxBridges[x][y];
        }

        int northLeft = calcMaxBridges(x - 1, y);
        int southLeft = calcMaxBridges(x, y - 1);

        if (north[x] == south[y]) {
            maxBridges[x][y] = 1 + Math.max(northLeft, southLeft);
        } else {
            maxBridges[x][y] = Math.max(northLeft, southLeft);
        }
        return maxBridges[x][y];
    }
}
