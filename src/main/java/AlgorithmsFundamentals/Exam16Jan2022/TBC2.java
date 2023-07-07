package AlgorithmsFundamentals.Exam16Jan2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TBC2 {
    public static char[][] matrix;
    public static boolean[][] visited;
    public static List<Integer> areas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]  == 't'&& !visited[row][col]){
                    areas.add(findArea(row, col));
                }
            }
        }
        System.out.println(areas.size());
    }

    private static int findArea(int row, int col){
        if (isOutOfBounds(row, col) || visited[row][col] || matrix[row][col] != 't') {
            return 0;
        }
        visited[row][col] = true;

        int areaSize = 1;

        areaSize += findArea(row + 1, col);
        areaSize += findArea(row - 1, col);
        areaSize += findArea(row, col + 1);
        areaSize += findArea(row, col - 1);
        areaSize += findArea(row + 1, col + 1);
        areaSize += findArea(row + 1, col - 1);
        areaSize += findArea(row - 1, col + 1);
        areaSize += findArea(row - 1, col - 1);

        return areaSize;
    }
    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
