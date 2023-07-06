package AlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithms;
//само за int >= 0
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CountSort {
    public static int [] count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = {5, 4, 1, 15, 0, 7, 25};

        int max = Arrays.stream(array).max().orElse(0);

        count = new int[max + 1];

        sort(array);

        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0){
                for (int j = 0; j < count[i]; j++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
    private static void sort(int[] array) {
        for (int num : array) {
            count[num]++;
        }
    }
}
