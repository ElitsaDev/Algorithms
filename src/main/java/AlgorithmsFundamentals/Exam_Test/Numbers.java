package AlgorithmsFundamentals.Exam_Test;
//100/100
import java.util.*;

/*
Input:
3
Output:
3
2 + 1
1 + 1 + 1
 */

/*
Input:
5
Output:
5
4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1
 */
public class Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();
        printCombinations(n, n, "");
    }
    public static void printCombinations(int n, int maxElement, String prefix) {
        if (n == 0) {
            System.out.println(prefix.substring(0,prefix.length()-2));

        }
        for (int i = Math.min(maxElement, n); i >= 1; i--) {
           printCombinations(n - i, i, prefix + i + " + ");
        }
    }
}
