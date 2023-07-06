package AlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

//Implement an algorithm that finds the index of an element
// in a sorted array of integers in logarithmic time
public class BinarySearch {
    public static final int KEY_NOT_FOUND = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int array[] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int elementToSearch = Integer.parseInt(scanner.nextLine());
        int start = 0;
        int end = array.length - 1;

        System.out.println(binarySearch(array, elementToSearch, start, end));
    }

    static int binarySearch(int array[], int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (array[mid] < key) {
                start = mid + 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return KEY_NOT_FOUND;
    }
}
