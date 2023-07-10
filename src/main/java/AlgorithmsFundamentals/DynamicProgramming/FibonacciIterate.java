package AlgorithmsFundamentals.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciIterate {
    public static long[] dynamicProgrammingMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        dynamicProgrammingMatrix = new long[n + 1];
        dynamicProgrammingMatrix[1] = 1;
        dynamicProgrammingMatrix[2] = 1;

        for (int i = 3; i < dynamicProgrammingMatrix.length; i++) {
            dynamicProgrammingMatrix[i] =
                    dynamicProgrammingMatrix[i - 1]
                    + dynamicProgrammingMatrix[i - 2];
        }

        System.out.println(dynamicProgrammingMatrix[n]);
    }
}
