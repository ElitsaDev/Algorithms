package AlgorithmsFundamentals.Exam02July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
n!/(k!.(n-k)!)
 */

public class BitcoinMiners {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        long result = recursiveFactorial(n) /(recursiveFactorial(k)*(recursiveFactorial(n - k)));
        System.out.println(result);
    }

    private static long recursiveFactorial(int n) {
        if(n == 1){
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }
}
