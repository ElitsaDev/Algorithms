package AlgorithmsFundamentals.Exam09Jan2022;

import java.util.Scanner;

public class SuperSet {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(",\\s+");

        for (int i = 0; i <= elements.length; i++) {
            variations = new String[i];
            combinations(0, 0);
        }
    }
    private static void combinations(int index, int start) {
        if (index == variations.length) {
            print(variations);
        }else {
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i + 1);
            }
        }
    }
    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
