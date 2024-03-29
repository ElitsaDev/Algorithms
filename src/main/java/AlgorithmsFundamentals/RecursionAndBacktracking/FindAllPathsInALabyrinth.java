package AlgorithmsFundamentals.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* input:
3
3
---
-*-
--e
 - output:
RRDD
DDRR

 */
public class FindAllPathsInALabyrinth {
    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrinth, 0, 0, ' ');
    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if ((!isInBounds(labyrinth, row, col))
                || labyrinth[row][col] == 'V'
                || labyrinth[row][col] == '*') {
            return;
        }

        path.add(direction);

        if (labyrinth[row][col] == 'e') {
            printPath();
        }else {
            labyrinth[row][col] = 'V';

            findPath(labyrinth, row - 1, col, 'U');
            findPath(labyrinth, row + 1, col, 'D');
            findPath(labyrinth, row, col - 1, 'L');
            findPath(labyrinth, row, col + 1, 'R');

            labyrinth[row][col] = '-';
        }

        path.remove(path.size() - 1);
    }

    private static void printPath() {

        for (Character character : path) {
            if(character != ' '){
                System.out.print(character);
            }
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row >= 0 && row < labyrinth.length  && col >= 0 && col < labyrinth[row].length;
    }
}
