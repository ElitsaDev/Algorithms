package AlgorithmsFundamentals.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;
//не се ползва в практиката рекурсивното решение!!!
//най-оптимално е итеративното решение
public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        sum = recursiveSum(numbers, numbers.length - 1);
        System.out.println("Recursive sum: " + sum);

        sum = iterationSum(numbers);
        System.out.println("Iteration sum: " + sum);
    }

    private static int iterationSum(int[] numbers) {
        int result = 0;
        for(int i = 0; i < numbers.length; i++){
            result += numbers[i];
        }
        return result;
    }

    private static int recursiveSum(int[] numbers, int index) {
        if(index < 0){
            return 0;
        }
        return numbers[index] + recursiveSum(numbers, index - 1);
    }
}
