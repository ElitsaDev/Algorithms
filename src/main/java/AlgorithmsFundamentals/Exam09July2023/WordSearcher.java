package AlgorithmsFundamentals.Exam09July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordSearcher {
    public static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String row = reader.readLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        String[] words = reader.readLine().split("\\s+");
        List<String> foundWords = findWordsInGrid(words);

        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    private static List<String> findWordsInGrid(String[] words) {
        List<String> foundWords = new ArrayList<>();
        for (String word : words) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                   
                    if (grid[i][j] == word.charAt(0)) {
                        if (searchWord(word, i, j, 0)) {
                            foundWords.add(word);
                            break;
                        }
                    }
                }
            }
        }
        return foundWords;
    }

    private static boolean searchWord(String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (isOutOfBounds(row, col) || grid[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = grid[row][col];

        grid[row][col] = '#';

        boolean found = searchWord(word, row - 1, col, index + 1) ||
                searchWord( word, row + 1, col, index + 1) ||
                searchWord(word, row, col - 1, index + 1) ||
                searchWord(word, row, col + 1, index + 1) ||
                searchWord(word, row - 1, col - 1, index + 1) ||
                searchWord(word, row - 1, col + 1, index + 1) ||
                searchWord(word, row + 1, col - 1, index + 1) ||
                searchWord(word, row + 1, col + 1, index + 1);

        grid[row][col] = temp;

        return found;
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= grid.length
                || col < 0 || col >= grid[row].length;
    }
}
