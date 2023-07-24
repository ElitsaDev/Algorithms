package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.Scanner;

public class BinomialCoefficientsIteratively {
    public static long[][] dynamicProgrammingMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int k = Integer.parseInt(scanner.nextLine());

        dynamicProgrammingMatrix = new long[n + 1][k + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= Math.min(row, k); col++) {
                if (col == 0 || col == row) {
                    dynamicProgrammingMatrix[row][col] = 1;
                } else {
                    dynamicProgrammingMatrix[row][col] = dynamicProgrammingMatrix[row - 1][col] + dynamicProgrammingMatrix[row - 1][col - 1];
                }
            }
        }

        System.out.println(dynamicProgrammingMatrix[n][k]);
    }
}
