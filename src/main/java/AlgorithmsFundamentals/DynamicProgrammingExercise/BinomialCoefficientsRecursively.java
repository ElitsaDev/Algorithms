package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.Scanner;

public class BinomialCoefficientsRecursively {
    public static long[][] dynamicProgrammingMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int k = Integer.parseInt(scanner.nextLine());

        dynamicProgrammingMatrix = new long[n + 1][k + 1];

        long binomial = binomial(n, k);

        System.out.println(binomial);
    }

    private static long binomial(int n, int k) {

        if (k == 0 || k == n) {
            return 1;
        }

        if (dynamicProgrammingMatrix[n][k] != 0) {
            return dynamicProgrammingMatrix[n][k];
        }
        return dynamicProgrammingMatrix[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}
