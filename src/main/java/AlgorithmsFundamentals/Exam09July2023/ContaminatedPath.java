package AlgorithmsFundamentals.Exam09July2023;
//100/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ContaminatedPath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] elements = new int[n][n];

        for (int row = 0; row < n; row++) {
            elements[row] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] contaminatedCells = reader.readLine().split(" ");

        int[][] fertility = new int[n][n];
        boolean[][] isContaminated = new boolean[n][n];

        for (String contaminatedCell : contaminatedCells) {
            String[] cell = contaminatedCell.split(",");
            int row = Integer.parseInt(cell[0]);
            int col = Integer.parseInt(cell[1]);
            isContaminated[row][col] = true;
        }

        fertility[0][0] = elements[0][0];

        for (int col = 1; col < n; col++) {
            if (isContaminated[0][col]) {
                fertility[0][col] = Integer.MIN_VALUE;
            } else {
                fertility[0][col] = fertility[0][col - 1] + elements[0][col];
            }
        }

        for (int row = 1; row < n; row++) {
            if (isContaminated[row][0]) {
                fertility[row][0] = Integer.MIN_VALUE;
            } else {
                fertility[row][0] = fertility[row - 1][0] + elements[row][0];
            }
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (isContaminated[row][col]) {
                    fertility[row][col] = Integer.MIN_VALUE;
                } else {
                    fertility[row][col] = Math.max(fertility[row - 1][col], fertility[row][col - 1]) + elements[row][col];
                }
            }
        }

        int row = n - 1;
        int col = n - 1;

        List<String> path = new ArrayList<>();
        path.add(formatOutput(row, col));

        while (row > 0 || col > 0) {
            if (row > 0 && col > 0 && !isContaminated[row - 1][col] && !isContaminated[row][col - 1]) {
                if (fertility[row - 1][col] > fertility[row][col - 1]) {
                    row--;
                } else {
                    col--;
                }
            } else if (row > 0 && !isContaminated[row - 1][col]) {
                row--;
            } else if (col > 0 && !isContaminated[row][col - 1]) {
                col--;
            } else {
                // Backtracking to find an alternate path
                int prevRow = row;
                int prevCol = col;
                while (prevRow >= 0 && prevCol >= 0) {
                    if (prevRow > 0 && fertility[prevRow - 1][prevCol] > fertility[prevRow][prevCol - 1]
                            && !isContaminated[prevRow - 1][prevCol]) {
                        row = prevRow - 1;
                        col = prevCol;
                        break;
                    } else if (prevCol > 0 && !isContaminated[prevRow][prevCol - 1]) {
                        row = prevRow;
                        col = prevCol - 1;
                        break;
                    }
                    prevRow--;
                    prevCol--;
                }
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);

        int maxFertility = fertility[n - 1][n - 1];
        System.out.println("Max total fertility: " + maxFertility);
        System.out.println("[" + String.join(" ", path) + "]");
    }

    private static String formatOutput(int row, int col) {
        return "(" + row + ", " + col + ")";
    }
}