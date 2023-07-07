package AlgorithmsFundamentals.Exam16Jan2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TBC {
    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]  == 't'){
                    areas.add(new int[]{row, col, 0});
                    findAreas(row, col);
                }
            }
        }

        System.out.println(areas.size());
    }

    private static void findAreas(int row, int col){
        if(isOutOfBounds(row, col) || isNotTraversal(row, col)){
            return;
        }
        matrix[row][col] = 'V';

        areas.get(areas.size() - 1)[2]++;

        findAreas(row + 1, col);
        findAreas(row - 1, col);
        findAreas(row , col + 1);
        findAreas(row , col - 1);
        findAreas(row + 1, col + 1);
        findAreas(row + 1, col - 1);
        findAreas(row - 1, col + 1);
        findAreas(row - 1, col - 1);
    }

    private static boolean isNotTraversal(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == 'd';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
