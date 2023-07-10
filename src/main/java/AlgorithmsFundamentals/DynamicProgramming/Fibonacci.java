package AlgorithmsFundamentals.DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fibonacci {
    public static long[] dynamicProgrammingMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if(n  > 92){
            System.out.println("Result overflow long");
        }
        dynamicProgrammingMatrix = new long[n + 1];

            long Fibonacci = calcFibonacci(n);
            System.out.println(Fibonacci);

    }

    private static long calcFibonacci(int n) {

        if (n <= 2) {
            return 1;
        }

        if (dynamicProgrammingMatrix[n] != 0) {
            return dynamicProgrammingMatrix[n];
        }
        return dynamicProgrammingMatrix[n] = calcFibonacci(n - 1) + (calcFibonacci(n - 2));
    }
}
