package AlgorithmsFundamentals.CombinatorialProblems;
/*
формулата е:
n^k
* */
import java.util.Scanner;

public class VariationsWithRepetition {
    public static String[] elements;
    public static String[] variations;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());
        variations = new String[k];

        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            variations[index] = elements[i];
            variations(index + 1);
        }
    }

//    private static void swap(String[] arr, int first, int second) {
//        String temp = arr[first];
//        arr[first] = arr[second];
//        arr[second] = temp;
//    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
