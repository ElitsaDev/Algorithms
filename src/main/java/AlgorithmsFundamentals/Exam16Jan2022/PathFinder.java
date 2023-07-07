package AlgorithmsFundamentals.Exam16Jan2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*  directed graph
7
3 6
4 5

1


1 2
3
0 3 1 5
0 3 1 5 6
0 6 2
 */
public class PathFinder {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int numberOfNodes = Integer.parseInt(scanner.nextLine());
        while (numberOfNodes-- > 0) {
            String line = scanner.nextLine();

            if (line.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }

        int numberOfPathsToCheck = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPathsToCheck; i++) {
            int [] paths = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean isPath = true;
            for (int j = 0; j < paths.length - 1; j++) {
                List<Integer> currentNode = graph.get(paths[j]);
                if (currentNode.isEmpty() || !currentNode.contains(paths[j + 1])) {
                    isPath = false;
                }
            }
            if (isPath) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
