package AlgorithmsFundamentals.Exam02July2023;
//80/100
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BitcoinTransactions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        if(firstInput.equals(secondInput)){
            System.out.print("[");
            print(Collections.singletonList(firstInput));
            System.out.print("]");
            return;
        }

        String [] array1 = firstInput.split(" ");
        String [] array2 = secondInput.split(" ");
        List<String> result = findLongestSequence(array1, array2);
        System.out.print("[");
        print(result);
        System.out.print("]");
    }

    private static List<String> findLongestSequence(String [] array1, String [] array2) {

        int n1 = array1.length;
        int n2 = array2.length;

        // Initialize the 2D matrix dp
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Fill the matrix dp
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (array1[i - 1].equals(array2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Find the longest common subsequence
        List<String> sequence = new ArrayList<>();
        int i = n1;
        int j = n2;
        while (i > 0 && j > 0) {
            if (array1[i - 1].equals(array2[j - 1])) {
                sequence.add(array1[i - 1]);
                i--;
                j--;
            } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        // Reverse the sequence to get the correct order
        Collections.reverse(sequence);

        return sequence;
    }

    private static void print(List<String> result ) {
        System.out.print(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
